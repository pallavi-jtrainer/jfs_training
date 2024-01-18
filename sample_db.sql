create database jdbc_paychex;
use jdbc_paychex;

create table products (
	productId int primary key,
    productname varchar(100) not null unique,
    unitprice double not null default 120
);

create table students (
	student_id int primary key,
    student_name varchar(100) not null,
    email varchar(200) not null unique
);

create table courses (
	course_id int primary key,
    course_name varchar(100) not null unique
);

create table student_course (
	student_id int not null,
    course_id int not null,
    constraint fk_student foreign key (student_id) references students(student_id),
    constraint fk_course foreign key (course_id) references courses(course_id)
);

insert into courses values 
(101, "Essentials of Core Java"),
(102, "Let Us Hibernate"),
(103, "Spring and You"),
(104, "World of Spring Boot"),
(105, "MySQL Universe");

SELECT S.STUDENT_ID, S.STUDENT_NAME, C.COURSE_NAME FROM STUDENTS S, STUDENT_COURSE SC, 
COURSES C WHERE SC.STUDENT_ID = S.STUDENT_ID AND SC.COURSE_ID = C.COURSE_ID 
AND C.COURSE_ID = 101;


