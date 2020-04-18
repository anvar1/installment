-- begin ASSISTANCE_INSURED_EVENT
create table ASSISTANCE_INSURED_EVENT (
    ID bigint,
    VERSION integer not null,
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    --
    PASSPORT_SERIES varchar(3),
    PASSPORT_NUMBER_ varchar(9),
    PASSPORT_GIVEN varchar(255),
    PASSPORT_GIVEN_DATE date,
    --
    CONTRACT_ID bigint not null,
    INSURANT varchar(255) not null,
    NUMBER_ varchar(20),
    DATE_ date not null,
    SERVICE_ID integer not null,
    EVENT_DATE date not null,
    YEAR_ integer,
    WAS_INSURED boolean not null,
    PHONE varchar(20),
    SUM_ double precision not null,
    SUM_NOT_RECOVERED double precision not null,
    VAT_SUM double precision not null,
    VAT_SUM_NOT_RECOVERED double precision not null,
    TOTAL double precision not null,
    TOTAL_NOT_RECOVERED double precision not null,
    STATUS varchar(50) not null,
    --
    primary key (ID)
)^
-- end ASSISTANCE_INSURED_EVENT
-- begin ASSISTANCE_INSURED_EVENT_REPAIR_NOT_COVERED
create table ASSISTANCE_INSURED_EVENT_REPAIR_NOT_COVERED (
    ID bigint,
    --
    INSURED_EVENT_ID bigint,
    REPAIR_ID integer not null,
    PRICE double precision not null,
    COUNT_ integer not null,
    SUM_ double precision not null,
    VAT double precision not null,
    VAT_SUM double precision not null,
    TOTAL double precision not null,
    --
    primary key (ID)
)^
-- end ASSISTANCE_INSURED_EVENT_REPAIR_NOT_COVERED
-- begin ASSISTANCE_CONTRACT
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
)^
-- end ASSISTANCE_CONTRACT
-- begin ASSISTANCE_INSURED_EVENT_REPAIR
create table ASSISTANCE_INSURED_EVENT_REPAIR (
    ID bigint,
    --
    INSURED_EVENT_ID bigint,
    REPAIR_ID integer not null,
    PRICE double precision not null,
    COUNT_ integer not null,
    SUM_ double precision not null,
    VAT double precision not null,
    VAT_SUM double precision not null,
    TOTAL double precision not null,
    --
    primary key (ID)
)^
-- end ASSISTANCE_INSURED_EVENT_REPAIR
-- begin ASSISTANCE_BRANCH
create table ASSISTANCE_BRANCH (
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
    NAME varchar(120) not null,
    PARENT_ID integer,
    --
    primary key (ID)
)^
-- end ASSISTANCE_BRANCH
-- begin ASSISTANCE_COUNTRY
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
)^
-- end ASSISTANCE_COUNTRY
-- begin ASSISTANCE_SERVICE_HIERARCHY
create table ASSISTANCE_SERVICE_HIERARCHY (
    ID integer,
    --
    SERVICE_ID integer not null,
    PARENT_ID integer not null,
    LEVEL_ integer,
    --
    primary key (ID)
)^
-- end ASSISTANCE_SERVICE_HIERARCHY
-- begin ASSISTANCE_REGION
create table ASSISTANCE_REGION (
    ID integer,
    --
    NAME varchar(40) not null,
    NAME_UZ varchar(40) not null,
    ORDER_ integer,
    --
    primary key (ID)
)^
-- end ASSISTANCE_REGION
-- begin ASSISTANCE_PROPERTY_TYPE
create table ASSISTANCE_PROPERTY_TYPE (
    ID integer,
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ASSISTANCE_PROPERTY_TYPE
-- begin ASSISTANCE_DISTRICT
create table ASSISTANCE_DISTRICT (
    ID integer,
    --
    NAME varchar(60) not null,
    NAME_UZ varchar(60) not null,
    REGION_ID integer not null,
    ORDER_ integer,
    --
    primary key (ID)
)^
-- end ASSISTANCE_DISTRICT
-- begin ASSISTANCE_BRANCH_HIERARCHY
create table ASSISTANCE_BRANCH_HIERARCHY (
    ID integer,
    --
    BRANCH_ID integer not null,
    PARENT_ID integer not null,
    LEVEL_ integer,
    --
    primary key (ID)
)^
-- end ASSISTANCE_BRANCH_HIERARCHY
-- begin ASSISTANCE_DETAIL_AND_REPAIR_LIST
create table ASSISTANCE_DETAIL_AND_REPAIR_LIST (
    ID integer,
    --
    NAME varchar(200) not null,
    --
    primary key (ID)
)^
-- end ASSISTANCE_DETAIL_AND_REPAIR_LIST
-- begin ASSISTANCE_PRODUCT
create table ASSISTANCE_PRODUCT (
    ID integer,
    --
    CODE varchar(10) not null,
    NAME varchar(150) not null,
    DESCRIPTION varchar(255),
    --
    primary key (ID)
)^
-- end ASSISTANCE_PRODUCT
-- begin ASSISTANCE_BRAND
create table ASSISTANCE_BRAND (
    ID integer,
    --
    NAME varchar(120) not null,
    DESCRIPTION varchar(255),
    --
    primary key (ID)
)^
-- end ASSISTANCE_BRAND
-- begin ASSISTANCE_SUB_PRODUCT
create table ASSISTANCE_SUB_PRODUCT (
    ID integer,
    --
    NAME varchar(255),
    PRODUCT_ID integer not null,
    ORDER_ integer,
    --
    primary key (ID)
)^
-- end ASSISTANCE_SUB_PRODUCT
-- begin ASSISTANCE_AGENT
create table ASSISTANCE_AGENT (
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
)^
-- end ASSISTANCE_AGENT
-- begin ASSISTANCE_SERVICE
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
)^
-- end ASSISTANCE_SERVICE
-- begin ASSISTANCE_AGENT_HIERARCHY
create table ASSISTANCE_AGENT_HIERARCHY (
    ID integer,
    --
    AGENT_ID integer not null,
    PARENT_ID integer not null,
    LEVEL_ integer,
    --
    primary key (ID)
)^
-- end ASSISTANCE_AGENT_HIERARCHY
-- begin SEC_USER
alter table SEC_USER add column BRANCH_ID integer ^
alter table SEC_USER add column AGENT_ID integer ^
alter table SEC_USER add column SERVICE_ID integer ^
alter table SEC_USER add column DTYPE varchar(100) ^
update SEC_USER set DTYPE = 'assistance_ExtUser' where DTYPE is null ^
-- end SEC_USER
