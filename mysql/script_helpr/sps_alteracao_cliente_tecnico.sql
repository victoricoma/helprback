use helpr_bda;
DELIMITER //
CREATE PROCEDURE sps_alteracao_cliente_tecnico(
IN dt_inicio DATE,
IN dt_fim DATE
)
BEGIN
CREATE TEMPORARY TABLE tpm_alteracao_cliente_tecnico
	AS
    SELECT * FROM log_alteracao_cliente_tecnico
    WHERE data_alteracao BETWEEN dt_inicio AND dt_fim;
    SELECT * FROM tpm_alteracao_cliente_tecnico;
    DROP TABLE tpm_alteracao_cliente_tecnico;
    
END //
DELIMITER ;

CALL sps_alteracao_cliente_tecnico("2022-08-20","2022-08-26");