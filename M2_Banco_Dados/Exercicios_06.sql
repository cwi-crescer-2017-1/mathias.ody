/*
1 - Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
*/

CREATE VIEW VwPrimeiroNome as 
	SELECT SUBSTRING (Nome, 1,CHARINDEX (' ', Nome)) as [Primeiro Nome]
	FROM Cliente

SELECT TOP 1
	[Primeiro Nome],
	COUNT ([Primeiro Nome]) as Ocorrencias 
	FROM VwPrimeiroNome
	GROUP BY [Primeiro Nome]
	ORDER BY Ocorrencias desc
	
/*
2 - Liste o total de pedidos (quantidade e valor) realizados no mês de abril/2017.
*/

SELECT
	COUNT (IDPedido) as Pedidos,
	SUM (ValorPedido) as [Valor Total]
	FROM Pedido
	WHERE MONTH (DataPedido) = 4 and YEAR (DataPedido) = 2017;

/*
3 - Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de 
clientes (tabela Cliente), liste também qual o Estado possuí o menor número de clientes.
*/

SELECT TOP 1
	cid.UF,
	COUNT (cid.UF) as Clientes
	FROM Cliente cli
	INNER JOIN Cidade cid ON cid.IDCidade = cli.IDCidade
	GROUP BY cid.UF
	ORDER BY Clientes desc;
SELECT TOP 1
	cid.UF,
	COUNT (cid.UF) as Clientes
	FROM Cliente cli
	INNER JOIN Cidade cid ON cid.IDCidade = cli.IDCidade
	GROUP BY cid.UF
	ORDER BY Clientes;

/*
4 - Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
Nome: Galocha Maragato
Preço de custo: 35.67
Preço de venda: 77.95
Situação: A
*/

INSERT INTO Produto
	(Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao)
VALUES(
	'Galocha Maragato',
	getdate(),
	35.67,
	77.95,
	'A'
	)

/*
5 - Identifique e liste os produtos que não tiveram nenhum pedido, considere os 
relacionamentos no modelo de dados, pois não há relacionamento direto entre Produto 
e Pedido (será preciso relacionar PedidoItem).
*/
		
SELECT 
	p.IDProduto,
	p.Nome
	FROM Produto p
	WHERE NOT EXISTS (SELECT ped.IDProduto
					FROM PedidoItem ped
					WHERE p.IDProduto = ped.IDProduto) -- por que precisa do where?

/*
6 - Liste os 30 produtos que mais geraram lucro em 2016.
*/

SELECT TOP 30
		prod.IDProduto as ID,
		prod.Nome,
		SUM (item.Quantidade) *(MAX (prod.PrecoVenda) - MAX (prod.PrecoCusto)) as [TotalVendas(R$)],
		MAX (prod.PrecoVenda) - MAX (prod.PrecoCusto) as [Lucro p/ item],
		SUM (item.Quantidade) as [Total Vendidos]
		FROM PedidoItem item
		INNER JOIN Produto prod ON prod.IDProduto = item.IDPedido
		INNER JOIN Pedido pedido ON item.IDPedido = pedido.IDPedido
		WHERE year (pedido.DataPedido) = 2016 --filtro
		GROUP BY prod.IDProduto, prod.Nome
		ORDER BY [TotalVendas(R$)] DESC