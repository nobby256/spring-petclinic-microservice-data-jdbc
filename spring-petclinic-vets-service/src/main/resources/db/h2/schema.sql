DROP TABLE vet_specialty IF EXISTS;
DROP TABLE vet IF EXISTS;
DROP TABLE specialty IF EXISTS;

CREATE TABLE vet (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30)
);
CREATE INDEX vet_last_name ON vet (last_name);

CREATE TABLE specialty (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX specialty_name ON specialty (name);

CREATE TABLE vet_specialty (
  vet       INTEGER NOT NULL,
  specialty INTEGER NOT NULL
);
