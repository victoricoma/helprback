use empregados_db;

SELECT * FROM empregado
INNER JOIN dependente
ON empregado.cod_empregado = dependente.cod_empregado
WHERE empregado.nome LIKE "%Zetti%";

SELECT * FROM empregado e
LEFT JOIN dependente d
ON e.cod_empregado = d.cod_empregado
WHERE e.salario > 5000;

SELECT * FROM empregado e
RIGHT JOIN dependente d
ON e.cod_empregado = d.cod_empregado;

SELECT * FROM empregado e
CROSS JOIN dependente d
ON e.cod_empregado = d.cod_empregado;

SELECT * FROM empregado e
CROSS JOIN dependente d;

SELECT emp.nome, IFNULL(dep.nome, "sem dependente") AS dependente,
IF(dep.dt_nascimento < "2005-01-01", "quase maior", "dep menor") AS estatus
FROM empregado emp LEFT JOIN dependente dep
ON emp.cod_empregado = dep.cod_empregado;

SELECT emp.nome, COUNT(dep.cod_empregado) AS N_dependentes, 
IF(COUNT(dep.cod_empregado) = 0, "Sem Abatimento", "Com Abatimento") AS IRPF 
FROM empregado emp LEFT JOIN dependente dep 
ON emp.cod_empregado = dep.cod_empregado
GROUP BY emp.nome;