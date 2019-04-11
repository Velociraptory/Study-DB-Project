CREATE TABLE invoice (
    invoce_id             INTEGER NOT NULL,
    movement_date         DATE NOT NULL,
    original_storage_id   INTEGER NOT NULL,
    final_storage_id      INTEGER NOT NULL
);

ALTER TABLE invoice ADD CONSTRAINT invoice_pk PRIMARY KEY ( invoce_id );