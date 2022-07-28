use empregados_db;
/* Pesquisa com relacionamento INNER JOIN */
SELECT * FROM empregado
INNER JOIN dependente
ON empregado.cod_empregado = dependente.cod_empregado
WHERE empregado.nome LIKE "%Zetti%";

/* Pesquisa com relacionamento LEFT JOIN */
SELECT * FROM empregado e
LEFT JOIN dependente d
ON e.cod_empregado = d.cod_empregado
WHERE e.salario > 5000;

/* Pesquisa com RIGHT JOIN */
SELECT * FROM empregado e
RIGHT JOIN dependente d
ON e.cod_empregado = d.cod_empregado;

/* Pesquisa com CROSS JOIN */
SELECT * FROM empregado e
CROSS JOIN dependente d;

SELECT emp.nome, IFNULL(dep.nome, "sem dependente") AS dependente,
IF(dep.dt_nascimento < "2005-01-01", "quase maior", "dep menor") AS estatus /* Condição, If, Else*/
FROM empregado emp 
RIGHT JOIN dependente dep
ON emp.cod_empregado = dep.cod_empregado;

/*Exercício JOINs*/
/*Monte um filtro que liste todos os empregados da empresa,
neste filtro deverá ter uma coluna onde mostre o numero de dependentes, os
empregados sem dependetes deve aparecer 0 e em um próxima coluna
deve aparecer o IRPF onde os empregdos com dependentes tem mensagem Com Abatimento e os
sem Sem Abatimento.
*/

SELECT e.nome AS empregado, IFNULL(COUNT(d.cod_dep), 0) AS dependente,
IF(COUNT(d.cod_dep)<=0, "Sem Abatimento", "Com Abatimento") AS IRPF
FROM empregado e
LEFT JOIN dependente d
ON e.cod_empregado = d.cod_empregado
GROUP BY e.nome
ORDER BY e.nome;