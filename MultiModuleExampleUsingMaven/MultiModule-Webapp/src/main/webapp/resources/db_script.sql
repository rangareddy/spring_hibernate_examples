drop table if exists Employees

create table Employees (
        id bigint not null auto_increment,
        age integer,
        name varchar(255),
        salary float,
        primary key (id)
)