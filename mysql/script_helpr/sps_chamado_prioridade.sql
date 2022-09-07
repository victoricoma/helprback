use helpr_bda;
DELIMITER //
CREATE PROCEDURE sps_chamado_prioridade(
IN dt_inicio DATE,
IN dt_fim DATE
)
BEGIN
CREATE TEMPORARY TABLE tpm_chamado_prioridade
	AS
    SELECT * FROM log_chamado_prioridade
    WHERE dt_alteracao BETWEEN dt_inicio AND dt_fim;
    SELECT * FROM tpm_chamado_prioridade;
    DROP TABLE tpm_chamado_prioridade;
    
END //
DELIMITER ;

CALL sps_chamado_prioridade("2022-08-20","2022-08-26");
