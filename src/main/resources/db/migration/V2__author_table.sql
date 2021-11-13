drop table if exists author;

create table author (
                      id bigint not null,
                      firstname varchar(255),
                      surname varchar(255),
                      info varchar(500),
                      primary key (id)
) engine=InnoDB;
