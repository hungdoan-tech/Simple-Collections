create database ShowImage;
use ShowImage;
create table Person(
Id numberic(19,0) not null,
Name varchar(50) not null,
Image_Data longblob not null,
Image_File_Name varchar(30) not null);

alter table Person
add constraint Person_PK primary key (Id);


