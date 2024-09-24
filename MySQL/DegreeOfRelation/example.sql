-- Unary type of table
CREATE TABLE Employee(
    employeeID INT PRIMARY KEY,
    name VARCHAR,
    superVisorID INT,
    FOREIGN KEY (superVisorID) REFERENCES Employee(employeeID)
);
-- This is Unary table, only one entity type is related to itself
-- One Employee can supervise another Employee in the same table

-- Binary type of table
CREATE TABLE customer(
    customerId INT PRIMARY KEY,
    name VARCHAR,
);

CREATE TABLE order(
    orderID INT PRIMARY KEY,
    customerId INT,
    FOREIGN KEY (customerId) REFERENCES customer(customerId)
);
-- This one involves 2 entities

-- Ternary type of degree
CREATE TABLE student(
    studentID INT PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE professor(
    professorID INT PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE course(
    courseID INT PRIMARY KEY,
    name VARCHAR
);

create TABLE enrollment(
    studentID INT,
    professorID INT,
    courseID INT,
    PRIMARY KEY (studentID, professorID, courseID),
    FOREIGN KEY (studentID) REFERENCES student(studentID),
    FOREIGN KEY (courseID) REFERENCES course(courseID),
    FOREIGN KEY (professorID) REFERENCES professor(professorID)
)