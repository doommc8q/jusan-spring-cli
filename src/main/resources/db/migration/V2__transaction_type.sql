CREATE TABLE TransactionType(
    transaction_type_id  IDENTITY NOT NULL PRIMARY KEY,
    transaction_type_name NVARCHAR(80)  NOT NULL
);

insert into TransactionType (transaction_type_name)
values ('ADD_MONEY'),
('WITHDRAW_MONEY'),
('TRANSFER_MONEY');