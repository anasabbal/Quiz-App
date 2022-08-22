/* xQuiz data seed */

/* EVENTS */
INSERT INTO public.events (id, active, created_at, created_by, deleted, updated_at, updated_by, version, end_date, location, logo, name, start_date)
VALUES ('1', true, '2022-08-04 15:54:12.000000', 'SYSTEM', false, '2022-08-04 15:54:26.000000', 'SYSTEM', 1, '2022-11-04 15:54:42.000000', 'AGADIR', 'https://svgshare.com/i/jt1.svg', 'DEVOXX MOROCCO', '2022-09-04 15:55:04.000000'),
       ('2', true, '2022-08-04 15:54:12.000000', 'SYSTEM', false, '2022-08-04 15:54:26.000000', 'SYSTEM', 1, '2022-11-04 15:54:42.000000', 'AGADIR', 'https://svgshare.com/i/jt1.svg', 'NAS', '2022-09-01 15:55:04.000000');

/* EVENT THEMES */
INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('1', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'white', 'https://svgshare.com/i/k6A.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', '1');

INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('2', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'linear-gradient(116.52deg, rgba(225, 125, 0, 0.2) 0%, rgba(59, 58, 59, 0.2) 98.56%)', 'https://svgshare.com/i/kEs.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', '1');

INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('3', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'white', 'https://svgshare.com/i/kEs.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', null );

INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('4', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'linear-gradient(116.52deg, rgba(225, 125, 0, 0.2) 0%, rgba(59, 58, 59, 0.2) 98.56%)', 'https://svgshare.com/i/k6A.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', null);

INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('5', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'white', 'https://svgshare.com/i/k6A.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', '2');

/* EVENT FORM SETUP */

INSERT INTO public.event_form_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, form_name, form_title, submit_method, submit_url,theme_id)
VALUES ('1', true, null, null, false, null, null, 1, 'qr-code', 'registration form', 'POST', '/api/v1/quiz-instance','3' );

INSERT INTO public.event_form_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, form_name, form_title, submit_method, submit_url,theme_id)
VALUES ('2', true, null, null, false, null, null, 1, 'Registration', 'registration form', 'POST', '/api/v1/quiz-instance','4' );

/* EVENT SETUP */
INSERT INTO public.event_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version, description, initialize_button_text, kind, submit_method, submit_url, title, event_id, form_setup_id)
VALUES ('1', true, '2022-08-04 18:24:36.000000', null, false, null, null, 1, 'This quiz is made for you in order to book your interview slot and possibily join our xFamily.', 'Register now', 'FORM', 'GET', 'https://devoxxma-registration-api.dev.x-hub.io/api/attendees/registration-code/{registrationCode}', 'Welcome to Devoxx Quiz', '1', '1');

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


/* Attendee */
insert into public.attendees(id, active, created_at, created_by, deleted, updated_at, updated_by, version, email, first_name, last_name, phone_number)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'xhub@gmail.com', 'xhub', 'xhub', '0766539731');


/* SENIORITY LEVELS */
insert into public.seniority_levels(id, label)
VALUES (1, 'SENIOR'), (2, 'JUNIOR'), (3, 'INTERMEDIATE');


/*  Quiz Instance */
insert into public.quiz_instance (id, active, created_at, created_by, deleted, updated_at, updated_by, version, end_date,last_question_index ,  start_date, status, final_score, attendee_event_attendee_id, attendee_event_event_id)
values (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '2022-04-16 01:27:07.8801', 3,  '2022-04-16 01:27:07.8801', 'OPENED', 1, null, null);

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


