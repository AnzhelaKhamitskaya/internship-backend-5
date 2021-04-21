create table checklist_item (id int4 not null, name varchar(20) not null, type varchar(255) not null, primary key (id));
create table checklist_item_grade (id int4 not null, grade varchar(20) not null, checklist_item_id int4 not null, interview_id int4 not null, primary key (id));
alter table events add column is_published boolean;
create table interview (id int4 not null, end_time timestamp, feedback varchar(100), start_time timestamp, candidate_id int4 not null, interviewer_id int4 not null, primary key (id));
create table interviewer (id int4 not null, name varchar(20) not null, type varchar(255) not null, primary key (id));
create table interviewer_timeslot (id int4 not null, end_time timestamp not null, start_time timestamp not null, interviewer_id int4 not null, primary key (id));
alter table checklist_item_grade add constraint FKhpwewqxsyc92cmovwlslvit2y foreign key (checklist_item_id) references checklist_item;
alter table checklist_item_grade add constraint FKkm54ja3khpp567k2ge4ivodaw foreign key (interview_id) references interviewer;
alter table interview add constraint FKjod0wwyxvbi7qyx9cmlnt8xq4 foreign key (candidate_id) references candidate;
alter table interview add constraint FK5amdvskvlsj31qxv5aceawoye foreign key (interviewer_id) references interviewer;
alter table interviewer_timeslot add constraint FKclg70w7gqslwgjo279a0qqg68 foreign key (interviewer_id) references interviewer;