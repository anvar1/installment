alter table ASSISTANCE_INSURED_EVENT add constraint FK_ASSISTANCE_INSURED_EVENT_ON_CONTRACT foreign key (CONTRACT_ID) references ASSISTANCE_CONTRACT(ID);
alter table ASSISTANCE_INSURED_EVENT add constraint FK_ASSISTANCE_INSURED_EVENT_ON_SERVICE foreign key (SERVICE_ID) references ASSISTANCE_SERVICE(ID);
create index IDX_ASSISTANCE_INSURED_EVENT_ON_CONTRACT on ASSISTANCE_INSURED_EVENT (CONTRACT_ID);
create index IDX_ASSISTANCE_INSURED_EVENT_ON_SERVICE on ASSISTANCE_INSURED_EVENT (SERVICE_ID);
