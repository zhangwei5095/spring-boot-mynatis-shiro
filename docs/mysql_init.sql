/* 建立测试数据库数据库 */
drop database if exists platform;

create database if not exists platform
    default character set utf8
    default collate utf8_general_ci;

grant all privileges on test.* to 'test'@'localhost'
identified by 'test'
with grant option;

use platform;