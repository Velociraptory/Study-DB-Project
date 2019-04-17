CREATE TABLE customer (
    id   INTEGER NOT NULL,
    first_name    CHAR(50) NOT NULL,
    last_name     CHAR(50) NOT NULL,
    phone         INTEGER NOT NULL,
    city          CHAR(100) NOT NULL,
    address       CHAR(100) NOT NULL,
    zip           INTEGER NOT NULL,
    bank_inf      CHAR(100) NOT NULL
);

ALTER TABLE customer ADD CONSTRAINT customer_pk PRIMARY KEY ( id );

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
    price        MONEY NOT NULL,
    special_offer_id   INTEGER NOT NULL
);

ALTER TABLE order_detail ADD CONSTRAINT order_detail_pk PRIMARY KEY ( id );

CREATE TABLE product (
    id      INTEGER NOT NULL,
    name    CHAR(100) NOT NULL,
    type    CHAR(100) NOT NULL,
    price   MONEY NOT NULL
);

ALTER TABLE product ADD CONSTRAINT product_pk PRIMARY KEY ( id );

CREATE TABLE special_offer (
    id     INTEGER NOT NULL,
    name   CHAR(50) NOT NULL,
    discount             INTEGER NOT NULL
);

ALTER TABLE special_offer ADD CONSTRAINT special_offer_pk PRIMARY KEY ( id );

CREATE TABLE product_in_shipment (
    id             INTEGER NOT NULL,
    id             INTEGER NOT NULL,
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
    id             INTEGER NOT NULL,
    movement_date         DATE NOT NULL,
    original_storage_id   INTEGER NOT NULL,
    final_storage_id      INTEGER NOT NULL
);

ALTER TABLE invoice ADD CONSTRAINT invoice_pk PRIMARY KEY ( id );

CREATE TABLE storage (
    id     INTEGER NOT NULL,
    name   CHAR(50) NOT NULL,
    city           CHAR(50) NOT NULL,
    address        CHAR(100) NOT NULL
);

ALTER TABLE storage ADD CONSTRAINT storage_pk PRIMARY KEY ( id );






ALTER TABLE "order"
    ADD CONSTRAINT order_customer_fk FOREIGN KEY ( customer_id )
        REFERENCES customer ( id );
        


ALTER TABLE order_detail
    ADD CONSTRAINT order_detail_product_fk FOREIGN KEY ( product_id )
        REFERENCES product ( id );
      
ALTER TABLE order_detail
    ADD CONSTRAINT order_detail_order_fk FOREIGN KEY ( order_number )
        REFERENCES "order" ( order_number );

ALTER TABLE order_detail
    ADD CONSTRAINT order_detail_special_offer_fk FOREIGN KEY ( special_offer_id )
        REFERENCES special_offer ( id );




ALTER TABLE product_in_shipment
    ADD CONSTRAINT product_in_shipment_product_fk FOREIGN KEY ( product_id )
        REFERENCES product ( id );

ALTER TABLE product_in_shipment
    ADD CONSTRAINT product_in_shipment_order_fk FOREIGN KEY ( order_number )
        REFERENCES "order" ( order_number );




ALTER TABLE product_in_movement
    ADD CONSTRAINT product_in_movement_product_fk FOREIGN KEY ( product_id )
        REFERENCES product ( id );

ALTER TABLE product_in_movement
    ADD CONSTRAINT product_in_movement_invoice_fk FOREIGN KEY ( invoice_id )
        REFERENCES invoice ( id );





ALTER TABLE invoice
    ADD CONSTRAINT invoice_storage_fk FOREIGN KEY ( original_storage_id )
        REFERENCES storage ( id );

ALTER TABLE invoice
    ADD CONSTRAINT invoice_storage_fkv2 FOREIGN KEY ( final_storage_id )
        REFERENCES storage ( id );
