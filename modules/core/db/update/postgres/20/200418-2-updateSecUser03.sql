alter table SEC_USER add constraint FK_SEC_USER_ON_BRANCH foreign key (BRANCH_ID) references ASSISTANCE_BRANCH(ID);
create index IDX_SEC_USER_ON_BRANCH on SEC_USER (BRANCH_ID);
