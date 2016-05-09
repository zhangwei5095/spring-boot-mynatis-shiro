/* 建立测试数据库数据库 */
drop database if exists springtest;

create database if not exists springtest
    default character set utf8
    default collate utf8_general_ci;

grant all privileges on springtest.* to 'test'@'localhost'
identified by 'test'
with grant option;

use springtest;

/* 角色表 */
drop table if exists roles;

create table roles (
    id          int not null auto_increment,
    code        varchar(255),
    description varchar(255),
    createdAt   datetime,
    createdBy   int,
    updatedAt   datetime,
    updatedBy   int,
    constraint pk_roles_id primary key (id)
);

create unique index idx_roles_code on roles (code);

/* 用户表 */
drop table if exists users;

create table users (
    id        int         not null auto_increment,
    username  varchar(50) not null,
    createdAt datetime,
    createdBy int,
    updatedAt datetime,
    updatedBy int,
    deletedAt datetime,
    deletedBy int,
    constraint pk_users_id primary key (id)
);

create unique index idx_ussrs_username on users (username);
