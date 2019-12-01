-- This is the base OAUTH Tables scripts which is being used by this application.
-- Created By: Sudhakar Tangellapalli
-- Maintainer : jgsudhakar735@gmail.com

ALTER TABLE ROLE ADD  DESCRIPTION  VARCHAR(255) DEFAULT NULL;
ALTER TABLE PERMISSION ADD DESCRIPTION  VARCHAR(255) DEFAULT NULL;
