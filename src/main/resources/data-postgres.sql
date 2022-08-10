/* xQuiz data seed */

/* EVENTS */
INSERT INTO public.events (id, active, created_at, created_by, deleted, updated_at, updated_by, version, end_date, location, logo, name, start_date)
VALUES ('1', true, '2022-08-04 15:54:12.000000', 'SYSTEM', false, '2022-08-04 15:54:26.000000', 'SYSTEM', 1, '2022-11-04 15:54:42.000000', 'AGADIR', 'https://svgshare.com/i/jt1.svg', 'DEVOXX MOROCCO', '2022-09-04 15:55:04.000000'),
       ('2', true, '2022-08-04 15:54:12.000000', 'SYSTEM', false, '2022-08-04 15:54:26.000000', 'SYSTEM', 1, '2022-11-04 15:54:42.000000', 'AGADIR', 'https://svgshare.com/i/jt1.svg', 'NAS', '2022-09-01 15:55:04.000000');

/* EVENT THEMES */
INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('1', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'white', 'https://svgshare.com/i/jro.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', '1');

INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('2', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'linear-gradient(116.52deg, rgba(225, 125, 0, 0.2) 0%, rgba(59, 58, 59, 0.2) 98.56%)', 'https://svgshare.com/i/jrH.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', '1');

INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('3', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'white', 'https://svgshare.com/i/jro.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', null );

INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('4', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'linear-gradient(116.52deg, rgba(225, 125, 0, 0.2) 0%, rgba(59, 58, 59, 0.2) 98.56%)', 'https://svgshare.com/i/jrH.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', null);

INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('5', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'white', 'https://svgshare.com/i/jro.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', '2');

/* EVENT FORM SETUP */

INSERT INTO public.event_form_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, form_name, form_title, submit_method, submit_url,theme_id)
VALUES ('1', true, null, null, false, null, null, 1, 'qr-code', 'registration form', 'POST', '/api/v1/events/session','3' );

INSERT INTO public.event_form_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, form_name, form_title, submit_method, submit_url,theme_id)
VALUES ('2', true, null, null, false, null, null, 1, 'Registration', 'registration form', 'POST', '/api/v1/events/session','4' );

/* EVENT SETUP */
INSERT INTO public.event_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, description, initialize_button_text, kind, submit_method, submit_url, title, event_id, form_setup_id)
VALUES ('1', true, '2022-08-04 18:24:36.000000', null, false, null, null, 1, 'This quiz is made for you in order to book your interview slot and possibily join our xFamily.', 'Register now', 'FORM', 'GET', 'https://devoxxma-registration-api.dev.x-hub.io/api/attendees/registration-code/{registrationCode}', 'Welcome to Devoxx Quiz', '1', '1');

INSERT INTO public.event_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, description, initialize_button_text, kind, submit_method, submit_url, title, event_id, form_setup_id)
VALUES ('2', true, '2022-08-04 18:24:36.000000', null, false, null, null, 1, 'This quiz is made for you in order to book your interview slot and possibily join our xFamily.', 'Register now!', 'FORM', null, null, 'Welcome to Devoxx Quiz', '1', '2');

/* EVENT FORM ELEMENTS */
INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('1', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'firstName','FIRST NAME', 'First name', true, 'input',null, '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('2', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text','lastName', 'LAST NAME', 'Last name', true, 'input',null,  '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('3', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'email','email', 'EMAIL', 'xAtendee@x-hub.io', true, 'input',null,  '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('4', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'number','phoneNumber', 'PHONE NUMBER', '+212 6 xx xx xx xx', true, 'input',null,  '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('5', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'submit', 'Register',null,null, null, 'button','Register now',  '2');

/* **************************** */
INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('6', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'registrationCode',null, 'Your registration code', true, 'input',null,  '1');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('7', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'submit', 'GO',null,null, null, 'button','GO',  '1');


/* Attendee */
insert into public.attendees(id, active, created_at, created_by, deleted, updated_at, updated_by, version, email, first_name, last_name, phone_number)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'xhub@gmail.com', 'xhub', 'xhub', '0766539731');


/* SENIORITY LEVELS */
insert into public.seniority_levels(id, label)
VALUES (1, 'SENIOR'), (2, 'JUNIOR'), (3, 'INTERMEDIATE');


/*  Quiz Instance */
insert into public.quiz_instance (id, active, created_at, created_by, deleted, updated_at, updated_by, version, end_date,last_question_index ,  start_date, status, final_score, attendee_event_attendee_id, attendee_event_event_id)
values (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '2022-04-16 01:27:07.8801', 3,  '2022-04-16 01:27:07.8801', 0, 1, null, null);

/* themes modes seed */
insert into public.themes(id, active, created_at, created_by, deleted, updated_at, updated_by, version, label, icon)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'BackEnd', null),
       (2, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'FrontEnd', null),
       (3, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'Big data', null),
       (4, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'AI', null),
       (5, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'Mobile', null);


insert into public.sub_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version,title, icon,theme_id)
values (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,  'spring', null, 1),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,  'java', null, 1);


insert into public.quiz_instructions (id, active, created_at, created_by, deleted, updated_at, updated_by, version,label, value)
values (1, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,  'Total Number of questions:', '20'),
       (2, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Time limit:', '15:00'),
       (3, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Total Number of attempts:', '1'),
       (4, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Pass Task:', '80%');



