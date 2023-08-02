create table PUBLIC.BOOKS
(
    ISBN        CHARACTER VARYING(10) not null primary key,
    TITLE       CHARACTER VARYING(50) not null,
    DESCRIPTION CHARACTER VARYING(50) not null
);
