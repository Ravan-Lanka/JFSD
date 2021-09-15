MySql Statements:
create database JFSD_Skill1;
use JFSD_Skill1;
create table Specialization(Spec_ID varchar(20) primary key,Spec_Name varchar(35),Avail_Slots int);
insert into Specialization(Spec_ID,Spec_Name,Avail_Slots)values
("19csml","Machine Learning",45),
("19csai","Artificial Inteligence",45),
("19cscc","Cloud Computing",45),
("19cssc","Soft Computing",45);
create table Student(ID bigint primary key,name varchar(50),Spec_ID varchar(20),Spec_Name varchar(35));