create table principal (
    id bigserial primary key,
    username text unique not null,
    password text not null,
    permission text not null,
    enabled boolean not null,

    -- not using PostgreSQL enum types due to lack of native Hibernate support
    constraint valid_permission check (permission in ('READ', 'WRITE'))
);
