create table ASSISTANCE_BRANCH_HIERARCHY (
    ID integer,
    --
    BRANCH_ID integer not null,
    PARENT_ID integer not null,
    LEVEL_ integer,
    --
    primary key (ID)
);