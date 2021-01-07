insert into users (id, age, last_name, name, email ,password) values (1, 10, 'Admin1', 'ADMIN', 'admin@mail.com' , '1234' );
insert into users (id, age, last_name, name, email, password) values (2, 20, 'User1', 'USER', 'user@gmail.com' , '1234' );

insert into roles (id, role) values (1,'ROLE_ADMIN' );
insert into roles (id, role) values (2,'ROLE_USER' );

insert into users_roles (user_id, roles_id) values (1, 1);
insert into users_roles (user_id, roles_id) values (1, 2);
insert into users_roles (user_id, roles_id) values (2, 2);