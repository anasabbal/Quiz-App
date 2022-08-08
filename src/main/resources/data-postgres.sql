/* xQuiz data seed */

/* EVENTS */
INSERT INTO public.events (id, active, created_at, created_by, deleted, updated_at, updated_by, version, end_date, location, logo, name, start_date,initialized)
VALUES ('1', true, '2022-08-04 15:54:12.000000', 'SYSTEM', false, '2022-08-04 15:54:26.000000', 'SYSTEM', 1, '2022-11-04 15:54:42.000000', 'AGADIR', 'https://svgshare.com/i/jt1.svg', 'DEVOXX MOROCCO', '2022-09-04 15:55:04.000000',false);

INSERT INTO public.events (id, active, created_at, created_by, deleted, updated_at, updated_by, version, end_date, location, logo, name, start_date,initialized)
VALUES ('2', true, '2022-08-04 15:54:12.000000', 'SYSTEM', false, '2022-08-04 15:54:26.000000', 'SYSTEM', 1, '2022-9-02 15:54:42.000000', 'MARAKECH', 'https://www.devoxx4kids.org/wp-content/uploads/2014/01/DevoxxWithoutBrackets_PNG_1000px.png', 'Devoxx4Kids', '2022-08-30 15:55:04.000000',false );

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
VALUES ('1', true, '2022-08-04 18:24:36.000000', null, false, null, null, 1, 'This quiz is made for you in order to book your interview slot and possibily join our xFamily.', null, 'FORM', 'GET', 'https://devoxxma-registration-api.dev.x-hub.io/api/attendees/registration-code/{registrationCode}', 'Welcome to Devoxx Quiz', '1', '1');

INSERT INTO public.event_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, description, initialize_button_text, kind, submit_method, submit_url, title, event_id, form_setup_id)
VALUES ('2', true, '2022-08-04 18:24:36.000000', null, false, null, null, 1, 'This quiz is made for you in order to book your interview slot and possibily join our xFamily.', 'Register now!', 'FORM', null, null, 'Welcome to Devoxx Quiz', '2', '2');

/* EVENT FORM ELEMENTS */
INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('1', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'firstName','FIRST NAME', 'First name', true, 'input',null, '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('2', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text','lastName', 'LAST NAME', 'Last name', true, 'input',null,  '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('3', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'email','email', 'EMAIL', 'xAtendee@x-hub.io', true, 'input',null,  '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('4', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'phone','phoneNumber', 'PHONE NUMBER', '+212 6 xx xx xx xx', true, 'input',null,  '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('5', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'submit', 'Register',null,null, null, 'button','Register now',  '2');

/* **************************** */
INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('6', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'registrationCode',null, 'Your registration code', true, 'input',null,  '1');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name,label, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('7', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'submit', 'GO',null,null, null, 'button','GO',  '1');
