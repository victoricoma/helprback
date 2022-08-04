use empregados_db;
/* Filtro com Relacionamento de Chaves */
SELECT * FROM empregado e, departamento d WHERE d.cod_depto = e.cod_depto;
SELECT * FROM dependente d, empregado e WHERE e.cod_empregado = d.cod_empregado;
/* Filtros com Relacionamentos Complexos (Subquery) */
SELECT d.nome AS Dependente, e.nome AS Empregado, e.salario AS Renda
FROM dependente d, empregado e WHERE d.cod_empregado IN (
	SELECT cod_empregado FROM empregado WHERE salario BETWEEN 2000 AND 5000
) AND d.cod_empregado = e.cod_empregado;
SELECT * FROM empregado WHERE salario > 3000
ORDER BY salario;
SELECT * FROM empregado WHERE
salario > 3000 AND FLOOR(datediff(NOW(), dt_admissao)/365) > 10
ORDER BY
FLOOR(DATEDIFF(NOW(), dt_nascimento)/365);

SELECT depto.nome, COUNT(emp.cod_empregado) AS N_Empregados FROM departamento depto, empregado emp WHERE depto.cod_depto = emp.cod_depto GROUP BY depto.nome ORDER BY COUNT(emp.cod_empregado);
SELECT emp.nome, COUNT(dep.cod_empregado) AS N_dependentes, emp.salario, FLOOR(datediff(NOW(), emp.dt_nascimento)/365) AS Idade, FORMAT(emp.salario / (COUNT(dep.cod_dep)+1), 2) AS media_renda FROM empregado emp, dependente dep WHERE emp.cod_empregado = dep.cod_empregado GROUP BY emp.nome ORDER BY n_dependentes;
