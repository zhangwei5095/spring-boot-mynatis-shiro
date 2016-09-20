delete from users;

insert into roles (code, description, createdAt, updatedAt)
values ('sysadmin', 'System Administrator', now(), now());

insert into roles (code, description, createdAt, updatedAt)
values ('manager', 'Manager', now(), now());

delete from users;

insert into users (username, description, createdAt, updatedAt)
values ('sysadmin', 'System Administrator', now(), now());

insert into users (username, description, createdAt, updatedAt)
values ('manager', 'Manager', now(), now());
