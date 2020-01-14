create table persons
(
       person_id number ,
       first_name varchar2(30),
       last_name varchar2(30),
       birth date,
       gender varchar2(5),
       email varchar2(30),
       phone varchar2(20),
       primary key(person_id) 
);

create table users
(
       user_id number,
       login varchar2(30),
       password varchar2(30) unique,
       person_id references persons(person_id),
       primary key(user_id)
);

