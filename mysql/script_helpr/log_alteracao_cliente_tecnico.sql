USE helpr_bda;
CREATE TABLE log_alteracao_cliente_tecnico (
	cod_log INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    data_alteracao DATETIME,
    dado_alterado INT,
    dado_novo INT,
    correcao_dev INT
);
DELIMITER //
CREATE TRIGGER tg_log_cliente_chamado BEFORE UPDATE
ON chamado
FOR EACH ROW
BEGIN
	IF(NEW.cliente_id <> OLD.cliente_id) THEN
		INSERT INTO log_alteracao_cliente_tecnico(data_alteracao, dado_alterado, dado_novo, correcao_dev)
		VALUES(NOW(), OLD.cliente_id, NEW.cliente_id, NULL);
	ELSEIF (NEW.tecnico_id <> OLD.tecnico_id) THEN 
		INSERT INTO log_alteracao_cliente_tecnico(data_alteracao, dado_alterado, dado_novo, correcao_dev)
		VALUES(NOW(), OLD.tecnico_id, NEW.tecnico_id, NULL);
	END IF;
    END 
 //
DELIMITER ;

SELECT * FROM chamado;
SELECT * FROM log_alteracao_cliente_tecnico;


        