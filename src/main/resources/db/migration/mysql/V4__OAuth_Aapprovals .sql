-- This is the base OAUTH Tables scripts which is being used by this application.
-- Created By: Sudhakar Tangellapalli
-- Maintainer : jgsudhakar735@gmail.com

-- This table is to store the approval details of the client
create table if not exists oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);