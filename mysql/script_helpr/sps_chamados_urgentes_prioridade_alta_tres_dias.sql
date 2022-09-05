use helpr_bda;

DELIMITER //
CREATE PROCEDURE sps_chamados_urgentes_prioridade_alta_tres_dias(
IN chamado INT,
IN dt_hoje DATE
)
BEGIN
	CREATE TEMPORARY TABLE tmp_chamados_urgentes_prioridade_alta_tres_dias
    AS
		SELECT * FROM chamado WHERE prioridade = 2
        AND status != 2 AND (data_abertura BETWEEN (dt_hoje - INTERVAL 3 DAY) AND dt_hoje);
    SELECT * FROM tmp_chamados_urgentes_prioridade_alta_tres_dias;
    DROP TABLE tmp_chamados_urgentes_prioridade_alta_tres_dias;
    END //
    DELIMITER ;
    
   CALL sps_chamados_urgentes_prioridade_alta_tres_dias(2, "2022-08-27");   
    
    