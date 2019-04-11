CREATE TABLE customer (
    customer_id   INTEGER NOT NULL,
    first_name    CHAR(50) NOT NULL,
    last_name     CHAR(50) NOT NULL,
    phone         INTEGER NOT NULL,
    city          CHAR(100) NOT NULL,
    address       CHAR(100) NOT NULL,
    zip           INTEGER NOT NULL,
    bank_inf      CHAR(100) NOT NULL
);

ALTER TABLE customer ADD CONSTRAINT customer_pk PRIMARY KEY ( customer_id );