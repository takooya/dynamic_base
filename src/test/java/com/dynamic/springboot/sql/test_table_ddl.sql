drop table if exists users;
create table users
(
    id          bigint auto_increment,
    name        varchar(255),
    create_time timestamp,
    primary key (id)
);

drop table if exists goods;
create table goods
(
    id          bigint auto_increment,
    name        varchar(255),
    price       bigint,
    create_time timestamp,
    update_time timestamp,
    primary key (id)
);