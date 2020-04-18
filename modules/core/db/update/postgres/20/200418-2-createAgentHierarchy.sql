alter table ASSISTANCE_AGENT_HIERARCHY add constraint FK_ASSISTANCE_AGENT_HIERARCHY_ON_AGENT foreign key (AGENT_ID) references ASSISTANCE_AGENT(ID);
alter table ASSISTANCE_AGENT_HIERARCHY add constraint FK_ASSISTANCE_AGENT_HIERARCHY_ON_PARENT foreign key (PARENT_ID) references ASSISTANCE_AGENT(ID);
create index IDX_ASSISTANCE_AGENT_HIERARCHY_ON_AGENT on ASSISTANCE_AGENT_HIERARCHY (AGENT_ID);
create index IDX_ASSISTANCE_AGENT_HIERARCHY_ON_PARENT on ASSISTANCE_AGENT_HIERARCHY (PARENT_ID);