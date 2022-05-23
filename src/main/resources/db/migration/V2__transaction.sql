CREATE TABLE Transaction(
    transaction_id NVARCHAR(80)  NOT NULL,
    client_id NVARCHAR(80)  NOT NULL,
    account_id INTEGER NOT NULL,
    transaction_data NVARCHAR(80) NOT NULL,
    amount NUMERIC(10,2),
    transaction_type NVARCHAR(80)  NOT NULL,
    completed BOOLEAN NOT NULL
);