create table location (
    id bigserial primary key,
    timestamp_utc timestamp with time zone not null,
    time_zone text not null,
    latitude double precision not null,
    longitude double precision not null,
    accuracy double precision,
    save_mode text not null,

    -- not using PostgreSQL enum types due to lack of native Hibernate support
    constraint valid_save_mode check (save_mode in ('AUTOMATIC', 'MANUAL'))
);
