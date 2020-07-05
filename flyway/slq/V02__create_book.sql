CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `author` varchar(50),
  `isbn` varchar(50),  
  `available` tinyint,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


INSERT INTO agrinessdb.book
(title, author, isbn, available)
VALUES('Como programar', 'Paul Deitel', '8543004799', true);


INSERT INTO agrinessdb.book
(title, author, isbn, available)
VALUES('Java Efetivo', 'Joshua Bloch', '8550804622', true);

INSERT INTO agrinessdb.book
(title, author, isbn, available)
VALUES('Domain-Driven Design', 'Eric Evans', '8550800651', true);

INSERT INTO agrinessdb.book
(title, author, isbn, available)
VALUES('Ponto de Impacto', 'Dan Brown', '85508342651', true);

INSERT INTO agrinessdb.book
(title, author, isbn, available)
VALUES('Código Da Vinci', 'Dan Brown', '85508341234', true);


INSERT INTO agrinessdb.book
(title, author, isbn, available)
VALUES('Origem', 'Dan Brown', '12348341234', true);

INSERT INTO agrinessdb.book
(title, author, isbn, available)
VALUES('Trabalho Eficaz com Código Legado', 'Michael C. Feathers', '8582600321', true);


