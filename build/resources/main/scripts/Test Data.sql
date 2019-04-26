INSERT INTO  customer (id, first_name, last_name, phone, city, address, zip, bank_inf) VALUES ('1', 'Michael', 'Scott', '999', 'Scranton', '1st Street', '777', 'bank_inf');
INSERT INTO  customer (id, first_name, last_name, phone, city, address, zip, bank_inf) VALUES ('2', 'Dwight', 'Schrute', '999', 'Scranton', '2nd Street', '777', 'bank_inf');
INSERT INTO  customer (id, first_name, last_name, phone, city, address, zip, bank_inf) VALUES ('3', 'Jim', 'Halpert', '999', 'Scranton', '3rd Street', '777', 'bank_inf');
INSERT INTO  customer (id, first_name, last_name, phone, city, address, zip, bank_inf) VALUES ('4', 'Pam', 'Beesly', '999', 'Scranton', '4th Street', '777', 'bank_inf');
INSERT INTO  customer (id, first_name, last_name, phone, city, address, zip, bank_inf) VALUES ('5', 'Ryan', 'Howard', '999', 'Scranton', '5th Street', '777', 'bank_inf');

INSERT INTO  "order" (order_number, customer_id, order_date, shipment_date) VALUES ('1', '1', '04.18.2019', '04.19.2019');
INSERT INTO  "order" (order_number, customer_id, order_date, shipment_date) VALUES ('2', '2', '04.18.2019', '04.19.2019');
INSERT INTO  "order" (order_number, customer_id, order_date, shipment_date) VALUES ('3', '3', '04.18.2019', '04.19.2019');
INSERT INTO  "order" (order_number, customer_id, order_date, shipment_date) VALUES ('4', '4', '04.18.2019', '04.19.2019');
INSERT INTO  "order" (order_number, customer_id, order_date, shipment_date) VALUES ('5', '5', '04.18.2019', '04.19.2019');

INSERT INTO  product (id, name, type, price) VALUES ('1', 'paper', 'office supply', '5');
INSERT INTO  product (id, name, type, price) VALUES ('2', 'staples', 'office supply', '2');
INSERT INTO  product (id, name, type, price) VALUES ('3', 'pencil', 'office supply', '10');
INSERT INTO  product (id, name, type, price) VALUES ('4', 'pen', 'office supply', '15');
INSERT INTO  product (id, name, type, price) VALUES ('5', 'scissors', 'office supply', '50');
INSERT INTO  product (id, name, type, price) VALUES ('6', 'world''s best boss coffee mug', 'dishes', '500');

INSERT INTO  special_offer (id, name, discount) VALUES ('1', 'quarter', '25');
INSERT INTO  special_offer (id, name, discount) VALUES ('2', 'half', '50');

INSERT INTO  storage (id, name, city, address) VALUES ('1', 'Dunder Mifflin', 'Scranton', '1st street');
INSERT INTO  storage (id, name, city, address) VALUES ('2', 'Staples Inc', 'Scranton', '2nd street');
INSERT INTO  storage (id, name, city, address) VALUES ('3', 'Office Depot', 'Scranton', '3rd street');
INSERT INTO  storage (id, name, city, address) VALUES ('4', 'Michael Scott Paper Company', 'Scranton', '4th street');
INSERT INTO  storage (id, name, city, address) VALUES ('0', 'GENERAL STORAGE', 'New York', '5th street');

INSERT INTO  order_detail (id, order_number, product_id, quantity, price, special_offer_id) VALUES ('1', '1', '6', '1', '500', NULL);
INSERT INTO  order_detail (id, order_number, product_id, quantity, price, special_offer_id) VALUES ('2', '2', '1', '1000', '5000', NULL);
INSERT INTO  order_detail (id, order_number, product_id, quantity, price, special_offer_id) VALUES ('3', '3', '2', '1000', '2000', NULL);
INSERT INTO  order_detail (id, order_number, product_id, quantity, price, special_offer_id) VALUES ('4', '4', '3', '100', '1000', NULL);
INSERT INTO  order_detail (id, order_number, product_id, quantity, price, special_offer_id) VALUES ('5', '5', '5', '5', '250', NULL);
INSERT INTO  order_detail (id, order_number, product_id, quantity, price, special_offer_id) VALUES ('6', '5', '5', '5', '125', '2');

INSERT INTO  product_in_shipment (id, shipment_id, quantity, product_id, order_number) VALUES ('1', '1', '1', '6', '1');
INSERT INTO  product_in_shipment (id, shipment_id, quantity, product_id, order_number) VALUES ('2', '2', '1000', '1', '2');
INSERT INTO  product_in_shipment (id, shipment_id, quantity, product_id, order_number) VALUES ('3', '3', '1000', '2', '3');
INSERT INTO  product_in_shipment (id, shipment_id, quantity, product_id, order_number) VALUES ('4', '4', '100', '3', '4');
INSERT INTO  product_in_shipment (id, shipment_id, quantity, product_id, order_number) VALUES ('5', '5', '5', '5', '5');

INSERT INTO  invoice (id, movement_date, original_storage_id, final_storage_id) VALUES ('1', '04.18.2019', '0', '1');
INSERT INTO  invoice (id, movement_date, original_storage_id, final_storage_id) VALUES ('2', '04.18.2019', '1', '2');
INSERT INTO  invoice (id, movement_date, original_storage_id, final_storage_id) VALUES ('3', '04.19.2019', '2', '1');
INSERT INTO  invoice (id, movement_date, original_storage_id, final_storage_id) VALUES ('4', '04.18.2019', '0', '3');
INSERT INTO  invoice (id, movement_date, original_storage_id, final_storage_id) VALUES ('5', '04.18.2019', '3', '4');
INSERT INTO  invoice (id, movement_date, original_storage_id, final_storage_id) VALUES ('6', '04.19.2019', '4', '3');
INSERT INTO  invoice (id, movement_date, original_storage_id, final_storage_id) VALUES ('7', '04.19.2019', '0', '3');

INSERT INTO  product_in_movement (id, quantity, product_id, invoice_id) VALUES ('1', '1000', '2', '1');
INSERT INTO  product_in_movement (id, quantity, product_id, invoice_id) VALUES ('2', '1000', '2', '2');
INSERT INTO  product_in_movement (id, quantity, product_id, invoice_id) VALUES ('3', '1000', '2', '3');
INSERT INTO  product_in_movement (id, quantity, product_id, invoice_id) VALUES ('4', '1000', '3', '4');
INSERT INTO  product_in_movement (id, quantity, product_id, invoice_id) VALUES ('5', '1000', '3', '5');
INSERT INTO  product_in_movement (id, quantity, product_id, invoice_id) VALUES ('6', '1000', '3', '6');
INSERT INTO  product_in_movement (id, quantity, product_id, invoice_id) VALUES ('7', '500', '1', '7');