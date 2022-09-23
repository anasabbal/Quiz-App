CREATE TABLE FEEDBACKS
(
    id         varchar(255) not null primary key,
    active     boolean,
    created_at timestamp,
    created_by varchar(255),
    deleted    boolean,
    updated_at timestamp,
    updated_by varchar(255),
    version    integer,
    content    varchar(255)
);

