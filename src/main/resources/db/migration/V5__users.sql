create table role
(
    role_id IDENTITY NOT NULL PRIMARY KEY,
    role_type NVARCHAR(80) not null
);


insert into role(role_type)
values ('ROLE_ADMIN'),
('ROLE_USER');

create table Users(
    user_id IDENTITY NOT NULL PRIMARY KEY,
    username NVARCHAR(80) NOT NULL,
    password NVARCHAR(80) NOT NULL,
    role_id  INTEGER,
    FOREIGN KEY (role_id) REFERENCES role (role_id)
);