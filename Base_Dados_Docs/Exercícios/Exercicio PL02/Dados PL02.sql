CREATE database Biblioteca_SimaoCardoso;

-- Tabela Editora
CREATE TABLE Editora (
    ID INT AUTO_INCREMENT,
    Nome VARCHAR(50) NOT NULL,
	PRIMARY KEY (ID)
);

-- Tabela Autor
CREATE TABLE Autor (
    ID INT AUTO_INCREMENT,
    Nome VARCHAR(50) NOT NULL,
    Pais VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID)
);

-- Tabela Genero
CREATE TABLE Genero (
    ID INT AUTO_INCREMENT,
    Tipo VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID)
);

-- Tabela Livro
CREATE TABLE Livro (
    ID INT AUTO_INCREMENT,
    Titulo VARCHAR(50) NOT NULL,
    EditoraID INT NOT NULL,
    AutorID INT NOT NULL,
    GeneroID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (EditoraID) REFERENCES Editora(ID),
    FOREIGN KEY (AutorID) REFERENCES Autor(ID),
    FOREIGN KEY (GeneroID) REFERENCES Genero(ID)
);

-- Tabela Cliente
CREATE TABLE Cliente (
    ID INT AUTO_INCREMENT,
    Nome VARCHAR(60) NOT NULL,
    Email VARCHAR(60),
    Contacto INT(9),
    PRIMARY KEY (ID)
);

-- Tabela Emprestimo
CREATE TABLE Emprestimo (
    ID INT AUTO_INCREMENT,
    Data_Devolucao DATE,
    Data_Emprestimo DATE NOT NULL,
    ClienteID INT NOT NULL,
    LivroID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (ClienteID) REFERENCES Cliente(ID),
    FOREIGN KEY (LivroID) REFERENCES Livro(ID)
);

-- Insercao de Dados
INSERT INTO Editora (Nome) VALUES 
('Porto Editora'),
('LeYa'),
('Planeta'),
('Editorial Presença'),
('Gradiva'),
('Plátano Editora'),
('Edições Piaget'),
('Grupo Lidel'),
('Livros do Brasil'),
('Sextante Editora'),
('Pergaminho');

INSERT INTO Autor (Nome, Pais) VALUES
('Frank Herbert','EUA'),
('Olga Ravn','Dinamarca'),
('Richard Morgan','EUA'),
('Daniel Silva','EUA'),
('José Rodrigues dos Santos','Portugal'),
('Stephen King','EUA'),
('Joana Marques','Portugal'),
('Ricardo Araújo Pereira','Portugal'),
('Juliet Marillier','Alemanha'),
('Chloe Gong','França'),
('TJ Klune','França'),
('David Costa','Brasil'),
('V.E. Schwab','Alemanha');

INSERT INTO Genero (Tipo) VALUES
('Fantasia'),
('Ficção Científica'),
('Crónicas'),
('Contos'),
('Biografias'),
('Poesia'),
('Romance'),
('Policial e Thiller'),
('Humor'),
('Literatura'),
('Monografias');

INSERT INTO Livro (Titulo, EditoraID, AutorID, GeneroID) VALUES
('Leão Da Insanidade',9,6,2),
('Vigarista Com Pecados',4,13,9),
('Companheiros Do Rio',6,10,11),
('Cobras De Vento',4,7,9),
('Árvores E Guardiões',4,11,2),
('Agentes E Cães',9,3,6),
('Influenciar Com Vigor',3,2,4),
('Conquista Sem Pecado',9,3,10),
('Chorando Na Tecnologia',4,5,1),
('Prepare-Se Para As Minas',7,11,4),
('Sacerdote Dos Perdidos',4,10,7),
('Chuvas De Desejo',6,10,4),
('Estrangeiros De Tristeza',3,10,9),
('Estranhos De Amanhã',6,5,1),
('Cobras E Defensores',10,9,4),
('Ratos E Descendentes',6,11,7),
('União Das Paliçadas',5,1,6),
('Visão Com Asas',11,4,3),
('Ainda Respirando Nas Profundezas',7,4,10),
('Sons Na Minha Esposa',7,5,11),
('Herói Sem Glória',4,12,4),
('Falcão Do Vento',1,11,10),
('Meninas Da Nação',8,11,5),
('Guardiões Do Mundo',9,4,8),
('Assassinos E Inimigos',1,7,8),
('Humanos E Fantasmas',10,12,3),
('Amaldiçoar Com Força',3,4,10),
('Clímax Sem Fé',3,13,7),
('Protegido Pelo Caçador',3,1,6),
('Prepare-Se Para O Universo',2,3,3);

