-- ex.-a.1
SELECT * FROM produto;

-- ex.-a.2
SELECT ID, ClienteID, FuncionarioID, DataVenda, Total FROM venda;

-- ex.-b.1
SELECT nome AS Produto, preco AS Preço
FROM produto;

-- ex-b.2
SELECT Nome, Cargo AS Função
FROM Funcionario;

-- ex-c.1
SELECT Nome, Preco, (Preco * 0.9) AS Precocomdescontode10
FROM produto;

-- ex-c.2
SELECT Nome, Preco, (Preco * 0.85) AS Precocomdescontode15
FROM produto;

-- ex-d.1
SELECT ID, DataVenda, DATEDIFF(CURRENT_DATE() , DataVenda) AS DiasDesdeVenda
FROM Venda;

-- ex-d.2
SELECT Nome, YEAR(DataNascimento) AS AnoNascimento
FROM Cliente;

-- ex-e.1
SELECT * FROM Funcionario
WHERE ID = 1;

-- ex-e.2
SELECT Nome, DataNascimento FROM Cliente
WHERE TIMESTAMPDIFF(YEAR, DataNascimento, CURRENT_DATE()) > 30
AND TIMESTAMPDIFF(YEAR, DataNascimento, CURRENT_DATE()) < 50;

-- ex-e.3
SELECT * FROM Venda
WHERE DataVenda BETWEEN '2023-01-01' AND '2023-03-31';

-- ex-f.1
SELECT * FROM Produto
WHERE CategoriaID IN (1, 2)
AND Stock > 10;

-- ex-g.1
SELECT * FROM Produto
WHERE Preco BETWEEN 100 AND 500;

-- ex-g.2
SELECT * FROM Venda
WHERE DataVenda BETWEEN '2023/01/01' AND '2023/03/01';

-- ex-g.3
SELECT Nome, DataNascimento FROM CLiente
WHERE TIMESTAMDIFF (YEAR, DataNascimento, CURRENT_DATE) >= 25
AND TIMESTAMDIFF (YEAR, CURRENT_DATE, DataNascimento) <= 40;

-- ex-h.1
SELECT ClienteID, DataVenda, Total FROM VENDA
WHERE ClienteID IN (1,5,7);
 
-- ex-h.2
SELECT Nome, Localidade FROM CLIENTE
WHERE Localidade IN ('Braga','Viseu','Coimbra');

-- ex-i.1
SELECT Nome, Preco, Stock FROM Produto
WHERE Nome LIKE '%Maquina%';

-- ex-i.2
SELECT * FROM CLIENTE
WHERE Nome LIKE 'A____ %';

-- ex-i.3
SELECT Nome, Email FROM CLIENTE
WHERE Email REGEXP '@(gmail|hotmail).com$';

-- ex-i.4
SELECT Nome, Preco, Stock FROM Produto
WHERE Nome REGEXP '^Ar|^As';

-- ex-j.1
SELECT CategoriaID, MAX(Preco) AS Preço_Máximo FROM produto
GROUP BY CategoriaID;

-- ex-j.2 
SELECT VendaID, COUNT(*) AS Quantidade FROM produtovenda
GROUP BY VendaID;

-- ex-k.1
SELECT FuncionarioID, SUM(Total) AS Total_Vendido FROM Venda
GROUP BY FuncionarioID
HAVING SUM(Total) > 600;

-- ex-k.2
SELECT CategoriaID, SUM(Stock) AS Total_Stock FROM Produto
GROUP BY CategoriaID
HAVING SUM(Stock) > 100;

-- ex-l.1
SELECT Nome, Preco, Stock FROM Produto
ORDER BY Preco ASC;

-- ex-l.2
SELECT Nome, DataNascimento FROM Cliente
ORDER BY DataNascimento DESC;

-- ex-m.1
SELECT Nome, Preco, Stock FROM Produto
ORDER BY Preco ASC
LIMIT 5;

-- ex-m.2
SELECT * FROM Venda
ORDER BY DataVenda DESC
LIMIT 10;

-- ex-m.3
SELECT * FROM Cliente
WHERE Nome LIKE 'A%'
LIMIT 5;

-- ex-n.1
SELECT Nome, Preco, Stock FROM produto
WHERE Preco BETWEEN 100 AND 500
ORDER BY preco ASC
LIMIT 10;

-- ex-n.2
SELECT FuncionarioID, COUNT(*) AS TotalVendas FROM Venda
GROUP BY FuncionarioID
HAVING COUNT(*) > 3
ORDER BY TotalVendas DESC;

-- ex-o.1
SELECT Cliente.Nome, Venda.DataVenda FROM Cliente
JOIN Venda ON Cliente.ID = Venda.ClienteID
WHERE Venda.DataVenda > '2023-03-01';

-- ex-o.2
SELECT Cliente.Nome AS NomeCliente, Funcionario.Nome AS NomeFuncionario, Venda.Total AS VendaTotal FROM Cliente
JOIN Venda ON Cliente.ID = Venda.ClienteID
JOIN Funcionario ON Funcionario.ID = Venda.FuncionarioID
ORDER BY Venda.Total DESC;

-- ex-o.3
SELECT Cliente.Nome AS NomeCliente, COUNT(Produtovenda.quantidade) AS TotalVendas FROM Cliente
JOIN Venda ON Cliente.ID = Venda.ClienteID
JOIN Produtovenda ON Venda.ID = Produtovenda.VendaID
GROUP BY Cliente.Nome
HAVING COUNT(Produtovenda.quantidade) > 2;

-- ex-o.4
SELECT Cliente.Nome AS NomeCliente, Produto.Nome AS NomeProduto, Produtovenda.Quantidade, Produtovenda.Subtotal, Produto.preco AS PrecoUnitario FROM Venda
JOIN Cliente ON Venda.ClienteID = Cliente.ID
JOIN Produtovenda ON Venda.ID = Produtovenda.VendaID
JOIN Produto ON Produtovenda.ProdutoID = Produto.ID
WHERE Produtovenda.Subtotal > 300 AND Produtovenda.Quantidade > 1 AND Venda.DataVenda > '2023-04-01'
ORDER BY Cliente.nome ASC
LIMIT 10;


 
 











