USE empregados_db;
/* Cript de testes no banco. */
SELECT * FROM departamento;
SELECT * FROM empregado;
SELECT * FROM dependente;
SELECT * FROM log_empregado;

DELIMITER //
CREATE PROCEDURE sps_verifica_log_salario(
IN dt_busca_init DATETIME,
IN dt_busca_fim DATETIME
)
BEGIN
	SELECT cod_log, cod_empregado, dt_alteracao, valor_antigo, valor_novo, correcao_legal, cod_correcao
    FROM log_empregado WHERE dt_alteracao BETWEEN dt_busca_fim AND dt_busca_init
    AND NOT ISNULL(valor_antigo);
END 
//
DELIMITER ;
DELIMITER //
CREATE PROCEDURE sps_verifica_log_departamento(
IN dt_busca_init DATETIME,
IN dt_busca_fim DATETIME
)
BEGIN
	SELECT cod_log, cod_empregado, dt_alteracao, cod_correcao, depto_novo, depto_antigo
    FROM log_empregado WHERE dt_alteracao BETWEEN dt_busca_fim AND dt_busca_init
    AND NOT ISNULL(depto_novo);
END
//
DELIMITER ;
DELIMITER //
CREATE PROCEDURE verifica_inss_empregado(
IN inss DECIMAL(10,2),
IN init_salario DECIMAL(10,2),
IN fim_salario DECIMAL(10,2)
)
BEGIN
	CREATE TEMPORARY TABLE tmp_inss_calculo
    AS
    SELECT cod_empregado,  nome AS empregado, salario AS renda_bruta, (salario * inss) AS desconto
    FROM empregado WHERE salario BETWEEN init_salario AND fim_salario;
    
    CREATE TEMPORARY TABLE tmp_inss_dependentes
    AS
    SELECT inss.cod_empregado, inss.empregado, inss.renda_bruta, inss.desconto, COUNT(dep.cod_dep) AS dependentes
    FROM tmp_inss_calculo inss, dependente dep
    WHERE inss.cod_empregado = dep.cod_empregado
    GROUP BY inss.empregado;
    
    SELECT * FROM tmp_inss_dependentes;
    
    DROP TABLE tmp_inss_dependentes;
    DROP TABLE tmp_inss_calculo;
END
//
DELIMITER ;
CALL sps_verifica_log_salario(NOW(),"2022-07-29");
CALL sps_verifica_log_departamento(NOW(), "2022-07-30");
CALL verifica_inss_empregado(0.12, 2427.36, 3641.03);
CALL verifica_inss_empregado(0.14, 3641.04, 7087.22);

