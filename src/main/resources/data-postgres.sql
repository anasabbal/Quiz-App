/* xQuiz data seed */

/* EVENTS */
INSERT INTO public.events (id, active, created_at, created_by, deleted, updated_at, updated_by, version, end_date, location, logo, name, start_date)
VALUES ('1', true, '2022-08-04 15:54:12.000000', 'SYSTEM', false, '2022-08-04 15:54:26.000000', 'SYSTEM', 1, '2022-11-04 15:54:42.000000', 'AGADIR', 'https://svgshare.com/i/jt1.svg', 'DEVOXX MOROCCO', '2022-09-04 15:55:04.000000'),
       ('2', true, '2022-08-04 15:54:12.000000', 'SYSTEM', false, '2022-08-04 15:54:26.000000', 'SYSTEM', 1, '2022-11-04 15:54:42.000000', 'AGADIR', 'https://svgshare.com/i/jt1.svg', 'NAS', '2022-09-01 15:55:04.000000');

/* EVENT THEMES */
INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('1', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'white', 'https://svgshare.com/i/k6A.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', '1');

INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('2', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'linear-gradient(116.52deg, rgba(225, 125, 0, 0.2) 0%, rgba(59, 58, 59, 0.2) 98.56%)', 'https://svgshare.com/i/mRs.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', '1');

INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('3', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'white', 'https://svgshare.com/i/kEs.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', null );

INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('4', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'linear-gradient(116.52deg, rgba(225, 125, 0, 0.2) 0%, rgba(59, 58, 59, 0.2) 98.56%)', 'https://svgshare.com/i/mRs.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', null);

INSERT INTO public.event_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version, background_color, background_image, font_family, primary_color, secondary_color, event_id)
VALUES ('5', true, '2022-08-04 16:01:25.000000', null, false, null, null, 1, 'white', 'https://svgshare.com/i/k6A.svg', 'Poppins', '#E17D00', 'rgba(225, 125, 0, 0.5)', '2');

/* EVENT FORM SETUP */

INSERT INTO public.event_form_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                     form_name, form_title, submit_method, submit_url, theme_id)
VALUES ('1', true, null, null, false, null, null, 1, 'qr-code', 'registration form', 'POST', '/api/v1/quiz-instance',
        '3');

INSERT INTO public.event_form_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                     form_name, form_title, submit_method, submit_url, theme_id)
VALUES ('2', true, null, null, false, null, null, 1, 'Registration', 'registration form', 'POST',
        '/api/v1/quiz-instance', '4');

/* EVENT SETUP */
INSERT INTO public.event_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                description, initialize_button_text, kind, submit_method, submit_url, title, event_id,
                                form_setup_id)
VALUES ('1', true, '2022-08-04 18:24:36.000000', null, false, null, null, 1,
        'This quiz is made for you in order to book your interview slot and possibily join our xFamily.',
        'Register now', 'FORM', 'GET',
        'https://devoxxma-registration-api.dev.x-hub.io/api/attendees/registration-code/{registrationCode}',
        'Welcome to Devoxx Quiz', '1', '1');

INSERT INTO public.event_setup (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                description, initialize_button_text, kind, submit_method, submit_url, title, event_id,
                                form_setup_id)
VALUES ('2', true, '2022-08-04 18:24:36.000000', null, false, null, null, 1,
        'This quiz is made for you in order to book your interview slot and possibily join our xFamily.',
        'Register now', 'FORM', null, null, 'Welcome to Devoxx Quiz', '2', '2');

/* EVENT FORM ELEMENTS */
INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                       html_type, name, label, placeholder, required, type, inner_text,
                                       event_form_setup_id)
VALUES ('1', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'firstName', 'FIRST NAME',
        'First name', true, 'input', null, '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                       html_type, name, label, placeholder, required, type, inner_text,
                                       event_form_setup_id)
VALUES ('2', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'lastName', 'LAST NAME',
        'Last name', true, 'input', null, '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                       html_type, name, label, placeholder, required, type, inner_text,
                                       event_form_setup_id)
VALUES ('3', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'email', 'email', 'EMAIL',
        'xAtendee@x-hub.io', true, 'input', null, '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                       html_type, name, label, placeholder, required, type, inner_text,
                                       event_form_setup_id)
