DELIMITER //
CREATE PROCEDURE sps_relatorio_chamados_prioridade_tecnico(
IN tecnico_id INT
) 
BEGIN
	CREATE TEMPORARY TABLE tmp_relatorio_chamados_prioridade_tecnico 
	AS SELECT p.nome AS tecnico_nome, c.prioridade, COUNT(c.id) AS Quant_chamados 
    FROM chamado c, pessoa p
	WHERE c.tecnico_id IN (
		SELECT c.tecnico_id FROM chamado c WHERE tecnico_id = c.tecnico_id
		) 
        AND c.tecnico_id = p.id        
		GROUP BY c.prioridade
        ORDER BY c.prioridade;
        
	SELECT * FROM tmp_relatorio_chamados_prioridade_tecnico;
DROP TABLE tmp_relatorio_chamados_prioridade_tecnico;
END //
DELIMITER ;