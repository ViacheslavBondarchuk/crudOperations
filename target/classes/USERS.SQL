create table users
(
    id bigserial not null,
    username character varying not null,
    password character varying not null,
    firstname character varying not null,
    lastname character varying not null,
    primary key(id)
)