create table ASSISTANCE_SERVICE (
    ID integer,
    --
    CLIENT_TIN varchar(12),
    CLIENT_NAME varchar(150),
    CLIENT_CHIEF_NAME varchar(120),
    CLIENT_ACCOUNTANT_NAME varchar(120),
    CLIENT_CONTACT_NAME varchar(120),
    CLIENT_DOCUMENT varchar(120),
    CLIENT_NCEA varchar(5),
    ADDRESS_COUNTRY_ID integer not null,
    ADDRESS_REGION_ID integer not null,
    ADDRESS_DISTRICT_ID integer,
    ADDRESS_CITY varchar(80),
    ADDRESS_ADDRESS varchar(150),
    BANK_CODE varchar(5),
    BANK_NAME varchar(255),
    BANK_ACCOUNT_NUMBER varchar(20),
    CONTACT_PHONE varchar(50),
    CONTACT_FAX varchar(50),
    CONTACT_MOBILE_PHONE varchar(50),
    CONTACT_EMAIL varchar(50),
    CONTACT_WWW varchar(50),
    CONTACT_TELEGRAM varchar(50),
    PASSPORT_SERIES varchar(3),
    PASSPORT_NUMBER_ varchar(9),
    PASSPORT_GIVEN varchar(255),
    PASSPORT_GIVEN_DATE date,
    --
    NAME varchar(150) not null,
    PARENT_ID integer,
    --
    primary key (ID)
);