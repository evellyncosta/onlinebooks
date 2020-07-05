CREATE TABLE `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int4 NOT NULL,
  `id_book` int4 NOT NULL,
  `dt_reservation` timestamp, 
  `ticket` DECIMAL(19 , 2 ), 
  `ticket_by_day` DECIMAL(19 , 2 ), 
  PRIMARY KEY (`id`),
  CONSTRAINT fk_id_client FOREIGN KEY (id_client) REFERENCES agrinessdb.client(id),
	CONSTRAINT fk_id__book FOREIGN KEY (id_book) REFERENCES agrinessdb.book(id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


INSERT INTO agrinessdb.reservation
(id_client, id_book, dt_reservation)
VALUES(9, 5, CURRENT_TIMESTAMP());

INSERT INTO agrinessdb.reservation
(id_client, id_book, dt_reservation)
VALUES(10, 6, '2020-07-04 09:30:00.0');

INSERT INTO agrinessdb.reservation
(id_client, id_book, dt_reservation)
VALUES(11, 7, '2020-06-28 15:15:00.0');

INSERT INTO agrinessdb.reservation
(id_client, id_book, dt_reservation)
VALUES(11, 7, '2020-07-01 15:15:00.0');
 
UPDATE book set available = false where id = 5;
UPDATE book set available = false where id = 6;
UPDATE book set available = false where id = 7;
UPDATE book set available = false where id = 8;
