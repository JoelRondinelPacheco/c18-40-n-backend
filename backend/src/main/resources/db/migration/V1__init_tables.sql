create table category (id bigserial not null, name varchar(50), primary key (id));
create table event_category_relation (category_id bigint not null, event_id bigint not null);
create table person (id bigserial not null, phone_number bigint, role_id bigint, address varchar(255), email varchar(255), lastname varchar(255), name varchar(255), password varchar(255), username varchar(255), primary key (id));
create table person_event_relation (event_id bigint not null, person_id bigint not null);
create table qualification (event_id bigint, id bigserial not null, quantity bigint, observations varchar(255), primary key (id));
create table role (id bigserial not null, name varchar(255), primary key (id));
create table social_event (price numeric(38,2), published boolean not null, id bigserial not null, invited_guest bigint, max_guests bigint, organizer_id bigint, programated_date timestamp(6), details varchar(2500), address varchar(255), contact_info varchar(255), name varchar(255), tags varchar(255), primary key (id));
alter table if exists event_category_relation add constraint FK4jg68qyk9ldme77p3ufwlco9r foreign key (category_id) references category;
alter table if exists event_category_relation add constraint FKb9b21hw6vuf0yhp4s7fy2wj46 foreign key (event_id) references social_event;
alter table if exists person add constraint FKfqfeq5nokuewxxtb44t9lw012 foreign key (role_id) references role;
alter table if exists person_event_relation add constraint FKfje2qtgfuhh9ao9k6cpm5gwpr foreign key (event_id) references social_event;
alter table if exists person_event_relation add constraint FKsx69wx9y6rmc68rg93852f4yp foreign key (person_id) references person;
alter table if exists qualification add constraint FKpd1l87ikelg9ity38y76mn7px foreign key (event_id) references social_event;
alter table if exists social_event add constraint FKe2kpqx37pv164e2vj2hvliasi foreign key (organizer_id) references person;