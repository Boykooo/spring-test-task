create table "user"
(
    id       serial primary key,
    fullname varchar(255) not null,
    password varchar(255) not null,
    login    varchar(255) not null
)