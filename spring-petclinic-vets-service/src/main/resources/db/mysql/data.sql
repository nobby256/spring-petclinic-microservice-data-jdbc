INSERT IGNORE INTO vet VALUES (1, 'James', 'Carter');
INSERT IGNORE INTO vet VALUES (2, 'Helen', 'Leary');
INSERT IGNORE INTO vet VALUES (3, 'Linda', 'Douglas');
INSERT IGNORE INTO vet VALUES (4, 'Rafael', 'Ortega');
INSERT IGNORE INTO vet VALUES (5, 'Henry', 'Stevens');
INSERT IGNORE INTO vet VALUES (6, 'Sharon', 'Jenkins');

INSERT IGNORE INTO specialty VALUES (1, 'radiology');
INSERT IGNORE INTO specialty VALUES (2, 'surgery');
INSERT IGNORE INTO specialty VALUES (3, 'dentistry');

INSERT IGNORE INTO vet_specialty VALUES (2, 1);
INSERT IGNORE INTO vet_specialty VALUES (3, 2);
INSERT IGNORE INTO vet_specialty VALUES (3, 3);
INSERT IGNORE INTO vet_specialty VALUES (4, 2);
INSERT IGNORE INTO vet_specialty VALUES (5, 1);
