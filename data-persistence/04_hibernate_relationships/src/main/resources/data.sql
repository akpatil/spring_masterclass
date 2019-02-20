insert into course (id, name) values (1, 'How to be wild');
insert into course (id, name) values (2, 'Meany Kitty');
insert into course (id, name) values (3, 'Kachao-ow');

insert into passport (id, number) values (100, 'N2001020');
insert into passport (id, number) values (102, 'P4011029');
insert into passport (id, number) values (103, 'S8061024');

insert into student (id, name, passport_id) values (100, 'Fae', 100);
insert into student (id, name, passport_id) values (102, 'Ada', 102);
insert into student (id, name, passport_id) values (103, 'Leon', 103);

insert into review (id, rating, description, course_id) values (100, '3', 'What a performance', 1);
insert into review (id, rating, description, course_id) values (102, '5', 'Awestruck', 1);
insert into review (id, rating, description, course_id) values (103, '1', 'I want my money back ! I got doped !!', 3);

insert into student_course (student_id, course_id) values (100, 1);
insert into student_course (student_id, course_id) values (103, 1);