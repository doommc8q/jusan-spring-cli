create TABLE AccountType (
    account_type_id IDENTITY NOT NULL PRIMARY KEY,
    account_type_name NVARCHAR(80)  NOT NULL,
    withdraw_allowed BOOLEAN NOT NULL
);

insert into AccountType (account_type_name, withdraw_allowed)
values ('CHECKING', true),
('SAVING', true),
('FIXED', false);