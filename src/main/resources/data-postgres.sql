/* xQuiz data seed */

/* EVENTS */
INSERT INTO public.events (id, active, created_at, created_by, deleted, updated_at, updated_by, version, end_date, location, logo, name, start_date)
VALUES ('1', true, '2022-08-04 15:54:12.000000', 'SYSTEM', false, '2022-08-04 15:54:26.000000', 'SYSTEM', 1, '2022-11-04 15:54:42.000000', 'AGADIR', null, 'DEVOXX MOROCCO', '2022-09-04 15:55:04.000000');

/* EVENT THEMES */
INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('1', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'red', null, null, 'orange', 'yellow', '1');


/* EVENT FORM SETUP */

INSERT INTO public.event_form_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, form_name, form_title, submit_method, submit_url)
VALUES ('1', true, null, null, false, null, null, 1, 'QR CODE FORM', 'QR CODE FORM', 'POST', '/events/sessions');

INSERT INTO public.event_form_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, form_name, form_title, submit_method, submit_url)
VALUES ('2', true, null, null, false, null, null, 1, 'REGISTER FORM', 'REGISTER FORM', 'POST', '/events/sessions');

/* EVENT SETUP */
INSERT INTO public.event_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, description, initialize_button_text, kind, submit_method, submit_url, title, event_id, form_setup_id)
VALUES ('1', true, '2022-08-04 18:24:36.000000', null, false, null, null, 1, 'DEVOXX SETUP', 'Register now', 'FORM', 'GET', 'https://devoxxma-registration-api.dev.x-hub.io/api/attendees/registration-code/{registrationCode}', null, '1', '1');

INSERT INTO public.event_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, description, initialize_button_text, kind, submit_method, submit_url, title, event_id, form_setup_id)
VALUES ('2', true, '2022-08-04 18:24:36.000000', null, false, null, null, 1, 'EVENT 1 SETUP', 'Register now', 'FORM', null, null, null, '1', '2');

/* EVENT FORM ELEMENTS */
INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('1', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'FIRST NAME', 'First name', true, 'input',null, '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('2', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'LAST NAME', 'Last name', true, 'input',null,  '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('3', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'EMAIL', 'xAtendee@x-hub.io', true, 'input',null,  '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('4', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'number', 'PHONE NUMBER', '+212 xxxxxxx', true, 'input',null,  '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('5', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'button', 'Register', '', true, 'button','Register now',  '2');

/* **************************** */
INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('6', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'Registration Code', 'Your registration code', true, 'input',null,  '1');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version, html_type, name, placeholder, required, type,inner_text, event_form_setup_id)
VALUES ('7', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'button', 'GO', '', true, 'button','GO',  '1');