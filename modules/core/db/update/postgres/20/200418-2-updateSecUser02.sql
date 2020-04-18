alter table SEC_USER add constraint FK_SEC_USER_ON_SERVICE foreign key (SERVICE_ID) references ASSISTANCE_SERVICE(ID);
create index IDX_SEC_USER_ON_SERVICE on SEC_USER (SERVICE_ID);
