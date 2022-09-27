delete FROM answers;
delete FROM questions;

insert into public.questions(id, active, created_at, created_by, deleted, updated_at, updated_by, version,is_multiple_choice , score, seniority_level_id, sub_theme_id, content)
VALUES (1, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 2, 'Variables in an interface are always: '),
       (2, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 2, 'Are all Strings immutable?'),
       (3, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 2, 'How many abstract methods are there in a functional interface in Java 8?'),
       (4, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 2, 'What are differences between String and StringBuffer?'),
       (5, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 2, 'To do a deep comparison between two arrays A and B, we write :'),
       (6, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 2, 'How many modules are there in Spring Framework and what are they?'),
       (7, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 2, 'Overloaded methods can have different : '),
       (8, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 2, 'Which of these keywords can be used to prevent Method overriding?'),
       (9, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 2, 2, 'Which of the following is true about PreparedStatement in java?'),
       (10, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 2, 2, 'The thread safe way of using Singleton pattern is via'),
       (11, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 2, 2, 'Which of the following functional interface represents a function that accepts a double-valued argument and produces a long-valued result ?'),
       (12, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 2, 'Code before Java 8 essentially used to be ?'),
       (13, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 2, 2, 'A pipeline is a sequence of what operations in java 8 ?'),
       (14, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 2, 'In Java 8 Interfaces, methods can be ?'),
       (15, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 2, 'What is the Optional object used for ?'),
       (16, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 1, 2, 'What is the return type of lambda expression ? '),
       (17, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 2, 'How many types of scopes  Spring Bean?'),
       (18, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 2, 'Given a class named Student, which of the following is a valid constructor declaration for the class ?'),
       (19, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,true, 1, 2, 2, 'What statements about the stack and heap memory are true ?'),
       (20, true, '2022-04-06 01:27:07.8801', 'SYSTEM', false, '2022-04-16 01:27:07.8801', 'SYSTEM', 0,false, 1, 1, 2, 'What does hashCode() method of the Object class return?');