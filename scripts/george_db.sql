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

CREATE TABLE "order"(
    order_number    INTEGER NOT NULL,
    customer_id     INTEGER NOT NULL,
    order_date      DATE NOT NULL,
    shipment_date   DATE NOT NULL
);

ALTER TABLE "order" ADD CONSTRAINT order_pk PRIMARY KEY ( order_number );

CREATE TABLE order_detail (
    id                 INTEGER NOT NULL,
    order_number       INTEGER NOT NULL,
    product_id         INTEGER NOT NULL,
    quantity           INTEGER NOT NULL,
    order_price        MONEY NOT NULL,
    special_offer_id   INTEGER NOT NULL
);

ALTER TABLE order_detail ADD CONSTRAINT order_detail_pk PRIMARY KEY ( id );

CREATE TABLE product (
    product_id      INTEGER NOT NULL,
    product_name    CHAR(100) NOT NULL,
    product_type    CHAR(100) NOT NULL,
    product_price   MONEY NOT NULL
);

ALTER TABLE product ADD CONSTRAINT product_pk PRIMARY KEY ( product_id );

CREATE TABLE special_offer (
    special_offer_id     INTEGER NOT NULL,
    special_offer_name   CHAR(50) NOT NULL,
    discount             INTEGER NOT NULL
);

ALTER TABLE special_offer ADD CONSTRAINT special_offer_pk PRIMARY KEY ( special_offer_id );

CREATE TABLE product_in_shipment (
    id             INTEGER NOT NULL,
    shipment_id    INTEGER NOT NULL,
    quantity       INTEGER NOT NULL,
    product_id     INTEGER NOT NULL,
    order_number   INTEGER NOT NULL
);

ALTER TABLE product_in_shipment ADD CONSTRAINT product_in_shipment_pk PRIMARY KEY ( id );

CREATE TABLE product_in_movement (
    id           INTEGER NOT NULL,
    quantity     INTEGER NOT NULL,
    product_id   INTEGER NOT NULL,
    invoice_id   INTEGER NOT NULL
);

ALTER TABLE product_in_movement ADD CONSTRAINT product_in_movement_pk PRIMARY KEY ( id );

CREATE TABLE invoice (
    invoce_id             INTEGER NOT NULL,
    movement_date         DATE NOT NULL,
    original_storage_id   INTEGER NOT NULL,
    final_storage_id      INTEGER NOT NULL
);

ALTER TABLE invoice ADD CONSTRAINT invoice_pk PRIMARY KEY ( invoce_id );

CREATE TABLE storage (
    storage_id     INTEGER NOT NULL,
    storage_name   CHAR(50) NOT NULL,
    city           CHAR(50) NOT NULL,
    address        CHAR(100) NOT NULL
);

ALTER TABLE storage ADD CONSTRAINT storage_pk PRIMARY KEY ( storage_id );






ALTER TABLE "order"
    ADD CONSTRAINT order_customer_fk FOREIGN KEY ( customer_id )
        REFERENCES customer ( customer_id );
        


ALTER TABLE order_detail
    ADD CONSTRAINT order_detail_product_fk FOREIGN KEY ( product_id )
        REFERENCES product ( product_id );
      
ALTER TABLE order_detail
    ADD CONSTRAINT order_detail_order_fk FOREIGN KEY ( order_number )
        REFERENCES "order" ( order_number );

ALTER TABLE order_detail
    ADD CONSTRAINT order_detail_special_offer_fk FOREIGN KEY ( special_offer_id )
        REFERENCES special_offer ( special_offer_id );




ALTER TABLE product_in_shipment
    ADD CONSTRAINT product_in_shipment_product_fk FOREIGN KEY ( product_id )
        REFERENCES product ( product_id );

ALTER TABLE product_in_shipment
    ADD CONSTRAINT product_in_shipment_order_fk FOREIGN KEY ( order_number )
        REFERENCES "order" ( order_number );




ALTER TABLE product_in_movement
    ADD CONSTRAINT product_in_movement_product_fk FOREIGN KEY ( product_id )
        REFERENCES product ( product_id );

ALTER TABLE product_in_movement
    ADD CONSTRAINT product_in_movement_invoice_fk FOREIGN KEY ( invoice_id )
        REFERENCES invoice ( invoce_id );





ALTER TABLE invoice
    ADD CONSTRAINT invoice_storage_fk FOREIGN KEY ( original_storage_id )
        REFERENCES storage ( storage_id );

ALTER TABLE invoice
    ADD CONSTRAINT invoice_storage_fkv2 FOREIGN KEY ( final_storage_id )
        REFERENCES storage ( storage_id );
