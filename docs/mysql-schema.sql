/*
grant all privileges on * to test@localhost
identified by 'test'
with grant option;
*/
/* 建立数据库 */
drop database if exists platform;

create database if not exists platform
    default character set utf8
    default collate utf8_general_ci;

use platform;

/* 组织表 */
create table sys_entity (
    id            int          not null auto_increment,
    uid           varchar(255) not null,
    type          varchar(255) not null,
    syncInd       varchar(255),
    syncTimestamp varchar(255),
    createdAt     datetime,
    createdBy     int,
    updatedAt     datetime,
    updatedBy     int,
    constraint sys_entity_id primary key (id)
);

create table sys_organization (
    id          int          not null,
    code        varchar(255) not null,
    title       varchar(255) not null,
    description varchar(255) null,
    constraint fk_sys_organization_id foreign key (id) references sys_entity (id)
);

create table sys_department (
    id          int          not null,
    code        varchar(255) not null,
    title       varchar(255) not null,
    description varchar(255) null,
    constraint fk_sys_department_id foreign key (id) references sys_entity (id)
);

create table sys_position (
    id          int          not null,
    code        varchar(255) not null,
    title       varchar(255) not null,
    description varchar(255) null,
    constraint fk_sys_position_id foreign key (id) references sys_entity (id)
);

create table sys_user (
    id          int          not null,
    username    varchar(255) not null,
    email       varchar(255) not null,
    mobile      varchar(255) not null,
    salt        varchar(255) not null,
    password    varchar(255) not null,
    description varchar(255) null,
    constraint fk_sys_user_id foreign key (id) references sys_entity (id)
);

create table sys_entity_relation (
    id        int         not null auto_increment,
    parentId  int         not null,
    childId   int         not null,
    level     int         not null,
    parentInd int         not null,
    type      varchar(50) not null,
    createAt  timestamp   not null,
    constraint pk_sys_entity_relation_id primary key (id),
    constraint fk_sys_entity_relation_parent_id foreign key (parentId) references sys_entity (id),
    constraint fk_sys_entity_relation_child_id foreign key (childId) references sys_entity (id)
);

/* =========================================================================== */
create table sys_organizations (
    org_id          int          not null auto_increment,
    org_parent_id   int          not null,
    org_code        varchar(255) not null,
    org_title       varchar(255) not null,
    org_description varchar(255),
    org_created_at  datetime,
    org_created_by  int,
    org_updated_at  datetime,
    org_updated_by  int,
    constraint sys_organizations_id primary key (org_id)
);

drop table if exists sys_organizations;

create table sys_organizations (
    org_id          int          not null auto_increment,
    org_parent_id   int          not null,
    org_code        varchar(255) not null,
    org_title       varchar(255) not null,
    org_description varchar(255),
    org_created_at  datetime,
    org_created_by  int,
    org_updated_at  datetime,
    org_updated_by  int,
    constraint sys_organizations_id primary key (org_id)
);

create unique index sys_organizations_code on sys_organizations (org_code);

/* 角色表 */
drop table if exists sys_roles;

create table sys_roles (
    rol_id          int          not null   auto_increment,
    rol_org_id      int          not null   default 1,
    rol_code        varchar(255) not null,
    rol_title       varchar(255) not null,
    rol_description varchar(255),
    rol_type        varchar(50),
    rol_created_at  datetime,
    rol_created_by  int,
    rol_updated_at  datetime,
    rol_updated_by  int,
    constraint fk_sys_roles_org_id foreign key (rol_org_id) references sys_organizations (org_id),
    constraint pk_sys_roles_id primary key (rol_id)
);

/* 用户组表 */
drop table if exists sys_usergroups;

create table sys_usergroups (
    usg_id          int          not null auto_increment,
    usg_org_id      int          not null,
    usg_parent_id   int          not null,
    usg_code        varchar(255) not null,
    usg_title       varchar(255) not null,
    usg_description varchar(255),
    usg_created_at  datetime,
    usg_created_by  int,
    usg_updated_at  datetime,
    usg_updated_by  int,
    constraint fk_sys_usergroups_org_id foreign key (usg_org_id) references sys_organizations (org_id),
    constraint pk_sys_usergroups_id primary key (usg_id)
);

