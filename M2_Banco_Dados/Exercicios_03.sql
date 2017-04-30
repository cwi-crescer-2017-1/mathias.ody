/*
1 - Faça uma consulta que liste o total de empregados admitidos no ano de 1980. 
Deve ser projetado nesta consulta: ID, Nome e Idade no momento da admissão.
*/

SELECT * FROM Empregado;

SELECT IDEmpregado, 
	NomeEmpregado, 
	datediff(year,DataNascimento,DataAdmissao) as data
	FROM Empregado
	WHERE DataAdmissao between '19800101' and '19801231';


/*
2 - Qual o cargo (tabela empregado) possui mais empregados ? Deve ser projetado apenas um registro. 
** DICA: Pesquise recursos específicos para esta funcionalidade.
*/

SELECT TOP 1 Cargo as [Cargo com Mais Empregados] FROM Empregado
	GROUP BY Cargo
	ORDER BY COUNT (*) DESC;


/*
3 - Liste os estados (atributo UF) e o total de cidades existente em cada estado na tabela cidade.
*/

SELECT UF, COUNT(UF) as Quantidade FROM Cidade
	GROUP BY UF
	--ORDER BY COUNT(UF) DESC;


/*
4 - Crie um novo departamento, denominado 'Inovação' com localização em 'SÃO LEOPOLDO'. 
Todos os empregados que foram admitidos no mês de dezembro (qualquer ano) que não ocupam o cargo de 
'Atendente' devem ser ter o departamento (IDDepartamento) atualizado para este novo registro (inovação).
*/

INSERT Departamento (IDDepartamento, NomeDepartamento, Localizacao)
values (100, 'Inovação', 'SÃO LEOPOLDO');

BEGIN TRANSACTION

UPDATE Empregado SET IDDepartamento = 100
	WHERE datepart (month, DataAdmissao) = 12 and
	Cargo != 'Atendente';


ROLLBACK

COMMIT