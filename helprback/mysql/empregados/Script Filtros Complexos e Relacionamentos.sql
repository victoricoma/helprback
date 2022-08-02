use empregados_db;
/* Filtro com Relacionamento de Chaves */
SELECT * FROM empregado e, departamento d WHERE d.cod_depto = e.cod_depto;
SELECT * FROM dependente d, empregado e WHERE e.cod_empregado = d.cod_empregado;
/* Filtros com Relacionamentos Complexos (Subquery) */
SELECT d.nome AS Dependente, e.nome AS Empregado, e.salario AS Renda
FROM dependente d, empregado e WHERE d.cod_empregado IN (
	SELECT cod_empregado FROM empregado WHERE salario BETWEEN 2000 AND 5000
) AND d.cod_empregado = e.cod_empregado;
/* Ordenação dor atributo */
SELECT * FROM empregado WHERE salario > 3000
ORDER BY nome;
SELECT * FROM empregado WHERE 
salario > 3000
AND
FLOOR(DATEDIFF(NOW(), dt_admissao)/365) >10
ORDER BY
FLOOR(DATEDIFF(NOW(), dt_nascimento)/365);

/* Agrupamento por relacionamento */
SELECT depto.nome, COUNT(emp.cod_empregado) AS n_empregados 
FROM departamento depto, empregado emp
WHERE 
depto.cod_depto = emp.cod_depto
GROUP BY depto.nome;

/* Agrupamento por relacionamento ordenado */
SELECT depto.nome, COUNT(emp.cod_empregado) AS n_empregados 
FROM departamento depto, empregado emp
WHERE 
depto.cod_depto = emp.cod_depto
GROUP BY depto.nome
ORDER BY n_empregados ASC;

/* Exercício de Agrupamento e Relacionamento */
SELECT emp.nome AS empregado, COUNT(dep.cod_dep) AS n_dependentes, 
emp.salario AS salario, FLOOR(DATEDIFF(NOW(), emp.dt_nascimento)/365) AS idade,
FORMAT(emp.salario / (COUNT(dep.cod_dep)+1), 2) AS media_renda
FROM empregado emp, dependente dep
WHERE emp.cod_empregado = dep.cod_empregado
GROUP BY emp.nome
ORDER BY n_dependentes;