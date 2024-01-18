use paychexdb;

create table country (
	country_id varchar(2) primary key,
    countryname varchar(200) not null unique
);


create table locations (
	location_id int primary key,
	street_address VARCHAR(40) not null,
    postal_code VARCHAR(12) not null,
    city VARCHAR(30) not null,
    state_province VARCHAR(25) not null,
    country_id varchar(2) not null,
    constraint fk_country foreign key (country_id) references country(country_id)
);

create table department (
	department_id int primary key,
    department_name varchar(100) not null,
    location_id int not null,
    manager_id int not null
);

CREATE TABLE jobs ( 
   job_id int primary key,
   job_code varchar(45) not null,
   job_title varchar(150) not null unique,
   min_salary decimal(10,2) not null default 10000.00,
   max_salary decimal(10,2) not null
   );
   
create table employee (
	employee_id int primary key,
    first_name VARCHAR(20) not null,
    last_name VARCHAR(25) not null,
    email VARCHAR(50) not null unique,
	phone_number VARCHAR(20) not null unique,
    hire_date DATE not null,
    job_id varchar(45) not null, 
    salary decimal(8,2) not null, 
    commission_pct decimal(8,2),
    manager_id int,
    department_id int not null,
    CONSTRAINT emp_salary_min CHECK (salary > 0),
    constraint fk_job_id 
    foreign key (job_id) references jobs(job_code),
    constraint fk_department 
    foreign key(department_id) references department(department_id)
);

CREATE TABLE job_history( 
   employee_id int not null,
   start_date DATE not null,
   end_date DATE not null,
   job_id varchar(45) not null,
   department_id int not null,
   CONSTRAINT jhist_date_interval
   CHECK (end_date > start_date),
   constraint fk_dept_jhist
   foreign key(department_id) references department(department_id),
   constraint fk_job_jhist
   foreign key(job_id) references jobs(job_code),
   constraint fk_emp_jhist
   foreign key(employee_id) references employee(employee_id)
   );
   
# insert into countries
INSERT INTO country VALUES 
   ( 'IT','Italy'), 
   ( 'JP', 'Japan'),
   ( 'US','United States of America'),
   ( 'CA', 'Canada'),
   ( 'CN', 'China'),
   ( 'IN','India'),
   ( 'AU','Australia'), 
   ( 'ZW', 'Zimbabwe'), 
   ( 'SG', 'Singapore'),
   ( 'UK', 'United Kingdom'),
   ( 'FR', 'France'),
   ( 'DE', 'Germany'), 
   ( 'ZM', 'Zambia'),
   ( 'EG', 'Egypt'),
   ( 'BR', 'Brazil'),
   ( 'CH','Switzerland'), 
   ( 'NL', 'Netherlands'),
   ( 'MX', 'Mexico'), 
   ( 'KW', 'Kuwait'), 
   ( 'IL', 'Israel'),
   ( 'DK', 'Denmark'), 
   ( 'HK', 'HongKong'),
   ( 'NG', 'Nigeria'),
   ( 'AR', 'Argentina'),
   ( 'BE', 'Belgium');
   
# insert into locations
INSERT INTO locations VALUES 
   ( 1000 
   , '1297 Via Cola di Rie'
   , '00989'
   , 'Roma'
   , NULL
   , 'IT'
   );
INSERT INTO locations VALUES 
   ( 1100 
   , '93091 Calle della Testa'
   , '10934'
   , 'Venice'
   , NULL
   , 'IT'
   );
INSERT INTO locations VALUES 
   ( 1200 
   , '2017 Shinjuku-ku'
   , '1689'
   , 'Tokyo'
   , 'Tokyo Prefecture'
   , 'JP'
   );
INSERT INTO locations VALUES 
   ( 1300 
   , '9450 Kamiya-cho'
   , '6823'
   , 'Hiroshima'
   , NULL
   , 'JP'
   );
INSERT INTO locations VALUES 
   ( 1400 
   , '2014 Jabberwocky Rd'
   , '26192'
   , 'Southlake'
   , 'Texas'
   , 'US'
   );
INSERT INTO locations VALUES 
   ( 1500 
   , '2011 Interiors Blvd'
   , '99236'
   , 'South San Francisco'
   , 'California'
   , 'US'
   );
INSERT INTO locations VALUES 
   ( 1600 
   , '2007 Zagora St'
   , '50090'
   , 'South Brunswick'
   , 'New Jersey'
   , 'US'
   );
INSERT INTO locations VALUES 
   ( 1700 
   , '2004 Charade Rd'
   , '98199'
   , 'Seattle'
   , 'Washington'
   , 'US'
   );
INSERT INTO locations VALUES 
   ( 1800 
   , '147 Spadina Ave'
   , 'M5V 2L7'
   , 'Toronto'
   , 'Ontario'
   , 'CA'
   );
INSERT INTO locations VALUES 
   ( 1900 
   , '6092 Boxwood St'
   , 'YSW 9T2'
   , 'Whitehorse'
   , 'Yukon'
   , 'CA'
   );
INSERT INTO locations VALUES 
   ( 2000 
   , '40-5-12 Laogianggen'
   , '190518'
   , 'Beijing'
   , NULL
   , 'CN'
   );
INSERT INTO locations VALUES 
   ( 2100 
   , '1298 Vileparle (E)'
   , '490231'
   , 'Bombay'
   , 'Maharashtra'
   , 'IN'
   );
