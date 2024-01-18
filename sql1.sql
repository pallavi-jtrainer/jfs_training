create database paychexdb;
use paychexdb;

-- single-line comment
#  single - line comment
/*
	multi
    line
    comment
*/

create table student (
	studentid int primary key,
    firstname varchar(25) not null,
    lastname varchar(50) not null,
    email varchar(100) not null unique,
    address varchar(255) not null,
    dob date not null,
    courseid int not null
);

create table courses (
	courseid int primary key,
    coursename varchar(100) not null unique,
    amount double not null default 2500.00
   --  constraint pk_course primary key(courseid)
);

alter table student add constraint fk_courseid 
foreign key (courseid) references courses(courseid);

-- drop table student;

-- show tables;
-- show databases;

# dml statements
# insert, update, delete

insert into courses values (1, "Essentials of Core Java", 3400);
insert into courses(courseid, coursename) values (2, "MySQL Specials");
insert into courses values 
(3, "Spring Boot Refresher", 4500),
(4, "Spring Revisited", 4000),
(5, "Hibernate Overview", 3500),
(6, "Core of Core Java", 5400);

-- insert into courses values (7, "Core of Core Java", 5400);
desc courses;
desc student;

-- update courses set amount = 4000 where courseid = 4;
-- update courses set amount = 4000;
commit;

delete from courses where courseid = 1;
delete from student where courseid = 4;

-- dql
# select column_list/* from table_name
# order of clauses:
# from -> where -> group by -> having -> order by

select * from courses;
select studentid, email from student;
select * from student where courseid = 2;


-- create a user and grant permissions
create user 'trainer' identified by 'pass1234';
grant all on paychexdb.* to 'trainer';