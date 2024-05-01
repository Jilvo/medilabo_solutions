USE microservicepatient;
CREATE TABLE Patient (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(64) NOT NULL,
  last_name VARCHAR(64) NOT NULL,
  birth_date DATE NOT NULL,
  gender ENUM("M","F") NOT NULL,
  phone VARCHAR(12),
  address VARCHAR(128),
  PRIMARY KEY (id)
);
INSERT INTO Patient (first_name, last_name, birth_date, gender, address, phone) VALUES
('TestNone', 'Test', '1966-12-31', 'F', '1 Brookside St', '100-222-3333'),
('TestBorderline', 'Test', '1945-06-24', 'M', '2 High St', '200-333-4444'),
('TestInDanger', 'Test', '2004-06-18', 'M', '3 Club Road', '300-444-5555'),
('TestEarlyOnset', 'Test', '2002-06-28', 'F', '4 Valley Dr', '400-555-6666'),
('Peter', 'Parker', '2001-08-10', 'M', '20 Ingram Street, New York', '111-222-3333'), -- Spiderman
('Gwen', 'Stacy', '2002-01-23', 'F', '32 Bleecker Street, New York', '555-666-7777'), -- Spider Gwen
('Elektra', 'Natchios', '1984-07-12', 'F', '21 Jump Street, New York', '666-777-8888'), -- Elektra Natchios
('Matt', 'Murdock', '1980-12-15', 'M', '182 Clinton Street, New York', '444-555-6666'); -- Daredevil