drop table if exists board CASCADE;
create table board
(
    id bigint generated by default as identity,
    title varchar(50) not null,
    content varchar(255) not null,
    author varchar(50) not null,
    createdAt date,
    primary key (id)
)