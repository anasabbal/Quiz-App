CREATE TABLE answers
(
    id          VARCHAR(255) NOT NULL,
    version     INTEGER,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    created_by  VARCHAR(255),
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_by  VARCHAR(255),
    deleted     BOOLEAN,
    active      BOOLEAN,
    is_correct  BOOLEAN,
    content     VARCHAR(255),
    question_id VARCHAR(255),
    CONSTRAINT pk_answers PRIMARY KEY (id)
);

CREATE TABLE attendee_event
(
    event_id    VARCHAR(255) NOT NULL,
    attendee_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_attendee_event PRIMARY KEY (event_id, attendee_id)
);

CREATE TABLE attendees
(
    id           VARCHAR(255) NOT NULL,
    version      INTEGER,
    created_at   TIMESTAMP WITHOUT TIME ZONE,
    created_by   VARCHAR(255),
    updated_at   TIMESTAMP WITHOUT TIME ZONE,
    updated_by   VARCHAR(255),
    deleted      BOOLEAN,
    active       BOOLEAN,
    first_name   VARCHAR(255),
    last_name    VARCHAR(255),
    email        VARCHAR(255),
    phone_number VARCHAR(255),
    CONSTRAINT pk_attendees PRIMARY KEY (id)
);

CREATE TABLE event_form_element
(
    id                  VARCHAR(255) NOT NULL,
    version             INTEGER,
    created_at          TIMESTAMP WITHOUT TIME ZONE,
    created_by          VARCHAR(255),
    updated_at          TIMESTAMP WITHOUT TIME ZONE,
    updated_by          VARCHAR(255),
    deleted             BOOLEAN,
    active              BOOLEAN,
    type                VARCHAR(255),
    name                VARCHAR(255),
    placeholder         VARCHAR(255),
    label               VARCHAR(255),
    required            BOOLEAN,
    html_type           VARCHAR(255),
    inner_text          VARCHAR(255),
    event_form_setup_id VARCHAR(255),
    CONSTRAINT pk_event_form_element PRIMARY KEY (id)
);

CREATE TABLE event_form_setup
(
    id            VARCHAR(255) NOT NULL,
    version       INTEGER,
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    created_by    VARCHAR(255),
    updated_at    TIMESTAMP WITHOUT TIME ZONE,
    updated_by    VARCHAR(255),
    deleted       BOOLEAN,
    active        BOOLEAN,
    form_name     VARCHAR(255),
    form_title    VARCHAR(255),
    submit_url    VARCHAR(255),
    submit_method VARCHAR(255),
    theme_id      VARCHAR(255),
    CONSTRAINT pk_event_form_setup PRIMARY KEY (id)
);

CREATE TABLE event_setup
(
    id                     VARCHAR(255) NOT NULL,
    version                INTEGER,
    created_at             TIMESTAMP WITHOUT TIME ZONE,
    created_by             VARCHAR(255),
    updated_at             TIMESTAMP WITHOUT TIME ZONE,
    updated_by             VARCHAR(255),
    deleted                BOOLEAN,
    active                 BOOLEAN,
    title                  VARCHAR(255),
    description            VARCHAR(255),
    kind                   VARCHAR(255),
    initialize_button_text VARCHAR(255),
    form_setup_id          VARCHAR(255),
    submit_url             VARCHAR(255),
    submit_method          VARCHAR(255),
    event_id               VARCHAR(255),
    CONSTRAINT pk_event_setup PRIMARY KEY (id)
);

CREATE TABLE event_themes
(
    id               VARCHAR(255) NOT NULL,
    version          INTEGER,
    created_at       TIMESTAMP WITHOUT TIME ZONE,
    created_by       VARCHAR(255),
    updated_at       TIMESTAMP WITHOUT TIME ZONE,
    updated_by       VARCHAR(255),
    deleted          BOOLEAN,
    active           BOOLEAN,
    background_image VARCHAR(255),
    background_color VARCHAR(255),
    primary_color    VARCHAR(255),
    secondary_color  VARCHAR(255),
    font_family      VARCHAR(255),
    event_id         VARCHAR(255),
    CONSTRAINT pk_event_themes PRIMARY KEY (id)
);

