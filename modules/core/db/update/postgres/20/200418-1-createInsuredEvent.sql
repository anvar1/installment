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
);