-- This is the base OAUTH Tables scripts which is being used by this application.
-- Created By: Sudhakar Tangellapalli
-- Maintainer : jgsudhakar735@gmail.com

-- Customer Table.
CREATE TABLE IF NOT EXISTS Author (
    author_id int(10) NOT NULL AUTO_INCREMENT,
    author_name VARCHAR(256),
    author_email VARCHAR(100),
    author_status VARCHAR(1),
    created_by  VARCHAR(50),
    uodated_by VARCHAR(50),
    created_date DATETIME ,
    updated_date DATETIME,
    PRIMARY KEY (author_id)
);

-- Book Table
CREATE TABLE IF NOT EXISTS Book (
    book_id int(10) NOT NULL AUTO_INCREMENT,
    book_name VARCHAR(256),
    book_status VARCHAR(1),
    author_id int(10) not NULL,
    created_by  VARCHAR(50),
    uodated_by VARCHAR(50),
    created_date DATETIME ,
    updated_date DATETIME,
    CONSTRAINT author_bk_fk_id FOREIGN KEY (author_id) REFERENCES Author(author_id),
    PRIMARY KEY (book_id)
);