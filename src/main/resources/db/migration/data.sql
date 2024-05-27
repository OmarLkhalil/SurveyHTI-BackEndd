CREATE TABLE Department
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE Specialization
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE Doctor
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    name              VARCHAR(255),
    description       VARCHAR(255),
    picture           VARCHAR(255),
    overallRating     FLOAT,
    teaching          FLOAT,
    mentorship        FLOAT,
    communication     FLOAT,
    rate1             FLOAT,
    rate2             FLOAT,
    rate3             FLOAT,
    department_id     BIGINT,
    specialization_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES Department (id),
    FOREIGN KEY (specialization_id) REFERENCES Specialization (id)
);

CREATE TABLE department_doctor_ids
(
    department_id BIGINT,
    doctor_id     BIGINT,
    PRIMARY KEY (department_id, doctor_id),
    FOREIGN KEY (department_id) REFERENCES Department (id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor (id)
);

CREATE TABLE specialization_doctor_ids
(
    specialization_id BIGINT,
    doctor_id         BIGINT,
    PRIMARY KEY (specialization_id, doctor_id),
    FOREIGN KEY (specialization_id) REFERENCES Specialization (id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor (id)
);

INSERT INTO Department (name, description)
VALUES ('Physics', 'Department of Physics'),
       ('Biology', 'Department of Biology'),
       ('Chemistry', 'Department of Chemistry'),
       ('Engineering', 'Department of Engineering'),
       ('Medicine', 'Department of Medicine');

INSERT INTO Specialization (name, description)
VALUES ('Theoretical Physics', 'Specialization in Theoretical Physics'),
       ('Genetics', 'Specialization in Genetics'),
       ('Organic Chemistry', 'Specialization in Organic Chemistry'),
       ('Mechanical Engineering', 'Specialization in Mechanical Engineering'),
       ('Neurology', 'Specialization in Neurology'),
       ('Pathology', 'Specialization in Pathology'),
       ('Biotechnology', 'Specialization in Biotechnology'),
       ('Civil Engineering', 'Specialization in Civil Engineering'),
       ('Ophthalmology', 'Specialization in Ophthalmology'),
       ('Pharmacology', 'Specialization in Pharmacology');

INSERT INTO Doctor (name, description, picture, overallRating, teaching, mentorship, communication, rate1, rate2, rate3,
                    department_id, specialization_id)
VALUES ('Dr. Adam Johnson', 'Expert in theoretical physics', 'https://randomuser.me/api/portraits/men/22.jpg', 0, 0, 0,
        0, 0, 0, 0, 1, 1),
       ('Dr. Sarah Williams', 'Expert in genetics', 'https://randomuser.me/api/portraits/women/15.jpg', 0, 0, 0, 0, 0,
        0, 0, 2, 2),
       ('Dr. Michael Smith', 'Expert in organic chemistry', 'https://randomuser.me/api/portraits/men/25.jpg', 0, 0, 0,
        0, 0, 0, 0, 3, 3),
       ('Dr. Emily Brown', 'Expert in mechanical engineering', 'https://randomuser.me/api/portraits/women/24.jpg', 0, 0,
        0, 0, 0, 0, 0, 4, 4),
       ('Dr. Daniel Jones', 'Expert in neurology', 'https://randomuser.me/api/portraits/men/27.jpg', 0, 0, 0, 0, 0, 0,
        0, 5, 5),
       ('Dr. Emma Davis', 'Expert in pathology', 'https://randomuser.me/api/portraits/women/11.jpg', 0, 0, 0, 0, 0, 0,
        0, 1, 6),
       ('Dr. Matthew Wilson', 'Expert in biotechnology', 'https://randomuser.me/api/portraits/men/30.jpg', 0, 0, 0, 0,
        0, 0, 0, 2, 7),
       ('Dr. Olivia Taylor', 'Expert in civil engineering', 'https://randomuser.me/api/portraits/women/17.jpg', 0, 0, 0,
        0, 0, 0, 0, 3, 8),
       ('Dr. Noah Anderson', 'Expert in ophthalmology', 'https://randomuser.me/api/portraits/men/35.jpg', 0, 0, 0, 0, 0,
        0, 0, 4, 9),
       ('Dr. Sophia Martin', 'Expert in pharmacology', 'https://randomuser.me/api/portraits/women/19.jpg', 0, 0, 0, 0,
        0, 0, 0, 5, 10),
       ('Dr. Ethan White', 'Expert in medicine', 'https://randomuser.me/api/portraits/men/41.jpg', 0, 0, 0, 0, 0, 0, 0,
        1, 5),
       ('Dr. Isabella Harris', 'Expert in physics', 'https://randomuser.me/api/portraits/women/21.jpg', 0, 0, 0, 0, 0,
        0, 0, 2, 1),
       ('Dr. Jacob Thompson', 'Expert in biology', 'https://randomuser.me/api/portraits/men/43.jpg', 0, 0, 0, 0, 0, 0,
        0, 3, 2),
       ('Dr. Mia Martinez', 'Expert in chemistry', 'https://randomuser.me/api/portraits/women/23.jpg', 0, 0, 0, 0, 0, 0,
        0, 4, 3),
       ('Dr. William Robinson', 'Expert in engineering', 'https://randomuser.me/api/portraits/men/45.jpg', 0, 0, 0, 0,
        0, 0, 0, 5, 4);

INSERT INTO department_doctor_ids (department_id, doctor_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (3, 6),
       (3, 7),
       (4, 8),
       (4, 9),
       (5, 10),
       (5, 11);

INSERT INTO specialization_doctor_ids (specialization_id, doctor_id)
VALUES (1, 3),
       (1, 4),
       (1, 12),
       (1, 13),
       (2, 1),
       (2, 2),
       (2, 5),
       (2, 14),
       (2, 15),
       (3, 3),
       (3, 4),
       (3, 6),
       (3, 7),
       (4, 8),
       (4, 9),
       (4, 10),
       (5, 5),
       (5, 11);
