CREATE SCHEMA IF NOT EXISTS medicine_management;

CREATE TABLE medicine_management.medicine_detail (
    ID bigint PRIMARY KEY,
    UNIQUE_ID UUID NOT NULL UNIQUE,
    NAME varchar(1000),
    PRIMARY_COMPOSITION varchar(1000),
    SECONDARY_COMPOSITION varchar(1000),
    PHARMACEUTICAL_NAME varchar(1000),
    PRICE numeric(10, 2),
    PACK_SIZE varchar(100),
    IS_DISCONTINUED boolean
);
