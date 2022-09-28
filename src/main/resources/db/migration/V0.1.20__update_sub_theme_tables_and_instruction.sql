update quiz_instructions
SET value = '10'
WHERE id in ('1');

UPDATE sub_themes
SET percentage = 40
WHERE id in ('13', '14');

UPDATE sub_themes
SET percentage = 10
WHERE id in ('22', '21', '24');

UPDATE sub_themes
SET percentage = 20
WHERE id in ('15', '20', '23');

UPDATE sub_themes
SET percentage = 100
WHERE id in ('16', '17', '18', '25');

UPDATE sub_themes
SET percentage = 30
WHERE id in ('19');


