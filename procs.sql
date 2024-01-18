/*
    delimiter $$
	CREATE PROCEDURE IF NOT EXISTS <NAME>
    DECLARE -- variable declaration
    BEGIN
		statements;
    END $$
*/

delimiter $$
create procedure GetAllEmployees()
	begin
		select * from employee;
	end$$

delimiter ;

call GetAllEmployees();

delimiter $$
create procedure CreateTablePerson()
begin
	-- drop table if exists person;
    
    create table person (
		personid int primary key auto_increment,
        first_name varchar(20) not null,
        last_name varchar(20) not null
    );
    
    insert into person(first_name, last_name) values
    ('John','Doe'), ('Jane', 'Doe'), ('Jimmy', 'Doe');
    
    select * from person;
end$$

delimiter ;

call CreateTablePerson();

delimiter $$
create procedure getemployeecount(IN dept int)
begin
	declare totalEmployees int default 0;
    
    select count(*)
    into totalEmployees
    from employee where department_id = dept;

	select totalEmployees as `Count of Employees`;
end$$
delimiter ;
call getemployeecount(90);

-- drop procedure getemployeecount;

delimiter $$
create procedure GetTotalEmployeesAtLocation(in loc int, out total int)
begin
	declare total int default 0;
    
	select count(*)
    into total
    from employee e
    join department d
    on e.department_id = d.department_id
    and d.location_id = loc;
    
    -- select total as `Total Employees`;
end$$
delimiter ;

set @total = 0;
call GetTotalEmployeesAtLocation(103, @total);
select @total;

-- conditional statements and iterative statements in procedures
/*
	if condition then
		statements;
	else if condition then
		statements;
    else
		statements;
	end if
*/
delimiter $$
create procedure CalculatePercentageAmount(in sal decimal(8,2))
begin
	declare amt decimal(8,2) default 0.0;
    declare str varchar(255);
    
    if sal > 10000.00 then
		set amt = sal * 0.15;
	elseif sal > 25000.00 then
		set amt = sal * 0.2;
	else
		set amt = 1000.00;
    end if;
    set str = concat('Commission Amount for ', sal);
    select amt as `Commission`, str as `Value`;
end$$
delimiter ;

call CalculatePercentageAmount(12000.00);

-- case
/*
	case value
		when condition then
			statements;
		Else
			begin
            end;
	end case;
*/
delimiter $$
create procedure CalculateWithCase(in sal decimal(8,2))
begin
	declare amt decimal(8,2) default 0.0;
    declare str varchar(255);
    
    case 
		when sal > 10000.00 then
			set amt = sal * 0.15;
		when sal > 25000.00 then
			set amt = sal * 0.2;
		else
			set amt = 0.0;
	end case;
    set str = concat('Commission Amount for ', sal);
    select str as `Info`, amt as `Commission`;
end$$
delimiter ;

call CalculateWithCase(20000.00);

create table calendars(
	`date` date primary key,
    `month` int not null,
    `year` int not null
);

/*
	label: loop
		statements;
	end loop;
*/
delimiter $$
create procedure FillCalendar(in startDate Date, in endDate date)
begin
	declare today date default startDate;
    
    -- insert_dates: LOOP
-- 		set today = date_add(today, interval 1 day);
--         
--         if today > endDate then
-- 			LEAVE insert_dates;
-- 		end if;
--         
--         insert into calendars values
--         (today, month(today), year (today));
-- 	end loop;
    insert_dates: While today <= endDate do
		insert into calendars values 
        (today, month(today), year(today));
        
        set today = date_add(today, interval 1 day);
	end while;
    select * from calendars;
end$$

delimiter ;

call FillCalendar('2024-01-01', '2024-01-31');

# delete from calendars;

/*
	declare cursor_name cursor for
		select;
        
	open cursor_name;
    
    fetch cursor_name into variable
    work with data
    
    close cursor_name;
*/

delimiter $$
create procedure CalculateCommission()
begin
	declare sal decimal(8,2) default 0.0;
    declare amt decimal(8,2) default 0.0;
    declare done bool default false;
    
    -- declare cursor
    declare loadEmployees cursor for
		select salary from employee;
	
    -- cursor exit handler
    declare continue handler
    for not found set done = true;
    
    open loadEmployees;
    
    process_commission: loop
		fetch loadEmployees into sal;
        
        if done = true then
			leave process_commission;
		end if;

		set amt = sal * 0.08;
        update employee set commission_pct = amt where salary = sal;
    end loop;
    
    close loadEmployees;
    
end$$
delimiter ;

call CalculateCommission();


/*
FUNCTIONS
create function function_name(param_list) 
return datatype
[not] deterministic
begin
 statements;
end
*/

create table invoice (
	invoiceid int primary key,
    itemid int not null,
    quantity int not null default 1,
    total bigint default 0
);

create table item (
	itemid int not null,
    item_name varchar(50) not null unique,
    unitprice int not null 
);
alter table item add constraint pk_item primary key (itemid);

alter table invoice add constraint fk_item 
foreign key (itemid) references item(itemid);

insert into item values
(1, 'Pencils', 12),
(2, 'Ball Point Pens', 10),
(3, 'Ink Pens', 35);

insert into invoice (invoiceid, itemid, quantity)
values
(1, 2, 40),
(2, 1, 35),
(3, 2, 25);

delimiter $$
create function calculate_total(qty int, price int)
returns bigint
deterministic
begin
	declare amt bigint default 0;
    
    set amt = qty * price;
    return amt;
end $$
delimiter ;

select calculate_total(12, 12);

delimiter $$
create procedure call_function()
begin
	declare total bigint;
    
    set total = calculate_total(12, 12);
    
    select total;
end $$
delimiter ;

call call_function();


/*
TRIGGERS
create trigger trigger_name
BEFORE | AFTER insert|update|delete
on table_name
for each row
begin
	statements;
end
*/

create table voters (
	voterid int primary key,
    age int not null,
    voterstatus varchar(25)
);

insert into voters (voterid, age) values
(1, 13),
(2, 18);

create table voterstat (
	voterid int not null,
    vstat varchar(25) not null
);

-- update voters set voterstatus = 'active' where age > 17;
delimiter $$
create trigger updatevoterstatus
after update
on voters
for each row
begin
	insert into voterstat values
    (NEW.voterid, 'active');
end $$
delimiter ;

update voters set age = 19 where voterid = 1;
