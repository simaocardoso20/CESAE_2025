create database Loja_SimaoCardoso;

CREATE TABLE Cliente (
	ID INT AUTO_INCREMENT,
	Nome VARCHAR(100) NOT NULL,
	Email VARCHAR(150) UNIQUE NOT NULL,
	Telefone VARCHAR(15),
	Morada VARCHAR(100),
	CP VARCHAR(8),
	Localidade VARCHAR(20),
	DataNascimento DATE,
	PRIMARY KEY (ID)
);

CREATE TABLE Funcionario (
	ID INT AUTO_INCREMENT,
	Nome VARCHAR(100) NOT NULL,
	Email VARCHAR(150) UNIQUE NOT NULL,
	Cargo VARCHAR(50) NOT NULL,
	DataContratacao DATE NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE CategoriaProduto (
	ID INT AUTO_INCREMENT,
	Nome VARCHAR(50) NOT NULL,
	Descricao VARCHAR(200),
	PRIMARY KEY (ID)
);

CREATE TABLE Produto (
	ID INT AUTO_INCREMENT,
	Nome VARCHAR(100) NOT NULL,
	Preco DECIMAL(10, 2) NOT NULL CHECK (Preco > 0),
	Stock INT NOT NULL DEFAULT 0,
	CategoriaID INT NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY (CategoriaID) REFERENCES CategoriaProduto(ID)
);

CREATE TABLE Venda (
	ID INT AUTO_INCREMENT,
	ClienteID INT NOT NULL,
	FuncionarioID INT NOT NULL,
	DataVenda DATE NOT NULL,
	Total DECIMAL(10, 2) CHECK (Total >= 0),
	PRIMARY KEY (ID),
	FOREIGN KEY (ClienteID) REFERENCES Cliente(ID),
	FOREIGN KEY (FuncionarioID) REFERENCES Funcionario(ID)
);

CREATE TABLE ProdutoVenda (
	VendaID INT NOT NULL,
	ProdutoID INT NOT NULL,
	Quantidade INT NOT NULL CHECK (Quantidade > 0),
	Subtotal DECIMAL(10, 2) NOT NULL CHECK (Subtotal >= 0),
	PRIMARY KEY (VendaID, ProdutoID),
	FOREIGN KEY (VendaID) REFERENCES Venda(ID),
	FOREIGN KEY (ProdutoID) REFERENCES Produto(ID)
);

INSERT INTO Cliente (Nome, Email, Telefone, Morada, CP, Localidade, DataNascimento)
VALUES
('Ana Silva', 'ana.silva@gmail.com', '912345678', 'Rua das Flores, 12', '1000-001', 'Lisboa', '1990-03-15'),
('Bruno Costa', 'bruno.costa@hotmail.com', '914567890', 'Avenida do Mar, 45', '2000-234', 'Porto', '1985-08-22'),
('Carla Gomes', 'carla.gomes@yahoo.com', '913987654', 'Travessa do Sol, 23', '3000-456', 'Coimbra', '1992-11-05'),
('Diogo Fernandes', 'diogo.fernandes@gmail.com', '967812345', 'Largo do Carmo, 2', '4000-789', 'Braga', '1988-06-18'),
('Eva Marques', 'eva.marques@hotmail.com', '965432198', 'Rua Verde, 7', '5000-123', 'Viseu', '1995-02-10'),
('Filipe Almeida', 'filipe.almeida@gmail.com', '914567234', 'Rua Nova, 10', '1000-456', 'Lisboa', '1980-09-25'),
('Gabriela Santos', 'gabriela.santos@outlook.com', '932198765', 'Praça da Alegria, 8', '3000-789', 'Coimbra', '1993-12-01'),
('Henrique Matos', 'henrique.matos@gmail.com', '911234987', 'Rua do Jardim, 18', '4000-234', 'Porto', '1987-03-14'),
('Isabel Rocha', 'isabel.rocha@sapo.pt', '962345678', 'Travessa da Liberdade, 5', '2000-567', 'Porto', '1996-06-21'),
('Jorge Tavares', 'jorge.tavares@yahoo.com', '964567890', 'Avenida Central, 22', '1000-123', 'Lisboa', '1984-11-19'),
('Kátia Nogueira', 'katia.nogueira@outlook.com', '933456789', 'Rua da Paz, 12', '5000-001', 'Viseu', '1991-07-08'),
('Leonardo Antunes', 'leonardo.antunes@gmail.com', '914321876', 'Rua Azul, 6', '2000-345', 'Braga', '1983-05-17'),
('Mafalda Cruz', 'mafalda.cruz@hotmail.com', '932876543', 'Praça do Comércio, 9', '4000-567', 'Coimbra', '1997-01-12'),
('Nuno Vieira', 'nuno.vieira@sapo.pt', '931234567', 'Travessa das Oliveiras, 7', '3000-234', 'Lisboa', '1982-09-28'),
('Olga Monteiro', 'olga.monteiro@gmail.com', '921987654', 'Rua da Vitória, 14', '2000-789', 'Porto', '1994-02-26'),
('Paulo Cardoso', 'paulo.cardoso@outlook.com', '964321876', 'Avenida Nova, 1', '1000-567', 'Viseu', '1989-10-05'),
('Rita Lopes', 'rita.lopes@hotmail.com', '915678234', 'Rua do Sol, 11', '3000-001', 'Braga', '1992-04-03'),
('Sérgio Pinto', 'sergio.pinto@yahoo.com', '933456123', 'Largo do Mercado, 3', '5000-789', 'Coimbra', '1990-08-18'),
('Teresa Faria', 'teresa.faria@sapo.pt', '968123765', 'Praça do Sol, 15', '4000-123', 'Lisboa', '1986-12-22'),
('Vera Lima', 'vera.lima@gmail.com', '962345987', 'Rua da Esperança, 4', '2000-001', 'Porto', '1999-06-30'),
('Xavier Moreira', 'xavier.moreira@gmail.com', '919876543', 'Rua da Liberdade, 15', '1000-234', 'Lisboa', '1985-06-12'),
('Yara Silva', 'yara.silva@hotmail.com', '913456789', 'Travessa do Mar, 7', '2000-456', 'Porto', '1992-01-20'),
('Zeca Oliveira', 'zeca.oliveira@yahoo.com', '914321987', 'Avenida dos Pinhais, 3', '3000-567', 'Coimbra', '1988-09-14'),
('André Matos', 'andre.matos@outlook.com', '967654321', 'Praça da Alegria, 9', '4000-678', 'Braga', '1987-02-25'),
('Beatriz Costa', 'beatriz.costa@sapo.pt', '962345876', 'Rua das Camélias, 4', '5000-789', 'Viseu', '1995-11-13'),
('Carlos Mendes', 'carlos.mendes@gmail.com', '921876543', 'Rua do Sol Nascente, 8', '1000-876', 'Lisboa', '1983-08-02'),
('Daniel Ferreira', 'daniel.ferreira@hotmail.com', '964321654', 'Largo do Comércio, 12', '2000-678', 'Porto', '1991-05-07'),
('Elisa Antunes', 'elisa.antunes@yahoo.com', '933456789', 'Travessa das Hortas, 5', '3000-789', 'Coimbra', '1994-03-30'),
('Fábio Tavares', 'fabio.tavares@gmail.com', '918765432', 'Avenida Central, 6', '4000-234', 'Braga', '1990-07-18'),
('Gabriela Oliveira', 'gabriela.oliveira@sapo.pt', '919234567', 'Rua Nova Esperança, 2', '5000-001', 'Viseu', '1989-12-22');

INSERT INTO Funcionario (Nome, Email, Cargo, DataContratacao)
VALUES
('João Almeida', 'joao.almeida@gmail.com', 'Gerente', '2018-01-10'),
('Marta Sousa', 'marta.sousa@hotmail.com', 'Vendedor', '2020-05-15'),
('Ricardo Nunes', 'ricardo.nunes@sapo.pt', 'Caixa', '2019-03-22'),
('Sofia Rodrigues', 'sofia.rodrigues@yahoo.com', 'Vendedor', '2021-08-30'),
('Pedro Santos', 'pedro.santos@outlook.pt', 'Caixa', '2022-11-10'),
('Ana Tavares', 'ana.tavares@gmail.com', 'Gerente', '2017-07-20'),
('Bruno Lopes', 'bruno.lopes@hotmail.com', 'Vendedor', '2021-02-14'),
('Carla Mendes', 'carla.mendes@sapo.pt', 'Caixa', '2019-12-09'),
('Daniela Costa', 'daniela.costa@gmail.com', 'Vendedor', '2020-10-05'),
('Eduardo Pires', 'eduardo.pires@outlook.pt', 'Gerente', '2015-04-23');

INSERT INTO CategoriaProduto (Nome, Descricao)
VALUES
('Electrodomésticos', 'Produtos de uso doméstico com tecnologia'),
('Pequenos Eletrodomésticos', 'Eletrodomésticos portáteis'),
('Televisores', 'Dispositivos de visualização para entretenimento'),
('Refrigeração', 'Aparelhos de conservação de alimentos e bebidas'),
('Limpeza', 'Equipamentos e acessórios para limpeza doméstica'),
('Cozinha', 'Aparelhos para preparação de alimentos e bebidas');

INSERT INTO Produto (Nome, Preco, Stock, CategoriaID)
VALUES
('Frigorífico', 799.99, 20, 1),
('Máquina de Lavar', 499.99, 15, 1),
('Televisão 55"', 1099.99, 10, 3),
('Microondas', 199.99, 30, 2),
('Liquidificador', 79.99, 50, 2),
('Forno Elétrico', 299.99, 25, 2),
('Aspirador', 249.99, 40, 5),
('Máquina de Secar', 399.99, 12, 1),
('Cafeteira Elétrica', 49.99, 60, 2),
('Chaleira Elétrica', 39.99, 70, 2),
('Exaustor', 349.99, 18, 1),
('Ferro de Engomar', 59.99, 50, 2),
('Batedeira Elétrica', 89.99, 40, 2),
('Máquina de Lavar Louça', 699.99, 10, 1),
('Ar Condicionado', 899.99, 8, 1),
('Ventoinha de Mesa', 49.99, 100, 5),
('Varinha Mágica', 39.99, 80, 2),
('Desumidificador', 229.99, 20, 1),
('Aquecedor Portátil', 89.99, 35, 5),
('Fogão a Gás', 599.99, 12, 1);

INSERT INTO Venda (ClienteID, FuncionarioID, DataVenda, Total)
VALUES
(7, 3, '2023-01-05', 1349.97),
(14, 5, '2023-01-10', 899.98),
(3, 9, '2023-01-15', 199.98),
(19, 7, '2023-01-20', 649.98),
(10, 2, '2023-01-25', 1599.98),
(16, 8, '2023-02-01', 129.98),
(5, 1, '2023-02-10', 549.98),
(18, 4, '2023-02-15', 149.97),
(2, 6, '2023-02-20', 249.98),
(20, 9, '2023-02-28', 599.98),
(11, 3, '2023-03-01', 99.98),
(6, 10, '2023-03-10', 599.99),
(1, 7, '2023-03-15', 799.98),
(13, 2, '2023-03-20', 349.98),
(4, 8, '2023-03-25', 129.98),
(9, 5, '2023-03-30', 169.98),
(12, 1, '2023-04-05', 149.97),
(15, 6, '2023-04-10', 459.97),
(17, 4, '2023-04-15', 749.97),
(8, 9, '2023-04-20', 269.97),
(19, 2, '2023-04-25', 599.98),
(3, 8, '2023-05-01', 219.98),
(7, 10, '2023-05-05', 329.97),
(5, 1, '2023-05-10', 399.98),
(14, 7, '2023-05-15', 549.97),
(2, 6, '2023-05-20', 179.98),
(11, 4, '2023-05-25', 629.98),
(1, 9, '2023-05-30', 899.98),
(18, 5, '2023-06-05', 249.98),
(20, 3, '2023-06-10', 499.98),
(13, 10, '2023-06-15', 649.98),
(4, 2, '2023-06-20', 129.98),
(9, 8, '2023-06-25', 899.98),
(12, 7, '2023-06-30', 199.98),
(15, 1, '2023-07-05', 1099.98),
(6, 4, '2023-07-10', 799.98),
(8, 9, '2023-07-15', 379.97),
(17, 6, '2023-07-20', 219.98),
(16, 3, '2023-07-25', 999.98),
(10, 5, '2023-07-30', 1499.98);

INSERT INTO ProdutoVenda (VendaID, ProdutoID, Quantidade, Subtotal)
VALUES
(1, 3, 1, 1099.99),
(1, 5, 2, 249.98),
(2, 2, 2, 899.98),
(3, 6, 1, 199.98),
(4, 8, 2, 649.98),
(5, 1, 2, 1599.98),
(6, 5, 1, 79.99),
(6, 10, 1, 49.99),
(7, 7, 2, 499.98),
(7, 9, 1, 49.99),
(8, 4, 3, 149.97),
(9, 11, 2, 249.98),
(10, 8, 2, 599.98),
(11, 13, 1, 99.98),
(12, 1, 1, 799.99),
(13, 2, 1, 349.99),
(13, 9, 2, 99.98),
(14, 5, 1, 79.99),
(14, 17, 1, 49.99),
(15, 18, 2, 459.97),
(16, 20, 1, 599.98),
(17, 3, 1, 1099.99),
(18, 10, 1, 49.99),
(18, 12, 1, 59.99),
(19, 6, 1, 249.99),
(19, 13, 1, 89.99),
(20, 16, 2, 99.98),
(20, 14, 1, 699.99),
(21, 1, 2, 1599.98),
(22, 4, 3, 149.97),
(23, 3, 1, 1099.99),
(24, 19, 1, 89.99),
(25, 5, 3, 239.97),
(26, 7, 2, 499.98),
(27, 8, 1, 399.99),
(27, 11, 1, 349.99),
(28, 12, 2, 119.98),
(28, 20, 1, 599.99),
(29, 2, 1, 499.99),
(30, 9, 1, 49.99),
(30, 6, 2, 399.98),
(31, 8, 1, 399.99),
(31, 18, 1, 229.99),
(32, 13, 3, 269.97),
(33, 15, 1, 899.99),
(34, 14, 2, 1399.98),
(35, 19, 1, 89.99),
(36, 17, 3, 149.97),
(37, 10, 2, 99.98),
(37, 11, 1, 349.99),
(38, 5, 2, 159.98),
(38, 2, 1, 349.99),
(39, 3, 1, 1099.99),
(39, 12, 2, 119.98),
(40, 4, 3, 149.97),
(40, 16, 1, 599.99);

select * from Cliente;

INSERT INTO Funcionario (Nome, Email, Cargo, DataContratacao)
Values ('Simão Cardoso', 'simao.teste@gmail.com', 'Vendedor', '2025-05-01');

update Cliente
set Telefone = '915923677'
where ID = '19';

select * from Funcionario;


select * from produto
