DELIMITER //
CREATE PROCEDURE sps_chamados_urgentes_prioridade_alta_tres_dias(
IN urgenteidtecnico INT,
IN dt_hoje DATE
)
BEGIN
	CREATE TEMPORARY TABLE tmp_chamados_urgentes_prioridade_alta_tres_dias
    AS
		SELECT * FROM chamado WHERE prioridade = 2
        AND status <> 2 AND (data_abertura BETWEEN (dt_hoje - INTERVAL 3 DAY) AND dt_hoje)
        AND tecnico_id = urgenteidtecnico;
    SELECT * FROM tmp_chamados_urgentes_prioridade_alta_tres_dias;
    DROP TABLE tmp_chamados_urgentes_prioridade_alta_tres_dias;
    END //
    DELIMITER ;
    
   CALL sps_chamados_urgentes_prioridade_alta_tres_dias(3, "2022-09-06");
    
    