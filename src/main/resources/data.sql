CREATE TABLE users (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL
);

INSERT INTO users (id, name, surname)
VALUES (1, 'sergio', 'castaneda');
INSERT INTO users (id, name, surname)
VALUES (2, 'sergio', 'castaneda');
INSERT INTO users (id, name, surname)
VALUES (3, 'sergio', 'castaneda');
