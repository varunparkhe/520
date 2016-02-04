

-- Insert into table roles

insert into roles (id , role) values (1 , 'admin');

insert into roles (id , role) values (2 , 'staff');

insert into roles (id , role) values (3 , 'student');



-- Insert into users 


insert into users ( id, cin , citizenship , dob , enabled , firstname , gender , lastname , password , phoneno , username ) 
values
(1 , 101 , 'usa' , '04/03/2016' , 'true' , 'admin' , 'male' , 'admin' ,'abcd' , '0123456789' , 'admin@localhost.localdomanin');

insert into users ( id, cin , citizenship , dob , enabled , firstname , gender , lastname , password , phoneno , username ) 
values
(2 , 102 ,'usa', '09/09/2015' , true ,  'staff1' , 'male' , 'staff1' , 'abcd' , '0123456798' , 'staff1@localhost.localdomanin');


insert into users ( id, cin , citizenship , dob , enabled , firstname , gender , lastname , password , phoneno , username ) 
values
(3, 103 , 'uk' , '05/02/2016' , 'true' , 'staff2' , 'female' , 'staff2' ,'abcd' , '0123456978' , 'staff2@localhost.localdomanin');

insert into users ( id, cin , citizenship , dob , enabled , firstname , gender , lastname , password , phoneno , username ) 
values
(4, 104 , 'usa' , '09/03/2016' , 'true' , 'student1' , 'female' , 'student1' ,'abcd' , '0123459678' , 'student1@localhost.localdomanin');

insert into users ( id, cin , citizenship , dob , enabled , firstname , gender , lastname , password , phoneno , username ) 
values
(5, 105 , 'usa' , '08/02/2016' , 'true' , 'student2' , 'male' , 'student2' ,'abcd' , '0123495678' , 'student2 @localhost.localdomanin');




-- Insert into roles_users 


insert into roles_users ( role_id , user_id ) values ( 1, 1 );

insert into roles_users ( role_id , user_id ) values ( 2 , 2 );

insert into roles_users ( role_id , user_id ) values ( 2 , 3 );

insert into roles_users ( role_id , user_id ) values ( 3 , 4 );

insert into roles_users ( role_id , user_id ) values ( 3 , 5 );




-- Insert into departments

insert into departments (id, departmentname , term , year )
values (1, 'Accounting Department' , 'Fall' , '2016'	);


insert into departments (id, departmentname , term , year )
values (2, 'Computer Science Department' , 'Fall' , '2016'	);





-- Insert into applicationstatus


insert into applicationstatus  ( id , status ) values (1, 'new' );

insert into applicationstatus  ( id , status ) values (2, 'pending review' );

insert into applicationstatus  ( id , status ) values (3, 'denied' );

insert into applicationstatus  ( id , status ) values (4, 'recommend admit' );

insert into applicationstatus  ( id , status ) values (5, 'recommend admit w / conditions' );




-- Insert into 


insert into additionalfield  ( id , name , required , type , departments_id )
values ( 1, 'gmat' , 'true' , 'text' , 1 );




-- Insert into  programs


insert into programs ( id , programname , departmentprog_id ) values ( 1, 'ms in accounting' , 1 );


insert into programs ( id , programname , departmentprog_id ) values ( 2, 'ms in computer science' , 2 );




-- Insert into applications

insert into applications 
	(id, gpa , gre , toefl ,trasncript , prog_id , user_id) 
values  (1, null , null , null , null , 1 , 4 );




-- Insert into auditstatus


insert into auditstatus  (id, comments , time , applicant_id , applicationstatus_id )
values (1, 'new' , '09/02/2016' ,  1 ,  1 );


-- insert into educationalbackground

insert into educationalbackground  ( id , degree , major , university , year , applicationsdegree_id	)
values ( 1, 'bs' , 'computer science' , 'stanford' , '08/05/2012' , 1	 );






