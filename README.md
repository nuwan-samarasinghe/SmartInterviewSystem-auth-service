# README #

###Run auth locally

INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES 
('mobile', '{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu', 'http://localhost:8080/code', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');

 INSERT INTO PERMISSION (id,NAME) VALUES
 (1,'create_customer'),
 (2,'read_customer'),
 (3,'update_customer'),
 (4,'delete_customer');

 INSERT INTO role (id,NAME) VALUES
		(1,'ROLE_admin'),(2,'ROLE_operator');

 INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID) VALUES
     (1,1), /*create-> admin */
     (2,1), /* read admin */
     (3,1), /* update admin */
     (4,1), /* delete admin */
     (2,2),  /* read operator */
     (3,2);  /* update operator */
insert into user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES 
('1', 'saman','{bcrypt}$2a$10$ODGwrk2ufy5d7T6afmACwOA/6j6rvXiP5amAMt1YjOQSdEw44QdqG', 'saman@gmail.com', 1, 1, 1, 1);
 insert into  user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES 
 ('2', 'kamal', '{bcrypt}$2a$10$wQ8vZl3Zm3.zDSIcZEYym.bGq3fPMJXH9k.Vhudcfr6O6KQwDPSt6','kamal@gmail.com', 1, 1, 1, 1);

INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
    VALUES
    (1, 1) /* saman-admin */,
    (2, 2) /* kamal-operatorr */ ;

