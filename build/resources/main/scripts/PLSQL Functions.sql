CREATE OR REPLACE FUNCTION test_insert() RETURNS void AS $$
DECLARE
    i INTEGER;
BEGIN
FOR i IN 10..10000
    LOOP
    RAISE NOTICE 'i = %', i;
INSERT INTO product (id, name, type, price) VALUES (i, 'test_product', 'trash', '666');

END LOOP;
 END;
$$ LANGUAGE plpgsql;

SELECT test_insert();

//////////////////////////////////////////////////////////////////////////////
CREATE OR REPLACE FUNCTION test_insert() RETURNS void AS $$
DECLARE
    i INTEGER;
BEGIN
FOR i IN 10..10000
    LOOP
    RAISE NOTICE 'i = %', i;
INSERT INTO product_in_movement (id, quantity, product_id, invoice_id) VALUES (i, '999', i, i);

END LOOP;
 END;
$$ LANGUAGE plpgsql;

SELECT test_insert();

//////////////////////////////////////////////////////////////////////////////
CREATE OR REPLACE FUNCTION test_insert() RETURNS void AS $$
DECLARE
    i INTEGER;
BEGIN
FOR i IN 10..10000
    LOOP
    RAISE NOTICE 'i = %', i;
INSERT INTO invoice (id, movement_date, original_storage_id, final_storage_id) VALUES (i, '04.18.2019', '0', '1');

END LOOP;
 END;
$$ LANGUAGE plpgsql;

SELECT test_insert();

/////////////////////////////////////////////////////////////////////////
CREATE OR REPLACE FUNCTION test_insert() RETURNS void AS $$
DECLARE
    i INTEGER;
BEGIN
FOR i IN 10..10000
    LOOP
    IF(i % 2 = 0) THEN
    RAISE NOTICE 'i = %', i;
INSERT INTO invoice (id, movement_date, original_storage_id, final_storage_id) VALUES (i, '04.18.2019', '0', '1');
    ELSE
    RAISE NOTICE 'i = %', i;
INSERT INTO invoice (id, movement_date, original_storage_id, final_storage_id) VALUES (i, '04.18.2019', '1', '2');
END IF;

END LOOP;
 END;
$$ LANGUAGE plpgsql;

SELECT test_insert();
