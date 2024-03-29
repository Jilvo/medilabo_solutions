create database microservicepatient;
-- use microservicepatient;
CREATE TABLE Patient (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(64) NOT NULL,
  lastName VARCHAR(64) NOT NULL,
  birthDate DATE NOT NULL,
  gender ENUM("Male","Female") NOT NULL,
  email VARCHAR(128) NOT NULL,
  phoneNumber VARCHAR(10),
  address VARCHAR(128),
  city VARCHAR(64),
  postalCode INT(5),
  lastUpdate DATETIME NOT NULL,
  creationDate DATETIME NOT NULL,

  PRIMARY KEY (id)
);
INSERT INTO Patient (firstName, lastName, birthDate, gender, email, phoneNumber, address, city, postalCode, lastUpdate, creationDate)
VALUES 
('John', 'Doe', '1980-01-01', 'Male', 'johndoe@example.com', '1234567890', '123 Main St', 'Anytown', 12345, NOW(), NOW()),
('Jane', 'Doe', '1980-01-02', 'Female', 'janedoe@example.com', '0987654321', '456 Main St', 'Anytown', 12345, NOW(), NOW()),
('Tony', 'Stark', '1970-05-29', 'Male', 'ironman@example.com', '1112223333', '10880 Malibu Point', 'Malibu', 90265, NOW(), NOW()),
('Steve', 'Rogers', '1918-07-04', 'Male', 'captainamerica@example.com', '4445556666', '569 Leaman Place', 'Brooklyn', 11201, NOW(), NOW()),
('Natasha', 'Romanoff', '1984-11-22', 'Female', 'blackwidow@example.com', '7778889999', 'KGB Headquarters', 'Moscow', 101000, NOW(), NOW());