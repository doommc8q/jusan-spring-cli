create TABLE Transaction(
    transaction_id IDENTITY NOT NULL PRIMARY KEY,
    client_id NVARCHAR(80),
    account_id INTEGER NOT NULL,
    bank_id INTEGER,
    transaction_data NVARCHAR(80),
    amount NUMERIC(10,2),
    transaction_type_id INTEGER,
    completed BOOLEAN,
    FOREIGN KEY (account_id) REFERENCES Account (account_id),
    FOREIGN KEY (transaction_type_id) REFERENCES TransactionType(transaction_type_id)
);