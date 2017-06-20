/*
   3)  Crie uma view para consultar possibilidades de fraudes. Inicialmente identifique apostas com registro (log) de 
criação/alteração executado após a data do sorteio.
*/

SELECT * 
FROM LogAposta_Operacao logApostas
JOIN Concurso c ON c.IdConcurso = logApostas.IdConcursoNovo
WHERE logApostas.DataNovo > c.Data_Sorteio;