INSERT INTO Cliente (Nome, Email, Contacto) VALUES
('Miguel Antunes','mantunes187@gmail.com','912456789'),
('Armindo Guterres','armindo.1963@live.com.pt','921568793'),
('Rita Rodrigues','ritinha111@gmail.com','963184687'),
('Larissa Ventura','lariss_ventura@hotmail.com','963215897'),
('Roberto Fragoso','robfrag@yahoo.com','928649873'),
('Adélia Custódio','adeliaamcustodio@hotmail.com','913254893'),
('Sofia Velasquez','velasquez.sof333@live.com.pt','916588731'),
('Delfim Pestana','pestanas1978@gmail.com','936544486'),
('Vânia Quaresma','vania.quaresma.77@yahoo.com','926888369'),
('Maria Pardo','pardo_maria@hotmail.com','913654879'),
('Wilson Guimarães','wwwilsonnn1994@gmail.com','963211548'),
('Nilton Godinho','nilton_god_@hotmail.com','923345869'),
('Clara Dantas','clarinha2000_1@live.com.pt','915487358'),
('Emanuel Rocha','emanuelonrocks@gmail.com','962144487'),
('Mark Raposo','markfoxx@hotmail.com','935587694'),
('Tiago Pacheco','tigas_pacheco@yahoo.com','916687943'),
('Raquel Caldas','caldas.raquel2001@live.com.pt','923648776'),
('Miriam Figueiras','miri_figueiras4321@hotmail.com','913478282'),
('Carlos Teixeira','carlosjrteixeira@gmail.com','963188413');

INSERT INTO Emprestimo (Data_Devolucao, Data_Emprestimo, ClienteID, LivroID) VALUES
('2022-01-06','2020-12-09',19,18),
('2021-08-22','2019-06-07',7,23),
('2022-04-19','2021-07-14',11,10),
('2021-11-02','2019-04-20',4,13),
('2022-05-26','2019-10-31',13,22),
(NULL,'2021-09-24',13,25),
('2022-04-17','2022-02-06',2,25),
('2022-06-06','2022-05-25',17,10),
('2022-06-24','2021-01-30',1,20),
('2021-06-06','2020-03-28',10,2),
(NULL,'2021-11-28',5,6),
(NULL,'2021-04-21',16,29),
(NULL,'2021-02-07',14,2),
(NULL,'2020-10-24',10,30),
('2022-07-26','2022-01-08',17,3),
(NULL,'2020-04-16',13,23),
('2022-07-03','2019-08-18',16,25),
('2021-09-06','2019-12-25',19,13),
(NULL,'2021-02-27',9,12),
('2021-06-22','2019-12-18',7,14),
(NULL,'2021-01-28',4,3),
('2021-08-24','2020-06-14',13,21),
('2022-04-26','2021-12-17',8,7),
('2022-05-14','2019-11-07',6,3),
(NULL,'2019-11-03',1,25),
('2021-03-27','2020-02-05',14,15),
('2020-06-05','2020-06-04',10,16),
('2020-12-28','2020-11-27',13,18),
('2022-01-21','2019-11-24',7,12),
('2021-12-25','2019-12-01',3,23);