create unique index idx_sys_usergroups_code on sys_usergroups (usg_code);

/* 岗位职务表 */
drop table if exists sys_positions;

create table sys_positions (
    pos_id          int          not null auto_increment,
    pos_org_id      int          not null,
    pos_parent_id   int          not null,
    pos_code        varchar(255) not null,
    pos_title       varchar(255) not null,
    pos_description varchar(255),
    pos_created_at  datetime,
    pos_created_by  int,
    pos_updated_at  datetime,
    pos_updated_by  int,
    constraint fk_sys_positions_org_id foreign key (pos_org_id) references sys_organizations (org_id),
    constraint pk_sys_positions_id primary key (pos_id)
);

create unique index idx_sys_positions_code on sys_positions (pos_code);

/* 用户表 */
drop table if exists sys_users;

create table sys_users (
    usr_id                  int          not null auto_increment,
    usr_org_id              int          not null default 0,
    usr_usg_id              int          not null default 0,
    usr_rol_id              int          not null default 0,
    usr_pos_id              int          not null default 0,
    usr_username            varchar(50)  not null,
    usr_email               varchar(255) not null,
    usr_mobile              varchar(255) not null,
    usr_password            varchar(255) not null,
    usr_salt                varchar(255),
    usr_nickname            varchar(255),
    usr_fullname            varchar(255),
    usr_description         varchar(255),
    usr_status              varchar(50),
    usr_source              varchar(50),
    usr_last_login_datetime datetime,
    usr_created_at          datetime,
    usr_created_by          int,
    usr_updated_at          datetime,
    usr_updated_by          int,
    constraint fk_sys_users_org_id foreign key (usr_org_id) references sys_organizations (org_id),
    constraint fk_sys_users_usg_id foreign key (usr_usg_id) references sys_usergroups (usg_id),
    constraint fk_sys_users_rol_id foreign key (usr_rol_id) references sys_roles (rol_id),
    constraint fk_sys_users_pos_id foreign key (usr_pos_id) references sys_positions (pos_id),
    constraint pk_sys_users_id primary key (usr_id)
);

create unique index idx_sys_users_username on sys_users (usr_username);
create unique index idx_sys_users_email on sys_users (usr_email);
create unique index idx_sys_users_mobile on sys_users (usr_mobile);

/* 权限表 */
create table sys_permissions (
    per_id          int not null auto_increment,
    per_code        varchar(255),
    per_title       varchar(255),
    per_description varchar(255),
    constraint pk_sys_permissions_id primary key (per_id)
);

/* 资源表 */
create table sys_resources (
    res_id          int not null auto_increment,
    res_url         varchar(255),
    res_permissions varchar(255),
    res_roles       varchar(255),
    res_description varchar(255),
    constraint pk_sys_resources_id primary key (res_id)
);

/* 用户-角色关联表 */
create table sys_users_roles (
    sur_usr_id int not null,
    sur_rol_id int not null,
    constraint pk_sys_users_roles primary key (sur_usr_id, sur_rol_id)
);

/* 用户-用户组关联表 */
create table sys_users_usergroups (
    suu_usr_id int not null,
    suu_usg_id int not null,
    constraint pk_sys_users_usergroups primary key (suu_usr_id, suu_usg_id)
);

/* 角色-权限关联表 */
create table sys_roles_permissions (
    sup_rol_id int not null,
    sup_per_id int not null,
    constraint pk_sys_roles_permissions primary key (sup_rol_id, sup_per_id)
);

/* 用户-权限关联表 */
create table sys_users_permissions (
    sup_usr_id int not null,
    sup_per_id int not null,
    constraint pk_sys_users_permissions primary key (sup_usr_id, sup_per_id)
);

/* 用户回话 */
create table sys_users_session (
    uss_id               int          not null auto_increment,
    uss_session_id       varchar(255) not null,
    uss_username         varchar(255) null,
    uss_host             varchar(255) not null,
    uss_last_access_time datetime,
    uss_start_time       datetime,
    uss_end_time         datetime,
    constraint pk_sys_users_session_id primary key (uss_id)
);
