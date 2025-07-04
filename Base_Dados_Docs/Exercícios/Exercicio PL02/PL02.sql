-- 4.a
CREATE VIEW vw_clientes_gmail_91_96 AS
SELECT Nome, Email, Contacto FROM Cliente
WHERE Email LIKE '%gmail%' AND Contacto LIKE '91%' OR Contacto LIKE '96%';

-- 4.b
CREATE VIEW vw_livros_com_preposicoes_de_do_da AS
SELECT Titulo FROM Livro
WHERE Titulo LIKE '% de %' OR Titulo LIKE '% do %' OR Titulo LIKE '% da %';

-- 4.c
CREATE VIEW vw_emprestimos_ativos_por_devolver AS
SELECT Emprestimo.ID, Cliente.Nome AS NomeCliente, Livro.Titulo AS TituloLivro, Emprestimo.Data_Emprestimo, Emprestimo.Data_Devolucao, 
DATEDIFF(CURDATE(), Data_Emprestimo) AS Dias FROM Emprestimo
JOIN Cliente ON Emprestimo.ClienteID = Cliente.ID
JOIN Livro ON Emprestimo.LivroID = Livro.ID
WHERE Data_Devolucao IS NULL; 

-- 4.d
CREATE VIEW vw_livro_e_autor AS
SELECT CONCAT(Livro.Titulo, ', ', Autor.Nome) AS 'Livro e Autor' FROM Livro
JOIN Autor ON Livro.AutorID = Autor.ID;

-- 4.e
CREATE VIEW vw_total_emprestimos_por_ano AS
SELECT YEAR(Data_Emprestimo) AS Ano,
COUNT(*) AS Total_Emprestimos FROM emprestimo
GROUP BY YEAR(Data_Emprestimo) ORDER BY ano;

-- 4.f
CREATE VIEW vw_editoras_mais_3_livros AS
SELECT Editora.Nome AS Editora,
COUNT(Livro.ID) AS Quantidade_Livros FROM Editora
JOIN Livro ON Livro.EditoraID = Editora.ID
GROUP BY Editora.ID, Editora.Nome HAVING COUNT(Livro.ID) > 3
ORDER BY Quantidade_Livros DESC;

-- 4.g
CREATE VIEW vw_livros_autores_usa_portugal AS
SELECT Livro.Titulo AS Titulo, Autor.Nome AS Autor, Autor.Pais AS Pais FROM Livro
JOIN Autor ON Livro.AutorID = Autor.ID
WHERE Autor.Pais IN ('EUA', 'Portugal')
ORDER BY Autor.Nome ASC;

-- 4.h
CREATE VIEW vw_qtd_livros_por_genero AS
SELECT Genero.Tipo AS Genero, 
COUNT(Livro.ID) AS Quantidade_Livros FROM Livro
JOIN Genero ON Livro.GeneroID = Genero.ID
GROUP BY Genero.ID, Genero.Tipo
ORDER BY Quantidade_Livros DESC;

-- 4.i
CREATE VIEW vw_editoras_generos_disponiveis AS
SELECT Editora.Nome AS Editora, Genero.Tipo AS Genero FROM Livro
JOIN Editora ON Livro.EditoraID = Editora.ID
JOIN Genero ON Livro.GeneroID = Genero.ID
GROUP BY Editora.ID, Genero.ID, Editora.Nome, Genero.Tipo
ORDER BY Editora.Nome, Genero.Tipo;

-- 4.j
CREATE VIEW vw_top3_autores_requisitados_sem_eua AS
SELECT Autor.Nome AS Autor,
COUNT(Emprestimo.ID) AS Total_Emprestimos FROM Emprestimo
JOIN Livro ON Emprestimo.LivroID = Livro.ID
JOIN Autor ON Livro.AutorID = Autor.ID
WHERE Autor.Pais != 'EUA'
GROUP BY Autor.ID, Autor.Nome
ORDER BY Total_Emprestimos DESC
LIMIT 3;

