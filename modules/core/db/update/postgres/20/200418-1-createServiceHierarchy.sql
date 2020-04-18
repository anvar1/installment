create table ASSISTANCE_SERVICE_HIERARCHY (
    ID integer,
    --
    SERVICE_ID integer not null,
    PARENT_ID integer not null,
    LEVEL_ integer,
    --
    primary key (ID)
);