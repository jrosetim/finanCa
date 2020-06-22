drop table users;

create table users(
  userid integer not null primary key,
  useremail varchar(255),
  userpassword varchar(20),
  userfone varchar(11),
  userstatus char(1)
);