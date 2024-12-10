CREATE DATABASE qlluong;
USE qlluong;

CREATE TABLE account
(
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);

INSERT INTO account(username, password)
VALUES ('Tung', '123321');

CREATE TABLE employee
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    fullName    VARCHAR(255),
    gender      VARCHAR(20),
    phone       VARCHAR(255),
    position    VARCHAR(255),
    base_salary FLOAT
);

CREATE TABLE salary_manager
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    employee_id     INT,
    date_received   VARCHAR(255),
    revenue         FLOAT,
    commission_rate FLOAT,
    net_salary      FLOAT,
    CONSTRAINT fk_salary_employee FOREIGN KEY (employee_id) REFERENCES employee (id)
);

CREATE TABLE salary_sale
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    employee_id   INT,
    date_received VARCHAR(255),
    ot_hours   INT,
    hour_work INT,
    net_salary INT,
    CONSTRAINT fk_sales_employee FOREIGN KEY (employee_id) REFERENCES employee (id)
);