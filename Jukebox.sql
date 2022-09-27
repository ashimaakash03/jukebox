create database Jukebox;
use Jukebox;

create table Songs(
SongId  int primary key,
 SongName varchar(20) unique not null,
 ArtistName varchar(30) not null,
 AlbumName varchar (20) not null,
 SongGenre varchar(20) not null,
 SongDuration varchar(10) not null);
 
 describe Songs;
 
 insert into Songs values (101, 'Castle of Glass', 'Linkin Park', 'None', 'Rock', '04:50');
 insert into Songs values (102, 'Beleiver', 'Imagine Dragons', 'None','Rock', '03:37');
 insert into Songs values (103, 'Venom', 'Eminem', 'None', 'Rock', '04:56');
 insert into Songs values (104, 'Dynamite', 'BTS', 'None', 'Rock', '03:44');
 insert into Songs values (105, '21 Guns', 'Green Day', 'None','Rock', '05:26');
 insert into Songs values (106, 'Hymn For The Weekend', 'ColdPlay', 'None', 'Rock', '04:21');
 insert into Songs values (107, 'Bailando', 'Enrique Iglesias', 'None', 'Rock', '04:32');
 insert into Songs values (108, 'Remember The Name', 'Fort Minor', 'None', 'Rock', '03:49');
 
 select * from Songs;