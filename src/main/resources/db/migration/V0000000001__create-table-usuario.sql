create table users(
  userid integer not null primary key,
  useremail varchar(255),
  username varchar(100),
  userpassword varchar(20),
  userstatus char(1),
  usertype char(1),
  datecreation timestamp
);

create sequence user_sequence start with 1;

create table gender(
  genderid integer not null primary key,
  description varchar(30)
);

insert into gender values(1, 'Masculino' );
insert into gender values(2, 'Feminino' );
insert into gender values(3, 'Outro' );

create table person(
  personid integer not null primary key,
  cpf varchar(14),
  rg varchar(20),
  genderid integer,
  userid integer,
  street varchar(100),
  neighborhood varchar(100),
  zipcode varchar(20),
  city varchar(100),
  state varchar(2),
  addressnumber varchar(10),
  personstate char(1)
);

alter table person add constraint fk_gender foreign key (genderid) references gender(genderid);
alter table person add constraint fk_users foreign key (userid) references users(userid);

create sequence person_sequence start with 1;