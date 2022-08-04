use empregados_db;
/* Filtro com Relacionamento de Chaves */
SELECT * FROM empregado e, departamento d WHERE d.cod_depto = e.cod_depto;
SELECT * FROM dependente d, empregado e WHERE e.cod_empregado = d.cod_empregado;
/* Filtros com Relacionamentos Complexos (Subquery) */
SELECT d.nome AS Dependente, e.nome AS Empregado, e.salario AS Renda
FROM dependente d, empregado e WHERE d.cod_empregado IN (
	SELECT cod_empregado FROM empregado WHERE salario BETWEEN 2000 AND 5000
) AND d.cod_empregado = e.cod_empregado;