INSERT INTO locations VALUES 
   ( 2200 
   , '12-98 Victoria Street'
   , '2901'
   , 'Sydney'
   , 'New South Wales'
   , 'AU'
   );
INSERT INTO locations VALUES 
   ( 2300 
   , '198 Clementi North'
   , '540198'
   , 'Singapore'
   , NULL
   , 'SG'
   );
INSERT INTO locations VALUES 
   ( 2400 
   , '8204 Arthur St'
   , NULL
   , 'London'
   , NULL
   , 'UK'
   );
INSERT INTO locations VALUES 
   ( 2500 
   , 'Magdalen Centre, The Oxford Science Park'
   , 'OX9 9ZB'
   , 'Oxford'
   , 'Oxford'
   , 'UK'
   );
INSERT INTO locations VALUES 
   ( 2600 
   , '9702 Chester Road'
   , '09629850293'
   , 'Stretford'
   , 'Manchester'
   , 'UK'
   );
INSERT INTO locations VALUES 
   ( 2700 
   , 'Schwanthalerstr. 7031'
   , '80925'
   , 'Munich'
   , 'Bavaria'
   , 'DE'
   );
INSERT INTO locations VALUES 
   ( 2800 
   , 'Rua Frei Caneca 1360 '
   , '01307-002'
   , 'Sao Paulo'
   , 'Sao Paulo'
   , 'BR'
   );
INSERT INTO locations VALUES 
   ( 2900 
   , '20 Rue des Corps-Saints'
   , '1730'
   , 'Geneva'
   , 'Geneve'
   , 'CH'
   );
INSERT INTO locations VALUES 
   ( 3000 
   , 'Murtenstrasse 921'
   , '3095'
   , 'Bern'
   , 'BE'
   , 'CH'
   );
INSERT INTO locations VALUES 
   ( 3100 
   , 'Pieter Breughelstraat 837'
   , '3029SK'
   , 'Utrecht'
   , 'Utrecht'
   , 'NL'
   );
INSERT INTO locations VALUES 
   ( 3200 
   , 'Mariano Escobedo 9991'
   , '11932'
   , 'Mexico City'
   , 'Distrito Federal,'
   , 'MX'
   );

# insert into department
INSERT INTO department VALUES 
   ( 10
   , 'Administration'
   , 200
   , 1700
   );
INSERT INTO department VALUES 
   ( 20
   , 'Marketing'
   , 201
   , 1800
   );
   
   INSERT INTO department VALUES 
   ( 30
   , 'Purchasing'
   , 114
   , 1700
   );
   
   INSERT INTO department VALUES 
   ( 40
   , 'Human Resources'
   , 203
   , 2400
   );
INSERT INTO department VALUES 
   ( 50
   , 'Shipping'
   , 121
   , 1500
   );
   
   INSERT INTO department VALUES 
   ( 60 
   , 'IT'
   , 103
   , 1400
   );
   
   INSERT INTO department VALUES 
   ( 70 
   , 'Public Relations'
   , 204
   , 2700
   );
   
   INSERT INTO department VALUES 
   ( 80 
   , 'Sales'
   , 145
   , 2500
   );
   
   INSERT INTO department VALUES 
   ( 90 
   , 'Executive'
   , 100
   , 1700
   );
INSERT INTO department VALUES 
   ( 100 
   , 'Finance'
   , 108
   , 1700
   );
   
   INSERT INTO department VALUES 
   ( 110 
   , 'Accounting'
   , 205
   , 1700
   );
INSERT INTO department VALUES 
   ( 120 
   , 'Treasury'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 130 
   , 'Corporate Tax'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 140 
   , 'Control And Credit'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 150 
   , 'Shareholder Services'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 160 
   , 'Benefits'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 170 
   , 'Manufacturing'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 180 
   , 'Construction'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 190 
   , 'Contracting'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 200 
   , 'Operations'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 210 
   , 'IT Support'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 220 
   , 'NOC'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 230 
   , 'IT Helpdesk'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 240 
   , 'Government Sales'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 250 
   , 'Retail Sales'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 260 
   , 'Recruiting'
   , NULL
   , 1700
   );
INSERT INTO department VALUES 
   ( 270 
   , 'Payroll'
   , NULL
   , 1700
   );
       
-- ***************************insert data into the JOBS table
INSERT INTO jobs (job_id, job_code, job_title, min_salary, max_salary) VALUES 
   ( 1,'AD_PRES'
   , 'President'
   , 20000
   , 40000
   ),
   ( 2,'AD_VP'
   , 'Administration Vice President'
   , 15000
   , 30000
   ),
   ( 3,'AD_ASST'
   , 'Administration Assistant'
   , 3000
   , 6000
   ),
   ( 4,'FI_MGR'
   , 'Finance Manager'
   , 8200
   , 16000
   ),
   ( 5,'FI_ACCOUNT'
   , 'Accountant'
   , 4200
   , 9000
   ), 
   ( 6,'AC_MGR'
   , 'Accounting Manager'
   , 8200
   , 16000
   ),
   ( 7,'AC_ACCOUNT'
   , 'Public Accountant'
   , 4200
   , 9000
   ),
   ( 8,'SA_MAN'
   , 'Sales Manager'
   , 10000
   , 20000
   );
INSERT INTO jobs (job_id, job_code, job_title, min_salary, max_salary) VALUES 
   ( 9,'SA_REP'
   , 'Sales Representative'
   , 6000
   , 12000
   ),
   ( 10,'PU_MAN'
   , 'Purchasing Manager'
   , 8000
   , 15000
   ),
   ( 11,'PU_CLERK'
   , 'Purchasing Clerk'
   , 2500
   , 5500
   ),
