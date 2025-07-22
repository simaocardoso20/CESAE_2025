-- 4.a
SELECT Nome FROM Cliente
WHERE Email LIKE '%gmail%' AND Contacto LIKE '91%' OR Contacto LIKE '96%';

-- 4.b
SELECT Titulo FROM Livro
WHERE Titulo LIKE '% de %' OR Titulo LIKE '% do %' OR Titulo LIKE '% da %';

-- 4.c
SELECT Emprestimo.ID, Cliente.Nome AS NomeCliente, Livro.Titulo AS TituloLivro, Emprestimo.Data_Emprestimo, Emprestimo.Data_Devolucao, 
DATEDIFF(CURDATE(), Data_Emprestimo) AS Dias FROM Emprestimo
JOIN Cliente ON Emprestimo.ClienteID = Cliente.ID
JOIN Livro ON Emprestimo.LivroID = Livro.ID
WHERE Data_Devolucao IS NULL; 

-- 4.d
SELECT CONCAT(Livro.Titulo, ', ', Autor.Nome) AS 'Livro e Autor' FROM Livro
JOIN Autor ON Livro.AutorID = Autor.ID;

-- 4.e
SELECT YEAR(Data_Emprestimo) AS Ano,
COUNT(*) AS Total_Emprestimos FROM emprestimo
GROUP BY YEAR(Data_Emprestimo) ORDER BY ano;

-- 4.f
SELECT Editora.Nome AS Editora,
COUNT(Livro.ID) AS Quantidade_Livros FROM Editora
JOIN Livro ON Livro.EditoraID = Editora.ID
GROUP BY Editora.ID, Editora.Nome HAVING COUNT(Livro.ID) > 3
ORDER BY Quantidade_Livros DESC;

-- 4.g
SELECT Livro.Titulo AS Titulo, Autor.Nome AS Autor, Autor.Pais AS Pais FROM Livro
JOIN Autor ON Livro.AutorID = Autor.ID
WHERE Autor.Pais IN ('EUA', 'Portugal')
ORDER BY Autor.Nome ASC;

-- 4.h
SELECT Genero.Tipo AS Genero, 
COUNT(Livro.ID) AS Quantidade_Livros FROM Livro
JOIN Genero ON Livro.GeneroID = Genero.ID
GROUP BY Genero.ID, Genero.Tipo
ORDER BY Quantidade_Livros DESC;

-- 4.i
SELECT Editora.Nome AS Editora, Genero.Tipo AS Genero FROM Livro
JOIN Editora ON Livro.EditoraID = Editora.ID
JOIN Genero ON Livro.GeneroID = Genero.ID
GROUP BY Editora.ID, Genero.ID, Editora.Nome, Genero.Tipo
ORDER BY Editora.Nome, Genero.Tipo;

-- 4.j
SELECT Autor.Nome AS Autor,
COUNT(Emprestimo.ID) AS Total_Emprestimos FROM Emprestimo
JOIN Livro ON Emprestimo.LivroID = Livro.ID
JOIN Autor ON Livro.AutorID = Autor.ID
WHERE Autor.Pais != 'EUA'
GROUP BY Autor.ID, Autor.Nome
ORDER BY Total_Emprestimos DESC
LIMIT 3;

-- 4.k
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

-- 5.c
DELIMITER $$
CREATE PROCEDURE livrosMaisEmprestados(IN Mais_Emprestados VARCHAR (100))
BEGIN
SELECT genero.Tipo AS Genero, livro.Titulo AS Livro, COUNT(emprestimo.LivroID) AS TotalEmprestimos FROM Livro
JOIN Genero ON livro.GeneroID = genero.ID
LEFT JOIN Emprestimo ON emprestimo.LivroID = livro.ID
GROUP BY genero.ID, genero.Nome, livro.ID, livro.Titulo
HAVING COUNT(emprestimo.LivroID) = (SELECT MAX(sub.TotalEmprestimos) FROM (SELECT COUNT(e2.LivroID) AS TotalEmprestimos FROM Livro l2
LEFT JOIN Emprestimo e2 ON e2.LivroID = l2.ID 
WHERE l2.GeneroID = g.ID
GROUP BY l2.ID
        ) AS sub
    )
ORDER BY g.Nome, TotalEmprestimos DESC;
END $$

DELIMITER ;


