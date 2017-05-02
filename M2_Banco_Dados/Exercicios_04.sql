/*
1 - Liste todos os projetos que tiveram atrasos no in�cio da obra, exibir tamb�m o tempo previsto 
(em meses), e o tempo realizado (em meses) para a conclus�o da obra.
*/

SELECT
	Projeto, 
	DATEDIFF (day, Data_Inicio_Prev,Data_Inicio_Real) as [Dias de Atraso], 
	DATEDIFF (month, Data_Inicio_Prev,Data_Fim_Prev) as [Tempo Previsto (meses)],
	DATEDIFF (month, Data_Inicio_Real,Data_Fim_Real) as [Tempo Real (meses)]
	FROM Licitacao
	WHERE Data_Inicio_Real > Data_Inicio_Prev
	ORDER BY (DATEDIFF (day, Data_Inicio_Prev,Data_Inicio_Real));

/*
2 - Liste as TOP 10 empresas que tiveram maior faturamento, deve ser projetado tamb�m 
o valor m�dio por profissional.
*/

SELECT TOP 10
	Empresa_Licitante,
	(SUM(Valor_Realizado)) as [Faturamento Total (R$)],
	(SUM(Valor_Realizado)) / SUM(Profissionais) as [Valor M�dio Profissional]
	FROM Licitacao
	GROUP BY Empresa_Licitante
	ORDER BY [Faturamento Total (R$)] desc

/*
3 - Liste as TOP 10 cidades com maior arreca��o de impostos.
*/

SELECT TOP 10
	Municipio,
	Estado,
	SUM (Imposto_Municipal) as [Total Arrecada��o]
	FROM Licitacao
	GROUP BY Municipio, Estado
	ORDER BY [Total Arrecada��o] desc;

/*
4 - Liste todos os projetos que tiveram a data de in�cio (real) ocorrendo em finais de semana (s�bado ou domingo).
*/

SELECT
	Projeto,
	DATENAME(dw,Data_Inicio_Real)
	FROM Licitacao
	WHERE ((DATEPART (dw, Data_Inicio_Real) = 7) or (DATEPART (dw, Data_Inicio_Real) = 1));

/*
5 - Liste todas as empresas que tiveram (ou ter�o) um faturamento (valor previsto) superior a 50% do seu faturamento no ano anterior.
*/

SELECT
	Empresa_Licitante,
	SUM (Valor_Previsto) as [Faturamento Ano Atual],
	MAX(Faturamento_1Ano_Anterior) as [Faturamento Ano Anterior],
	((SUM (Valor_Previsto)) * 100) / MAX(Faturamento_1Ano_Anterior) as [% em rela��o ao ano passado]
	FROM Licitacao
	GROUP BY Empresa_Licitante
	HAVING ((SUM (Valor_Previsto)) * 100) / MAX(Faturamento_1Ano_Anterior) > 50
	ORDER BY [% em rela��o ao ano passado] desc

/*
6 - Liste os projetos exibindo o custo real do projeto. Caso o projeto seja de esfera federal deve ser descontado o imposto federal, 
e assim respectivamente para as esferas estaduais e municipais.
*/

SELECT 
	Projeto,
	CASE Esfera
		WHEN 'Federal' THEN Valor_Realizado - Imposto_Federal
		WHEN 'Estadual' THEN Valor_Realizado - Imposto_Estadual
		WHEN 'Municipal' THEN Valor_Realizado - Imposto_Municipal
	END as [Custo_Real]
	FROM Licitacao
	ORDER BY [Custo_Real] desc

/*
7 - O projeto 17255 foi suspenso, o motivo foi o elevado custo para o or�amento anual do munic�pio. A partir de uma investiga��o mais 
detalhada foi visto que esse motivo n�o era a verdadeira raz�o. Explique por que este motivo n�o � v�lido apresentando uma consulta com dados.
*/

SELECT 
	Projeto,
	Solicitante,
	Esfera,
	Municipio,
	Estado,
	Valor_Previsto as [Valor Previsto],
	Lance_2Colocado as [Lance 2 Colocado],
	Lance_2Colocado - Valor_Previsto as [Diferenca Entre Lances],
	Empresa_Licitante as [Beneficiada]
	FROM Licitacao
	WHERE Projeto = 'Escola T�cnica Bento Gon�alves' and
		Solicitante = 'Secretaria de Educacao' and
		Esfera = 'Estadual' and
		Municipio = 'Caxias do Sul' and
		Estado = 'RS'