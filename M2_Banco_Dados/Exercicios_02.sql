Select * from Empregado;

Select IDEmpregado, NomeEmpregado
from Empregado
order by DataAdmissao

Select IDEmpregado,
		NomeEmpregado,
		Cargo,
		IDGerente,
		DataAdmissao,
		Salario,
		IDDepartamento
from Empregado 
where Comissao is null
order by salario


Select IDEmpregado,
		NomeEmpregado,
		(salario * 13) as SalarioAnual,
		(comissao * 12) as ComissaoAnual,
		((salario * 13) + ISNULL(comissao * 12,0)) as RendaAnual
from Empregado


Select IDEmpregado,
		NomeEmpregado,
		Cargo,
		salario as SalarioAnual
from Empregado
where (salario * 13) < 18500 or cargo = 'Atendente'