CREATE TABLE GOODIES
(
    id                  varchar(255) not null primary key,
    active              boolean,
    created_at          timestamp,
    created_by          varchar(255),
    deleted             boolean,
    updated_at          timestamp,
    updated_by          varchar(255),
    version             integer,
    available_stock     integer,
    label               varchar(255),
    win_score_threshold integer
);

ALTER TABLE goodies
    ADD CONSTRAINT UNIQUE_LABEL UNIQUE (label);
