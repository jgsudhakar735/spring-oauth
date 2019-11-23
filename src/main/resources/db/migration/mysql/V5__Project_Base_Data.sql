-- This is the base OAUTH Tables scripts which is being used by this application.
-- Created By: Sudhakar Tangellapalli
-- Maintainer : jgsudhakar735@gmail.com

-- This file will be having base Data of the project
INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES ('mobile', '{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu', 'http://localhost:8080/code', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');

 INSERT INTO PERMISSION (NAME) VALUES
 ('CREATE'),
 ('READ'),
 ('UPDATE'),
 ('DELETE');

 INSERT INTO ROLE (NAME) VALUES 
 ('ROLE_ADMIN'),
 ('ROLE_OPERATOR'),
 ('ROLE_USER');

 INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID) VALUES
     ((SELECT ID FROM PERMISSION WHERE NAME = 'CREATE') , (SELECT ID FROM ROLE WHERE NAME = 'ROLE_ADMIN')), /*create-> admin */
     ((SELECT ID FROM PERMISSION WHERE NAME = 'UPDATE') , (SELECT ID FROM ROLE WHERE NAME = 'ROLE_ADMIN')), /*create-> admin */
     ((SELECT ID FROM PERMISSION WHERE NAME = 'READ') , (SELECT ID FROM ROLE WHERE NAME = 'ROLE_ADMIN')), /*create-> admin */
     ((SELECT ID FROM PERMISSION WHERE NAME = 'DELETE') , (SELECT ID FROM ROLE WHERE NAME = 'ROLE_ADMIN')), /*create-> admin */
     ((SELECT ID FROM PERMISSION WHERE NAME = 'READ') , (SELECT ID FROM ROLE WHERE NAME = 'ROLE_OPERATOR')), /*create-> admin */
     ((SELECT ID FROM PERMISSION WHERE NAME = 'UPDATE') , (SELECT ID FROM ROLE WHERE NAME = 'ROLE_OPERATOR')), /*create-> admin */
     ((SELECT ID FROM PERMISSION WHERE NAME = 'READ') , (SELECT ID FROM ROLE WHERE NAME = 'ROLE_USER')) /*create-> admin */
;  
insert into user (user_id, user_name,user_password, user_email, user_status, accountNonExpired, password_status, accountNonLocked) VALUES ('1', 'Sudhakar','{bcrypt}$2a$10$405iEat0nlEpBS5gITl3OeSLEiJ60X97xvDB9GFdRiYqOn25F5AMa', 'sudhakar@justgo.com', '1', '1', '1', '1');
 insert into  user (user_id, user_name,user_password, user_email, user_status, accountNonExpired, password_status, accountNonLocked) VALUES ('2', 'Sriyaan', '{bcrypt}$2a$10$1vHF7hKxotHYPjoCiRK3NOxrEbTBTNG889QIj2r3oUDIgXnbGwsai','sriyaan@justgo.com', '1', '1', '1', '1');
 insert into  user (user_id, user_name,user_password, user_email, user_status, accountNonExpired, password_status, accountNonLocked) VALUES ('3', 'Sanvi', '{bcrypt}$2a$10$kc4i3Hh7jp//ErIxFuhC9..GQqb3i5Pw/zphy6QPjZokNtCehVUhS','sanvi@justgo.com', '1', '1', '1', '1');

INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
    VALUES
    ((SELECT ID FROM ROLE WHERE NAME = 'ROLE_ADMIN'), (SELECT user_id FROM USER WHERE user_name ='Sudhakar')) /* Sudhakar-admin */,
    ((SELECT ID FROM ROLE WHERE NAME = 'ROLE_OPERATOR') , (SELECT user_id FROM USER WHERE user_name ='Sriyaan')) /* Sriyaan-operatorr */ ,
    ((SELECT ID FROM ROLE WHERE NAME = 'ROLE_USER'), (SELECT user_id FROM USER WHERE user_name ='Sanvi')) /* Sriyaan-operatorr */ ;