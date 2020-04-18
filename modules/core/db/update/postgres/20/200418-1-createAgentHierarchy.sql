create table ASSISTANCE_AGENT_HIERARCHY (
    ID integer,
    --
    AGENT_ID integer not null,
    PARENT_ID integer not null,
    LEVEL_ integer,
    --
    primary key (ID)
);