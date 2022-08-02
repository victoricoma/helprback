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

//
DELIMITER ;
CALL sps_verifica_log_salario(NOW(),"2022-07-29");
