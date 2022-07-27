use empregados_db;
/*Select sem filtragem de campos ou registros*/
SELECT * FROM departamento;
SELECT * FROM empregado;
SELECT * FROM dependente;
/*Select com modificações de campos*/
SELECT cod_dep, nome FROM dependente;
SELECT cod_empregado, nome, salario FROM empregado;
SELECT nome FROM departamento;
/*Select com filtros de registros*/
SELECT cod_depto, nome FROM departamento WHERE cod_depto > 4;
SELECT * FROM departamento WHERE cod_depto % 3 = 0;
SELECT cod_depto AS CÓDIGO FROM departamento WHERE cod_depto <> 5;
SELECT * FROM departamento WHERE cod_depto <> 5 AND nome <> "Comercial";
SELECT (cod_depto * 5) AS COD_BASE FROM departamento WHERE (cod_depto + 1) <> 5 AND nome <> "Comercial";
SELECT * FROM dependente WHERE nome LIKE "%Ana%";
SELECT * FROM empregado WHERE salario BETWEEN 2100 AND 5400;
SELECT * FROM empregado WHERE NOT salario > 5000;
SELECT * FROM empregado WHERE NOT cod_depto = 2;
SELECT * FROM empregado WHERE cod_depto = 2 OR salario > 5000;
SELECT * FROM empregado WHERE cod_empregado IN(2, 3, 4);
SELECT MIN(salario) AS MENOR FROM empregado;
SELECT MAX(salario) AS MENOR FROM empregado;
SELECT * FROM empregado LIMIT 10;
SELECT COUNT(cod_empregado) AS FAIXA_2 FROM empregado WHERE salario BETWEEN 2000 AND 3000;
SELECT SUM(salario) AS FOLHA FROM empregado WHERE salario BETWEEN 2000 AND 3000;
SELECT floor(AVG(salario)) AS AVERIGUAR FROM empregado WHERE salario BETWEEN 2000 AND 3000;
SELECT nome, FLOOR((DATEDIFF(now(), dt_nascimento) / 365)) AS IDADE FROM empregado;
SELECT MIN(FLOOR((DATEDIFF(now(), dt_admissao)/365))) AS ADMISSÃO FROM empregado;


