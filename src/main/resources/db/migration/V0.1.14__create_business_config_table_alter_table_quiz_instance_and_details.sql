CREATE TABLE BUSINESS_CONFIG
(
    id    varchar(255) not null primary key,
    key   varchar(255) not null unique,
    value varchar(255)
);

INSERT INTO business_config (id, key, value)
VALUES ('TECHNICAL_QUIZ_FACTOR_PERCENT', 'TECHNICAL_QUIZ_FACTOR_PERCENT', '50'),
       ('CULTURAL_QUIZ_FACTOR_PERCENT', 'CULTURAL_QUIZ_FACTOR_PERCENT', '50');

ALTER TABLE culture_quiz_details
ADD COLUMN percent_final_score float4;

ALTER TABLE quiz_instance
ADD COLUMN percent_final_score float4;