VALUES ('4', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'phone', 'phoneNumber', 'PHONE NUMBER',
        '+212 6 xx xx xx xx', true, 'input', null, '2');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                       html_type, name, label, placeholder, required, type, inner_text,
                                       event_form_setup_id)
VALUES ('5', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'submit', 'Register', null, null, null,
        'button', 'Register now', '2');

/* **************************** */
INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                       html_type, name, label, placeholder, required, type, inner_text,
                                       event_form_setup_id)
VALUES ('6', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'text', 'registrationCode', null,
        'Your registration code', true, 'input', null, '1');

INSERT INTO public.event_form_element (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                       html_type, name, label, placeholder, required, type, inner_text,
                                       event_form_setup_id)
VALUES ('7', true, '2022-08-04 17:35:57.000000', null, false, null, null, 1, 'submit', 'GO', null, null, null, 'button',
        'GO', '1');


/*  Goodies seed */
INSERT INTO PUBLIC.goodies(id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                           available_stock, win_score_threshold, label)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 150, 0,
        'Xhub pen'),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 150, 20,
        'Xhub Notebook'),
       (3, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 50, 40,
        'Xhub small pack'),
       (4, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 30, 60,
        'Xhub medium pack'),
       (5, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 20, 80,
        'Xhub large pack'),
       (6, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 5, 80,
        'Devoxx Ticket');


/* SENIORITY LEVELS */
insert into public.seniority_levels(id, active, created_at, created_by, deleted, updated_at, updated_by, version, label)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'JUNIOR'),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'INTERMEDIATE'),
       (3, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'SENIOR');

