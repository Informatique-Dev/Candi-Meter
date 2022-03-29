insert into candi_meter.company ("name",describtion) 
VALUES('Sirius' , 'Software Development Company');

insert into candi_meter.position  ("name", describtion, company_id) 
VALUES('senior java' , 'senior backend developer ',1);
insert into candi_meter.position  ("name", describtion, company_id) 
VALUES('junior java' , 'junior backend developer',1);
insert into candi_meter.position  ("name", describtion, company_id) 
VALUES('senior front' , 'senior frontend developer',1);
insert into candi_meter.position  ("name", describtion, company_id) 
VALUES('junior front' , 'junior frontend developer',1);
insert into candi_meter.position  ("name", describtion, company_id) 
VALUES('hr' , 'hr',1);

insert into candi_meter.employee ("name",company_id,position_id)
values ('emp1', 1,1);

INSERT INTO candi_meter.document(cv)
VALUES(null);

INSERT INTO candi_meter.candidate
(name, phone, e_mail, document_id)
VALUES('can1', 0100777777, 'can1@asd.com', 1);

insert into candi_meter.question (describtion,expected_salary,experiance)
values ('what position want to applay?', 3000,'fresh');

insert into candi_meter.vacancy (post_date,expire_date,position_id,employee_id,vacancies,vacancy_name)
values ('2022-1-1', '2022-2-1',2,1,4,'junior java');
insert into candi_meter.vacancy (post_date,expire_date,position_id,employee_id,vacancies,vacancy_name)
values ('2022-1-1', '2022-2-1',2,1,4,'junior java');
insert into candi_meter.vacancy (post_date,expire_date,position_id,employee_id,vacancies,vacancy_name)
values ('2022-3-21', '2022-4-21',2,1,4,'junior java');


INSERT INTO candi_meter.application(vacancy_id, candidate_id, question_id, document_id)
VALUES(1, 1, 1, 1);


insert into  candi_meter.topic_question (describtion,answer,hint)
values ('q1','answer1','hint1');
insert into  candi_meter.topic_question (describtion,answer,hint)
values ('q2','answer2','hint2');
insert into candi_meter.topic_level (describtion,topic_question_id,position_id)
values ('level1',1,2);
insert into candi_meter.topic_level (describtion,topic_question_id,position_id)
values ('level1',2,2);
insert into candi_meter.topics (topic_name,describtion,topic_level_id,employee_id,position_id,topic_question_id)
values ('OOP','object orinted programming',1,1,2,1);

insert into candi_meter.topics (topic_name,describtion,topic_level_id,employee_id,position_id,topic_question_id)
values ('DB','database',1,1,2,2);

INSERT INTO candi_meter.interview (interview_date, employee_id, application_id, topics_id)
VALUES('2022-2-15', 1, 1, 1);

INSERT INTO candi_meter.interview (interview_date, employee_id, application_id, topics_id)
VALUES('2022-2-15', 1, 1,2);

insert into candi_meter.topic_rate (topics_id,rate,interview_id)
values (1,40,1);
insert into candi_meter.topic_rate (topics_id,rate,interview_id)
values (2,50,1);

INSERT INTO candi_meter.candidate_evaluation
(candidate_id, employee_id, evaluation)
VALUES(1, 1, 90);

insert into candi_meter.accept (candidate_id ,vacancy_id)
values (1,1);

insert into candi_meter.follow_up (describtion,employee_id,interview_id,follow_up_date)
values ('Accepted',1,1,'2022-2-15');
