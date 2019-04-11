CREATE TABLE special_offer (
    special_offer_id     INTEGER NOT NULL,
    special_offer_name   CHAR(50) NOT NULL,
    discount             INTEGER NOT NULL
);

ALTER TABLE special_offer ADD CONSTRAINT special_offer_pk PRIMARY KEY ( special_offer_id );