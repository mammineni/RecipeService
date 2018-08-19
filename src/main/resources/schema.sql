
create table recipe
(
   id integer not null AUTO_INCREMENT,
   name varchar(255) not null,
   ingredients varchar(800) not null,
   addedDate DATE,
   url varchar(255) default null,
   primary key(id)
);