/* themes modes seed */
insert into public.themes(id, active, created_at, created_by, deleted, updated_at, updated_by, version, label, icon)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Backend', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1660154514/Backend_icon_ffaody.png'),
       (2, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'Frontend', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1660128579/Web_development_rdmwfh.png'),
       (3, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'Fullstack','https://res.cloudinary.com/dizlyig0d/image/upload/v1661282875/fi-rs-layers_xov9iu.png'),
       (4, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'DevOps', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1661282808/Group_2_ywswmq.png'),
       (5, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'UX/UI', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1661336538/design_icon_kmpejb.png'),
       (6, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'Agile methodologies', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1661282912/file-icons_test-generic_wuom8u.png'),
       (7, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'QA', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1660155052/bxs_data_qupdkg.png'),
       (8, true, '2022-04-06 01:27:07.8802', 'SYSTEM', false, '2022-04-16 01:27:07.8802', 'SYSTEM', 0, 'Mobile', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1660155135/phone_lzswzx.png');


insert into public.sub_themes (id, active, created_at, created_by, deleted, updated_at, updated_by, version,title, icon,theme_id)
values (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,  'Spring', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1661336412/Spring_Boot_kchrrv.png', 1),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,  'Java', 'https://res.cloudinary.com/dizlyig0d/image/upload/v1660134120/Java_sqfbla.png', 1);


insert into public.quiz_instructions (id, active, created_at, created_by, deleted, updated_at, updated_by, version,label, value, key)
values (1, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,  'Total Number of questions:', '20', 'TOTAL_QUESTIONS'),
       (2, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Time limit:', '900', 'TIME_LIMIT'),
       (3, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Total Number of attempts:', '1', 'TOTAL_ATTEMPTS'),
       (4, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Pass Mark:', '80', 'PASS_TASK'),
       (5, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'Questions must be answered or you can’t go to the next one.', null, null ),
       (6, true, '2022-08-10 01:27:07.8801', 'SYSTEM', false, '2022-08-10 01:27:07.8801', 'SYSTEM', 0,   'You are not allowed to go back and change your answers.', null, null);


insert into public.questions(id, active, created_at, created_by, deleted, updated_at, updated_by, version,is_multiple_choice , score, seniority_level_id, sub_theme_id, content)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 1, 'What do you mean by Dependency Injection?'),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 1, 'If a bean is created once per Ioc Container, scope is?'),
       (3, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 1, 'Which of the following statement is correct?'),
       (4, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 1, 'What are the true annotation used in Spring test'),
       (5, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 1, 'Spring, which of the following about the scope of a stateful bean is correct?'),
       (6, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 1, 'How many modules are there in Spring Framework and what are they?'),
       (7, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 1, 'What is the difference between @Component, @Repository & @Service annotations in Spring?'),
       (8, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 1, 'What is @Lazy annotation used for ?'),
       (9, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 1, 'Which of the following statement is correct?'),
       (10, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 1, 'What are the types of advice in AOP?'),
       (11, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 1, '@Component annotation on class indicates ?'),
       (12, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 1, 'What does @ResponseEntity annotation? ?'),
       (13, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 1, 'What does @RequestMapping annotation?'),
       (14, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 1, 'What is annotations used for validation?'),
       (15, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 1, 'ClassPathXmlApplicationContext searches .xml file in ?'),
       (16, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 1, 'What is a Spring Bean?'),
       (17, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 1, 'How many types of scopes  Spring Bean?'),
       (18, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 1, 'What is @Embeddable used for ?'),
       (19, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 1, 'What is @Aspect used for ??'),
       (20, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 1, 'What is @Scope used for?');

insert into public.answers(id, active, created_at, created_by, deleted, updated_at, updated_by, version, content, is_correct, question_id)
values (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'A design pattern which implements Inversion of Control for software applications', true, 1),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'One of the spring module ', false, 1),
       (3, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Singleton', true, 2),
       (4, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Spring is an open source framework.', true, 3),
       (5, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Spring is heavyweight.', true, 3),
       (6, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Spring not supports tight coupling.', false, 3),
       (7, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@ExtendWith', true, 4),
       (8, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@SpringJUnitConfig', true, 4),
       (9, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'None of those', false, 5),
       (10, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '11', false, 6),
       (11, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '17', false, 6),
       (12, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@Component This is a general-purpose stereotype annotation indicating that the class is a spring component.', true, 7),
       (13, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Explicitly defines a dependency to other beans in terms of creation order', true, 8),
       (14, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'REST is an architectural style.', true, 9),
       (15, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@Before', true, 10),
       (16, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@After', true, 10),
       (17, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@AfterThrowing', true, 10),
       (18, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, ' that a bean should not be created for the class', false, 11),
       (19, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'It can also be used to annotate other custom annotations that can then be used as qualifiers.', false, 12),
       (20, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'The @RequestMapping annotation maps the request with the method. It is applied on the method', true, 13),
       (21, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@Validated', true, 14),
       (22, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'specific location within filesystem', false, 15),
       (23, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'anywhere in project path (including jar file)', false, 15),
       (24, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'anywhere in classpath (including jar file)', true, 15),
       (25, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Component', true, 16),
       (26, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '4', false, 17),
       (27, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '6', true, 17),
       (28, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '8', false, 17),
       (29, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'is injected into annotated setters and fields', false, 18),
       (30, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Declares an annotated component as an aspect containing pointcuts and advices', true, 19),
       (31, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Annotated bean will be picked if multiple beans can be autowired', false, 20),
       (32, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Defines bean creation scope, e.g. prototype, singleton, etc.', true, 20),
       (33, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'global-session', false, 2),
       (34, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Annotated field is not persistent', false, 18),
       (35, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Marks annotated class as a bean found by the component-scanning and loaded into the application context', false, 20),
       (36, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Explicitly defines a dependency to other beans in terms of creation order', true, 8),
       (37, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Annotated bean will be lazily initialized on the first usage', true, 8),
       (38, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'represents an HTTP response, including headers, body, and status', true, 12),
       (39, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.', false, 12),
       (40, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Declares a pointcut executed if the join point throws an exception', false, 19),
       (41, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Annotated fields and parameters values will be injected', false, 20),
       (42, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'Declares a pointcut executed before the call giving control over the execution of the join point to the advice',
        true, 19),
       (43, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'that a bean should be created for the class', true, 11),
       (44, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@Valid', true,
        14),
       (45, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'Autowiring feature of spring framework enables you to inject the object dependency implicitly', false, 18),
       (46, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'Instances of an annotated class are stored as part of an entity', true, 18),
       (47, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'It tells to the Spring that any HTTP request should map to the corresponding method.', true, 13),
       (48, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'sed to bind a web request parameter to a method parameter', false, 13),
       (49, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'REST permits different data format such as Plain text, HTML, XML, JSON etc.', true, 9),
       (50, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Object', false,
        16),
       (51, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, ' Class', true,
        16),
       (52, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'A technique to get dependencies of any project', false, 1),
       (53, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'Used to promote tight coupling in code.', false, 1),
       (54, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'Spring using Dependency Injection and supports loose coupling.', true, 3),
       (55, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Container',
        false, 16),
       (56, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@Transient',
        false, 4),
       (57, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@RolesAllowed',
        false, 4),
       (58, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'Prototype scope', false, 5),
       (59, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'Singleton and Prototype', false, 5),
       (60, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'Singleton scope', true, 5),
       (61, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,
        'SOAP uses URI to expose business logic.', false, 9),
       (62, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Prototype',
        false, 2),
       (63, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Request',
        false, 2),
       (64, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '20', true, 6),
       (65, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '8', false, 6),
       (66, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@Repository This is to indicate that the class defines a database repository.', true, 7),
       (67, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@Controller hold the business logic and call methods in the repository layer.', false, 7),
       (68, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@Service indicate that the annotate classes at presentation layers level, mainly used in Spring MVC.', false, 7),
       (69, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@AfterMapping', false, 10),
       (70, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@NotEmpty', true, 14),
       (71, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '@Autowired', false, 14),
       (73, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'SOAP is less preferred than REST..', true, 9),
       (74, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'informs to the Spring to render the result back to the caller', false, 13),
       (75, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'that autowiring should be enabled for the class', false, 11),
       (76, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'that autowiring should not be enabled for the class', false, 11),
       (77, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'in WEB_INF folder', true, 15),
       (78, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, '12', false, 17),
       (72, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Specifies a list of security roles allowed to invoke protected method', false, 19);

/* culture question */
insert into public.culture_questions(id, active, created_at, created_by, deleted, updated_at, updated_by, version, type , score, content)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,'UNIQUE_CHOICE', 5, 'Do you have an idea about xHub'),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,'MULTI_CHOICE', 5, 'Would you like to work with xHub'),
       (3, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,'TEXT', 5, 'How did you heard about xHub');

insert into public.culture_answers(id, active, created_at, created_by, deleted, updated_at, updated_by, version, content, culture_question_id)
values (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Yes', 1),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'No', 1),
       (3, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'No', 2),
       (4, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0, 'Yes', 2);

/* attendee seed */
INSERT INTO public.attendees (id, active, created_at, created_by, deleted, updated_at, updated_by, version, email,
                              first_name, last_name, phone_number)
VALUES ('1', true, '2022-09-13 19:59:40.428386', 'SYSTEM', false, '2022-09-13 19:59:40.428386', 'SYSTEM', 0,
        'john.doe@x-hub.io', 'John', 'Doe', '(+212)799-794-994');

/* attendee event seed */
INSERT INTO public.attendee_event (event_id, attendee_id)
VALUES ('1', '1');

/* quiz instance seed */
INSERT INTO public.quiz_instance (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                  end_date, final_score, last_question_index, start_date, status,
                                  attendee_event_attendee_id, attendee_event_event_id)
VALUES ('1', true, '2022-09-13 19:59:40.458381', 'SYSTEM', false, '2022-09-13 20:00:23.982048', 'SYSTEM', 22,
        '2022-09-13 20:00:23.978050', 6, 19, '2022-09-13 19:59:44.465600', 'FINISHED', '1', '1');


/* quiz instance details seed for attendee  */
INSERT INTO public.quiz_instance_details (id, active, created_at, created_by, deleted, updated_at, updated_by, version,
                                          question_index, score, question_id, quiz_instance_id)
VALUES ('f11e1853-2876-46a4-a7eb-5f709cdbcf3b', true, '2022-09-13 19:59:44.485614', 'SYSTEM', false,
        '2022-09-13 19:59:44.485614', 'SYSTEM', 0, 1, 0, '8', '1'),
       ('e36cf112-d5ff-46a4-8f2d-9875307e8679', true, '2022-09-13 19:59:44.486612', 'SYSTEM', false,
        '2022-09-13 19:59:44.486612', 'SYSTEM', 0, 2, 0, '2', '1'),
       ('0ff8dd60-e670-4fd3-a416-90072f09957a', true, '2022-09-13 19:59:44.486612', 'SYSTEM', false,
        '2022-09-13 19:59:44.486612', 'SYSTEM', 0, 3, 0, '9', '1'),
       ('002ddaed-11c1-4722-a7ae-7ff153bbe3d3', true, '2022-09-13 19:59:44.486612', 'SYSTEM', false,
        '2022-09-13 19:59:44.486612', 'SYSTEM', 0, 4, 0, '15', '1'),
       ('a2c8108c-334b-4f93-921d-35dd98f7df62', true, '2022-09-13 19:59:44.487613', 'SYSTEM', false,
        '2022-09-13 19:59:44.487613', 'SYSTEM', 0, 5, 0, '19', '1'),
       ('231e90da-6c5e-4d92-9796-740377c86a14', true, '2022-09-13 19:59:44.488613', 'SYSTEM', false,
        '2022-09-13 19:59:44.488613', 'SYSTEM', 0, 8, 0, '14', '1'),
       ('b01bacd9-07fa-48ae-9152-76033e46cfac', true, '2022-09-13 19:59:44.488613', 'SYSTEM', false,
        '2022-09-13 19:59:44.488613', 'SYSTEM', 0, 9, 0, '18', '1'),
       ('ca8d4922-a9d1-478f-bca2-f48c0b59062c', true, '2022-09-13 19:59:44.488613', 'SYSTEM', false,
        '2022-09-13 19:59:44.488613', 'SYSTEM', 0, 10, 0, '12', '1'),
       ('89b2b564-5ad2-433e-9ade-55eb6cfa587a', true, '2022-09-13 19:59:44.488613', 'SYSTEM', false,
        '2022-09-13 19:59:44.488613', 'SYSTEM', 0, 12, 0, '10', '1'),
       ('ca48b2a5-8739-4ec1-8bad-f57f1191c9e2', true, '2022-09-13 19:59:44.489614', 'SYSTEM', false,
        '2022-09-13 19:59:44.489614', 'SYSTEM', 0, 13, 0, '17', '1'),
       ('f646f622-f6cd-4384-befe-90880bd7db8a', true, '2022-09-13 19:59:44.489614', 'SYSTEM', false,
        '2022-09-13 19:59:44.489614', 'SYSTEM', 0, 14, 0, '6', '1'),
       ('c8796f8a-3cd5-42b3-91e4-70864fb61ef6', true, '2022-09-13 19:59:44.490615', 'SYSTEM', false,
        '2022-09-13 19:59:44.490615', 'SYSTEM', 0, 16, 0, '16', '1'),
       ('dff4b0b8-9fe9-4a9d-8022-a81bc8f16c09', true, '2022-09-13 19:59:44.490615', 'SYSTEM', false,
        '2022-09-13 19:59:44.490615', 'SYSTEM', 0, 19, 0, '3', '1'),
       ('08ee788e-4ed6-42d9-b853-2a78483483d2', true, '2022-09-13 19:59:44.490615', 'SYSTEM', false,
        '2022-09-13 19:59:44.490615', 'SYSTEM', 0, 20, 0, '5', '1'),
       ('843afaef-7a63-4156-b079-99303bedfecd', true, '2022-09-13 19:59:44.487613', 'SYSTEM', false,
        '2022-09-13 19:59:56.927784', 'SYSTEM', 1, 6, 1, '11', '1'),
       ('f30c1d68-dc5d-4dcd-a988-32274b0eb4d4', true, '2022-09-13 19:59:44.487613', 'SYSTEM', false,
        '2022-09-13 19:59:58.413843', 'SYSTEM', 1, 7, 1, '20', '1'),
       ('979cd707-961f-4c75-9d1d-6b185c027c4b', true, '2022-09-13 19:59:44.488613', 'SYSTEM', false,
        '2022-09-13 20:00:07.035121', 'SYSTEM', 1, 11, 1, '4', '1'),
       ('8ac3afeb-88ec-46a4-b652-e4ccc5657327', true, '2022-09-13 19:59:44.490615', 'SYSTEM', false,
        '2022-09-13 20:00:14.532026', 'SYSTEM', 1, 15, 1, '7', '1'),
       ('164c9d84-f3dc-42d6-9746-36f2f5327abf', true, '2022-09-13 19:59:44.490615', 'SYSTEM', false,
        '2022-09-13 20:00:19.207311', 'SYSTEM', 1, 17, 1, '13', '1'),
       ('c6b8b9ef-320b-4856-8034-025f3128f0c6', true, '2022-09-13 19:59:44.490615', 'SYSTEM', false,
        '2022-09-13 20:00:20.369398', 'SYSTEM', 1, 18, 1, '1', '1');
