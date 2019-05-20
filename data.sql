create table account (id bigint AUTO_INCREMENT PRIMARY KEY, name varchar(255) not null, description varchar(255), owned_by varchar(255));
create table account_rev (account_id bigint, aggrev bigint);
insert into account values(1,"Name 1", "Description 1", "owner1");
insert into account values(2,"Name 2", "Description 2", "owner2");
insert into account_rev values(1, 200);
insert into account_rev values(2, 400);