-- INSERT INTO jobs VALUES 
   ( 12,'ST_MAN'
   , 'Stock Manager'
   , 5500
   , 8500
   ),
   -- INSERT INTO jobs VALUES 
   ( 13,'ST_CLERK'
   , 'Stock Clerk'
   , 2000
   , 5000
   ),
-- INSERT INTO jobs VALUES 
   ( 14,'SH_CLERK'
   , 'Shipping Clerk'
   , 2500
   , 5500
   ),
-- INSERT INTO jobs VALUES 
   ( 15,'IT_PROG'
   , 'Programmer'
   , 4000
   , 10000
   ),
-- INSERT INTO jobs VALUES 
   ( 16,'MK_MAN'
   , 'Marketing Manager'
   , 9000
   , 15000
   ),
-- INSERT INTO jobs VALUES 
   ( 17,'MK_REP'
   , 'Marketing Representative'
   , 4000
   , 9000
   ),
-- INSERT INTO jobs VALUES 
   ( 18, 'HR_REP'
   , 'Human Resources Representative'
   , 4000
   , 9000
   ), 
   ( 19,'PR_REP'
   , 'Public Relations Representative'
   , 4500
   , 10500
   );
   
# employee table data
INSERT INTO employee VALUES 
   ( 100
   , 'Steven'
   , 'King'
   , 'SKING'
   , '515.123.4567'
   , '1987-06-18'
   , 'AD_PRES'
   , 24000
   , NULL
   , NULL
   , 90
   );
INSERT INTO employee VALUES 
   ( 101
   , 'Neena'
   , 'Kochhar'
   , 'NKOCHHAR'
   , '515.123.4568'
   , '1991-09-13'
   , 'AD_VP'
   , 17000
   , NULL
   , 100
   , 90
   );
INSERT INTO employee VALUES 
   ( 102
   , 'Lex'
   , 'De Haan'
   , 'LDEHAAN'
   , '515.123.4569'
   , '1993-01-12'
   , 'AD_VP'
   , 17000
   , NULL
   , 100
   , 90
   );
INSERT INTO employee VALUES 
   ( 103
   , 'Alexander'
   , 'Hunold'
   , 'AHUNOLD'
   , '590.423.4567'
   , '1990-01-03'
   , 'IT_PROG'
   , 9000
   , NULL
   , 102
   , 60
   );
INSERT INTO employee VALUES 
   ( 104
   , 'Bruce'
   , 'Ernst'
   , 'BERNST'
   , '590.423.4568'
   , '1991-05-21'
   , 'IT_PROG'
   , 6000
   , NULL
   , 103
   , 60
   );
INSERT INTO employee VALUES 
   ( 105
   , 'David'
   , 'Austin'
   , 'DAUSTIN'
   , '590.423.4569'
   , '1997-06-25'
   , 'IT_PROG'
   , 4800
   , NULL
   , 103
   , 60
   );
INSERT INTO employee VALUES 
   ( 106
   , 'Valli'
   , 'Pataballa'
   , 'VPATABAL'
   , '590.423.4560'
   , '1998-02-15'
   , 'IT_PROG'
   , 4800
   , NULL
   , 103
   , 60
   );
INSERT INTO employee VALUES 
   ( 107
   , 'Diana'
   , 'Lorentz'
   , 'DLORENTZ'
   , '590.423.5567'
   , '1999-02-07'
   , 'IT_PROG'
   , 4200
   , NULL
   , 103
   , 60
   );
INSERT INTO employee VALUES 
   ( 108
   , 'Nancy'
   , 'Greenberg'
   , 'NGREENBE'
   , '515.124.4569'
   , '1994-08-17'
   , 'FI_MGR'
   , 12000
   , NULL
   , 101
   , 100
   );
INSERT INTO employee VALUES 
   ( 109
   , 'Daniel'
   , 'Faviet'
   , 'DFAVIET'
   , '515.124.4169'
   , '1994-04-16'
   , 'FI_ACCOUNT'
   , 9000
   , NULL
   , 108
   , 100
   );
INSERT INTO employee VALUES 
   ( 110
   , 'John'
   , 'Chen'
   , 'JCHEN'
   , '515.124.4269'
   , '1997-09-28'
   , 'FI_ACCOUNT'
   , 8200
   , NULL
   , 108
   , 100
   );
INSERT INTO employee VALUES 
   ( 111
   , 'Ismael'
   , 'Sciarra'
   , 'ISCIARRA'
   , '515.124.4369'
   , '1997-09-30'
   , 'FI_ACCOUNT'
   , 7700
   , NULL
   , 108
   , 100
   );
INSERT INTO employee VALUES 
   ( 112
   , 'Jose Manuel'
   , 'Urman'
   , 'JMURMAN'
   , '515.124.4469'
   , '1998-03-12'
   , 'FI_ACCOUNT'
   , 7800
   , NULL
   , 108
   , 100
   );
INSERT INTO employee VALUES 
   ( 113
   , 'Luis'
   , 'Popp'
   , 'LPOPP'
   , '515.124.4567'
   , '1999-12-08'
   , 'FI_ACCOUNT'
   , 6900
   , NULL
   , 108
   , 100
   );
INSERT INTO employee VALUES 
   ( 114
   , 'Den'
   , 'Raphaely'
   , 'DRAPHEAL'
   , '515.127.4561'
   , '1999-12-12'
   , 'PU_MAN'
   , 11000
   , NULL
   , 100
   , 30
   );
