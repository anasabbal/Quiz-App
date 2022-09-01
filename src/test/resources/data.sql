-- SESSION TEST

insert into quiz_instance (id, active, created_at, created_by, deleted, updated_at, updated_by, version, end_date,last_question_index ,  start_date, status, final_score, attendee_event_attendee_id, attendee_event_event_id)
values (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '2022-04-16 01:27:07.8801', 0,  '2022-04-16 01:27:07.8801', 'OPENED', 0, 1 , null);

-- EVENT TEST

INSERT INTO events (id, active, created_at, created_by, deleted, updated_at, updated_by, version, end_date, location, logo, name, start_date)
VALUES ('1', true, '2022-08-04 15:54:12.000000', 'SYSTEM', false, '2022-08-04 15:54:26.000000', 'SYSTEM', 1, '2022-09-06 15:54:42.000000', 'AGADIR', 'https://svgshare.com/i/jt1.svg', 'DEVOXX MOROCCO', '2022-09-04 15:55:04.000000'),
       ('2', true, '2022-08-04 15:54:12.000000', 'SYSTEM', false, '2022-08-04 15:54:26.000000', 'SYSTEM', 1, '2022-09-05 15:54:42.000000', 'RABAT', 'https://svgshare.com/i/jt1.svg', 'DEVOXX4KIDS', '2022-09-01 15:55:04.000000');

-- EVENT THEMES TEST

INSERT INTO event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('1', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'white', 'https://svgshare.com/i/k6A.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', '1');

INSERT INTO event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('2', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'linear-gradient(116.52deg, rgba(225, 125, 0, 0.2) 0%, rgba(59, 58, 59, 0.2) 98.56%)', 'https://svgshare.com/i/kEs.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', '1');

INSERT INTO event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('3', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'white', 'https://svgshare.com/i/kEs.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', null );

INSERT INTO event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('4', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'linear-gradient(116.52deg, rgba(225, 125, 0, 0.2) 0%, rgba(59, 58, 59, 0.2) 98.56%)', 'https://svgshare.com/i/jrH.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', null);

INSERT INTO event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('5', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'white', 'https://svgshare.com/i/k6A.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', '2');

-- EVENT FORM SETUP TEST


INSERT INTO event_form_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, form_name, form_title, submit_method, submit_url,theme_id)
VALUES ('1', true, null, null, false, null, null, 1, 'qr-code', 'registration form', 'POST', '/api/v1/quiz-instance','3' ),
('2', true, null, null, false, null, null, 1, 'Registration', 'registration form', 'POST', '/api/v1/quiz-instance','4' );


-- EVENT SETUP TEST

INSERT INTO event_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, description, initialize_button_text, kind, submit_method, submit_url, title, event_id, form_setup_id)
VALUES ('1', true, '2022-08-04 18:24:36.000000', null, false, null, null, 1, 'This quiz is made for you in order to book your interview slot and possibily join our xFamily.', 'Register now', 'FORM', 'GET', 'https://devoxxma-registration-api.dev.x-hub.io/api/attendees/registration-code/{registrationCode}', 'Welcome to Devoxx Quiz', '1', '1');

INSERT INTO event_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, description, initialize_button_text, kind, submit_method, submit_url, title, event_id, form_setup_id)
VALUES ('2', true, '2022-08-04 18:24:36.000000', null, false, null, null, 1, 'This quiz is made for you in order to book your interview slot and possibily join our xFamily.', 'Register now', 'FORM', null, null, 'Welcome to Devoxx Quiz', '2', '2');


-- EVENT FORM ELEMENTS TEST

INSERT INTO event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('1', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'firstName','FIRST NAME', 'First name', true, 'input',null, '2');

INSERT INTO event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('2', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text','lastName', 'LAST NAME', 'Last name', true, 'input',null,  '2');

INSERT INTO event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('3', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'email','email', 'EMAIL', 'xAtendee@x-hub.io', true, 'input',null,  '2');

INSERT INTO event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('4', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'phone','phoneNumber', 'PHONE NUMBER', '+212 6 xx xx xx xx', true, 'input',null,  '2');

INSERT INTO event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('5', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'submit', 'Register',null,null, null, 'button','Register now',  '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('6', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'registrationCode',null, 'Your registration code', true, 'input',null,  '1');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('7', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'submit', 'GO',null,null, null, 'button','GO',  '1');

-- ATTENDEE TEST

insert into attendees(id, active, created_at, created_by, deleted, updated_at, updated_by, version, email, first_name, last_name, phone_number)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'xhub@gmail.com', 'xhub', 'xhub', '+212666666666');


-- SENIORITY LEVELS TEST

insert into seniority_levels(id, active, created_at, created_by, deleted, updated_at, updated_by, version, label)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,'JUNIOR'),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,'INTERMEDIATE'),
       (3, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'SENIOR');



-- THEMES MODES SEEDS TEST

insert into themes(id, active, created_at, created_by, deleted, updated_at, updated_by, version, label, icon)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Backend', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1660154514/Backend_icon_ffaody.png'),
       (2, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'Frontend', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1660128579/Web_development_rdmwfh.png'),
       (3, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'Fullstack','https://res.cloudinary.com/dizlyig0d/image/upload/v1661282875/fi-rs-layers_xov9iu.png'),
       (4, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'DevOps', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1661282808/Group_2_ywswmq.png'),
       (5, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'UX/UI', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1661336538/design_icon_kmpejb.png'),
       (6, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'Agile methodologies', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1661282912/file-icons_test-generic_wuom8u.png'),
       (7, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'QA', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1660155052/bxs_data_qupdkg.png'),
       (8, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'Mobile', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1660155135/phone_lzswzx.png');


insert into sub_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version,title, icon,theme_id)
values (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,  'Spring', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1661336412/Spring_Boot_kchrrv.png', 1),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,  'Java', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1660134120/Java_sqfbla.png', 1);


insert into quiz_instructions (id, active, created_at, created_by, deleted, updated_at, updated_by, version,label, value, key)
values (1, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,  'Total Number of questions:', '20', 'TOTAL_QUESTIONS'),
       (2, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Time limit:', '900', 'TIME_LIMIT'),
       (3, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Total Number of attempts:', '1', 'TOTAL_ATTEMPTS'),
       (4, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Pass Mark:', '80', 'PASS_TASK'),
       (5, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Questions must be answered or you can’t go to the next one.', null, null ),
       (6, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'You are not allowed to go back and change your answers.', null, null);



insert into questions(id, active, created_at, created_by, deleted, updated_at, updated_by, version,is_multiple_choice , score, seniority_level_id, sub_theme_id, content)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 1, 'question?'),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 1, 'question2?');

insert into answers(id, active, created_at, created_by, deleted, updated_at, updated_by, version, content, is_correct, question_id)
values (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'right', true, 1),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'wrong', false, 1);

insert into quiz_instance_details (id, active, created_at, created_by, deleted, updated_at, updated_by, version,question_index,score,question_id,quiz_instance_id)
values('1', true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,1,1,'1','1'),
      ('2', true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,2,1,'2','1');


