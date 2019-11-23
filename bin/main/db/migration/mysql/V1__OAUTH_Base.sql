-- This is the base OAUTH Tables scripts which is being used by this application.
-- Created By: Sudhakar Tangellapalli
-- Maintainer : jgsudhakar735@gmail.com


-- Standard Table of Client Registration
create table if not EXISTS oauth_client_details (
    client_id VARCHAR(256),
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256),
    PRIMARY KEY (client_id)
);

-- User Registration table. This will be basically having the user information along with password.
create table if not EXISTS user (
    user_id int(10) NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(256),
    user_email VARCHAR(100),
    user_password VARCHAR(256),
    user_status VARCHAR(1),
    password_status VARCHAR(1),
    accountNonExpired VARCHAR(4),
    accountNonLocked  VARCHAR(4),
    created_by  VARCHAR(50),
    uodated_by VARCHAR(50),
    created_date DATETIME ,
    updated_date DATETIME,
    failed_login_attempts int(10),
    last_login DATETIME,
    PRIMARY KEY (user_id)
);
