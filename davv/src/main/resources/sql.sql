use scholarship;
CREATE TABLE personal_info (
  sName varchar(40) NOT NULL,
  dob varchar(45) NOT NULL,
  fName varchar(45) NOT NULL,
  gender varchar(45) NOT NULL,
  catagory varchar(45) NOT NULL,
  aadhra_no varchar(45) NOT NULL,
  phone varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  state varchar(45) NOT NULL,
  city varchar(45) NOT NULL,
  pin int(11) NOT NULL,
  user_name varchar(45) NOT NULL,
  hs_school varchar(40) NOT NULL,
  hs_board varchar(45) NOT NULL,
  hs_year varchar(45) NOT NULL,
  hs_mars varchar(45) NOT NULL,
  h_school varchar(40) NOT NULL,
  h_board varchar(45) NOT NULL,
  h_year varchar(45) NOT NULL,
  h_mars varchar(45) NOT NULL,
  b_name varchar(40) NOT NULL,
  branch varchar(45) NOT NULL,
  ifsc varchar(45) NOT NULL,
  ac_no varchar(45) NOT NULL,
  PRIMARY KEY  (user_name),
  KEY user_name (user_name),
  CONSTRAINT personal_info_ibfk_1 FOREIGN KEY (user_name) REFERENCES scholarship.user (username)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE status (
  userName varchar(40) NOT NULL,
  status varchar(45) NOT NULL default 'panding',
  PRIMARY KEY  (userName),
  CONSTRAINT userName FOREIGN KEY (userName) REFERENCES personal_info (userName) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
use scholarship;
delete from users_roles where user_id=1 and role_id=1;

select * from personal_info;
select * from user;
select * from users_roles;
select * from role;
insert into users_roles values(1,2);
select * from status;
delete from user where id=5;
delete from users_roles where user_id=6;