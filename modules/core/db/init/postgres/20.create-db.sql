-- begin ASSISTANCE_INSURED_EVENT
alter table ASSISTANCE_INSURED_EVENT add constraint FK_ASSISTANCE_INSURED_EVENT_ON_CONTRACT foreign key (CONTRACT_ID) references ASSISTANCE_CONTRACT(ID)^
alter table ASSISTANCE_INSURED_EVENT add constraint FK_ASSISTANCE_INSURED_EVENT_ON_SERVICE foreign key (SERVICE_ID) references ASSISTANCE_SERVICE(ID)^
create index IDX_ASSISTANCE_INSURED_EVENT_ON_CONTRACT on ASSISTANCE_INSURED_EVENT (CONTRACT_ID)^
create index IDX_ASSISTANCE_INSURED_EVENT_ON_SERVICE on ASSISTANCE_INSURED_EVENT (SERVICE_ID)^
-- end ASSISTANCE_INSURED_EVENT
-- begin ASSISTANCE_INSURED_EVENT_REPAIR_NOT_COVERED
alter table ASSISTANCE_INSURED_EVENT_REPAIR_NOT_COVERED add constraint FK_ASSISTANCE_INSUREVENTREPAINOTCOVER_ON_INSURED_EVENT foreign key (INSURED_EVENT_ID) references ASSISTANCE_INSURED_EVENT(ID)^
alter table ASSISTANCE_INSURED_EVENT_REPAIR_NOT_COVERED add constraint FK_ASSISTANCE_INSURED_EVENT_REPAIR_NOT_COVERED_ON_REPAIR foreign key (REPAIR_ID) references ASSISTANCE_DETAIL_AND_REPAIR_LIST(ID)^
create index IDX_ASSISTANCE_INSUREVENTREPAINOTCOVER_ON_INSURED_EVENT on ASSISTANCE_INSURED_EVENT_REPAIR_NOT_COVERED (INSURED_EVENT_ID)^
create index IDX_ASSISTANCE_INSURED_EVENT_REPAIR_NOT_COVERED_ON_REPAIR on ASSISTANCE_INSURED_EVENT_REPAIR_NOT_COVERED (REPAIR_ID)^
-- end ASSISTANCE_INSURED_EVENT_REPAIR_NOT_COVERED
-- begin ASSISTANCE_CONTRACT
alter table ASSISTANCE_CONTRACT add constraint FK_ASSISTANCE_CONTRACT_ON_BRANCH foreign key (BRANCH_ID) references ASSISTANCE_BRANCH(ID)^
alter table ASSISTANCE_CONTRACT add constraint FK_ASSISTANCE_CONTRACT_ON_PRODUCT foreign key (PRODUCT_ID) references ASSISTANCE_PRODUCT(ID)^
alter table ASSISTANCE_CONTRACT add constraint FK_ASSISTANCE_CONTRACT_ON_SUB_PRODUCT foreign key (SUB_PRODUCT_ID) references ASSISTANCE_SUB_PRODUCT(ID)^
alter table ASSISTANCE_CONTRACT add constraint FK_ASSISTANCE_CONTRACT_ON_BRAND foreign key (BRAND_ID) references ASSISTANCE_BRAND(ID)^
alter table ASSISTANCE_CONTRACT add constraint FK_ASSISTANCE_CONTRACT_ON_PROPERTY_TYPE foreign key (PROPERTY_TYPE_ID) references ASSISTANCE_PROPERTY_TYPE(ID)^
alter table ASSISTANCE_CONTRACT add constraint FK_ASSISTANCE_CONTRACT_ON_AGENT foreign key (AGENT_ID) references ASSISTANCE_AGENT(ID)^
create index IDX_ASSISTANCE_CONTRACT_ON_BRANCH on ASSISTANCE_CONTRACT (BRANCH_ID)^
create index IDX_ASSISTANCE_CONTRACT_ON_PRODUCT on ASSISTANCE_CONTRACT (PRODUCT_ID)^
create index IDX_ASSISTANCE_CONTRACT_ON_SUB_PRODUCT on ASSISTANCE_CONTRACT (SUB_PRODUCT_ID)^
create index IDX_ASSISTANCE_CONTRACT_ON_BRAND on ASSISTANCE_CONTRACT (BRAND_ID)^
create index IDX_ASSISTANCE_CONTRACT_ON_PROPERTY_TYPE on ASSISTANCE_CONTRACT (PROPERTY_TYPE_ID)^
create index IDX_ASSISTANCE_CONTRACT_ON_AGENT on ASSISTANCE_CONTRACT (AGENT_ID)^
-- end ASSISTANCE_CONTRACT
-- begin ASSISTANCE_INSURED_EVENT_REPAIR
alter table ASSISTANCE_INSURED_EVENT_REPAIR add constraint FK_ASSISTANCE_INSURED_EVENT_REPAIR_ON_INSURED_EVENT foreign key (INSURED_EVENT_ID) references ASSISTANCE_INSURED_EVENT(ID)^
alter table ASSISTANCE_INSURED_EVENT_REPAIR add constraint FK_ASSISTANCE_INSURED_EVENT_REPAIR_ON_REPAIR foreign key (REPAIR_ID) references ASSISTANCE_DETAIL_AND_REPAIR_LIST(ID)^
create index IDX_ASSISTANCE_INSURED_EVENT_REPAIR_ON_INSURED_EVENT on ASSISTANCE_INSURED_EVENT_REPAIR (INSURED_EVENT_ID)^
create index IDX_ASSISTANCE_INSURED_EVENT_REPAIR_ON_REPAIR on ASSISTANCE_INSURED_EVENT_REPAIR (REPAIR_ID)^
-- end ASSISTANCE_INSURED_EVENT_REPAIR
-- begin ASSISTANCE_BRANCH
alter table ASSISTANCE_BRANCH add constraint FK_ASSISTANCE_BRANCH_ON_PARENT foreign key (PARENT_ID) references ASSISTANCE_BRANCH(ID)^
alter table ASSISTANCE_BRANCH add constraint FK_ASSISTANCE_BRANCH_ON_ADDRESS_COUNTRY foreign key (ADDRESS_COUNTRY_ID) references ASSISTANCE_COUNTRY(ID)^
alter table ASSISTANCE_BRANCH add constraint FK_ASSISTANCE_BRANCH_ON_ADDRESS_REGION foreign key (ADDRESS_REGION_ID) references ASSISTANCE_REGION(ID)^
alter table ASSISTANCE_BRANCH add constraint FK_ASSISTANCE_BRANCH_ON_ADDRESS_DISTRICT foreign key (ADDRESS_DISTRICT_ID) references ASSISTANCE_DISTRICT(ID)^
create unique index IDX_ASSISTANCE_BRANCH_UK_NAME on ASSISTANCE_BRANCH (NAME) ^
create index IDX_ASSISTANCE_BRANCH_ON_PARENT on ASSISTANCE_BRANCH (PARENT_ID)^
create index IDX_ASSISTANCE_BRANCH_ON_ADDRESS_COUNTRY on ASSISTANCE_BRANCH (ADDRESS_COUNTRY_ID)^
create index IDX_ASSISTANCE_BRANCH_ON_ADDRESS_REGION on ASSISTANCE_BRANCH (ADDRESS_REGION_ID)^
create index IDX_ASSISTANCE_BRANCH_ON_ADDRESS_DISTRICT on ASSISTANCE_BRANCH (ADDRESS_DISTRICT_ID)^
-- end ASSISTANCE_BRANCH
-- begin ASSISTANCE_COUNTRY
create unique index IDX_ASSISTANCE_COUNTRY_UK_ALPHA2 on ASSISTANCE_COUNTRY (ALPHA2) ^
create unique index IDX_ASSISTANCE_COUNTRY_UK_NAME_EN on ASSISTANCE_COUNTRY (NAME_EN) ^
create unique index IDX_ASSISTANCE_COUNTRY_UK_NAME on ASSISTANCE_COUNTRY (NAME) ^
create unique index IDX_ASSISTANCE_COUNTRY_UK_ALPHA3 on ASSISTANCE_COUNTRY (ALPHA3) ^
-- end ASSISTANCE_COUNTRY
-- begin ASSISTANCE_SERVICE_HIERARCHY
alter table ASSISTANCE_SERVICE_HIERARCHY add constraint FK_ASSISTANCE_SERVICE_HIERARCHY_ON_SERVICE foreign key (SERVICE_ID) references ASSISTANCE_SERVICE(ID)^
alter table ASSISTANCE_SERVICE_HIERARCHY add constraint FK_ASSISTANCE_SERVICE_HIERARCHY_ON_PARENT foreign key (PARENT_ID) references ASSISTANCE_SERVICE(ID)^
create index IDX_ASSISTANCE_SERVICE_HIERARCHY_ON_SERVICE on ASSISTANCE_SERVICE_HIERARCHY (SERVICE_ID)^
create index IDX_ASSISTANCE_SERVICE_HIERARCHY_ON_PARENT on ASSISTANCE_SERVICE_HIERARCHY (PARENT_ID)^
-- end ASSISTANCE_SERVICE_HIERARCHY
-- begin ASSISTANCE_REGION
create unique index IDX_ASSISTANCE_REGION_UK_NAME on ASSISTANCE_REGION (NAME) ^
create unique index IDX_ASSISTANCE_REGION_UK_NAME_UZ on ASSISTANCE_REGION (NAME_UZ) ^
-- end ASSISTANCE_REGION
-- begin ASSISTANCE_DISTRICT
alter table ASSISTANCE_DISTRICT add constraint FK_ASSISTANCE_DISTRICT_ON_REGION foreign key (REGION_ID) references ASSISTANCE_REGION(ID)^
create index IDX_ASSISTANCE_DISTRICT_ON_REGION on ASSISTANCE_DISTRICT (REGION_ID)^
-- end ASSISTANCE_DISTRICT
-- begin ASSISTANCE_BRANCH_HIERARCHY
alter table ASSISTANCE_BRANCH_HIERARCHY add constraint FK_ASSISTANCE_BRANCH_HIERARCHY_ON_BRANCH foreign key (BRANCH_ID) references ASSISTANCE_BRANCH(ID)^
alter table ASSISTANCE_BRANCH_HIERARCHY add constraint FK_ASSISTANCE_BRANCH_HIERARCHY_ON_PARENT foreign key (PARENT_ID) references ASSISTANCE_BRANCH(ID)^
create index IDX_ASSISTANCE_BRANCH_HIERARCHY_ON_BRANCH on ASSISTANCE_BRANCH_HIERARCHY (BRANCH_ID)^
create index IDX_ASSISTANCE_BRANCH_HIERARCHY_ON_PARENT on ASSISTANCE_BRANCH_HIERARCHY (PARENT_ID)^
-- end ASSISTANCE_BRANCH_HIERARCHY
-- begin ASSISTANCE_PRODUCT
create unique index IDX_ASSISTANCE_PRODUCT_UK_CODE on ASSISTANCE_PRODUCT (CODE) ^
-- end ASSISTANCE_PRODUCT
-- begin ASSISTANCE_BRAND
create unique index IDX_ASSISTANCE_BRAND_UK_NAME on ASSISTANCE_BRAND (NAME) ^
-- end ASSISTANCE_BRAND
-- begin ASSISTANCE_SUB_PRODUCT
alter table ASSISTANCE_SUB_PRODUCT add constraint FK_ASSISTANCE_SUB_PRODUCT_ON_PRODUCT foreign key (PRODUCT_ID) references ASSISTANCE_PRODUCT(ID)^
create index IDX_ASSISTANCE_SUB_PRODUCT_ON_PRODUCT on ASSISTANCE_SUB_PRODUCT (PRODUCT_ID)^
-- end ASSISTANCE_SUB_PRODUCT
-- begin ASSISTANCE_AGENT
alter table ASSISTANCE_AGENT add constraint FK_ASSISTANCE_AGENT_ON_PARENT foreign key (PARENT_ID) references ASSISTANCE_AGENT(ID)^
alter table ASSISTANCE_AGENT add constraint FK_ASSISTANCE_AGENT_ON_ADDRESS_COUNTRY foreign key (ADDRESS_COUNTRY_ID) references ASSISTANCE_COUNTRY(ID)^
alter table ASSISTANCE_AGENT add constraint FK_ASSISTANCE_AGENT_ON_ADDRESS_REGION foreign key (ADDRESS_REGION_ID) references ASSISTANCE_REGION(ID)^
alter table ASSISTANCE_AGENT add constraint FK_ASSISTANCE_AGENT_ON_ADDRESS_DISTRICT foreign key (ADDRESS_DISTRICT_ID) references ASSISTANCE_DISTRICT(ID)^
create unique index IDX_ASSISTANCE_AGENT_UK_NAME on ASSISTANCE_AGENT (NAME) ^
create index IDX_ASSISTANCE_AGENT_ON_PARENT on ASSISTANCE_AGENT (PARENT_ID)^
create index IDX_ASSISTANCE_AGENT_ON_ADDRESS_COUNTRY on ASSISTANCE_AGENT (ADDRESS_COUNTRY_ID)^
create index IDX_ASSISTANCE_AGENT_ON_ADDRESS_REGION on ASSISTANCE_AGENT (ADDRESS_REGION_ID)^
create index IDX_ASSISTANCE_AGENT_ON_ADDRESS_DISTRICT on ASSISTANCE_AGENT (ADDRESS_DISTRICT_ID)^
-- end ASSISTANCE_AGENT
-- begin ASSISTANCE_SERVICE
alter table ASSISTANCE_SERVICE add constraint FK_ASSISTANCE_SERVICE_ON_PARENT foreign key (PARENT_ID) references ASSISTANCE_SERVICE(ID)^
alter table ASSISTANCE_SERVICE add constraint FK_ASSISTANCE_SERVICE_ON_ADDRESS_COUNTRY foreign key (ADDRESS_COUNTRY_ID) references ASSISTANCE_COUNTRY(ID)^
alter table ASSISTANCE_SERVICE add constraint FK_ASSISTANCE_SERVICE_ON_ADDRESS_REGION foreign key (ADDRESS_REGION_ID) references ASSISTANCE_REGION(ID)^
alter table ASSISTANCE_SERVICE add constraint FK_ASSISTANCE_SERVICE_ON_ADDRESS_DISTRICT foreign key (ADDRESS_DISTRICT_ID) references ASSISTANCE_DISTRICT(ID)^
create unique index IDX_ASSISTANCE_SERVICE_UK_NAME on ASSISTANCE_SERVICE (NAME) ^
create index IDX_ASSISTANCE_SERVICE_ON_PARENT on ASSISTANCE_SERVICE (PARENT_ID)^
create index IDX_ASSISTANCE_SERVICE_ON_ADDRESS_COUNTRY on ASSISTANCE_SERVICE (ADDRESS_COUNTRY_ID)^
create index IDX_ASSISTANCE_SERVICE_ON_ADDRESS_REGION on ASSISTANCE_SERVICE (ADDRESS_REGION_ID)^
create index IDX_ASSISTANCE_SERVICE_ON_ADDRESS_DISTRICT on ASSISTANCE_SERVICE (ADDRESS_DISTRICT_ID)^
-- end ASSISTANCE_SERVICE
-- begin ASSISTANCE_AGENT_HIERARCHY
alter table ASSISTANCE_AGENT_HIERARCHY add constraint FK_ASSISTANCE_AGENT_HIERARCHY_ON_AGENT foreign key (AGENT_ID) references ASSISTANCE_AGENT(ID)^
alter table ASSISTANCE_AGENT_HIERARCHY add constraint FK_ASSISTANCE_AGENT_HIERARCHY_ON_PARENT foreign key (PARENT_ID) references ASSISTANCE_AGENT(ID)^
create index IDX_ASSISTANCE_AGENT_HIERARCHY_ON_AGENT on ASSISTANCE_AGENT_HIERARCHY (AGENT_ID)^
create index IDX_ASSISTANCE_AGENT_HIERARCHY_ON_PARENT on ASSISTANCE_AGENT_HIERARCHY (PARENT_ID)^
-- end ASSISTANCE_AGENT_HIERARCHY
-- begin SEC_USER
alter table SEC_USER add constraint FK_SEC_USER_ON_BRANCH foreign key (BRANCH_ID) references ASSISTANCE_BRANCH(ID)^
create index IDX_SEC_USER_ON_BRANCH on SEC_USER (BRANCH_ID)^
alter table SEC_USER add constraint FK_SEC_USER_ON_AGENT foreign key (AGENT_ID) references ASSISTANCE_AGENT(ID)^
create index IDX_SEC_USER_ON_AGENT on SEC_USER (AGENT_ID)^
alter table SEC_USER add constraint FK_SEC_USER_ON_SERVICE foreign key (SERVICE_ID) references ASSISTANCE_SERVICE(ID)^
create index IDX_SEC_USER_ON_SERVICE on SEC_USER (SERVICE_ID)^
-- end SEC_USER
