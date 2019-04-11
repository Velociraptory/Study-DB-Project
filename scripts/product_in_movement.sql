CREATE TABLE product_in_movement (
    id           INTEGER NOT NULL,
    quantity     INTEGER NOT NULL,
    product_id   INTEGER NOT NULL,
    invoice_id   INTEGER NOT NULL
);

ALTER TABLE product_in_movement ADD CONSTRAINT product_in_movement_pk PRIMARY KEY ( id );