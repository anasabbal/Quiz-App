ALTER TABLE sub_themes
ADD COLUMN percentage INTEGER;

update quiz_instructions
SET value = '10'
WHERE id in ('1');

UPDATE sub_themes
SET percentage = 60
WHERE id in ('1', '2');

UPDATE sub_themes
SET percentage = 40
WHERE id in ('2');

update questions
SET sub_theme_id = '2'
WHERE id in ('1', '2', '3', '4', '5', '6', '7', '8', '9');