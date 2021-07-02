DROP TABLE IF EXISTS surrender_applications CASCADE;

CREATE TABLE surrender_applications (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  phone_number VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  application_status VARCHAR(255) DEFAULT 'pending',
  pet_type_id INTEGER REFERENCES pet_types(id) NOT NULL
);