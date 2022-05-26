create TABLE Account(
    account_id  IDENTITY NOT NULL PRIMARY KEY,
    full_account_id NVARCHAR(80),
    account_type_id INTEGER,
    client_id NVARCHAR(80),
    bank_id INTEGER,
    balance NUMERIC(10,2),
    FOREIGN KEY (account_type_id) REFERENCES AccountType (account_type_id)
);
