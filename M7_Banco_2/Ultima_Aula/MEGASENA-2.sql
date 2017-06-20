/*
  2 - Liste os estados com maior número de apostas, e maior valor arrecadado em cada concurso. 
Adicionalmente também deve ser exibido o total de acertadores e o valor da premiação em cada estado.
*/

SELECT cidade.UF, concurso.IDConcurso, 
SUM(aposta.IDAposta) Numero_Apostas , SUM(aposta.Valor) Valor_Arrecadado, 
                                      SUM(premiada.IDAposta_Premiada) Acertadores, 
                                      SUM(premiada.Valor) Premiacao
FROM Aposta aposta
JOIN Concurso concurso ON concurso.IDConcurso = aposta.IDConcurso -- apostar por concurso
JOIN Cidade cidade ON aposta.IDCidade = cidade.IDCidade --cidade para pegar o uf
LEFT JOIN Aposta_Premiada premiada ON premiada.IDAposta = aposta.IDAposta --pegar só premiados
GROUP BY concurso.IDConcurso, cidade.UF; -- agrupar cada concurso e cada UF