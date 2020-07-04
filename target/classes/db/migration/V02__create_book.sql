CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `author` varchar(50),
  `isbn` varchar(50),  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


INSERT INTO agrinessdb.book
(title, author, isbn)
VALUES('Como programar', 'Paul Deitel', '8543004799');


INSERT INTO agrinessdb.book
(title, author, isbn)
VALUES('Java Efetivo', 'Joshua Bloch', '8550804622');

INSERT INTO agrinessdb.book
(title, author, isbn)
VALUES('Domain-Driven Design', 'Eric Evans', '8550800651');

INSERT INTO agrinessdb.book
(title, author, isbn)
VALUES('Ponto de Impacto', 'Dan Brown', '85508342651');

INSERT INTO agrinessdb.book
(title, author, isbn)
VALUES('Trabalho Eficaz com Código Legado', 'Michael C. Feathers', '8582600321');


