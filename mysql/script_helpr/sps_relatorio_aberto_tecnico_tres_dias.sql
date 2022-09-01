use helpr_bda;
DELIMITER //
CREATE PROCEDURE sps_relatorio_aberto_tecnico_tres_dias(
IN Tecnico INT,
IN dt_hoje DATE
)
BEGIN
	CREATE TEMPORARY TABLE tmp_relatorio_aberto_tecnico_dia AS
	SELECT * FROM chamado WHERE tecnico = Tecnico AND status = 0 AND (data_abertura BETWEEN (dt_hoje - INTERVAL 3 DAY) AND dt_hoje);
    SELECT * FROM tmp_relatorio_aberto_tecnico_dia;
    DROP TABLE tmp_relatorio_aberto_tecnico_dia;
END //
DELIMITER ;

CALL sps_relatorio_aberto_tecnico_tres_dias(0, "2022-08-31");
