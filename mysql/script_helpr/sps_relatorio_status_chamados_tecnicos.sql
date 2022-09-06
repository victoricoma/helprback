DELIMITER //
CREATE PROCEDURE sps_relatorio_status_chamados_tecnicos(
IN status_chamado INT
)
BEGIN
	CREATE TEMPORARY TABLE tmp_relatorio_status_chamados_tecnicos
    AS
    SELECT p.nome AS tecnico, COUNT(c.id) AS qtd_chamados_por_status FROM chamado c, pessoa p WHERE c.tecnico_id IN(
		SELECT tecnico_id FROM chamado WHERE status = status_chamado
        )
        AND c.id = p.id
        GROUP BY p.id;
	SELECT * FROM tmp_relatorio_status_chamados_tecnicos;
    DROP TABLE tmp_relatorio_status_chamados_tecnicos;
END //
DELIMITER ;

CALL sps_relatorio_status_chamados_tecnicos("0");
