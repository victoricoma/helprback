use empregados_db;

CREATE OR REPLACE VIEW vw_imposto_renda
AS 
SELECT e.nome AS empregado,
COUNT(d.cod_dep) AS n_dependente,
(e.salario * 13) AS renda,
(e.salario * 13) *(COUNT(d.cod_dep) * 0.2) as abatimento
FROM empregado e
LEFT JOIN dependente d
ON e.cod_empregado = d.cod_empregado
GROUP BY e.nome;

SELECT * FROM empregado;
SELECT * FROM vw_imposto_renda;

START TRANSACTION;
UPDATE empregado SET nome = "Maria Massumy" WHERE cod_empregado=13;
UPDATE empregado SET nome = "Juliana Marcondes" WHERE cod_empregado=14;
ROLLBACK;
COMMIT;

START TRANSACTION;
UPDATE empregado SET dt_nascimento = "1982-10-19", sexo='F' WHERE cod_empregado=2;
ROLLBACK;
COMMIT;

SELECT *, IF(renda>50000,"IRPF alto","IRPF Normal") as faixa FROM vw_imposto_renda;

SELECT empregado,
CASE
	WHEN renda < 22848 THEN "Faixa1 [0]"
    WHEN renda < 33920 THEN "Faixa 2 [7,5]"
    WHEN renda < 45013 THEN "Faixa 3 [1]"
    WHEN renda < 55977 THEN "Faixa 4 [22,5]"
    ELSE "Faixa 5 [27,5]" 
END AS faixa,
(renda - abatimento) as renda_real
FROM vw_imposto_renda;

START TRANSACTION;
UPDATE empregado SET salario = 8200.30 WHERE cod_empregado=2;