INSERT INTO employee VALUES 
   ( 115
   , 'Alexander'
   , 'Khoo'
   , 'AKHOO'
   , '515.127.4562'
   , '1995-10-14'
   , 'PU_CLERK'
   , 3100
   , NULL
   , 114
   , 30
   );
INSERT INTO employee VALUES 
   ( 116
   , 'Shelli'
   , 'Baida'
   , 'SBAIDA'
   , '515.127.4563'
   , '1997-10-19'
   , 'PU_CLERK'
   , 2900
   , NULL
   , 114
   , 30
   );
INSERT INTO employee VALUES 
   ( 117
   , 'Sigal'
   , 'Tobias'
   , 'STOBIAS'
   , '515.127.4564'
   , '1997-07-04'
   , 'PU_CLERK'
   , 2800
   , NULL
   , 114
   , 30
   );
INSERT INTO employee VALUES 
   ( 118
   , 'Guy'
   , 'Himuro'
   , 'GHIMURO'
   , '515.127.4565'
   , '1998-05-12'
   , 'PU_CLERK'
   , 2600
   , NULL
   , 114
   , 30
   );
INSERT INTO employee VALUES 
   ( 119
   , 'Karen'
   , 'Colmenares'
   , 'KCOLMENA'
   , '515.127.4566'
   , '1996-04-19'
   , 'PU_CLERK'
   , 2500
   , NULL
   , 114
   , 30
   );
INSERT INTO employee VALUES 
   ( 120
   , 'Matthew'
   , 'Weiss'
   , 'MWEISS'
   , '650.123.1234'
   , '1997-11-09'
   , 'ST_MAN'
   , 8000
   , NULL
   , 100
   , 50
   );
INSERT INTO employee VALUES 
   ( 121
   , 'Adam'
   , 'Fripp'
   , 'AFRIPP'
   , '650.123.2234'
   , '1997-10-16'
   , 'ST_MAN'
   , 8200
   , NULL
   , 100
   , 50
   );
INSERT INTO employee VALUES 
   ( 122
   , 'Payam'
   , 'Kaufling'
   , 'PKAUFLIN'
   , '650.123.3234'
   , '1995-05-02'
   , 'ST_MAN'
   , 7900
   , NULL
   , 100
   , 50
   );
INSERT INTO employee VALUES 
   ( 123
   , 'Shanta'
   , 'Vollman'
   , 'SVOLLMAN'
   , '650.123.4234'
   , '1994-03-08'
   , 'ST_MAN'
   , 6500
   , NULL
   , 100
   , 50
   );
INSERT INTO employee VALUES 
   ( 124
   , 'Kevin'
   , 'Mourgos'
   , 'KMOURGOS'
   , '650.123.5234'
   , '1995-09-02'
   , 'ST_MAN'
   , 5800
   , NULL
   , 100
   , 50
   );
INSERT INTO employee VALUES 
   ( 125
   , 'Julia'
   , 'Nayer'
   , 'JNAYER'
   , '650.124.1214'
   , '1997-06-16'
   , 'ST_CLERK'
   , 3200
   , NULL
   , 120
   , 50
   );
