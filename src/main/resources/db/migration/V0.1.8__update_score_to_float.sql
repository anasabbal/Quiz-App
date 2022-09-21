ALTER TABLE culture_questions
DROP COLUMN score;

ALTER TABLE culture_questions
    ADD score FLOAT;

ALTER TABLE culture_quiz_details
DROP COLUMN score;

ALTER TABLE culture_quiz_details
    ADD score FLOAT;