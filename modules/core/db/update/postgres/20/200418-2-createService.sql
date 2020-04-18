alter table ASSISTANCE_SERVICE add constraint FK_ASSISTANCE_SERVICE_ON_PARENT foreign key (PARENT_ID) references ASSISTANCE_SERVICE(ID);
alter table ASSISTANCE_SERVICE add constraint FK_ASSISTANCE_SERVICE_ON_ADDRESS_COUNTRY foreign key (ADDRESS_COUNTRY_ID) references ASSISTANCE_COUNTRY(ID);
alter table ASSISTANCE_SERVICE add constraint FK_ASSISTANCE_SERVICE_ON_ADDRESS_REGION foreign key (ADDRESS_REGION_ID) references ASSISTANCE_REGION(ID);
alter table ASSISTANCE_SERVICE add constraint FK_ASSISTANCE_SERVICE_ON_ADDRESS_DISTRICT foreign key (ADDRESS_DISTRICT_ID) references ASSISTANCE_DISTRICT(ID);
create unique index IDX_ASSISTANCE_SERVICE_UK_NAME on ASSISTANCE_SERVICE (NAME) ;
create index IDX_ASSISTANCE_SERVICE_ON_PARENT on ASSISTANCE_SERVICE (PARENT_ID);
create index IDX_ASSISTANCE_SERVICE_ON_ADDRESS_COUNTRY on ASSISTANCE_SERVICE (ADDRESS_COUNTRY_ID);
create index IDX_ASSISTANCE_SERVICE_ON_ADDRESS_REGION on ASSISTANCE_SERVICE (ADDRESS_REGION_ID);
create index IDX_ASSISTANCE_SERVICE_ON_ADDRESS_DISTRICT on ASSISTANCE_SERVICE (ADDRESS_DISTRICT_ID);