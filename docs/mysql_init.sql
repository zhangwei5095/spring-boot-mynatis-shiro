/* 建立测试数据库数据库 */
drop database if exists platform;

create database if not exists platform
    default character set utf8
    default collate utf8_general_ci;

grant all privileges on test.* to 'test'@'localhost'
identified by 'test'
with grant option;

use platform;

/* 实体表 */
create table Entity (
    `id`        int          not null auto_increment,
    `uid`       varchar(255) not null,
    `source`    varchar(50)  not null,
    `type`      varchar(50)  not null,
    `createdAt` datetime,
    `createdBy` int,
    `updatedAt` datetime,
    `updatedBy` int,
    `deletedAt` datetime,
    `deletedBy` int,
    constraint PK_Entity_id primary key (id)
);

create table EntityRelation (
    `id`        int not null auto_increment,
    `parentId`  int not null,
    `childId`   int not null,
    `parentInd` int not null,
    `level`     int not null,
    `type`      varchar(255),
    `createdAt` datetime,
    `createdBy` int,
    constraint FK_EntityRelation_parentId foreign key (parentId) references Entity (id),
    constraint FK_EntityRelation_childId foreign key (childId) references Entity (id),
    constraint PK_EntityRelation_id primary key (id)
);

/* 角色表 */
create table Role (
    `id`          int          not null   auto_increment,
    `code`        varchar(255) not null,
    `title`       varchar(255) not null,
    `description` varchar(255),
    constraint FK_Role_id foreign key (id) references Entity (id),
    constraint PK_Role_id primary key (id)
);

/* 组织表 */
create table Organization (
    `id`          int          not null,
    `code`        varchar(255) not null,
    `title`       varchar(255) not null,
    `description` varchar(255),
    constraint FK_Organization_id foreign key (id) references Entity (id),
    constraint PK_Organization_id primary key (id)
);

/* 部门表 */
create table Department (
    `id`          int          not null,
    `code`        varchar(255) not null,
    `title`       varchar(255) not null,
    `description` varchar(255),
    constraint FK_Department_id foreign key (id) references Entity (id),
    constraint PK_Department_id primary key (id)
);

/* 岗位表 */
create table Position (
    `id`          int          not null,
    `code`        varchar(255) not null,
    `title`       varchar(255) not null,
    `description` varchar(255),
    constraint FK_Position_id foreign key (id) references Entity (id),
    constraint PK_Position_id primary key (id)
);

/* 用户表 */
create table User (
    `id`                int          not null,
    `username`          varchar(50)  not null,
    `email`             varchar(255) not null,
    `mobile`            varchar(255) not null,
    `password`          varchar(255) not null,
    `salt`              varchar(255),
    `nickname`          varchar(255),
    `fullname`          varchar(255),
    `description`       varchar(255),
    `status`            varchar(50),
    `source`            varchar(50),
    `lastLoginStatus`   varchar(50),
    `lastLoginDatetime` datetime,
    constraint FK_User_id foreign key (id) references Entity (id),
    constraint PK_User_id primary key (id)
);

/* 权限表 */
create table Permission (
    `id`          int not null auto_increment,
    `code`        varchar(255),
    `title`       varchar(255),
    `description` varchar(255),
    constraint PK_Permission_id primary key (id)
);

/* 实体-权限关联表 */
create table EntityPermission (
    `id`           int not null auto_increment,
    `entityId`     int not null,
    `permissionId` int not null,
    `createdAt`    datetime,
    `createdBy`    int,
    constraint FK_EntityPermission_entityId foreign key (entityId) references Entity (id),
    constraint FK_EntityPermission_permissionId foreign key (permissionId) references Permission (id),
    constraint PK_EntityPermission_id primary key (id)
);

/* 用户回话 */
create table UserSession (
    `id`             int          not null auto_increment,
    `sessionId`      varchar(255) not null,
    `username`       varchar(255) null,
    `host`           varchar(255) not null,
    `lastAccessTime` datetime,
    `startDatetime`  datetime,
    `endDatetime`    datetime,
    constraint PK_UserSession_id primary key (id)
);

/* 字典 */
create table Dict (
    `id`          int          not null auto_increment,
    `code`        varchar(255) not null,
    `name`        varchar(255) not null,
    `description` varchar(255) not null,
    `createdAt`   datetime,
    `createdBy`   int,
    `updatedAt`   datetime,
    `updatedBy`   int,
    constraint PK_Dict_id primary key (id)
);

/* 字典明细 */
create table DictItem (
    `id`          int          not null auto_increment,
    `dictId`      int          not null,
    `key`         varchar(255) not null,
    `value`       varchar(255) not null,
    `description` varchar(255) not null,
    `createdAt`   datetime,
    `createdBy`   int,
    `updatedAt`   datetime,
    `updatedBy`   int,
    constraint FK_DictItem_dictId foreign key (dictId) references Dict (id),
    constraint PK_DictItem_id primary key (id)
);

/* 上传附件表 */
create table Attachment (
    `id`          int          not null auto_increment,
    `uuid`        varchar(255) not null,
    `filename`    varchar(255) null,
    `description` varchar(255) not null,
    `createdAt`   datetime,
    `createdBy`   int,
    `updatedAt`   datetime,
    `updatedBy`   int,
    constraint PK_Attachment_id primary key (id)
);

/* 目录 */
create table Catalog (
    `id`          int          not null auto_increment,
    `code`        varchar(255) not null,
    `title`       varchar(255) null,
    `description` varchar(255) not null,
    `type`        varchar(255) not null,
    `createdAt`   datetime,
    `createdBy`   int,
    `updatedAt`   datetime,
    `updatedBy`   int,
    constraint PK_Catalog_id primary key (id)
);

create table CatalogRelation (
    `id`        int not null auto_increment,
    `parentId`  int not null,
    `childId`   int not null,
    `parentInd` int not null,
    `level`     int not null,
    `createdAt` datetime,
    `createdBy` int,
    constraint FK_CatalogRelation_parentId foreign key (parentId) references Catalog (id),
    constraint FK_CatalogRelation_childId foreign key (childId) references Catalog (id),
    constraint PK_CatalogRelation_id primary key (id)
);

create table CatalogAccess (
    `id`             int         not null auto_increment,
    `accessType`     varchar(50) not null,
    `accessRoleId`   int         not null,
    `accessEntityId` int         not null,
    `createdAt`      datetime,
    `createdBy`      int,
    constraint FK_CatalogAccess_accessRoleId foreign key (accessRoleId) references Entity (id),
    constraint FK_CatalogAccess_accessEntityId foreign key (accessEntityId) references Entity (id),
    constraint PK_CatalogAccess_id primary key (id)
);

/* 资源表 */
create table Resource (
    `id`          int not null auto_increment,
    `code`        varchar(255),
    `title`       varchar(255),
    `description` varchar(255),
    `type`        varchar(255),
    `createdAt`   datetime,
    `createdBy`   int,
    `updatedAt`   datetime,
    `updatedBy`   int,
    constraint PK_Resources_id primary key (id)
);

create table ResourceAccess (
    `id`             int         not null auto_increment,
    `accessType`     varchar(50) not null,
    `accessRoleId`   int         not null,
    `accessEntityId` int         not null,
    `createdAt`      datetime,
    `createdBy`      int,
    constraint FK_ResourceAccess_accessRoleId foreign key (accessRoleId) references Entity (id),
    constraint FK_ResourceAccess_accessEntityId foreign key (accessEntityId) references Entity (id),
    constraint PK_ResourceAccess_id primary key (id)
);