-- INSERT INTO employee VALUES 
--    ( 126
--    , 'Irene'
--    , 'Mikkilineni'
--    , 'IMIKKILI'
--    , '650.124.1224'
--    , TO_DATE('28-SEP-1998', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2700
--    , NULL
--    , 120
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 127
--    , 'James'
--    , 'Landry'
--    , 'JLANDRY'
--    , '650.124.1334'
--    , TO_DATE('14-JAN-1999', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2400
--    , NULL
--    , 120
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 128
--    , 'Steven'
--    , 'Markle'
--    , 'SMARKLE'
--    , '650.124.1434'
--    , TO_DATE('08-MAR-2000', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2200
--    , NULL
--    , 120
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 129
--    , 'Laura'
--    , 'Bissot'
--    , 'LBISSOT'
--    , '650.124.5234'
--    , TO_DATE('20-AUG-1997', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 3300
--    , NULL
--    , 121
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 130
--    , 'Mozhe'
--    , 'Atkinson'
--    , 'MATKINSO'
--    , '650.124.6234'
--    , TO_DATE('30-OCT-1997', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2800
--    , NULL
--    , 121
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 131
--    , 'James'
--    , 'Marlow'
--    , 'JAMRLOW'
--    , '650.124.7234'
--    , TO_DATE('16-FEB-1997', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2500
--    , NULL
--    , 121
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 132
--    , 'TJ'
--    , 'Olson'
--    , 'TJOLSON'
--    , '650.124.8234'
--    , TO_DATE('10-APR-1999', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2100
--    , NULL
--    , 121
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 133
--    , 'Jason'
--    , 'Mallin'
--    , 'JMALLIN'
--    , '650.127.1934'
--    , TO_DATE('14-JUN-1996', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 3300
--    , NULL
--    , 122
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 134
--    , 'Michael'
--    , 'Rogers'
--    , 'MROGERS'
--    , '650.127.1834'
--    , TO_DATE('26-AUG-1998', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2900
--    , NULL
--    , 122
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 135
--    , 'Ki'
--    , 'Gee'
--    , 'KGEE'
--    , '650.127.1734'
--    , TO_DATE('12-DEC-1999', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2400
--    , NULL
--    , 122
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 136
--    , 'Hazel'
--    , 'Philtanker'
--    , 'HPHILTAN'
--    , '650.127.1634'
--    , TO_DATE('06-FEB-2000', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2200
--    , NULL
--    , 122
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 137
--    , 'Renske'
--    , 'Ladwig'
--    , 'RLADWIG'
--    , '650.121.1234'
--    , TO_DATE('14-JUL-1995', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 3600
--    , NULL
--    , 123
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 138
--    , 'Stephen'
--    , 'Stiles'
--    , 'SSTILES'
--    , '650.121.2034'
--    , TO_DATE('26-OCT-1997', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 3200
--    , NULL
--    , 123
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 139
--    , 'John'
--    , 'Seo'
--    , 'JSEO'
--    , '650.121.2019'
--    , TO_DATE('12-FEB-1998', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2700
--    , NULL
--    , 123
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 140
--    , 'Joshua'
--    , 'Patel'
--    , 'JPATEL'
--    , '650.121.1834'
--    , TO_DATE('06-APR-1998', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2500
--    , NULL
--    , 123
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 141
--    , 'Trenna'
--    , 'Rajs'
--    , 'TRAJS'
--    , '650.121.8009'
--    , TO_DATE('17-OCT-1995', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 3500
--    , NULL
--    , 124
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 142
--    , 'Curtis'
--    , 'Davies'
--    , 'CDAVIES'
--    , '650.121.2994'
--    , TO_DATE('29-JAN-1997', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 3100
--    , NULL
--    , 124
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 143
--    , 'Randall'
--    , 'Matos'
--    , 'RMATOS'
--    , '650.121.2874'
--    , TO_DATE('15-MAR-1998', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2600
--    , NULL
--    , 124
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 144
--    , 'Peter'
--    , 'Vargas'
--    , 'PVARGAS'
--    , '650.121.2004'
--    , TO_DATE('09-JUL-1998', 'dd-MON-yyyy')
--    , 'ST_CLERK'
--    , 2500
--    , NULL
--    , 124
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 145
--    , 'John'
--    , 'Russell'
--    , 'JRUSSEL'
--    , '011.44.1344.429268'
--    , TO_DATE('01-OCT-1996', 'dd-MON-yyyy')
--    , 'SA_MAN'
--    , 14000
--    , .4
--    , 100
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 146
--    , 'Karen'
--    , 'Partners'
--    , 'KPARTNER'
--    , '011.44.1344.467268'
--    , TO_DATE('05-JAN-1997', 'dd-MON-yyyy')
--    , 'SA_MAN'
--    , 13500
--    , .3
--    , 100
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 147
--    , 'Alberto'
--    , 'Errazuriz'
--    , 'AERRAZUR'
--    , '011.44.1344.429278'
--    , TO_DATE('10-MAR-1997', 'dd-MON-yyyy')
--    , 'SA_MAN'
--    , 12000
--    , .3
--    , 100
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 148
--    , 'Gerald'
--    , 'Cambrault'
--    , 'GCAMBRAU'
--    , '011.44.1344.619268'
--    , TO_DATE('15-OCT-1999', 'dd-MON-yyyy')
--    , 'SA_MAN'
--    , 11000
--    , .3
--    , 100
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 149
--    , 'Eleni'
--    , 'Zlotkey'
--    , 'EZLOTKEY'
--    , '011.44.1344.429018'
--    , TO_DATE('29-JAN-2000', 'dd-MON-yyyy')
--    , 'SA_MAN'
--    , 10500
--    , .2
--    , 100
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 150
--    , 'Peter'
--    , 'Tucker'
--    , 'PTUCKER'
--    , '011.44.1344.129268'
--    , TO_DATE('30-JAN-1997', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 10000
--    , .3
--    , 145
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 151
--    , 'David'
--    , 'Bernstein'
--    , 'DBERNSTE'
--    , '011.44.1344.345268'
--    , TO_DATE('24-MAR-1997', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 9500
--    , .25
--    , 145
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 152
--    , 'Peter'
--    , 'Hall'
--    , 'PHALL'
--    , '011.44.1344.478968'
--    , TO_DATE('20-AUG-1997', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 9000
--    , .25
--    , 145
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 153
--    , 'Christopher'
--    , 'Olsen'
--    , 'COLSEN'
--    , '011.44.1344.498718'
--    , TO_DATE('30-MAR-1998', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 8000
--    , .2
--    , 145
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 154
--    , 'Nanette'
--    , 'Cambrault'
--    , 'NCAMBRAU'
--    , '011.44.1344.987668'
--    , TO_DATE('09-DEC-1998', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 7500
--    , .2
--    , 145
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 155
--    , 'Oliver'
--    , 'Tuvault'
--    , 'OTUVAULT'
--    , '011.44.1344.486508'
--    , TO_DATE('23-NOV-1999', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 7000
--    , .15
--    , 145
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 156
--    , 'Janette'
--    , 'King'
--    , 'JKING'
--    , '011.44.1345.429268'
--    , TO_DATE('30-JAN-1996', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 10000
--    , .35
--    , 146
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 157
--    , 'Patrick'
--    , 'Sully'
--    , 'PSULLY'
--    , '011.44.1345.929268'
--    , TO_DATE('04-MAR-1996', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 9500
--    , .35
--    , 146
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 158
--    , 'Allan'
--    , 'McEwen'
--    , 'AMCEWEN'
--    , '011.44.1345.829268'
--    , TO_DATE('01-AUG-1996', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 9000
--    , .35
--    , 146
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 159
--    , 'Lindsey'
--    , 'Smith'
--    , 'LSMITH'
--    , '011.44.1345.729268'
--    , TO_DATE('10-MAR-1997', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 8000
--    , .3
--    , 146
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 160
--    , 'Louise'
--    , 'Doran'
--    , 'LDORAN'
--    , '011.44.1345.629268'
--    , TO_DATE('15-DEC-1997', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 7500
--    , .3
--    , 146
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 161
--    , 'Sarath'
--    , 'Sewall'
--    , 'SSEWALL'
--    , '011.44.1345.529268'
--    , TO_DATE('03-NOV-1998', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 7000
--    , .25
--    , 146
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 162
--    , 'Clara'
--    , 'Vishney'
--    , 'CVISHNEY'
--    , '011.44.1346.129268'
--    , TO_DATE('11-NOV-1997', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 10500
--    , .25
--    , 147
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 163
--    , 'Danielle'
--    , 'Greene'
--    , 'DGREENE'
--    , '011.44.1346.229268'
--    , TO_DATE('19-MAR-1999', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 9500
--    , .15
--    , 147
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 164
--    , 'Mattea'
--    , 'Marvins'
--    , 'MMARVINS'
--    , '011.44.1346.329268'
--    , TO_DATE('24-JAN-2000', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 7200
--    , .10
--    , 147
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 165
--    , 'David'
--    , 'Lee'
--    , 'DLEE'
--    , '011.44.1346.529268'
--    , TO_DATE('23-FEB-2000', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 6800
--    , .1
--    , 147
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 166
--    , 'Sundar'
--    , 'Ande'
--    , 'SANDE'
--    , '011.44.1346.629268'
--    , TO_DATE('24-MAR-2000', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 6400
--    , .10
--    , 147
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 167
--    , 'Amit'
--    , 'Banda'
--    , 'ABANDA'
--    , '011.44.1346.729268'
--    , TO_DATE('21-APR-2000', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 6200
--    , .10
--    , 147
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 168
--    , 'Lisa'
--    , 'Ozer'
--    , 'LOZER'
--    , '011.44.1343.929268'
--    , TO_DATE('11-MAR-1997', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 11500
--    , .25
--    , 148
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 169 
--    , 'Harrison'
--    , 'Bloom'
--    , 'HBLOOM'
--    , '011.44.1343.829268'
--    , TO_DATE('23-MAR-1998', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 10000
--    , .20
--    , 148
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 170
--    , 'Tayler'
--    , 'Fox'
--    , 'TFOX'
--    , '011.44.1343.729268'
--    , TO_DATE('24-JAN-1998', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 9600
--    , .20
--    , 148
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 171
--    , 'William'
--    , 'Smith'
--    , 'WSMITH'
--    , '011.44.1343.629268'
--    , TO_DATE('23-FEB-1999', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 7400
--    , .15
--    , 148
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 172
--    , 'Elizabeth'
--    , 'Bates'
--    , 'EBATES'
--    , '011.44.1343.529268'
--    , TO_DATE('24-MAR-1999', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 7300
--    , .15
--    , 148
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 173
--    , 'Sundita'
--    , 'Kumar'
--    , 'SKUMAR'
--    , '011.44.1343.329268'
--    , TO_DATE('21-APR-2000', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 6100
--    , .10
--    , 148
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 174
--    , 'Ellen'
--    , 'Abel'
--    , 'EABEL'
--    , '011.44.1644.429267'
--    , TO_DATE('11-MAY-1996', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 11000
--    , .30
--    , 149
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 175
--    , 'Alyssa'
--    , 'Hutton'
--    , 'AHUTTON'
--    , '011.44.1644.429266'
--    , TO_DATE('19-MAR-1997', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 8800
--    , .25
--    , 149
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 176
--    , 'Jonathon'
--    , 'Taylor'
--    , 'JTAYLOR'
--    , '011.44.1644.429265'
--    , TO_DATE('24-MAR-1998', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 8600
--    , .20
--    , 149
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 177
--    , 'Jack'
--    , 'Livingston'
--    , 'JLIVINGS'
--    , '011.44.1644.429264'
--    , TO_DATE('23-APR-1998', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 8400
--    , .20
--    , 149
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 178
--    , 'Kimberely'
--    , 'Grant'
--    , 'KGRANT'
--    , '011.44.1644.429263'
--    , TO_DATE('24-MAY-1999', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 7000
--    , .15
--    , 149
--    , NULL
--    );
-- INSERT INTO employee VALUES 
--    ( 179
--    , 'Charles'
--    , 'Johnson'
--    , 'CJOHNSON'
--    , '011.44.1644.429262'
--    , TO_DATE('04-JAN-2000', 'dd-MON-yyyy')
--    , 'SA_REP'
--    , 6200
--    , .10
--    , 149
--    , 80
--    );
-- INSERT INTO employee VALUES 
--    ( 180
--    , 'Winston'
--    , 'Taylor'
--    , 'WTAYLOR'
--    , '650.507.9876'
--    , TO_DATE('24-JAN-1998', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 3200
--    , NULL
--    , 120
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 181
--    , 'Jean'
--    , 'Fleaur'
--    , 'JFLEAUR'
--    , '650.507.9877'
--    , TO_DATE('23-FEB-1998', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 3100
--    , NULL
--    , 120
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 182
--    , 'Martha'
--    , 'Sullivan'
--    , 'MSULLIVA'
--    , '650.507.9878'
--    , TO_DATE('21-JUN-1999', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 2500
--    , NULL
--    , 120
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 183
--    , 'Girard'
--    , 'Geoni'
--    , 'GGEONI'
--    , '650.507.9879'
--    , TO_DATE('03-FEB-2000', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 2800
--    , NULL
--    , 120
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 184
--    , 'Nandita'
--    , 'Sarchand'
--    , 'NSARCHAN'
--    , '650.509.1876'
--    , TO_DATE('27-JAN-1996', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 4200
--    , NULL
--    , 121
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 185
--    , 'Alexis'
--    , 'Bull'
--    , 'ABULL'
--    , '650.509.2876'
--    , TO_DATE('20-FEB-1997', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 4100
--    , NULL
--    , 121
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 186
--    , 'Julia'
--    , 'Dellinger'
--    , 'JDELLING'
--    , '650.509.3876'
--    , TO_DATE('24-JUN-1998', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 3400
--    , NULL
--    , 121
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 187
--    , 'Anthony'
--    , 'Cabrio'
--    , 'ACABRIO'
--    , '650.509.4876'
--    , TO_DATE('07-FEB-1999', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 3000
--    , NULL
--    , 121
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 188
--    , 'Kelly'
--    , 'Chung'
--    , 'KCHUNG'
--    , '650.505.1876'
--    , TO_DATE('14-JUN-1997', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 3800
--    , NULL
--    , 122
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 189
--    , 'Jennifer'
--    , 'Dilly'
--    , 'JDILLY'
--    , '650.505.2876'
--    , TO_DATE('13-AUG-1997', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 3600
--    , NULL
--    , 122
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 190
--    , 'Timothy'
--    , 'Gates'
--    , 'TGATES'
--    , '650.505.3876'
--    , TO_DATE('11-JUL-1998', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 2900
--    , NULL
--    , 122
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 191
--    , 'Randall'
--    , 'Perkins'
--    , 'RPERKINS'
--    , '650.505.4876'
--    , TO_DATE('19-DEC-1999', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 2500
--    , NULL
--    , 122
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 192
--    , 'Sarah'
--    , 'Bell'
--    , 'SBELL'
--    , '650.501.1876'
--    , TO_DATE('04-FEB-1996', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 4000
--    , NULL
--    , 123
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 193
--    , 'Britney'
--    , 'Everett'
--    , 'BEVERETT'
--    , '650.501.2876'
--    , TO_DATE('03-MAR-1997', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 3900
--    , NULL
--    , 123
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 194
--    , 'Samuel'
--    , 'McCain'
--    , 'SMCCAIN'
--    , '650.501.3876'
--    , TO_DATE('01-JUL-1998', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 3200
--    , NULL
--    , 123
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 195
--    , 'Vance'
--    , 'Jones'
--    , 'VJONES'
--    , '650.501.4876'
--    , TO_DATE('17-MAR-1999', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 2800
--    , NULL
--    , 123
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 196
--    , 'Alana'
--    , 'Walsh'
--    , 'AWALSH'
--    , '650.507.9811'
--    , TO_DATE('24-APR-1998', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 3100
--    , NULL
--    , 124
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 197
--    , 'Kevin'
--    , 'Feeney'
--    , 'KFEENEY'
--    , '650.507.9822'
--    , TO_DATE('23-MAY-1998', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 3000
--    , NULL
--    , 124
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 198
--    , 'Donald'
--    , 'OConnell'
--    , 'DOCONNEL'
--    , '650.507.9833'
--    , TO_DATE('21-JUN-1999', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 2600
--    , NULL
--    , 124
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 199
--    , 'Douglas'
--    , 'Grant'
--    , 'DGRANT'
--    , '650.507.9844'
--    , TO_DATE('13-JAN-2000', 'dd-MON-yyyy')
--    , 'SH_CLERK'
--    , 2600
--    , NULL
--    , 124
--    , 50
--    );
-- INSERT INTO employee VALUES 
--    ( 200
--    , 'Jennifer'
--    , 'Whalen'
--    , 'JWHALEN'
--    , '515.123.4444'
--    , TO_DATE('17-SEP-1987', 'dd-MON-yyyy')
--    , 'AD_ASST'
--    , 4400
--    , NULL
--    , 101
--    , 10
--    );
-- INSERT INTO employee VALUES 
--    ( 201
--    , 'Michael'
--    , 'Hartstein'
--    , 'MHARTSTE'
--    , '515.123.5555'
--    , TO_DATE('17-FEB-1996', 'dd-MON-yyyy')
--    , 'MK_MAN'
--    , 13000
--    , NULL
--    , 100
--    , 20
--    );
-- INSERT INTO employee VALUES 
--    ( 202
--    , 'Pat'
--    , 'Fay'
--    , 'PFAY'
--    , '603.123.6666'
--    , TO_DATE('17-AUG-1997', 'dd-MON-yyyy')
--    , 'MK_REP'
--    , 6000
--    , NULL
--    , 201
--    , 20
--    );
-- INSERT INTO employee VALUES 
--    ( 203
--    , 'Susan'
--    , 'Mavris'
--    , 'SMAVRIS'
--    , '515.123.7777'
--    , TO_DATE('07-JUN-1994', 'dd-MON-yyyy')
--    , 'HR_REP'
--    , 6500
--    , NULL
--    , 101
--    , 40
--    );
-- INSERT INTO employee VALUES 
--    ( 204
--    , 'Hermann'
--    , 'Baer'
--    , 'HBAER'
--    , '515.123.8888'
--    , TO_DATE('07-JUN-1994', 'dd-MON-yyyy')
--    , 'PR_REP'
--    , 10000
--    , NULL
--    , 101
--    , 70
--    );
-- INSERT INTO employee VALUES 
--    ( 205
--    , 'Shelley'
--    , 'Higgins'
--    , 'SHIGGINS'
--    , '515.123.8080'
--    , TO_DATE('07-JUN-1994', 'dd-MON-yyyy')
--    , 'AC_MGR'
--    , 12000
--    , NULL
--    , 101
--    , 110
--    );
-- INSERT INTO employee VALUES 
--    ( 206
--    , 'William'
--    , 'Gietz'
--    , 'WGIETZ'
--    , '515.123.8181'
--    , TO_DATE('07-JUN-1994', 'dd-MON-yyyy')
--    , 'AC_ACCOUNT'
--    , 8300
--    , NULL
--    , 205
--    , 110
--    );
-- ********* insert data into the JOB_HISTORY table
       
INSERT INTO job_history
         VALUES (102
   , '1993-01-13'
   , '1998-07-14'
   , 'IT_PROG'
   , 60);
INSERT INTO job_history
         VALUES (101
   , '1989-09-21'
   , '1993-10-27'
   , 'AC_ACCOUNT'
   , 110);
INSERT INTO job_history
         VALUES (101
   , '1993-10-28'
   , '1997-03-15'
   , 'AC_MGR'
   , 110);
INSERT INTO job_history
         VALUES (125
   , '1996-02-17'
   , '1999-12-19'
   , 'MK_REP'
   , 20);
INSERT INTO job_history
         VALUES (114
   , '1998-03-24'
   , '1999-12-24'
   , 'ST_CLERK'
   , 50
   );
INSERT INTO job_history
         VALUES (122
   , '1999-01-01'
   , '1999-12-31'
   , 'ST_CLERK'
   , 50
   );
INSERT INTO job_history
         VALUES (120
   , '1987-06-17'
   , '1993-06-17'
   , 'AD_ASST'
   , 90
   );
INSERT INTO job_history
         VALUES (115
   , '1998-03-24'
   , '1998-12-31'
   , 'SA_REP'
   , 80
   );
INSERT INTO job_history
         VALUES (115
   , '1999-01-01'
   , '1999-12-31'
   , 'SA_MAN'
   , 80
   );
INSERT INTO job_history
         VALUES (125
   , '1994-07-01'
   , '1998-12-31'
   , 'AC_ACCOUNT'
   , 90
   );
   
   
-- Joins
#1 Write a query to display the last name, 
# department number, and department name for all employees.
select e.last_name, d.department_id, d.department_name
from employee e
inner join
department d
on d.department_id = e.department_id;
 
 # 2 Create a unique listing of all jobs that are in department 50. 
 # Include the location of the Department in the output.
--  select distinct j.job_id, l.location_id
--  from job_history j
--  inner join department d
--  on j.department_id = d.department_id
--  inner join locations l
--  on d.location_id = l.location_id  and d.department_id = 50;
 
 -- select j.job_id
--  from job_history j
--  where j.department_id=50;
--  and d.location_id = l.location_id;

select j.job_id, d.location_id
from job_history j
inner join department d
on j.department_id = d.department_id and d.department_id = 50;

#3 Write a query to display the employee last name, department name, 
# location ID, and city of all employees.
select e.last_name as `Last Name`, d.department_name as `Department`,
l.location_id as `Location Id`, l.city as `City`
from employee e
join department d
on e.department_id = d.department_id
join locations l
on d.location_id = l.location_id;

#4 Display the employee last name and department name for 
#all employees who have an ‘a’ (lowercase) in their last names.

#5 Write a query to display the last name, job, department number, 
# and department name for all employees who work in Toronto

#6 Display the employee last name and employee number along with their manager’s last name and manager number. 
# Label the columns Employee, Emp#, Manager, and Mgr#, respectively.

#7 Modify Q6.sql to display all employees including King, 
# who has no manager. Order the results by the employee number.
select e.last_name as `Employee`, e.employee_id as `Emp#`,
e1.last_name as `Manager`, e1.manager_id as `Mgr#`
from employee e
left join employee e1
on e1.employee_id = e.manager_id
order by e.employee_id;

#8 Create a query that displays employee last names, department numbers, 
# and all the employees who work in the same department as a given employee. 
# Give each column an appropriate label.

#9 Show the structure of the JOB_GRADES table. Create a query that displays the name, 
#job,department name, salary, and grade for all employees

#10 Create a query to display the name and hire date of any employee hired after employee Davies

#11 Display the names and hire dates for all employees who were hired before their managers,
# along with their manager’s names and hire dates. Label the columns Employee, Emp
# Hired, Manager, and Mgr Hired, respectively

/*
	Sub Queries
*/
#1.	Write a query to display the name and hire date of any employee in the same department as SMITH. Exclude SMITH.

#2. Create a query to display the employee numbers and last names of all employees who earn more than the average salary. 
#Sort the results in ascending order of salary.

#3. Write a query that displays the employee numbers and names of all employees who work in a department with any employee whose name contains a U.

#4. Display the last name and salary of every employee who reports to BLAKE

#5. Display the department number, name, and job ID for every employee in the sales department.

#6. Modify the query in 5th exercise  to display the employee numbers, last names, and salaries of all employees who earn more than the average salary and 
# who work in a department with any employee with a ‘A’ in their name.
 



