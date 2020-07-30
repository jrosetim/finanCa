create table paymentmethod(
  id numeric(10,0),
  description varchar(100),
  state char(1)
);

insert into paymentmethod values(1, 'cartão crédito', 'A');
insert into paymentmethod values(2, 'cartão débito', 'A');
insert into paymentmethod values(3, 'Dinheiro', 'A');
insert into paymentmethod values(4, 'Transferência', 'A');
insert into paymentmethod values(5, 'Boleto', 'A');
insert into paymentmethod values(6, 'Débito automático', 'A');

create table typeexpense(
  id numeric(10,0),
  description varchar(100),
  state char(1)
);

insert into typeexpense values(1, 'Livre', 'A');
insert into typeexpense values(2, 'Essencial', 'A');
insert into typeexpense values(3, 'Objetivo', 'A');
insert into typeexpense values(4, 'Educação', 'A');
insert into typeexpense values(5, 'Outros', 'A');

create table groupexpense(
  id numeric(10,0),
  description varchar(100),
  state char(1)
);

insert into groupexpense values(1, 'Economia', 'A');
insert into groupexpense values(2, 'Investimento', 'A');
insert into groupexpense values(3, 'Fármacia', 'A');
insert into groupexpense values(4, 'Lazer', 'A');
insert into groupexpense values(5, 'Combustível', 'A');
insert into groupexpense values(6, 'Mercado', 'A');
insert into groupexpense values(7, 'Energia elétrica', 'A');
insert into groupexpense values(8, 'Condominio', 'A');
insert into groupexpense values(9, 'Internet', 'A');
insert into groupexpense values(10, 'Casa', 'A');
insert into groupexpense values(11, 'Presente', 'A');
insert into groupexpense values(12, 'Alimentação', 'A');
insert into groupexpense values(13, 'Outros', 'A');
insert into groupexpense values(14, 'Carro', 'A');
insert into groupexpense values(15, 'Faculdade', 'A');
insert into groupexpense values(16, 'Escola', 'A');
insert into groupexpense values(17, 'Material escolar/faculdade', 'A');
insert into groupexpense values(18, 'Curso', 'A');
insert into groupexpense values(19, 'Educação', 'A');
insert into groupexpense values(20, 'TV por assinatura', 'A');

create table situationexpense(
  id numeric(10,0),
  description varchar(100),
  state char(1)
);

insert into situationexpense values(1, 'Conferido', 'A');
insert into situationexpense values(2, 'Aproximado', 'A');
insert into situationexpense values(3, 'Conferir', 'A');

create sequence paymentmethod_sequence start with 7;

create sequence typeexpense_sequence start with 6;

create sequence groupexepense_sequence start with 21;
