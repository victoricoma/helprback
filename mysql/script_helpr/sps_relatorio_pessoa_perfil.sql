use helpr_bda;
DELIMITER //
CREATE PROCEDURE sps_relatorio_pessoa_perfil(
IN dt_inicio DATE,
IN dt_fim DATE
)
BEGIN
CREATE TEMPORARY TABLE tpm_relatorio_pessoa_perfil
	AS
    SELECT * FROM log_pessoa
    WHERE dt_alteracao BETWEEN dt_inicio AND dt_fim;
    SELECT * FROM tpm_relatorio_pessoa_perfil;
    DROP TABLE tpm_relatorio_pessoa_perfil;
    
END //
DELIMITER ;

CALL sps_relatorio_pessoa_perfil("2022-08-20","2022-08-26");