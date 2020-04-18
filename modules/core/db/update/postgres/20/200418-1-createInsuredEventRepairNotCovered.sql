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
);