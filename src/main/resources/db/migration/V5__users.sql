create TABLE Users(
    user_id IDENTITY NOT NULL PRIMARY KEY,
    username  NVARCHAR(80) NOT NULL,
    password  NVARCHAR(80) NOT NULL,
    email NVARCHAR(80) NOT NULL
);
--insert into Users (username, password, email) values
--('doom1', '$2a$16$28myhXGaex5e106VEskTxe3y.ZeaD8E66NUxoV5iO91iZABM0O9SK', 'doom1@gmail.com'),
--('doom2', '$2a$16$28myhXGaex5e106VEskTxe3y.ZeaD8E66NUxoV5iO91iZABM0O9SK');