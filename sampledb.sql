create database rmsdb;
use rmsdb;

-- members table
create table members (
	memberId int primary key,
    memberName varchar(50) not null,
    email varchar(100) not null unique,
    phone varchar(12) not null,
    walletbalance double not null,
    passkey varchar(25) not null,
    memberstatus varchar(45) not null default 'ACTIVE',
    membershipDate date not null default (current_date())
); 

-- employees table
create table employees (
	employeeid int primary key,
    employeename varchar(50) not null,
    phone varchar(12) not null,
    email varchar(100) not null unique,
    passkey varchar(25) not null
);

-- facilities table
create table facilities (
	facilityId int primary key,
    facilityname varchar(100) not null unique,
    price double not null
);

-- rooms table
create table rooms (
	roomId int primary key,
    roomType varchar(50) not null,
    price double not null,
    available boolean not null default true
);

-- bookings table
create table bookings (
	bookingid int primary key,
    bookingdate date not null,
    fromDate date not null,
    no_OfNights int not null default 1,
    numRooms int not null default 1,
    totalamt double not null default 0.0,
    memberid int not null,
    employeeid int not null,
    bookingstatus varchar(50) not null default 'PENDING'
);

create table roomsBooked(
	bookingId int not null,
    roomId int not null
);

create table availed (
	facilityId int not null,
    memberId int not null,
    availedDate date not null
);

-- adding foreign key constraints
alter table bookings add foreign key (memberid) references members(memberId);
alter table bookings add foreign key (employeeid) references employees(employeeid);
alter table availed add foreign key (facilityId) references facilities(facilityId);
alter table availed add foreign key (memberid) references members(memberid);
alter table roomsbooked add foreign key (bookingid) references bookings(bookingid);
alter table roomsbooked add foreign key (roomid) references rooms(roomid);

insert  into members (memberid, membername, email, phone, walletbalance, passkey, membershipdate) values
(103,'Carine Schmitt','carrie@abc.com','872919191',21000.00,'carrie123', '2018-01-09'),
(112,'Jean King','jking@xyz.com','7025551838', 71800.00, 'king123', '2018-12-10'),
(114,'Peter Ferguson','petef@xyz.com','9520034555', 72300.00, 'pete123', '2020-01-10'),
(119,'Janine Labrune','janie@abc.com','4067118555',48200.00,'janie123', '2020-03-18'),
(124,'Susan Nelson','susan@bcd.co.in','4155551450', 21050.00, 'susan123', '2020-06-29'),
(128,'Roland Keitel','roland.k@xyz.com','696905551',59700.00, 'rk@123', '2020-11-11'),
(129,'Julie Murphy','julie.murph@bcd.co.in','650555578',64600.00, 'julie123', '2021-05-30'),
(131,'Mary Lee','lee.m@abc.com', '2125557818', 114900.00, 'lee123', '2021-07-17');

select * from members;

insert  into employees(employeeid,employeeName, phone, email, passkey) values 
(1000, 'Administrator', '000000000', 'admin@blackstoneresorts.com', 'admin123'),
(1002,'Diane Murphy', '384579292', 'dmurphy@blackstoneresorts.com','diane123'),
(1056,'Mary Patterson','46112424','mpatterson@blackstoneresorts.com','mary123'),
(1076,'Jeff Firrelli','927323423','jfirrelli@blackstoneresorts.com','jeff123'),
(1088,'William Patterson','487124242','wpatterson@blackstoneresorts.com','wpat123'),
(1102,'Gerard Bondur','540824242','gbondur@blackstoneresorts.com','gb123'),
(1143,'Anthony Bow','5428224234','abow@blackstoneresorts.com','tony123'),
(1165,'Leslie Jennings','32934241','ljennings@blackstoneresorts.com','leslie123'),
(1166,'Larry Thompson','42323065','lthompson@blackstoneresorts.com','larry123'),
(1188,'Andrea Knowlings','2342342173','aknowlings@blackstoneresorts.com','andy123'),
(1216,'Steve Mayors','445353334','smayors@blackstoneresorts.com','steve123');