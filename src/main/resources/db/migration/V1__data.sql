create TABLE AccountType
(
    account_type_id   IDENTITY     NOT NULL PRIMARY KEY,
    account_type_name NVARCHAR(80) NOT NULL,
    withdraw_allowed  BOOLEAN      NOT NULL
);

insert into AccountType (account_type_name, withdraw_allowed)
values ('CHECKING', true),
       ('SAVING', true),
       ('FIXED', false);

CREATE TABLE TransactionType
(
    transaction_type_id   IDENTITY     NOT NULL PRIMARY KEY,
    transaction_type_name NVARCHAR(80) NOT NULL
);

insert into TransactionType (transaction_type_name)
values ('ADD_MONEY'),
       ('WITHDRAW_MONEY'),
       ('TRANSFER_MONEY');

create table role
(
    role_id   IDENTITY     NOT NULL PRIMARY KEY,
    role_type NVARCHAR(80) not null
);


insert into role(role_type)
values ('ROLE_ADMIN'),
       ('ROLE_USER');

create table Users
(
    user_id  IDENTITY     NOT NULL PRIMARY KEY,
    username NVARCHAR(80) NOT NULL,
    password NVARCHAR(80) NOT NULL,
    role_id  INTEGER,
    FOREIGN KEY (role_id) REFERENCES role (role_id)
);

create TABLE Account
(
    account_id      IDENTITY NOT NULL PRIMARY KEY,
    full_account_id NVARCHAR(80),
    account_type_id INTEGER,
    client_id       NVARCHAR(80),
    bank_id         INTEGER,
    balance         NUMERIC(10, 2),
    user_id         INTEGER NOT NULL,
    FOREIGN KEY (account_type_id) REFERENCES AccountType (account_type_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);

create TABLE Transaction
(
    transaction_id      IDENTITY NOT NULL PRIMARY KEY,
    client_id           NVARCHAR(80),
    account_id          INTEGER  NOT NULL,
    bank_id             INTEGER,
    transaction_data    NVARCHAR(80),
    amount              NUMERIC(10, 2),
    transaction_type_id INTEGER,
    completed           BOOLEAN,
    FOREIGN KEY (account_id) REFERENCES Account (account_id),
    FOREIGN KEY (transaction_type_id) REFERENCES TransactionType (transaction_type_id)
);