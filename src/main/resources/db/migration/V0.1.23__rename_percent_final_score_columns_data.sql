ALTER TABLE culture_quiz_details
    RENAME COLUMN percent_final_score TO final_score_percentage;
ALTER TABLE quiz_instance
    RENAME COLUMN percent_final_score TO final_score_percentage;

