create database Jukebox;
use Jukebox;

create table Songs(
SongId  int primary key auto_increment,
 SongName varchar(20) unique not null,
 ArtistName varchar(30) not null,
 AlbumName varchar (20) not null,
 SongGenre varchar(20) not null,
 SongDuration varchar(10) not null);
 
 describe Songs;
 
 insert into Songs values (101, 'Castle of Glass', 'Linkin Park', 'ABC', 'Rock', '04:50');
 insert into Songs values (103, 'Beleiver', 'Imagine Dragons', 'BCD', 'Pop', '03:37');
 insert into Songs values (105, 'Venom', 'Eminem', 'CDE', 'Rap', '04:56');
 insert into Songs values (107, 'Dynamite', 'BTS', 'DEF', 'Dance', '03:44');
 insert into Songs values (109, '21 Guns', 'Green Day', 'EFG', 'Pop', '04:58');
 insert into Songs values (111, 'Hymn For The Weekend', 'ColdPlay', 'FGH', 'Calm', '04:21');
 insert into Songs values (113, 'Bailando', 'Enrique Iglesias', 'GHI', 'Party', '04:32');
 insert into Songs values (115, 'Remember The Name', 'Fort Minor', 'HIJ', 'Motivation', '03:49');
 insert into Songs values (117, 'What I Have Done', 'Linkin Park', 'IJK', 'Rock', '03:27');
 insert into Songs values (119, 'Till I Collapse', 'Eminem', 'JKL', 'Motivation', '04:58');
 
 select * from Songs;
 
  create table Playlist(
 PlaylistId int primary key auto_increment,
 PlayListName varchar(20) unique not null);
 
 describe PlayList;
 
 create table PlayListContent(
 PlaylistId int,
 SongId int,
 foreign key(PlayListId) references Playlist(PlaylistId),
 foreign key (SongId) references Songs(SongId),
 primary key(PlaylistId, SongId));
 
  describe PlaylistContent;
  
  insert into Playlist values (201, 'Travel');
 insert into Playlist values (202, 'WorkOut');
 insert into Playlist values (203, 'Focus');
 insert into Playlist values (204, 'Patriotic');
 insert into Playlist values (205, 'Devotional');
 
 insert into PlaylistContent values (201, 101);
 insert into PlaylistContent values (202, 103);
 
 select * from Playlist order by PlayListId;
 select * from PlaylistContent;