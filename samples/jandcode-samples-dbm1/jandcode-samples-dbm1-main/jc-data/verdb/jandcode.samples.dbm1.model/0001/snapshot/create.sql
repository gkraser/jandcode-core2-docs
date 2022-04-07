create table simple_dict (
  id bigint not null,
  name varchar(30),
  code varchar(10)
)
~~
create table tab1 (
  id bigint not null,
  f_string varchar(30),
  f_boolean smallint,
  f_datetime timestamp,
  f_date date,
  f_int integer,
  f_smallint smallint,
  f_long bigint,
  f_ref_simple_dict_1 bigint,
  f_ref_simple_dict_2 bigint,
  f_memo text,
  f_blob bytea,
  f_parent bigint,
  f_parent_auto_title bigint,
  f_ref_auto_title bigint
)
~~
create table tab2 (
  id bigint not null,
  f_string varchar(30),
  f_boolean smallint
)
~~
create table tab3 (
  id bigint not null,
  f_string varchar(30)
)
~~
alter table simple_dict add constraint pk_simple_dict primary key (id)
~~
alter table tab1 add constraint pk_tab1 primary key (id)
~~
alter table tab2 add constraint pk_tab2 primary key (id)
~~
alter table tab3 add constraint pk_tab3 primary key (id)
~~
alter table tab1 add constraint fk_tab1_f_ref_simple_dict_1
foreign key(f_ref_simple_dict_1) references simple_dict(id)
~~
alter table tab1 add constraint fk_tab1_f_ref_simple_dict_2
foreign key(f_ref_simple_dict_2) references simple_dict(id)
~~
alter table tab1 add constraint fk_tab1_f_parent
foreign key(f_parent) references tab1(id)
~~
alter table tab1 add constraint fk_tab1_f_parent_auto_title
foreign key(f_parent_auto_title) references tab1(id)
~~
alter table tab1 add constraint fk_tab1_f_ref_auto_title
foreign key(f_ref_auto_title) references simple_dict(id)
~~
