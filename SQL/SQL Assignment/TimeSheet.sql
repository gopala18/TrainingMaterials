--TimeSheet Domain

-- Timesheet Domain
CREATE TABLE department(dept_id char(6) PRIMARY KEY,dept_name char(20), dept_location char(20));


CREATE TABLE role(role_id char(6) PRIMARY KEY,role_title char(20));

CREATE TABLE skill(skill_id char(6) PRIMARY KEY,skill_name char(20));	

CREATE TABLE employee(emp_id char(6) PRIMARY KEY,
					  emp_name char(20),
					  hire_date date,
					  salary decimal(10,2),
					  mgr_id char(6) REFERENCES employee(emp_id),
					  dept_no char(6) REFERENCES department(dept_id),
					  mobile_no char(10),
					  casual_leave int,
					  sick_leave int,
					  privilege_leave int);


CREATE TABLE employeeskill(emp_id char(6) references employee ,skill_id char(6) references skill);
				  
					  
CREATE TABLE project(project_id char(6) PRIMARY KEY,project_name char(20),client_name char(20),deadline date);


CREATE TABLE allocation(emp_id char(6) references employee,project_id char(6) references project ,role_id char(6) references role , from_date date PRIMARY KEY,to_date date, amount_per_day decimal(10,2));


select * from employee
select * from role

-- Insert
insert into role values('R001','Tester');
insert into role values('R002','UI Designer');
insert into role values('R003','Programmer');

insert into project values('P001','Billing','SS Enterprises','2014-04-01');
insert into project values('P002','ERP','HTC','2014-06-25');
insert into project values('P003','Optical','Eagle Vision','2016-02-09');
insert into project values('P004','Collection','The Collector','2015-07-14');
insert into project values('P005','Banking','SomeBank','2015-08-01');


insert into skill values('S001','Java');
insert into skill values('S002','DotNet');
insert into skill values('S003','PHP');
insert into skill values('S004','SQL');
insert into skill values('S005','Mainframe');


insert into department values('D001','Training','Chennai');
insert into department values('D002','Systems','Hydrabad');
insert into department values('D003','Operations','Mumbai');
insert into department values('D004','Development','Delhi');
insert into department values('D005','HR','Goa');

select * from employee

insert into employee (emp_id,emp_name,hire_date,salary,dept_no,mobile_no,casual_leave, sick_leave,privilege_leave)values('E005','Anish','2014-08-25',90000.00,'D001','7845781336',20,20,15);
insert into employee values('E001','Gopi','2013-03-01',30000.00,'E005','D001','7845781446',10,10,5);
insert into employee values('E002','Raja','2012-04-01',20500.00,'E005','D001','7745781446',10,10,5);
insert into employee values('E003','Kumar','2013-01-30',450000.00,'E005','D002','9845781446',10,10,5);
insert into employee values('E004','Vikram','2012-04-23',25000.00,'E005','D003','7825781446',10,10,5);



insert into employeeskill values('E001','S001');
insert into employeeskill values('E002','S002');
insert into employeeskill values('E003','S003');
insert into employeeskill values('E004','S004');
insert into employeeskill values('E005','S005');


insert into allocation values('E001','P001','R002','2013-04-01','2013-12-30',300.00);
insert into allocation values('E002','P002','R001','2012-06-01','2013-04-01',300.00);
insert into allocation values('E003','P001','R002','2013-03-01','2013-04-01',350.00);
insert into allocation values('E004','P002','R003','2012-05-01','2013-06-01',300.00);


insert into allocation values('E001','P002','R001','2014-06-01','2014-08-01',200.00);
insert into allocation values('E002','P002','R002','2019-04-01','2020-06-30',350.00);
insert into allocation values('E003','P001','R003','2020-03-01','2020-06-15',350.00);
insert into allocation values('E003','P003','R002','2019-05-01','2020-01-01',330.00);




--select

select * from employee;
select * from department;
select * from skill;
select * from employeeskill;
select * from project;



--Alter

