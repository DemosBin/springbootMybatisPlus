create table t_user(
  id long primary key not null,
  account varchar(50) not null ,
  name varchar(50) not null ,
  password varchar(50) not null ,
  email varchar(100) null
);

create table t_role(
  id long primary key not null,
  code varchar(50) not null ,
  name varchar(50) not null ,
  remark varchar(255) null
);

create table t_permission(
  id long primary key not null,
  code varchar(50) not null ,
  name varchar(50) not null ,
  remark varchar(255) null
);

create table t_user_role(
   id long primary key not null,
   code varchar(50) not null ,
   user_id varchar(50) not null ,
   role_id varchar(255) null
);

create table t_role_permission(
  id int primary key not null,
  code varchar(50) not null ,
  role_id varchar(255) not null ,
  permission_id varchar(50) not null
);