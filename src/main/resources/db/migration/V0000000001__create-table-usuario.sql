create table users(
  userid integer not null primary key,
  username varchar(100),
  useremail varchar(255),
  userlogin varchar(50),
  userpassword varchar(20),
  userfone varchar(11),
  userstatus char(1)
);

create sequence user_sequence start with 1;