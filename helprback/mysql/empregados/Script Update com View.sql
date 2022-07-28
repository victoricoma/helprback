use empregados_db;

CREATE OR REPLACE VIEW vw_imposto_renda
AS
SELECT e.nome AS empregado,
COUNT(d.cod_dep) AS n_dependente,
(e.salario * 13) AS renda,
FORMAT((e.salario * 13) *(COUNT(d.cod_dep) * 0.2), 2) AS abatimento 
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
UPDATE empregado SET dt_nascimento = "1982-10-19", sexo = "F" WHERE cod_empregado=2;
ROLLBACK;
COMMIT;


