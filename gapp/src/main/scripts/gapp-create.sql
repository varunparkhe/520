
    create table additionalfield (
        id int4 not null,
        name varchar(255),
        required boolean,
        type varchar(255),
        departments_id int4,
        primary key (id)
    );

    create table applications (
        id int4 not null,
        gpa float8,
        gre int4,
        toefl int4,
        trasncript bytea,
        prog_id int4,
        user_id int4,
        primary key (id)
    );

    create table applicationstatus (
        id int4 not null,
        status varchar(255),
        primary key (id)
    );

    create table auditstatus (
        id int4 not null,
        comments varchar(255),
        time timestamp,
        applicant_id int4,
        applicationstatus_id int4,
        primary key (id)
    );

    create table departments (
        id int4 not null,
        departmentname varchar(255),
        term varchar(255),
        year varchar(255),
        primary key (id)
    );

    create table educationalbackground (
        id int4 not null,
        degree varchar(255),
        major varchar(255),
        university varchar(255),
        year timestamp,
        applicationsdegree_id int4,
        primary key (id)
    );

    create table programs (
        id int4 not null,
        programname varchar(255),
        departmentprog_id int4,
        primary key (id)
    );

    create table roles (
        id int4 not null,
        role varchar(255),
        primary key (id)
    );

    create table roles_users (
        role_id int4 not null,
        user_id int4 not null
    );

    create table users (
        id int4 not null,
        cin varchar(255),
        citizenship varchar(255),
        dob varchar(255),
        enabled boolean not null,
        firstname varchar(255),
        gender varchar(255),
        lastname varchar(255),
        password varchar(255) not null,
        phoneno varchar(255),
        username varchar(255) not null,
        primary key (id)
    );

    alter table users 
        add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table additionalfield 
        add constraint FK_32gegxyctpjsqbafxapc0xnpb 
        foreign key (departments_id) 
        references departments;

    alter table applications 
        add constraint FK_mjcwxwtwdjfyatv9d7tx42gfv 
        foreign key (prog_id) 
        references programs;

    alter table applications 
        add constraint FK_il296b7i4a8es7mgs2a79gl8o 
        foreign key (user_id) 
        references users;

    alter table auditstatus 
        add constraint FK_rki1occy8jp1q7ox39mmx76li 
        foreign key (applicant_id) 
        references applications;

    alter table auditstatus 
        add constraint FK_qwpo4mg5h9mjguqdqebgeah60 
        foreign key (applicationstatus_id) 
        references applicationstatus;

    alter table educationalbackground 
        add constraint FK_qhy9qjmjoj6d8u0pwkqi34dqu 
        foreign key (applicationsdegree_id) 
        references applications;

    alter table programs 
        add constraint FK_t5cnf8h447539dwswhid6ilho 
        foreign key (departmentprog_id) 
        references departments;

    alter table roles_users 
        add constraint FK_3va0ssladn9mwg8ohg8a8el0 
        foreign key (user_id) 
        references users;

    alter table roles_users 
        add constraint FK_4k5l5kx7d2epf59gyoqpycdbs 
        foreign key (role_id) 
        references roles;

    create sequence hibernate_sequence;
