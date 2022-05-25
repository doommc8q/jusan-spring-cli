CREATE TABLE Account(
    id NVARCHAR(80)  NOT NULL,
    account_type NVARCHAR(80)  NOT NULL,
    client_id NVARCHAR(80)  NOT NULL,
    bank_id INTEGER  NOT NULL,
    balance NUMERIC(10,2),
    withdraw_allowed BOOLEAN NOT NULL
);
