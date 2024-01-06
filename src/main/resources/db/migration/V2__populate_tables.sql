insert into employee (employee_id, first_name, last_name, email ) values (1000, 'Steven', 'King', 'steve_king@pmaemail.com');
insert into employee (employee_id, first_name, last_name, email ) values (1001, 'Neena', 'Kochhar', 'neena_kochhar@email.com');
insert into employee (employee_id, first_name, last_name, email ) values (1002, 'Lex', 'De Haan', 'lex_dan@gmial.com');
insert into employee (employee_id, first_name, last_name, email ) values (1003, 'Alexander', 'Hunold', 'alex_hunold@ymail');
insert into employee (employee_id, first_name, last_name, email ) values (1004, 'Bruce', 'Ernst', 'bruce_ernst@grail.com');
insert into employee (employee_id, first_name, last_name, email ) values (1005, 'David', 'Austin', 'david_austin@kako.com');

insert into project (project_id, name, stage, description) values (1001, 'Project X', 0, 'This is project X description');
insert into project (project_id, name, stage, description) values (1002, 'Project Y', 1, 'This is project Y description');
insert into project (project_id, name, stage, description) values (1003, 'Project Z', 2, 'This is project Z description');

insert into projects_employees (project_id, employee_id) values (1001, 1000);
insert into projects_employees (project_id, employee_id) values (1001, 1001);
insert into projects_employees (project_id, employee_id) values (1002, 1002);
insert into projects_employees (project_id, employee_id) values (1002, 1003);
insert into projects_employees (project_id, employee_id) values (1003, 1004);
insert into projects_employees (project_id, employee_id) values (1003, 1005);
