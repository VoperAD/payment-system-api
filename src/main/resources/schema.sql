DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS transactions;

CREATE TABLE users (
    id IDENTITY PRIMARY KEY,
    balance DECIMAL(10, 2) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    document VARCHAR(255) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    user_type VARCHAR(255) NOT NULL
);

CREATE TABLE transactions (
    id IDENTITY PRIMARY KEY,
    sender LONG NOT NULL,
    receiver LONG NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (sender) REFERENCES users(id),
    FOREIGN KEY (receiver) REFERENCES users(id)
);