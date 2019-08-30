insert into t_owner(id,first_name,last_name) values (1,'Burak','Elitas');
insert into t_owner(id,first_name,last_name) values (2,'Ahmet','Elitas');
insert into t_owner(id,first_name,last_name) values (3,'Dilara','Elitas');
insert into t_owner(id,first_name,last_name) values (4,'Aybuke','Yazıcı');
insert into t_owner(id,first_name,last_name) values (5,'Gülşah','Aydın');
insert into t_owner(id,first_name,last_name) values (6,'Sude','fidan');
insert into t_owner(id,first_name,last_name) values (7,'Ethem','aksakal');



insert into t_pet(id,name,birth_date,owner_id) values(1,'Maviş','2005-09-07',1);
insert into t_pet(id,name,birth_date,owner_id) values(2,'Karaburun','2004-10-07',1);
insert into t_pet(id,name,birth_date,owner_id) values(3,'Tahta','2012-08-02',2);
insert into t_pet(id,name,birth_date,owner_id) values(4,'Toprak','2002-12-2',7);
insert into t_pet(id,name,birth_date,owner_id) values(5,'Boncuk','2010-05-04',4);
insert into t_pet(id,name,birth_date,owner_id) values(6,'Lapa','2013-01-09',4);
insert into t_pet(id,name,birth_date,owner_id) values(7,'Fresh','2004-01-12',6);




INSERT INTO USERS VALUES('user1','{bcrypt}$2a$10$GOErxPhSGMSXia9t.uEyMuUKyGwS36KwUB3ORbmrEn44x5RaTLoqi',TRUE);
INSERT INTO USERS VALUES('user2','{bcrypt}$2a$10$9mijMsd3yL7EkqtvCrTUte7FtNXWTOURxdXb2O.CO9BWcQ20HZgBm',TRUE);
INSERT INTO USERS VALUES('user3','{bcrypt}$2a$10$pkvQiXhsItq30CBv09ihQOcjRZTkxIWZfQ2T3JIKehMxuYgWSeBGS',TRUE);

INSERT INTO AUTHORITIES VALUES('user1','ROLE_USER');
INSERT INTO AUTHORITIES VALUES('user2','ROLE_USER');
INSERT INTO AUTHORITIES VALUES('user2','ROLE_EDITOR');
INSERT INTO AUTHORITIES VALUES('user3','ROLE_USER');
INSERT INTO AUTHORITIES VALUES('user3','ROLE_EDITOR');
INSERT INTO AUTHORITIES VALUES('user3','ROLE_ADMIN');