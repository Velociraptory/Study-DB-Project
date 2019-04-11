CREATE TABLE "order"(
    order_number    INTEGER NOT NULL,
    customer_id     INTEGER NOT NULL,
    order_date      DATE NOT NULL,
    shipment_date   DATE NOT NULL
);

ALTER TABLE "order" ADD CONSTRAINT order_pk PRIMARY KEY ( order_number );