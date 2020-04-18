create table ASSISTANCE_COUNTRY (
    ID integer,
    --
    NAME varchar(80) not null,
    NAME_FULL varchar(80),
    NAME_EN varchar(80) not null,
    ALPHA2 varchar(2) not null,
    ALPHA3 varchar(3) not null,
    --
    primary key (ID)
);