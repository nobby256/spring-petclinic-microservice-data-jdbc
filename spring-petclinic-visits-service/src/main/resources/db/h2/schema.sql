DROP TABLE visit IF EXISTS;

CREATE TABLE visit (
  id          INTEGER IDENTITY PRIMARY KEY,
  pet_id      INTEGER NOT NULL,
  visit_date  DATE,
  description VARCHAR(255)
);
CREATE INDEX visit_pet_id ON visit (pet_id);
