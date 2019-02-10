create table person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);

insert into person (id, name, location, birth_date) values (1001, 'Ahmed Alkubaisey', 'Al Basrah', sysdate());
insert into person (id, name, location, birth_date) values (1002, 'Josh Matthews', 'Chicago', sysdate());
insert into person (id, name, location, birth_date) values (1003, 'Josh Berstein', 'Egypt', sysdate());
insert into person (id, name, location, birth_date) values (1004, 'Raman Chodu', 'Chennai', sysdate());
insert into person (id, name, location, birth_date) values (1005, 'Dania Zacharia', 'Hungary', sysdate());
insert into person (id, name, location, birth_date) values (1006, 'Christa Melarossa', 'Norway', sysdate());