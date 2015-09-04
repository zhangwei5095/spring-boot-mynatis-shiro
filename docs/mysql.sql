/*
grant all privileges on * to test@localhost
identified by 'test'
with grant option;
*/
/* 建立数据库 */
drop database if exists spring;

create database if not exists spring
    default character set utf8
    default collate utf8_general_ci;

use spring;

/* Base */
drop table if exists sys_roles;
drop table if exists sys_users;
drop table if exists sys_users_roles;
drop table if exists sys_usergroups;
drop table if exists sys_users_usergroups;
drop table if exists sys_permissions;
drop table if exists sys_roles_permissions;
drop table if exists sys_users_permissions;
drop table if exists sys_resources;

/* 角色表 */
create table sys_roles (
    rol_id          int          not null   auto_increment,
    rol_code        varchar(255) not null,
    rol_title       varchar(255) not null,
    rol_description varchar(255),
    rol_created_at  datetime,
    rol_created_by  int,
    rol_updated_at  datetime,
    rol_updated_by  int,
    constraint pk_sys_roles_id primary key (rol_id)
);

create unique index idx_sys_roles_code on sys_roles (rol_code);

/* 用户组表 */
create table sys_usergroups (
    usg_id          int          not null auto_increment,
    usg_parent_id   int          not null,
    usg_code        varchar(255) not null,
    usg_title       varchar(255) not null,
    usg_description varchar(255),
    usg_created_at  datetime,
    usg_created_by  int,
    usg_updated_at  datetime,
    usg_updated_by  int,
    constraint sys_usergroups_id primary key (usg_id)
);

create unique index idx_sys_usergroups_code on sys_usergroups (usg_code);

/* 用户表 */
create table sys_users (
    usr_id                  int          not null auto_increment,
    usr_usg_id              int,
    usr_username            varchar(50)  not null,
    usr_email               varchar(255) not null,
    usr_password            varchar(255) not null,
    usr_nickname            varchar(255),
    usr_fullname            varchar(255),
    usr_status              varchar(50),
    usr_salt                varchar(255),
    usr_description         varchar(255),
    usr_source              varchar(50),
    usr_last_login_datetime datetime,
    usr_created_at          datetime,
    usr_created_by          int,
    usr_updated_at          datetime,
    usr_updated_by          int,
    constraint pk_sys_users_id primary key (usr_id)
);

create unique index idx_sys_users_username on sys_users (usr_username);
create unique index idx_sys_users_email on sys_users (usr_email);

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

/* 角色基础数据 */
insert into sys_roles (rol_id, rol_code, rol_title, rol_description) values
    (1, 'sysadmin', 'System Administrator', '系统管理员'),
    (2, 'admin', 'Administrator', '管理员'),
    (3, 'user', 'User', '用户');

/* 用户组基础数据 */
insert into sys_usergroups (usg_id, usg_parent_id, usg_code, usg_title, usg_created_at, usg_updated_at) values
    (1, 0, 'Root', 'Head Department', now(), now()),
    (2, 0, 'RecycleBin', 'Recycle Bin', now(), now()),
    (3, 1, 'G001', 'User Group A', now(), now()),
    (4, 1, 'G002', 'User Group B', now(), now()),
    (5, 1, 'G003', 'User Group C', now(), now()),
    (6, 1, 'G004', 'User Group D', now(), now()),
    (7, 1, 'G005', 'User Group E', now(), now()),
    (8, 1, 'G006', 'User Group F', now(), now()),
    (9, 1, 'G007', 'User Group G', now(), now()),
    (10, 3, 'G001001', 'User Group A Sub A', now(), now()),
    (11, 3, 'G001002', 'User Group A Sub B', now(), now()),
    (12, 3, 'G001003', 'User Group A Sub C', now(), now()),
    (13, 3, 'G001004', 'User Group A Sub D', now(), now()),
    (14, 3, 'G001005', 'User Group A Sub E', now(), now()),
    (15, 3, 'G001006', 'User Group A Sub F', now(), now()),
    (16, 3, 'G001007', 'User Group A Sub G', now(), now());

/* 用户基础数据 */
insert into sys_users (usr_id, usr_usg_id, usr_username, usr_nickname, usr_email, usr_source, usr_password, usr_salt)
values
    (1, 1, 'sysadmin', 'Administrator', 'sysadmin@elvea.cn', 'SYSTEM', '54a42628b7507805dd1bae08f40ccaf6274cce1b',
     '046548c3b1e3ab57'),
    (2, 1, 'admin', 'Administrator', 'admin@elvea.cn', 'SYSTEM', 'db8ce0a0872d80fa31b7ebd0d0c06cf02a900e57',
     'e416781ea9858934'),
    (3, 1, 'test', 'Test', 'test@elvea.cn', 'SYSTEM', 'dc26ff929f275650cb1787c8492c89f1c7c8892a',
     'c7a112741c92434b');

/* 用户-角色关联数据 */
insert into sys_users_roles (sur_usr_id, sur_rol_id) values
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 2),
    (2, 3),
    (3, 3);

