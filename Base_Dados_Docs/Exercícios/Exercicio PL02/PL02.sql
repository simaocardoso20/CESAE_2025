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


