alter table SEC_USER add constraint FK_SEC_USER_ON_AGENT foreign key (AGENT_ID) references ASSISTANCE_AGENT(ID);
create index IDX_SEC_USER_ON_AGENT on SEC_USER (AGENT_ID);
