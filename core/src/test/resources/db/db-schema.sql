/* 角色表 */
drop table if exists roles;

create table roles (
    id          int not null auto_increment,
    code        varchar(255),
    description varchar(255),
    createdAt   datetime,
    updatedAt   datetime,
    constraint pk_roles_id primary key (id)
);

create unique index idx_roles_code on roles (code);

/* 用户表 */
drop table if exists users;

create table users (
    id          int         not null auto_increment,
    username    varchar(50) not null,
    description varchar(255),
    createdAt   datetime,
    updatedAt   datetime,
    constraint pk_users_id primary key (id)
);

create unique index idx_ussrs_username on users (username);
