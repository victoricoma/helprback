DELIMITER //
CREATE PROCEDURE sps_relatorio_chamados_prioridade_tecnico(
IN tecnico_id INT
) 
BEGIN
	SET @contador:=0;
	CREATE TEMPORARY TABLE tmp_relatorio_chamados_prioridade_tecnico 
	AS SELECT @contador:=@contador+1 AS cod ,p.nome AS tecnico, null as status, c.prioridade AS prioridade, COUNT(c.id) AS contagem 
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

CALL sps_relatorio_chamados_prioridade_tecnico(4);