create table users(
  userid integer not null primary key,
  useremail varchar(255),
  userpassword varchar(20),
  userstatus char(1),
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
  personname varchar(100) not null,
  cpf varchar(14),
  rg varchar(20),
  genderid integer,
  userid integer,
  personfone varchar(20)
);

alter table person add constraint fk_gender foreign key (genderid) references gender(genderid);
alter table person add constraint fk_users foreign key (userid) references users(userid);

create sequence person_sequence start with 1;

create table address(
  addressid integer not null primary key,
  street varchar(100),
  neighborhood varchar(100),
  zipcode varchar(15),
  city varchar(100),
  state char(2),
  personid integer
);

alter table address add constraint fk_person foreign key(personid) references person(personid);

create sequence address_sequence start with 1;