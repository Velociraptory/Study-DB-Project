CREATE TABLE storage (
    storage_id     INTEGER NOT NULL,
    storage_name   CHAR(50) NOT NULL,
    city           CHAR(50) NOT NULL,
    address        CHAR(100) NOT NULL
);

ALTER TABLE storage ADD CONSTRAINT storage_pk PRIMARY KEY ( storage_id );