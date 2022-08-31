use helpr_bda;

DELIMITER //
CREATE PROCEDURE sps_chamados_andamento_semanal(
IN Tecnico INT,
IN dt_hoje DATE
)
BEGIN
	CREATE TEMPORARY TABLE tmp_chamados_andamento_semanal
    AS
    SELECT * FROM chamado
    WHERE tecnico AND STATUS = 1 AND (data_abertura BETWEEN (dt_hoje - INTERVAL 7 DAY) AND dt_hoje);
    SELECT * FROM tmp_chamados_andamento_semanal;
    DROP TABLE tmp_chamados_andamento_semanal;
END //
DELIMITER ;


CALL sps_chamados_andamento_semanal(1, "2022-08-31");