CREATE TABLE events
(
    id          VARCHAR(255) NOT NULL,
    version     INTEGER,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    created_by  VARCHAR(255),
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_by  VARCHAR(255),
    deleted     BOOLEAN,
    active      BOOLEAN,
    name        VARCHAR(255),
    logo        VARCHAR(255),
    start_date  TIMESTAMP WITHOUT TIME ZONE,
    end_date    TIMESTAMP WITHOUT TIME ZONE,
    location    VARCHAR(255),
    initialized BOOLEAN,
    CONSTRAINT pk_events PRIMARY KEY (id)
);

CREATE TABLE file
(
    id           VARCHAR(255) NOT NULL,
    version      INTEGER,
    created_at   TIMESTAMP WITHOUT TIME ZONE,
    created_by   VARCHAR(255),
    updated_at   TIMESTAMP WITHOUT TIME ZONE,
    updated_by   VARCHAR(255),
    deleted      BOOLEAN,
    active       BOOLEAN,
    file_name    VARCHAR(255),
    content_type VARCHAR(255),
    extension    VARCHAR(255),
    size         BIGINT       NOT NULL,
    content      BYTEA,
    CONSTRAINT pk_file PRIMARY KEY (id)
);

CREATE TABLE question_answer_details
(
    answer_id           VARCHAR(255) NOT NULL,
    question_details_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_question_answer_details PRIMARY KEY (answer_id, question_details_id)
);

CREATE TABLE questions
(
    id                 VARCHAR(255) NOT NULL,
    version            INTEGER,
    created_at         TIMESTAMP WITHOUT TIME ZONE,
    created_by         VARCHAR(255),
    updated_at         TIMESTAMP WITHOUT TIME ZONE,
    updated_by         VARCHAR(255),
    deleted            BOOLEAN,
    active             BOOLEAN,
    score              INTEGER,
    content            VARCHAR(255),
    is_multiple_choice BOOLEAN,
    seniority_level_id VARCHAR(255),
    sub_theme_id       VARCHAR(255),
    CONSTRAINT pk_questions PRIMARY KEY (id)
);

CREATE TABLE quiz_instance
(
    id                         VARCHAR(255) NOT NULL,
    version                    INTEGER,
    created_at                 TIMESTAMP WITHOUT TIME ZONE,
    created_by                 VARCHAR(255),
    updated_at                 TIMESTAMP WITHOUT TIME ZONE,
    updated_by                 VARCHAR(255),
    deleted                    BOOLEAN,
    active                     BOOLEAN,
    start_date                 TIMESTAMP WITHOUT TIME ZONE,
    end_date                   TIMESTAMP WITHOUT TIME ZONE,
    status                     VARCHAR(255),
    final_score                INTEGER,
    last_question_index        INTEGER,
    attendee_event_event_id    VARCHAR(255),
    attendee_event_attendee_id VARCHAR(255),
    CONSTRAINT pk_quiz_instance PRIMARY KEY (id)
);

CREATE TABLE quiz_instance_details
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
    question_index   INTEGER,
    question_id      VARCHAR(255),
    quiz_instance_id VARCHAR(255),
    CONSTRAINT pk_quiz_instance_details PRIMARY KEY (id)
);

CREATE TABLE quiz_instructions
(
    id         VARCHAR(255) NOT NULL,
    version    INTEGER,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    created_by VARCHAR(255),
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    updated_by VARCHAR(255),
    deleted    BOOLEAN,
    active     BOOLEAN,
    label      VARCHAR(255),
    value      VARCHAR(255),
    key        VARCHAR(255),
    CONSTRAINT pk_quiz_instructions PRIMARY KEY (id)
);

CREATE TABLE ratings
(
    id           VARCHAR(255) NOT NULL,
    version      INTEGER,
    created_at   TIMESTAMP WITHOUT TIME ZONE,
    created_by   VARCHAR(255),
    updated_at   TIMESTAMP WITHOUT TIME ZONE,
    updated_by   VARCHAR(255),
    deleted      BOOLEAN,
    active       BOOLEAN,
    rating_score INTEGER,
    attendee_id  VARCHAR(255),
    content      VARCHAR(255),
    CONSTRAINT pk_ratings PRIMARY KEY (id)
);

CREATE TABLE seniority_levels
(
    id         VARCHAR(255) NOT NULL,
    version    INTEGER,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    created_by VARCHAR(255),
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    updated_by VARCHAR(255),
    deleted    BOOLEAN,
    active     BOOLEAN,
    label      VARCHAR(255),
    CONSTRAINT pk_seniority_levels PRIMARY KEY (id)
);

