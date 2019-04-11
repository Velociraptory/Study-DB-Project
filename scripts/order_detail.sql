CREATE TABLE order_detail (
    id                 INTEGER NOT NULL,
    order_number       INTEGER NOT NULL,
    product_id         INTEGER NOT NULL,
    quantity           INTEGER NOT NULL,
    order_price        MONEY NOT NULL,
    special_offer_id   INTEGER NOT NULL
);

ALTER TABLE order_detail ADD CONSTRAINT order_detail_pk PRIMARY KEY ( id );