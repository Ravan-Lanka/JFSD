MySQL Statements:
create table StudentBacklog(ID bigint primary key, StudentName varchar(35), Gender varchar(10), year_of_study int, Department varchar(25), mail varchar(35), CGPA float, NoOfBacklogs int);
insert into StudentBacklog values
(190330202, "Raviteja", "Male",3,"cse","190330202@klh.edu.in",9.31,0),
(190330352, "rajesh", "Male",2,"ece","190330352@klh.edu.in",8.43,0),
(190330353, "rakesh", "Male",3,"cse","190330353@klh.edu.in",5.31,4),
(190330354, "mahesh", "Male",2,"ece","190330354@klh.edu.in",4.32,6),
(190330355, "ramesh", "Male",3,"cse","190330355@klh.edu.in",7.21,3);