use platform;

/* 添加顶层组织架构 */

insert into sys_organizations (
    org_id, org_parent_id, org_code, org_title, org_description,
    org_created_at, org_updated_at)
values
    (1, 0, 'TOP_ORG', 'Top Organizations', 'Top Organizations', now(), now());

/* 添加系统角色 */

insert into sys_roles (
    rol_id, rol_org_id, rol_code, rol_title, rol_description,
    rol_created_at, rol_updated_at)
values
    (1, 1, 'ROL_SYS_ADMIN', 'System Administrator', 'System Administrator', now(), now()),
    (2, 1, 'ROL_ADMIN', 'Administrator', 'Administrator', now(), now()),
    (3, 1, 'ROL_USER', 'Normal User', 'Normal User', now(), now());

/* 用户组基础数据 */
insert into sys_usergroups (usg_id, usg_org_id, usg_parent_id, usg_code, usg_title, usg_created_at, usg_updated_at)
values
    (1, 1, 0, 'Root', 'Top UserGroup', now(), now()),
    (2, 1, 0, 'RecycleBin', 'Recycle Bin', now(), now());

/* 岗位职务基础数据 */
insert into sys_positions (pos_id, pos_org_id, pos_parent_id, pos_code, pos_title, pos_created_at, pos_updated_at)
values
    (1, 1, 0, 'Root', 'Top Position', now(), now()),
    (2, 1, 0, 'Default', 'Default Position', now(), now());

/* 用户基础数据 */
insert into sys_users (usr_id, usr_org_id, usr_usg_id, usr_username, usr_nickname, usr_email, usr_source, usr_password, usr_salt)
values
    (1, 1, 1, 'sysadmin', 'Administrator', 'sysadmin@elvea.cn', 'SYSTEM', '54a42628b7507805dd1bae08f40ccaf6274cce1b',
     '046548c3b1e3ab57'),
    (2, 1, 1, 'admin', 'Administrator', 'admin@elvea.cn', 'SYSTEM', 'db8ce0a0872d80fa31b7ebd0d0c06cf02a900e57',
     'e416781ea9858934'),
    (3, 1, 1, 'test', 'Test', 'test@elvea.cn', 'SYSTEM', 'dc26ff929f275650cb1787c8492c89f1c7c8892a',
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
