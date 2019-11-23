-- This is the base OAUTH Tables scripts which is being used by this application.
-- Created By: Sudhakar Tangellapalli
-- Maintainer : jgsudhakar735@gmail.com


-- Standard Table of Permission
create table if not EXISTS Permission (
    id int(10) not NULL AUTO_INCREMENT,
    name VARCHAR(512) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY PER_NAME (name)
);

-- User Role Table;
create table if not EXISTS role (
    id int(10) not NULL AUTO_INCREMENT,
    name VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY ROLE_NAME (name)
);

-- Permission Role Table;
create table if not EXISTS permission_role (
    permission_id int(10) DEFAULT NULL,
    role_id int(10) DEFAULT NULL,
    KEY permission_id (permission_id),
    KEY role_id (role_id),
    CONSTRAINT per_fk_id FOREIGN KEY (permission_id) REFERENCES Permission(id),
    CONSTRAINT role_fk_id FOREIGN KEY (role_id) REFERENCES role(id)
);

-- User and Role Mapping
CREATE TABLE IF NOT EXISTS role_user (
role_id int(10) DEFAULT NULL,
user_id int(10) DEFAULT NULL,
KEY role_id (role_id),
KEY user_id (user_id),
CONSTRAINT role_user_fk_key FOREIGN KEY (user_id) REFERENCES user(user_id),
CONSTRAINT role_user_fk_id FOREIGN KEY (role_id) REFERENCES role(id)
);
