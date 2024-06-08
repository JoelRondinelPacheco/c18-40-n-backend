create table category (id bigserial not null, name varchar(50) unique, primary key (id));
create table event_category_relation (category_id bigint not null, event_id bigint not null);
create table user_data (id bigserial not null, phone_number bigint, address varchar(255), email varchar(255) unique not null, lastname varchar(255), name varchar(255), username varchar(255), primary key (id));
create table user_data_event_relation (event_id bigint not null, user_data_id bigint not null);
create table review (event_id bigint not null, user_data_email varchar(255) not null, id bigserial not null, qualification numeric(2,1), comment varchar(500), primary key (id));
create table social_event (price numeric(38,2), published boolean not null, id bigserial not null, invited_guest bigint, max_guests bigint, organizer_id bigint, confirmed_guests bigint, programmed_date timestamp(6), details varchar(2500), address varchar(255), contact_info varchar(255), name varchar(255), primary key (id));
create table user_credentials(id bigserial not null, user_email varchar(255), password varchar(500) not null, account_non_expired boolean, account_non_locked boolean, credentials_non_expired boolean, enabled boolean, role_id bigserial not null, primary key (id));
create table role (id bigserial not null, name varchar(100) unique not null, primary key (id));
create table permissions (id bigserial not null, name varchar(255) unique not null, primary key (id));
create table role_permissions (role_id bigserial not null, permission_id bigserial not null);

alter table if exists event_category_relation add constraint FK4jg68qyk9ldme77p3ufwlco9r foreign key (category_id) references category;
alter table if exists event_category_relation add constraint FKb9b21hw6vuf0yhp4s7fy2wj46 foreign key (event_id) references social_event;
alter table if exists user_data_event_relation add constraint FKfje2qtgfuhh9ao9k6cpm5gwpr foreign key (event_id) references social_event;
alter table if exists user_data_event_relation add constraint FKsx69wx9y6rmc68rg93852f4yp foreign key (user_data_id) references user_data;

alter table if exists review add constraint FKpd1l87ikelg9ity38y76mn7px foreign key (event_id) references social_event;
alter table if exists review add constraint fk_review_user foreign key (user_data_email) references user_data(email);

alter table if exists social_event add constraint FKe2kpqx37pv164e2vj2hvliasi foreign key (organizer_id) references user_data;

alter table if exists user_credentials add constraint fk_user_credentials_user_data foreign key (user_email) references user_data(email);

alter table if exists role_permissions add constraint fk_permission_role foreign key (role_id) references role;
alter table if exists role_permissions add constraint fk_role_permission foreign key (permission_id) references permissions;