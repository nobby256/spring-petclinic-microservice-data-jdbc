CREATE TABLE IF NOT EXISTS vet (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  INDEX(last_name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS specialty (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS vet_specialty (
  vet INT(4) UNSIGNED NOT NULL,
  specialty INT(4) UNSIGNED NOT NULL,
  UNIQUE (vet,specialty)
) engine=InnoDB;