CREATE TABLE sub_themes
(
    id         VARCHAR(255) NOT NULL,
    version    INTEGER,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    created_by VARCHAR(255),
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    updated_by VARCHAR(255),
    deleted    BOOLEAN,
    active     BOOLEAN,
    title      VARCHAR(255),
    icon       VARCHAR(255),
    theme_id   VARCHAR(255),
    CONSTRAINT pk_sub_themes PRIMARY KEY (id)
);

CREATE TABLE themes
(
    id         VARCHAR(255) NOT NULL,
    version    INTEGER,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    created_by VARCHAR(255),
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    updated_by VARCHAR(255),
    deleted    BOOLEAN,
    active     BOOLEAN,
    label      VARCHAR(255),
    icon       VARCHAR(255),
    CONSTRAINT pk_themes PRIMARY KEY (id)
);

ALTER TABLE answers
    ADD CONSTRAINT FK_ANSWERS_ON_QUESTION FOREIGN KEY (question_id) REFERENCES questions (id);

ALTER TABLE attendee_event
    ADD CONSTRAINT FK_ATTENDEE_EVENT_ON_ATTENDEE FOREIGN KEY (attendee_id) REFERENCES attendees (id);

ALTER TABLE attendee_event
    ADD CONSTRAINT FK_ATTENDEE_EVENT_ON_EVENT FOREIGN KEY (event_id) REFERENCES events (id);

ALTER TABLE event_form_element
    ADD CONSTRAINT FK_EVENT_FORM_ELEMENT_ON_EVENTFORMSETUP FOREIGN KEY (event_form_setup_id) REFERENCES event_form_setup (id);

ALTER TABLE event_form_setup
    ADD CONSTRAINT FK_EVENT_FORM_SETUP_ON_THEME FOREIGN KEY (theme_id) REFERENCES event_themes (id);

ALTER TABLE event_setup
    ADD CONSTRAINT FK_EVENT_SETUP_ON_EVENT FOREIGN KEY (event_id) REFERENCES events (id);

ALTER TABLE event_setup
    ADD CONSTRAINT FK_EVENT_SETUP_ON_FORMSETUP FOREIGN KEY (form_setup_id) REFERENCES event_form_setup (id);

ALTER TABLE event_themes
    ADD CONSTRAINT FK_EVENT_THEMES_ON_EVENT FOREIGN KEY (event_id) REFERENCES events (id);

ALTER TABLE questions
    ADD CONSTRAINT FK_QUESTIONS_ON_SENIORITYLEVEL FOREIGN KEY (seniority_level_id) REFERENCES seniority_levels (id);

ALTER TABLE questions
    ADD CONSTRAINT FK_QUESTIONS_ON_SUBTHEME FOREIGN KEY (sub_theme_id) REFERENCES sub_themes (id);

ALTER TABLE question_answer_details
    ADD CONSTRAINT FK_QUESTION_ANSWER_DETAILS_ON_ANSWER FOREIGN KEY (answer_id) REFERENCES answers (id);

ALTER TABLE question_answer_details
    ADD CONSTRAINT FK_QUESTION_ANSWER_DETAILS_ON_QUESTION_DETAILS FOREIGN KEY (question_details_id) REFERENCES quiz_instance_details (id);

ALTER TABLE quiz_instance_details
    ADD CONSTRAINT FK_QUIZ_INSTANCE_DETAILS_ON_QUESTION FOREIGN KEY (question_id) REFERENCES questions (id);

ALTER TABLE quiz_instance_details
    ADD CONSTRAINT FK_QUIZ_INSTANCE_DETAILS_ON_QUIZINSTANCE FOREIGN KEY (quiz_instance_id) REFERENCES quiz_instance (id);

ALTER TABLE quiz_instance
    ADD CONSTRAINT FK_QUIZ_INSTANCE_ON_ATEVIDATATID FOREIGN KEY (attendee_event_event_id, attendee_event_attendee_id) REFERENCES attendee_event (event_id, attendee_id);

ALTER TABLE ratings
    ADD CONSTRAINT FK_RATINGS_ON_ATTENDEE FOREIGN KEY (attendee_id) REFERENCES attendees (id);

ALTER TABLE sub_themes
    ADD CONSTRAINT FK_SUB_THEMES_ON_THEME FOREIGN KEY (theme_id) REFERENCES themes (id);