use helpr_bda;

CREATE TABLE log_chamado_prioridade (
	cod_log INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data_alteracao DATETIME,
    dado_alterado DECIMAL(10,2),
    dado_novo DECIMAL(10,2),
    dev_correcao VARCHAR(100),
    cod_correcao INT
);
DELIMITER //
CREATE TRIGGER tg_log_prioridade_chamado BEFORE UPDATE
ON chamado
FOR EACH ROW
BEGIN
	IF(OLD.prioridade <> NEW.prioridade) THEN
		INSERT INTO log_chamado_prioridade(data_alteracao, dado_alterado, dado_novo, dev_correcao)
		VALUES(NOW(), OLD.prioridade, NEW.prioridade, NULL);
	END IF;
    END //
DELIMITER ;

START TRANSACTION;
UPDATE chamado SET prioridade = 1 WHERE id IN(1,2);

SELECT * FROM chamado;
SELECT * FROM log_chamado_prioridade;