/* 用户-用户组关联数据 */
insert into sys_users_usergroups (suu_usr_id, suu_usg_id) values (1, 1);
insert into sys_users_usergroups (suu_usr_id, suu_usg_id) values (2, 1);
insert into sys_users_usergroups (suu_usr_id, suu_usg_id) values (3, 1);

/* 权限明细数据 */
insert into sys_permissions (per_id, per_title, per_code) values
    (1, 'System', 'sys'),
    (2, 'Resource Management', 'sys:resource'),
    (3, 'View Resource', 'sys:resource:view'),
    (4, 'Create Resource', 'sys:resource:create'),
    (5, 'Update Resource', 'sys:resource:update'),
    (6, 'Delete Resource', 'sys:resource:delete'),
    (7, 'Permision Management', 'sys:permission'),
    (8, 'View Permision', 'sys:permission:view'),
    (9, 'Create Permision', 'sys:permission:create'),
    (10, 'Update Permision', 'sys:permission:update'),
    (11, 'Delete Permision', 'sys:permission:delete'),
    (12, 'Role Management', 'sys:role'),
    (13, 'View Role', 'sys:role:view'),
    (14, 'Create Role', 'sys:role:create'),
    (15, 'Update Role', 'sys:role:update'),
    (16, 'Delete Role', 'sys:role:delete'),
    (17, 'UserGroup Management', 'sys:usergroup'),
    (18, 'View UserGroup', 'sys:usergroup:view'),
    (19, 'Create UserGroup', 'sys:usergroup:create'),
    (20, 'Update UserGroup', 'sys:usergroup:update'),
    (21, 'Delete UserGroup', 'sys:usergroup:delete'),
    (22, 'User Management', 'sys:user'),
    (23, 'View User', 'sys:user:view'),
    (24, 'Create User', 'sys:user:create'),
    (25, 'Update User', 'sys:user:update'),
    (26, 'Delete User', 'sys:user:delete'),
    (27, 'Customer Management', 'sys:customer'),
    (28, 'View Customer', 'sys:customer:view'),
    (29, 'Create Customer', 'sys:customer:create'),
    (30, 'Update Customer', 'sys:customer:update'),
    (31, 'Delete Customer', 'sys:customer:delete'),
    (32, 'Dashboard', 'sys:dashboard');

/* 权限资源数据 */
insert into sys_resources (res_id, res_description, res_url, res_permissions, res_roles) values
    (1, 'Resource Management', '/resource/*', 'sys:resource', ''),
    (2, 'View Resource', '/resource/view', 'sys:resource:view', ''),
    (3, 'Create Resource', '/resource/create', 'sys:resource:create', ''),
    (4, 'Update Resource', '/resource/update', 'sys:resource:update', ''),
    (5, 'Delete Resource', '/resource/delete', 'sys:resource:delete', ''),
    (6, 'Permision Management', '/permission/*', 'sys:permission', ''),
    (7, 'View Permision', '/permission/view', 'sys:permission:view', ''),
    (8, 'Create Permision', '/permission/create', 'sys:permission:create', ''),
    (9, 'Update Permision', '/permission/update', 'sys:permission:update', ''),
    (10, 'Delete Permision', '/permission/delete', 'sys:permission:delete', ''),
    (11, 'Role Management', '/role/*', 'sys:role', ''),
    (12, 'View Role', '/role/view', 'sys:role:view', ''),
    (13, 'Create Role', '/role/create', 'sys:role:create', ''),
    (14, 'Update Role', '/role/update', 'sys:role:update', ''),
    (15, 'Delete Role', '/role/delete', 'sys:role:delete', ''),
    (16, 'UserGroup Management', '/usergroup/*', 'sys:usergroup', ''),
    (17, 'View UserGroup', '/usergroup/view', 'sys:usergroup:view', ''),
    (18, 'Create UserGroup', '/usergroup/create', 'sys:usergroup:create', ''),
    (19, 'Update UserGroup', '/usergroup/update', 'sys:usergroup:update', ''),
    (20, 'Delete UserGroup', '/usergroup/delete', 'sys:usergroup:delete', ''),
    (21, 'User Management', '/user/*', 'sys:user', ''),
    (22, 'View User', '/user/view', 'sys:user:view', ''),
    (23, 'Create User', '/user/create', 'sys:user:create', ''),
    (24, 'Update User', '/user/update', 'sys:user:update', ''),
    (25, 'Delete User', '/user/delete', 'sys:user:delete', ''),
    (26, 'Customer Management', '/customer/*', 'sys:customer', ''),
    (27, 'View Customer', '/customer/view', 'sys:customer:view', ''),
    (28, 'Create Customer', '/customer/create', 'sys:customer:create', ''),
    (29, 'Update Customer', '/customer/update', 'sys:customer:update', ''),
    (30, 'Delete Customer', '/customer/delete', 'sys:customer:delete', '');

/* 角色-权限数据 */
insert into sys_roles_permissions
    select
        rol_id,
        per_id
    from sys_roles, sys_permissions
    where rol_code = 'sysadmin';

/* 用户回话 */
drop table if exists sys_users_session;
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
