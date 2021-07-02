DROP TABLE IF EXISTS adoption_applications;

CREATE TABLE adoption_applications (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  email VARCHAR(255) NOT NULL,
  home_status VARCHAR(255) NOT NULL,
  application_status VARCHAR(20) DEFAULT 'pending',
  pet_id INTEGER REFERENCES pets(id) NOT NULL
);