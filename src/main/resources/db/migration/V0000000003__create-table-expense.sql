create table expense(
  id integer not null,
  dateexpense date,
  description varchar(500),
  paymentid integer,
  typeexpenseid integer,
  groupexpenseid integer,
  value numeric(15,2),
  instalment integer,
  userid integer,
  situationexpenseid integer,
  inout char(1)
);

create sequence expense_sequence start with 1;