insert into public.quiz_instructions (id, active, created_at, created_by, deleted, updated_at, updated_by, version,label, value, key)
values (1, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,  'Total Number of questions:', '20', 'TOTAL_QUESTIONS'),
       (2, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Time limit:', '900', 'TIME_LIMIT'),
       (3, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Total Number of attempts:', '1', 'TOTAL_ATTEMPTS'),
       (4, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Pass Task:', '80', 'PASS_TASK'),
       (5, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Questions must be answered or you can’t go to the next one.', null, null ),
       (6, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'You are not allowed to go back and change your answers.', null, null);


insert into public.questions(id, active, created_at, created_by, deleted, updated_at, updated_by, version,is_multiple_choice , score, seniority_level_id, sub_theme_id, content)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 80, 1, 1, 'What do you mean by Dependency Injection?'),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 80, 1, 1, 'What is Spring IOC Container?'),
       (3, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 80, 1, 1, 'What are the various ways of using Spring Framework?'),
       (4, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 80, 1, 1, 'What are the different components of a Spring application?'),
       (5, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 80, 1, 1, 'What is a Spring configuration file?'),
       (6, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 80, 1, 1, 'How many modules are there in Spring Framework and what are they?'),
       (7, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 80, 1, 1, 'What is autowiring in spring? What are the autowiring modes?'),
       (8, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 80, 1, 1, 'What is AOP?'),
       (9, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 80, 1, 1, 'What is Advice?'),
       (10, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 80, 1, 1, 'What are the types of advice in AOP?'),
       (11, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 80, 1, 1, 'What is Pointcut?'),
       (12, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 80, 1, 1, 'What does @Controller annotation? ?'),
       (13, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 80, 1, 1, 'What does @RequestMapping annotation?'),
       (14, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 80, 1, 1, 'Does spring MVC provide validation support?'),
       (15, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 80, 1, 1, 'What are the AOP implementation?'),
       (16, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 80, 1, 1, 'What is a Spring Bean?'),
       (17, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 80, 1, 1, 'What are the different scopes of Spring Bean?'),
       (18, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 80, 1, 1, 'Can we have multiple Spring configuration files?'),
       (19, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 80, 1, 1, 'What is ContextLoaderListener?'),
       (20, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 80, 1, 1, 'How can we use Spring to create Restful Web Service returning JSON response?');

insert into public.answers(id, active, created_at, created_by, deleted, updated_at, updated_by, version, content, is_correct, question_id)
values (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Constructor Injection', true, 1),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Setter Injection ', true, 1),
       (3, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'The ApplicationContext is a sub-interface of BeanFactory and provides more enterprise like functionality', true, 2),
       (4, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'As a Full-fledged Spring web application.', true, 3),
       (5, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'For remote usage.', true, 3),
       (6, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'As a third-party web framework, using Spring Frameworks middle-tier.', true, 3),
       (7, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Interface: It defines the functions.', true, 4),
       (8, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'User program: It uses the function.', true, 4),
       (9, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'This file mainly contains the classes information.', true, 5),
       (10, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Spring Core Container', true, 6),
       (11, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Data Access/Integration', true, 6),
       (12, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Autowiring enables the programmer to inject the bean automatically. We dont need to write explicit injection logic.', true, 7),
       (13, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'AOP is an acronym for Aspect Oriented Programming. It is a methodology that divides the program logic into pieces or parts or concerns.', true, 8),
       (14, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Advice represents action taken by aspect.', true, 9),
       (15, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Before Advice', true, 10),
       (16, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'After Advice', true, 10),
       (17, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'After Returning Advice', true, 10),
       (18, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Pointcut is expression language of Spring AOP.', true, 11),
       (19, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'The @Controller annotation marks the class as controller class. It is applied on the class.', true, 12),
       (20, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'The @RequestMapping annotation maps the request with the method. It is applied on the method', true, 13),
       (21, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'is used to restrict the input provided by the user', true, 14),
       (22, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Spring AOP', true, 15),
       (23, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Apache AspectJ', true, 15),
       (24, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'JBoss AOP', true, 15),
       (25, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Any normal java class that is initialized by the Spring IoC container is called Spring Bean', true, 16),
       (26, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'singleton', true, 17),
       (27, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'session', true, 17),
       (28, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'global session', true, 17),
       (29, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Specify the list of files in web.xml file using contextConfigLocation init parameter.', true, 18),
       (30, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, ' is a Servlet listener that loads all the different configuration files (service layer configuration, persistence layer configuration etc) ', true, 19),
       (31, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Adding Jackson JSON dependencies', true, 20),
       (32, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'In the controller handler methods, return the Object as response using @ResponseBody annotation. Sample code', true, 20),
       (33, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Spring BeanFactory Interface it is an IoC container that is responsible for maintaining beans and their dependencies', true, 2),
       (34, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Import the configuration files into a existing configuration file that is already configured.', true, 18),
       (35, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'It describes how those classes are configured as well as introduced to each other', true, 5),
       (36, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'AspectJ: It is an extension for Java programming created at PARC research centre', true, 8),
       (37, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'JBoss: It is an open source Java application server developed by JBoss, used for Java development.', true, 8),
       (38, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'annotation indicates that a particular class serves the role of a controller', true, 12),
        (39, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'annotation is typically used in combination with annotated handler methods based on the @RequestMapping annotation', true, 12),
       (40, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'is one of the essential components of the Spring MVC framework, probably the most important after the DispatcherServlet itself.', true, 19),
       (42, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'is used to create the root context and responsible for loading beans, which are shared by multiple DispatcherServlet like beans related to the service layer and data access layer', true, 19),
       (43, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'pointcut is a set of join points. Pointcut specifies where exactly to apply advice, which allows separation of concerns and helps in modularizing business logic', true, 11),
       (44, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'To validate the users input', true, 14),
       (45, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Autowiring feature of spring framework enables you to inject the object dependency implicitly', true, 7),
       (46, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Autowiring cant be used to inject primitive and string values. It works with reference only', true, 7),
       (47, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'annotation is used to map web requests onto specific handler classes and/or handler methods.', true, 13),
       (48, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'can be applied to the controller class as well as methods', true, 13),
       (49, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, ' type which ensures that an advice runs before the method execution.', true, 9),
       (50, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, ' is an object that form the backbone of your application and that is managed by the Spring IoC container.', true, 16),
       (51, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, ' A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container', true, 16);





