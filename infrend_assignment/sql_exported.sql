create database neptun;
use neptun;

create table oktato (id int(9) auto_increment primary key, name varchar(255) not null, tanszek varchar(255) not null, oktatottTargyak varchar(255));

-- nehany adat statikus felvitele
insert into oktato values(1, 'Teszt Elek', 'Alkalmazot Informatikai Intézeti Tanszék', 'Infrend');
insert into oktato values(2, 'Gipsz Jakab', 'Analízis Tanszék', 'Analízis I., Analízis II.');
insert into oktato values(3, 'Barna Endre', 'Általános Informatikai Intézeti Tanszék', 'Számítógép hálózatok');
insert into oktato values(4, 'Székely Balázs', 'Ábrázoló Geometria Tanszék', 'Ábrázoló Geometria, Bevezetés a CAD-be');


create table hallgato (id int(9) auto_increment primary key, name varchar(255) not null, tankor varchar(9) not null, hallgatottTargyak varchar(255), jegy int(1));

-- nehany adat statikus felvitele
insert into hallgato values(1, 'Takács Attila', 'G3BIW', 'Infrend', 5);
insert into hallgato values(2, 'Pásztor Péter', 'G3BIT', 'Analízis II.', 4);
insert into hallgato values(3, 'Juhász Dénes', 'G3BIR', 'Bevezetés a CAD-be', 3);
insert into hallgato values(4, 'Somogyi Attila', 'G3BIW', 'Számítógép hálózatok', 2);