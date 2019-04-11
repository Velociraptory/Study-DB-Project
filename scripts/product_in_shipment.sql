CREATE TABLE product_in_shipment (
    id             INTEGER NOT NULL,
    shipment_id    INTEGER NOT NULL,
    quantity       INTEGER NOT NULL,
    product_id     INTEGER NOT NULL,
    order_number   INTEGER NOT NULL
);

ALTER TABLE product_in_shipment ADD CONSTRAINT product_in_shipment_pk PRIMARY KEY ( id );