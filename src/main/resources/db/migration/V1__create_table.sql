create table employee(employee_id int primary key auto_increment, first_name varchar(50) not null, last_name varchar(50) not null, email varchar(50) not null);

create table project(project_id int primary key auto_increment, name varchar(50) not null, description varchar(500) not null, stage smallint not null);

create table projects_employees(project_id int not null, employee_id int not null, foreign key (employee_id) references employee(employee_id), foreign key (project_id) references project(project_id));