-- 4.k
CREATE VIEW vw_emprestimos_livros_nao_devolvidos_antes_2021 AS
SELECT Livro.Titulo AS Titulo_Livro, Cliente.Nome AS Nome_Cliente, Cliente.Email AS Cliente_Email, Emprestimo.Data_Emprestimo FROM Emprestimo
JOIN Livro ON Emprestimo.LivroID = Livro.ID
JOIN Cliente ON Emprestimo.ClienteID = Cliente.ID
WHERE Emprestimo.Data_Devolucao IS NULL AND Emprestimo.Data_Emprestimo < '2021-01-01'
ORDER BY Emprestimo.Data_Devolucao ASC;

-- 5.a
DELIMITER $$
CREATE PROCEDURE procuraEmail (IN v_Email Varchar(50))
BEGIN
SELECT Cliente.Email FROM Cliente
WHERE Email LIKE CONCAT('%' , v_Email, '%');
END $$
DELIMITER ;

CALL procuraEmail('hotmail');

-- 5.b
DELIMITER $$
CREATE PROCEDURE procuraEmprestimosAtivos (IN Cliente_ID VARCHAR(70))
BEGIN
SELECT Emprestimo.ID AS EmprestimoID, Livro.Titulo AS Titulo_Livro, Emprestimo.Data_Emprestimo FROM Emprestimo
JOIN Livro ON Emprestimo.LivroID = Livro.ID
JOIN Cliente ON Emprestimo.ClienteID = Cliente.ID
WHERE Cliente.Nome = Cliente_ID AND Emprestimo.Data_Devolucao IS NULL
ORDER BY Emprestimo.Data_Emprestimo ASC;
END $$
DELIMITER ;

CALL procuraEmprestimosAtivos('Miguel Antunes');

-- 5.c
DELIMITER $$
CREATE PROCEDURE livrosMaisEmprestados(IN emprestados_Genero VARCHAR(100))
BEGIN
SELECT Genero.Tipo AS Genero, Livro.Titulo AS Livro, COUNT(Emprestimo.ID) AS TotalEmprestimos FROM Livro
JOIN Genero ON Livro.GeneroID = Genero.ID
LEFT JOIN Emprestimo ON Emprestimo.LivroID = Livro.ID
WHERE Genero.Tipo = emprestados_Genero OR emprestados_Genero IS NULL OR emprestados_Genero = ''
GROUP BY Genero.Tipo, Livro.Titulo
ORDER BY TotalEmprestimos DESC;
END $$
DELIMITER ;

CALL livrosMaisEmprestados('');

-- 5.d
DELIMITER $$
CREATE PROCEDURE registarNovoEmprestimo(IN p_LivroID INT, IN p_ClienteID INT, IN p_DataEmprestimo DATE)
BEGIN
IF NOT EXISTS (
    SELECT * FROM Emprestimo
    WHERE LivroID = p_LivroID AND Data_Devolucao IS NULL
) THEN
    INSERT INTO Emprestimo (LivroID, ClienteID, Data_Emprestimo, Data_Devolucao)
    VALUES (p_LivroID, p_ClienteID, p_DataEmprestimo, NULL);
END IF;
END $$
DELIMITER ;

CALL registarNovoEmprestimo(19, 18, '2020-12-09');


-- 6.a
DELIMITER $$
CREATE TRIGGER trg_cliente_email_invalido 
BEFORE INSERT ON Cliente
FOR EACH ROW
BEGIN
    IF NEW.email IS NULL OR NEW.email = '' THEN
	SET NEW.email = 'email_invalido@exemplo.com';
    END IF;
END $$
DELIMITER ;

-- 6.b
DELIMITER $$
CREATE TRIGGER trg_cliente_contacto_valido
BEFORE UPDATE ON Cliente
FOR EACH ROW
BEGIN
    IF LENGTH(NEW.Contacto) != 9 THEN
	SET NEW.Contacto = NULL;
    END IF;
END $$
DELIMITER ;

-- 6.c
DELIMITER $$
CREATE TRIGGER trg_livro_titulo_maiusculo
BEFORE INSERT ON Livro
FOR EACH ROW
BEGIN
    SET NEW.Titulo = UPPER(NEW.Titulo);
END $$
DELIMITER ;



