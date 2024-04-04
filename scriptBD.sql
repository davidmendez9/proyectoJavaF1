CREATE TABLE IF NOT EXISTS escuderia (
    codigo VARCHAR(9) NOT NULL,
    contraseña VARCHAR(25) NOT NULL,
    nombre VARCHAR(25) NOT NULL,
    mundiales INT,
    PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS piloto (
    nif VARCHAR(9) NOT NULL,
    nombre VARCHAR(25) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    sueldo FLOAT NOT NULL,
    foto VARCHAR(255),
    escCodigo VARCHAR(9) NOT NULL,
    PRIMARY KEY(nif),
    FOREIGN KEY (escCodigo) REFERENCES escuderia(codigo)
);

CREATE TABLE IF NOT EXISTS patrocinador (
    codigo INT NOT NULL,
    nombre VARCHAR(25) NOT NULL,
    pilNif VARCHAR(9),
    PRIMARY KEY(codigo),
    FOREIGN KEY (pilNif) REFERENCES piloto(nif)
);

-- Inserts para la tabla escuderia

INSERT INTO escuderia (codigo, contraseña, nombre, mundiales) VALUES
(1, 'ferrari_pass', 'Scuderia Ferrari', 16),
(2, 'mercedes_pass', 'Mercedes-AMG Petronas', 8),
(3, 'redbull_pass', 'Red Bull Racing', 4),
(4, 'mclaren_pass', 'McLaren F1 Team', 8),
(5, 'williams_pass', 'Williams Racing', 9),
(6, 'renault_pass', 'Alpine F1 Team', 2),
(7, 'alfaromeo_pass', 'Alfa Romeo Racing Orlen', 2),
(8, 'alphatauri_pass', 'Scuderia AlphaTauri', 1),
(9, 'haas_pass', 'Haas F1 Team', NULL),
(10, 'astonmartin_pass', 'Aston Martin', NULL);

-- Inserts para la tabla piloto

INSERT INTO piloto (nif, nombre, fecha_nacimiento, sueldo, foto, escCodigo) VALUES
('12345678A', 'Lewis Hamilton', '1985-01-07', 486000, 'hamilton.jpg', 2),
('98765432B', 'Max Verstappen', '1997-09-30', 241000, 'verstappen.jpg', 2),
('45678912C', 'Charles Leclerc', '1997-10-16', 190000, 'leclerc.jpg', 1),
('78912345D', 'Lando Norris', '1999-11-13', 102000, 'norris.jpg', 1),
('32165498E', 'George Russell', '1998-02-15', 71000, 'russell.jpg', 3),
('65498732F', 'Fernando Alonso', '1981-07-29', 318000, 'alonso.jpg', 3),
('78945612G', 'Kimi Räikkönen', '1979-10-17', 153000, 'raikkonen.jpg', 4),
('98732165H', 'Pierre Gasly', '1996-02-07', 98000, 'gasly.jpg', 4),
('65412398I', 'Mick Schumacher', '1999-03-22', 45000, 'schumacher.jpg', 5),
('32178965J', 'Sebastian Vettel', '1987-07-03', 189000, 'vettel.jpg', 5),
('45632178K', 'Esteban Ocon', '1996-09-17', 84000, 'ocon.jpg', 6),
('78965432L', 'Valtteri Bottas', '1989-08-28', 174000, 'bottas.jpg', 6),
('32145698M', 'Daniel Ricciardo', '1989-07-01', 146000, 'ricciardo.jpg', 7),
('65432178N', 'Nikita Mazepin', '1999-03-02', 39000, 'mazepin.jpg', 7),
('98778965O', 'Sergio Perez', '1990-01-26', 137000, 'perez.jpg', 8),
('45632178P', 'Kimi Räikkönen', '1979-10-17', 126000, 'raikkonen.jpg', 8),
('78965412Q', 'Yuki Tsunoda', '2000-05-11', 68000, 'tsunoda.jpg', 9),
('32178965R', 'Mick Schumacher', '1999-03-22', 45000, 'schumacher.jpg', 9),
('98745632S', 'Lance Stroll', '1998-10-29', 114000, 'stroll.jpg', 10),
('65478912T', 'Nikita Mazepin', '1999-03-02', 39000, 'mazepin.jpg', 10);

-- Inserts para la tabla patrocinador

INSERT INTO patrocinador (codigo, nombre, pilNif) VALUES
(1, 'UPS', '12345678A'),
(2, 'Oracle', '98765432B'),
(3, 'Shell', '45678912C'),
(4, 'Microsoft', '78912345D'),
(5, 'Intel', '32165498E'),
(6, 'DHL', '65498732F'),
(7, 'Puma', '78945612G'),
(8, 'Red Bull', '98732165H'),
(9, 'Rolex', '65412398I'),
(10, 'Santander', '32178965J'),
(11, 'Hublot', '45632178K'),
(12, 'Lego', '78965432L'),
(13, 'Coca-Cola', '32145698M'),
(14, 'AT&T', '65432178N'),
(15, 'Aston Martin', '98778965O'),
(16, 'BWT', '45632178P'),
(17, 'Hugo Boss', '78965412Q'),
(18, 'UPS', '32178965R'),
(19, 'Pirelli', '98745632S'),
(20, 'Acronis', '65478912T'),
(21, 'FedEx', '12345678A'),
(22, 'SAP', '98765432B'),
(23, 'BP', '45678912C'),
(24, 'Sony', '78912345D'),
(25, 'Samsung', '32165498E'),
(26, 'Nike', '65498732F'),
(27, 'Adidas', '78945612G'),
(28, 'Coca-Cola', '98732165H'),
(29, 'McDonald\'s', '65412398I'),
(30, 'Visa', '32178965J'),
(31, 'Red Bull', '45632178K'),
(32, 'Pirelli', '45632178K'),
(33, 'Mercedes', '78965432L'),
(34, 'UPS', '78965432L'),
(35, 'Rolex', '98778965O'),
(36, 'DHL', '98778965O'),
(37, 'Nike', '45632178P'),
(38, 'SAP', '45632178P'),
(39, 'Adidas', '78965412Q'),
(40, 'Coca-Cola', '78965412Q');