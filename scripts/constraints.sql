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