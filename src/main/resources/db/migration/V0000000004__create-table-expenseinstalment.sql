create table expenseinstalment(
  id integer not null primary key,
  instalment integer,
  value numeric(15,2),
  duedate date,
  idexpense integer,
  state char(1)
);

create sequence expenseinstalment_sequence start with 1;