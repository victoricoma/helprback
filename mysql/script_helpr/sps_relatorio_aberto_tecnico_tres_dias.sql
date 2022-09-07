use helpr_bda;
DELIMITER //
CREATE PROCEDURE sps_relatorio_aberto_tecnico_tres_dias(
IN tecnico INT,
IN dt_hoje DATE
)
BEGIN
	CREATE TEMPORARY TABLE tmp_relatorio_aberto_tecnico_dia AS
	SELECT * FROM chamado WHERE tecnico_id = tecnico AND status = 0 AND (data_abertura BETWEEN (dt_hoje - INTERVAL 3 DAY) AND dt_hoje);
    SELECT * FROM tmp_relatorio_aberto_tecnico_dia;
    DROP TABLE tmp_relatorio_aberto_tecnico_dia;
END //
DELIMITER ;

CALL sps_relatorio_aberto_tecnico_tres_dias(3, "2022-09-02");
