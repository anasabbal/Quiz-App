ALTER TABLE attendee_event
ADD COLUMN feed_back_id VARCHAR(255) REFERENCES feedbacks(id);


