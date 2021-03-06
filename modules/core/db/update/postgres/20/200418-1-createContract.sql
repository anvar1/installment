create table ASSISTANCE_CONTRACT (
    ID bigint,
    VERSION integer not null,
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    --
    BRANCH_ID integer not null,
    PRODUCT_ID integer not null,
    SUB_PRODUCT_ID integer not null,
    INSURANT varchar(255) not null,
    PHONE varchar(20),
    MOBILE_PHONE varchar(50),
    NUMBER_ varchar(25) not null,
    DATE_ date not null,
    LIABILITY double precision not null,
    PREMIUM double precision not null,
    DATE_FROM date not null,
    DATE_TO date not null,
    BRAND_ID integer,
    PROPERTY_TYPE_ID integer not null,
    PROPERTY varchar(255) not null,
    PROPERTY_CODE varchar(50) not null,
    AGENT_ID integer,
    COMMISSION double precision not null,
    COMMENT_ varchar(255),
    --
    primary key (ID)
);