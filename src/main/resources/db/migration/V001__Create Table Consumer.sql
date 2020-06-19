create table consumer(
id bigint not null auto_increment,
name varchar (255) not null,
last_name varchar (255) not null,
address varchar (255) not null,
phone varchar (20) not null,
email varchar (50) not null,
complement varchar (255),
cpf varchar(20) not null,

primary key (id)
);