alter table allocation add column to_date date
alter table employee add Constraint emp_Id_Pk Primary Key(emp_Id);
alter table employee drop constraint emp_Id_Pk;
alter table employee alter column emp_Id type char(5);
alter table employee rename to emp;

--Create User
create user gopi with password '123456';

--Grant & Revoke
grant create on database postgres to gopi; 
revoke insert on test from gopi
grant all privileges on test to gopi

-- SubQueries

Select * from employee where dept_no='D001'
select * from employee where dept_no IN (select dept_no from employee where salary>10000)
select * from employee where dept_no <> (select dept_no from employee where emp_name='Vikram')
select * from employee where salary not between 1000.00 and (select salary from employee where emp_name='Gopi');
select count(emp_id) from employee
select max(salary) from employee
select upper(emp_name) from employee


--with clause


with empname_employee as ( select emp_name from employee )

select emp_id,dept_no from Employee where emp_name IN (select * from empname_employee)


--Joins

--Cross join  ( combined result from two tables )
select * from employee cross join department
select * from skill cross join employeeskill

--Inner join

select * from department

select e.emp_id,e.emp_name,e.dept_no from employee e Inner join department d on e.dept_no=d.dept_id

select * from skill
select * from employeeskill

select e.emp_id,e.emp_name,e.dept_no,s.skill_id from employee e 
Inner join skill s on s.skill_id IN(select es.skill_id from employeeskill es)
where emp_id IN (select es.emp_id from employeeskill es)
group by e.emp_id,e.dept_no,s.skill_id


--outter (left)

select e.emp_id,e.emp_name,e.dept_no from employee e
left join department d on e.dept_no=d.dept_id


select department.dept_id,e.emp_id,e.emp_name from department.dept_id
right join employee e
on department.dept_id=e.dept_no


--Sample questions

--Which project has maximum number of employees?

select project_id,count(emp_id) from allocation group by project_id;

select project_id,count(emp_id) from allocation group by project_id having count(emp_id)>= all(select count(emp_id) from allocation group by project_id);

--which employee has not yet been allocated to any project?

select emp_id from employee where emp_id not in (select emp_id from allocation);

--which role played by employee 'E003' frequently?
select role_id,count(role_id) from allocation where emp_id='E003' group by role_id

select role_id from allocation where emp_id='E003' group by role_id having count(role_id)>=all(select count(role_id) from allocation where emp_id='E003' group by role_id);

--What is the salary of the employee who played maximum role in project 'P001'?

select emp_id,project_id,count(role_id) from allocation group by emp_id,project_id

select emp_id,count(role_id) from allocation where project_id='P001' group by emp_id

select emp_id,salary from employee where emp_id=(select emp_id from allocation where project_id='P001' group by emp_id having count(role_id)>=all (select count(role_id) from allocation where project_id='P001' group by emp_id))


-- How many project were handled by senior most employee;

select emp_id,hire_date from employee order by hire_date

select emp_id from employee where hire_date= (select min(hire_date) from employee)

select count(project_id)from allocation where emp_id=(select emp_id from employee where hire_date= (select min(hire_date) from employee))

-- How many employees are working under each managers?
SELECT e.mgr_id,
       count(*)
FROM employee e,
     employee m
WHERE e.mgr_id = m.emp_id
GROUP BY e.mgr_id

--Which project has maximum number of employees?

--which employee has not yet been allocated to any project?

--which role played by employee 'E003' frequently?

--What is the salary of the employee who played maximum role in project 'P001'?

-- How many project were handled by senior most employee;





--How many employees have worked for less than 10 projects?
--How many employees are working with role 'R002' in project 'P001'?
--Which client has given maximum number of projects?
--Which employee has not been allocated to any project in the year 2015?
--Find the total number of days worked by the employee 'E004' in project 'P003'?
--Which project has been completed exactly on deadline date?
--How many employees were working for the project, which has crossed the deadline?
--Which project has been completed so earlier?
--Which project has taken maximum duration?
