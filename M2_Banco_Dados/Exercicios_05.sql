/*
1 - Liste o nome do empregado, o nome do gerente e o departamento de cada um.
*/

SELECT * FROM Empregado; 

SELECT e.NomeEmpregado,
	   g.NomeEmpregado as NomeGerente,
	   d.NomeDepartamento
	   FROM Empregado e
	   INNER JOIN Departamento d ON e.IDDepartamento = d.IDDepartamento
	   INNER JOIN Empregado g ON g.IDEmpregado = e.IDGerente;

/*
2 - Liste o deparamento (id e nome) com o empregado de maior salário.
*/

SELECT DISTINCT
	d.IDDepartamento,
	d.NomeDepartamento
	FROM  Empregado e
	INNER JOIN Departamento d ON e.IDDepartamento = d.IDDepartamento
	WHERE e.Salario IN (SELECT MAX(Salario)
						 FROM Empregado
						 WHERE (IDDepartamento IS NOT NULL))

/*
3 - Aplique uma alteração salarial em todos os empregados que o departamento fique na localidade de SAO PAULO, este reajuste 
deve ser de 17,3%. Por segurança faça uma cópia da tabela Empregado antes de iniciar esta tarefa.
*/


BEGIN TRANSACTION
UPDATE Empregado
	SET Salario = e.Salario + (Salario * 0.173)
	FROM Empregado e
	INNER JOIN Departamento d ON d.IDDepartamento = e.IDDepartamento
	WHERE d.Localizacao = 'SAO PAULO' 

COMMIT

/*
4 - Liste todas as cidades duplicadas (nome e UF iguais).
*/

SELECT
	Nome as [Nome da Cidade],
	UF
	FROM Cidade
	GROUP BY Nome, UF
	HAVING COUNT (1) > 1

/*
5 A - Faça uma alteraçao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. 
Mas atenção! apenas a cidade com maior ID deve ser alterada.
*/

UPDATE Cidade
	SET Nome = Nome + '*'
	FROM Cidade c
	WHERE IDCidade IN (SELECT DISTINCT MAX(IDCidade)
					  FROM Cidade
					  GROUP BY Nome, UF
					  HAVING COUNT (*) > 1);