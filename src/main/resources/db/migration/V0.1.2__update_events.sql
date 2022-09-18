/* xQuiz data seed */

/* EVENTS */
update events
SET start_date = '2022-09-04 15:55:04.000000',
    end_date = '2022-09-06 15:54:42.000000'
WHERE id IN ('1','2');

update event_themes
SET background_image = 'https://svgshare.com/i/mgJ.svg'
WHERE ID in ('2', '3', '4');