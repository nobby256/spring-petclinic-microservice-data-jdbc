DROP TABLE pet IF EXISTS;
DROP TABLE pet_type IF EXISTS;
DROP TABLE owner IF EXISTS;

CREATE TABLE pet_type (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX type_name ON pet_type (name);

CREATE TABLE owner (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR_IGNORECASE(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(20)
);
CREATE INDEX owner_last_name ON owner (last_name);

CREATE TABLE pet (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(30),
  birth_date DATE,
  type_id    INTEGER NOT NULL,
  owner_id   INTEGER NOT NULL
);
ALTER TABLE pet ADD CONSTRAINT fk_pet_owner FOREIGN KEY (owner_id) REFERENCES owner (id);
CREATE INDEX pet_name ON pet (name);
