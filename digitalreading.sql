SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO';
START TRANSACTION;
SET time_zone = '+00:00';

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS 'digitalreading' DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE 'digitalreading';

CREATE TABLE 'bibliotecas' (
  'ID' int(11) NOT NULL,
  'IDuser' int(11) NOT NULL,
  'IDbook' int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE 'comentarios' (
  'ID' int(11) NOT NULL,
  'IDuser' int(11) NOT NULL,
  'IDbook' int(11) NOT NULL,
  'Username' varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  'Comentario' varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE 'libros' (
  'ID' int(5) NOT NULL,
  'Title' varchar(80) COLLATE utf8_spanish_ci NOT NULL,
  'Author' varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  'Genre' varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  'SellingDate' date NOT NULL,
  'Price' decimal(10,2) NOT NULL,
  'Likes' int(3) DEFAULT NULL,
  'Foto' text COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

INSERT INTO ROOT.'BOOKS' ('ID', 'TITLE', 'AUTHOR', 'GENRE', 'SELLINGDATE', 'PRICE', 'LIKES', 'FOTO') VALUES
(1, '', '', '', '', '', , '')



INSERT INTO ROOT.BOOKS (ID, TITLE, AUTHOR, GENRE, SELLINGDATE, PRICE, LIKES, FOTO) 
	VALUES (1, 'Mistborn 1: The final Empire', 'Brandon Sanderson', 'epic fantasy', '2006-07-17', 8.50, 5,'./img/CPmistborn1.jpg'),
(2, 'Mistborn 2: The Well of Ascension', 'Brandon Sanderson', 'epic fantasy', '2007-08-21', '10.00', 4, './img/CPmistborn2.jpg'),
(3, 'Mistborn 3: The Hero of Ages', 'Brandon Sanderson', 'epic fantasy', '2008-10-14', '12.50', 12, './img/CPmistborn3.png'),
(4, 'Service oriented architecture: SOA strategy, methodology, and technology', 'James P. Lawler, H. Howler-Barber.', '', '2007-01-01', '50.00', 7, './img/bookAS1.jpg'),
(5, 'Software architecture in practice', 'Len Bass, Paul Clements, Rick Kazman.', '', '2012-09-25', '36.00', 5, './img/BookAS2.jpg'),
(6, 'Patterns of enterprise application architecture ', 'Martin Fowler', '', '2012-01-01', '52.00', 4, './img/bookAS3.jpg'),
(7, 'The Kingkiller Chronicle', 'Patrick Rothfuss', 'Heroic fantasy', '2007-03-27', '12.50', 12, './img/CPTheKingkillerChronicle1.jpg\r\n'),
(8, 'The Wise Mans Fear', 'Patrick Rothfuss', 'Heroic fantasy', '2011-05-01', '10.00', 8, './img/CPTheKingkillerChronicle2.jpg'),
(9, 'it', 'Stephen King', 'Horror', '1986-09-15', '12.70', 2, './img/it.jpg');



INSERT INTO 'libros' ('ID', 'Title', 'Author', 'Genre', 'SellingDate', 'Price', 'Likes', 'Foto') VALUES
(1, 'Mistborn 1: The final Empire', 'Brandon Sanderson', 'epic fantasy', '2006-07-17', '8.50', 5, './img/CPmistborn1.jpg'),
(2, 'Mistborn 2: The Well of Ascension', 'Brandon Sanderson', 'epic fantasy', '2007-08-21', '10.00', 4, './img/CPmistborn2.jpg'),
(3, 'Mistborn 3: The Hero of Ages', 'Brandon Sanderson', 'epic fantasy', '2008-10-14', '12.50', 12, './img/CPmistborn3.png'),
(4, 'Service oriented architecture: SOA strategy, methodology, and technology', 'James P. Lawler, H. Howler-Barber.', '', '2007-01-01', '50.00', 7, './img/bookAS1.jpg'),
(5, 'Software architecture in practice', 'Len Bass, Paul Clements, Rick Kazman.', '', '2012-09-25', '36.00', 5, './img/BookAS2.jpg'),
(6, 'Patterns of enterprise application architecture ', 'Martin Fowler', '', '2012-01-01', '52.00', 4, './img/bookAS3.jpg'),
(7, 'The Kingkiller Chronicle', 'Patrick Rothfuss', 'Heroic fantasy', '2007-03-27', '12.50', 12, './img/CPTheKingkillerChronicle1.jpg\r\n'),
(8, 'The Wise Mans Fear', 'Patrick Rothfuss', 'Heroic fantasy', '2011-05-01', '10.00', 8, './img/CPTheKingkillerChronicle2.jpg'),
(9, 'it', 'Stephen King', 'Horror', '1986-09-15', '12.70', 2, './img/it.jpg');

CREATE TABLE 'usuarios' (
  'ID' int(8) NOT NULL,
  'name' varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  'lastname' varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  'email' text COLLATE utf8_spanish_ci NOT NULL,
  'password' varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  'Admin' int(1) NOT NULL DEFAULT 0 COMMENT '1=admin\r\n0=normal',
  'account' decimal(10,2) NOT NULL DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

INSERT INTO 'usuarios' ('ID', 'name', 'lastname', 'email', 'password', 'Admin', 'account') VALUES
(1, 'Miguel', 'Berciano', 'miguel.berciano101@alu.ulpgc.es', '1', 1, '3.50'),
(2, 'admin', 'admin', 'admin@example.com', '1', 1, '69.00'),
(3, 'Jeff', 'Gutierrez', 'Jeff@pimentera.com', '1', 0, '4.80'),
(10, 'Tamara', 'Pazos', 'Tamara.pazos@gmail.com', '1', 0, '0.00'),
(13, 'Gabri', 'Garcia Buey', 'gabribuey@hotmail.com', '1', 0, '0.00'),
(14, 'Cristina', 'Benlliure', 'CristBenlliure@gmail.com', '1', 0, '0.50'),
(15, 'Javier', 'Sanchez', 'jsanchez@hotmail.com', '1', 0, '19.00');


ALTER TABLE 'bibliotecas'
  ADD PRIMARY KEY ('ID');

ALTER TABLE 'comentarios'
  ADD PRIMARY KEY ('ID');

ALTER TABLE 'libros'
  ADD PRIMARY KEY ('ID');

ALTER TABLE 'usuarios'
  ADD PRIMARY KEY ('ID');


ALTER TABLE 'bibliotecas'
  MODIFY 'ID' int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE 'comentarios'
  MODIFY 'ID' int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE 'libros'
  MODIFY 'ID' int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

ALTER TABLE 'usuarios'
  MODIFY 'ID' int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
