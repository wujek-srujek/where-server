create table read_log (
    id bigserial primary key,
    principal_username text not null,
    timestamp_utc timestamp with time zone not null
);
