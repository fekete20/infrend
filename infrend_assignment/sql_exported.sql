create database neptun;
use neptun;

create table oktato (id int(9) auto_increment primary key, name varchar(255) not null, tanszek varchar(255) not null, oktatottTargyak varchar(255));

-- néhány adat statikus felvitele
insert into oktato values(1, 'oktato1', 'tanszek1', 'targy1');
insert into oktato values(2, 'oktato2', 'tanszek2', 'targy2');
insert into oktato values(3, 'oktato3', 'tanszek3', 'targy3');
insert into oktato values(4, 'oktato4', 'tanszek4', 'targy2');
insert into oktato values(5, 'oktato5', 'tanszek5', 'targy1');

create table hallgato (id int(9) auto_increment primary key, name varchar(255) not null, tankor varchar(9) not null, hallgatottTargyak varchar(255), jegy int(1));

-- néhány adat statikus felvitele
insert into hallgato values(1, 'hallgato1', 'tankor1', 'targy1', 5);
insert into hallgato values(2, 'hallgato2', 'tankor2', 'targy2', 4);
insert into hallgato values(3, 'hallgato3', 'tankor2', 'targy3', 5);
insert into hallgato values(4, 'hallgato4', 'tankor1', 'targy2', 1);
insert into hallgato values(5, 'hallgato5', 'tankor1', 'targy1', 2);

