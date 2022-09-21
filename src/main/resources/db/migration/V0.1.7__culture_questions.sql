CREATE SEQUENCE IF NOT EXISTS uuid2 START WITH 1 INCREMENT BY 1;

CREATE TABLE culture_answers
(
    id                  VARCHAR(255) NOT NULL,
    version             INTEGER,
    created_at          TIMESTAMP WITHOUT TIME ZONE,
    created_by          VARCHAR(255),
    updated_at          TIMESTAMP WITHOUT TIME ZONE,
    updated_by          VARCHAR(255),
    deleted             BOOLEAN,
    active              BOOLEAN,
    content             VARCHAR(255),
    culture_question_id VARCHAR(255),
    CONSTRAINT pk_culture_answers PRIMARY KEY (id)
);

CREATE TABLE culture_answers_details
(
    id                      VARCHAR(255) NOT NULL,
    version                 INTEGER,
    created_at              TIMESTAMP WITHOUT TIME ZONE,
    created_by              VARCHAR(255),
    updated_at              TIMESTAMP WITHOUT TIME ZONE,
    updated_by              VARCHAR(255),
    deleted                 BOOLEAN,
    active                  BOOLEAN,
    culture_answer_id       VARCHAR(255),
    culture_quiz_details_id VARCHAR(255),
    content                 VARCHAR(255),
    CONSTRAINT pk_culture_answers_details PRIMARY KEY (id)
);

CREATE TABLE culture_questions
(
    id         VARCHAR(255) NOT NULL,
    version    INTEGER,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    created_by VARCHAR(255),
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    updated_by VARCHAR(255),
    deleted    BOOLEAN,
    active     BOOLEAN,
    score      INTEGER,
    content    VARCHAR(255),
    type       VARCHAR(255),
    CONSTRAINT pk_culture_questions PRIMARY KEY (id)
);

CREATE TABLE culture_quiz_details
(
    id               VARCHAR(255) NOT NULL,
    version          INTEGER,
    created_at       TIMESTAMP WITHOUT TIME ZONE,
    created_by       VARCHAR(255),
    updated_at       TIMESTAMP WITHOUT TIME ZONE,
    updated_by       VARCHAR(255),
    deleted          BOOLEAN,
    active           BOOLEAN,
    score            INTEGER,
    quiz_instance_id VARCHAR(255),
    CONSTRAINT pk_culture_quiz_details PRIMARY KEY (id)
);

CREATE TABLE culture_quiz_details_culture_question
(
    culture_quiz_details_id  VARCHAR(255) NOT NULL,
    culture_question_id VARCHAR(255) NOT NULL
);

ALTER TABLE culture_answers_details
    ADD CONSTRAINT FK_CULTURE_ANSWERS_DETAILS_ON_CULTUREANSWER FOREIGN KEY (culture_answer_id) REFERENCES culture_answers (id);

ALTER TABLE culture_answers_details
    ADD CONSTRAINT FK_CULTURE_ANSWERS_DETAILS_ON_CULTUREQUIZDETAILS FOREIGN KEY (culture_quiz_details_id) REFERENCES culture_quiz_details (id);

ALTER TABLE culture_answers
    ADD CONSTRAINT FK_CULTURE_ANSWERS_ON_CULTURE_QUESTION FOREIGN KEY (culture_question_id) REFERENCES culture_questions (id);

ALTER TABLE culture_quiz_details
    ADD CONSTRAINT FK_CULTURE_QUIZ_DETAILS_ON_QUIZINSTANCE FOREIGN KEY (quiz_instance_id) REFERENCES quiz_instance (id);

ALTER TABLE culture_quiz_details_culture_question
    ADD CONSTRAINT fk_culquidetculque_on_culture_question FOREIGN KEY (culture_question_id) REFERENCES culture_questions (id);

ALTER TABLE culture_quiz_details_culture_question
    ADD CONSTRAINT fk_culquidetculque_on_culture_quiz_details FOREIGN KEY (culture_quiz_details_id) REFERENCES culture_quiz_details (id);

ALTER TABLE file
    ALTER COLUMN size DROP NOT NULL;