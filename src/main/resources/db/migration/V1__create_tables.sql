create table employee(employee_id bigint primary key, first_name varchar(50) not null,
                      last_name varchar(50) not null, email varchar(50) not null);

create table project(project_id bigint primary key, name varchar(50) not null,
                     description varchar(500) not null, stage tinyint not null);

create table projects_employees(project_id bigint not null, employee_id bigint not null,
                                foreign key (employee_id) references employee(employee_id),
                                foreign key (project_id) references project(project_id));

create table question(question_id bigint primary key, ask varchar(500), category varchar(500),
                      option1 varchar(500), option2 varchar(500), option3 varchar(500), option4 varchar(500), answer varchar(500),
                      has_image boolean, image varchar(500));

create sequence employee_seq start with 1 increment by 50;
create sequence project_seq start with 1 increment by 50;
create sequence question_seq start with 1 increment by 50;