create database candi_meter;
CREATE SCHEMA candi_meter;
CREATE TABLE  candi_meter.company
(
ID INT PRIMARY key GENERATED ALWAYS AS IDENTITY,
NAME VARCHAR(100),
DESCRIBTION VARCHAR(250)
);
CREATE TABLE CANDI_METER.POSITION 
(
ID INT PRIMARY key GENERATED ALWAYS AS IDENTITY,
NAME VARCHAR(100),
DESCRIBTION VARCHAR(250),
company_id INT,
CONSTRAINT POSITION_R01 FOREIGN KEY (company_id) REFERENCES CANDI_METER.COMPANY (id)
);

CREATE TABLE CANDI_METER.EMPLOYEE
(
ID INT PRIMARY key GENERATED ALWAYS AS IDENTITY,
NAME VARCHAR (100),
company_id INT,
position_id INT,
CONSTRAINT EMPLOYEE_R01 FOREIGN KEY (company_id) REFERENCES CANDI_METER.COMPANY (id),
constraint EMPLOYEE_R03 foreign key (position_id) references candi_meter.position (id)
);
CREATE TABLE CANDI_METER.VACANCY 
(
ID INT PRIMARY key GENERATED ALWAYS AS IDENTITY,
vacancies INT,
vacancy_name varchar(100),
post_date TIMESTAMP(6),
expire_date TIMESTAMP(6),
position_id INT,
employee_id INT,
CONSTRAINT VACANCY_JOP_R01 FOREIGN KEY (position_id) REFERENCES CANDI_METER.POSITION (id),
CONSTRAINT VACANCY_JOP_R02 FOREIGN KEY (employee_id) REFERENCES CANDI_METER.EMPLOYEE (id)
);

create TABLE candi_meter.document
(
ID INT PRIMARY key GENERATED ALWAYS AS identity,
CV bytea 
);


CREATE TABLE CANDI_METER.CANDIDATE 
(
ID INT PRIMARY key GENERATED ALWAYS AS IDENTITY,
NAME VARCHAR(100),
PHONE INT ,
E_MAIL VARCHAR(255),
document_id INT,
CONSTRAINT CANDIDATE_R02 FOREIGN key (document_id) references candi_meter.document (id)
);

create table candi_meter.QUESTION
(
ID INT PRIMARY key GENERATED ALWAYS AS identity,
DESCRIBTION VARCHAR(250),
expected_salary INT,
experiance VARCHAR (100)
);

create table candi_meter.APPLICATION
(
ID INT PRIMARY key GENERATED ALWAYS AS identity,
vacancy_id INT ,
candidate_id INT ,
question_id INT ,
document_id INT,
CONSTRAINT APPLICATION_R01 FOREIGN KEY (vacancy_id) REFERENCES CANDI_METER.VACANCY (id),
CONSTRAINT APPLICATION_R02 FOREIGN KEY (candidate_id) REFERENCES CANDI_METER.candidate  (id),
CONSTRAINT APPLICATION_R03 FOREIGN KEY (question_id) REFERENCES CANDI_METER.question (id),
CONSTRAINT APPLICATION_R04 FOREIGN key (document_id) references candi_meter.document (id)
);

create table candi_meter.TOPIC_QUESTION
(
ID INT PRIMARY key GENERATED ALWAYS AS identity,
DESCRIBTION VARCHAR(250),
answer VARCHAR (250), 
hint VARCHAR (250)
);
create table candi_meter.TOPIC_LEVEL
(
ID INT PRIMARY key GENERATED ALWAYS AS identity,
DESCRIBTION VARCHAR(250),
topic_question_id INT,
position_id INT,
CONSTRAINT TOPIC_LEVEL_R01 FOREIGN KEY (topic_question_id) REFERENCES CANDI_METER.TOPIC_QUESTION(id),
constraint TOPIC_LEVEL_R02 FOREIGN KEY (position_id) REFERENCES CANDI_METER.position (id)
);

create table candi_meter.TOPICS
(
ID INT PRIMARY key GENERATED ALWAYS AS identity,
Topic_Name VARCHAR(100),
DESCRIBTION VARCHAR(250),
topic_level_id INT,
employee_id INT,
position_id INT,
topic_question_id iNT,
CONSTRAINT TOPICS_R01 FOREIGN KEY (topic_level_id) REFERENCES CANDI_METER.TOPIC_LEVEL (id),
CONSTRAINT TOPICS_R02 FOREIGN KEY (employee_id) REFERENCES CANDI_METER.EMPLOYEE (id),
CONSTRAINT TOPICS_R03 FOREIGN KEY (position_id) REFERENCES CANDI_METER.position  (id),
constraint TOPICS_R04 FOREIGN KEY (topic_question_id ) REFERENCES CANDI_METER.TOPIC_QUESTION (ID)
);

CREATE TABLE CANDI_METER.INTERVIEW 
(
ID INT PRIMARY key GENERATED ALWAYS AS IDENTITY,
INTERVIEW_DATE TIMESTAMP(6),
evaluation INT,
employee_id INT,
application_id INT,
topics_id INT,
CONSTRAINT INTERVIEW_R01 FOREIGN KEY (employee_id) REFERENCES CANDI_METER.EMPLOYEE (id),
constraint INTERVIEW_R05 FOREIGN KEY (application_id) references candi_meter.application(id),
constraint INTERVIEW_R06 foreign key (topics_id) references candi_meter.topics (id)
);


CREATE TABLE CANDI_METER.FOLLOW_UP
(
ID INT PRIMARY key GENERATED ALWAYS AS IDENTITY,
follow_up_date TIMESTAMP(6),
DESCRIBTION VARCHAR(250),
employee_id INT,
interview_id INT,
CONSTRAINT FOLLOW_UP_R01 FOREIGN KEY (employee_id) REFERENCES CANDI_METER.EMPLOYEE (id),
CONSTRAINT FOLLOW_UP_R02 FOREIGN KEY (interview_id) REFERENCES CANDI_METER.INTERVIEW (id)
);

create table candi_meter.TOPIC_RATE
(
ID INT PRIMARY key GENERATED ALWAYS AS identity,
topics_id INT,
rate INT,
interview_id INT ,
CONSTRAINT TOPIC_RATE_R01 FOREIGN KEY (topics_id) REFERENCES CANDI_METER.TOPICS (id),
constraint TOPIC_RATE_R02 foreign key (interview_id) references candi_meter.interview (id)
);

create table candi_meter.ACCEPT
(
ID INT PRIMARY key GENERATED ALWAYS AS IDENTITY,
candidate_id  INT ,
vacancy_id INT ,
CONSTRAINT ACCEPT_R01 FOREIGN key (candidate_id) references candi_meter.candidate (id),
constraint ACCEPT_R02 FOREIGN key (vacancy_id) references candi_meter.vacancy (id)
);


create table candi_meter.CANDIDATE_EVALUATION
(
ID INT PRIMARY key GENERATED ALWAYS AS IDENTITY,
candidate_id  INT ,
employee_id INT ,
evaluation INT ,
CONSTRAINT CANDIDATE_EVALUATION_R01 FOREIGN key (candidate_id) references candi_meter.candidate (id),
CONSTRAINT CANDIDATE_EVALUATION_R02 FOREIGN key (employee_id) references candi_meter.employee (id)
);

