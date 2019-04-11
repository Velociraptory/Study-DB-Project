CREATE TABLE product (
    product_id      INTEGER NOT NULL,
    product_name    CHAR(100) NOT NULL,
    product_type    CHAR(100) NOT NULL,
    product_price   MONEY NOT NULL
);

ALTER TABLE product ADD CONSTRAINT product_pk PRIMARY KEY ( product_id );