SELECT *
INTO CidadeAux 
FROM Cidade;

SELECT * FROM CidadeAux;

TRUNCATE TABLE CidadeAux;

INSERT INTO CidadeAux (IDCidade, Nome, UF)
SELECT * FROM Cidade WHERE UF = 'RS';
/*
1. É uma boa prática escrever todos os nomes no select:
INSERT INTO CidadeAux (IDCidade, Nome, UF)
	SELECT IDCidade, Nome, UF 
	FROM Cidade 
	WHERE UF = 'RS';

2. Os tipos precisam ser iguais, os nomes não, mas precisam ser os mesmos nomes da tabela:
Ex:
	INSERT INTO CidadeAux (IDCidade, Nome, UF)
	SELECT ID, AlgumNome, ESTADO -- A tabela precisa ter esse nomes
	FROM Cidade 
	WHERE UF = 'RS';

3. Pode-se mudar um dos valores, nesse exemplo, o UF
Ex:
	INSERT INTO CidadeAux (IDCidade, Nome, UF)
	SELECT IDCidade, Nome, 'RJ' 
	FROM Cidade 
	WHERE UF = 'RS';
*/

INSERT INTO CidadeAux (IDCidade, Nome, UF)
	SELECT IDCidade, Nome, 'RJ' 
	FROM Cidade 
	WHERE UF = 'RS';


CREATE TABLE InfoProdutos (
IDProduto		int identity			NOT NULL,
Nome			varchar(15)			NOT NULL,
NomeDescritivo		varchar (40)			NOT NULL,
DataCriacao		date				NOT NULL,
LocalEstoque		varchar (20)			NOT NULL,
Quantidade		int				NOT NULL,
Preco			smallmoney			NOT NULL
)

/*
- ID deve ser identity
- Idealmente, deve-se iniciar com chave primaria
- Pode-se usar dados mais primitivos
CREATE TABLE InfoProdutos (
IDProduto		int identity		NOT NULL,
Nome			varchar(20)			NOT NULL,
NomeDescritivo	varchar (60)		NOT NULL,
LocalEstoque	varchar (20)		NOT NULL,
DataCriacao		date				NOT NULL,
Quantidade		decimal (7,3)		NOT NULL,
Preco			decimal (9,2)		NOT NULL
)
*/

SELECT * FROM InfoProdutos

ALTER TABLE InfoProdutos ADD
	CONSTRAINT PK_InfoProdutos primary key (IDProduto)


INSERT INTO InfoProdutos(
	Nome, 
	NomeDescritivo, 
	LocalEstoque, 
	DataCriacao, 
	Quantidade, 
	Preco)
VALUES (
	'Farinh',
	'Farinha de mandioca 1KG',
	'Deposito Sul',
	getdate(),
	1,
	3.49 ) 

INSERT INTO InfoProdutos(
	Nome, 
	NomeDescritivo, 
	LocalEstoque, 
	DataCriacao, 
	Quantidade, 
	Preco)
VALUES (
	'Batata',
	'Batata Rosa KG',
	'Deposito Sul',
	getdate(),
	2,
	2.49 ) 

	-- Convesão de data
	-- 103= dd/mm/aaaa
SELECT CONVERT (DATETIME, '13/05/2017', 103)
