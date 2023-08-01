
DROP TABLE books IF EXISTS;

create table books (
    isbn varchar(10) NOT NULL,
    title varchar(50) NOT NULL,
    description varchar(50) NOT NULL,
    PRIMARY KEY (isbn)
);


