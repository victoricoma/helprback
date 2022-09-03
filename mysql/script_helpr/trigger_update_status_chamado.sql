
CREATE TABLE log_update_status(
id INT NOT NULL AUTO_INCREMENT,
dt_alteracao DATETIME,
status_antigo INT NOT NULL,
status_novo INT NOT NULL,
PRIMARY KEY(id)
);

DELIMITER //
CREATE TRIGGER trigger_update_status_chamado BEFORE UPDATE ON chamado
FOR EACH ROW 
BEGIN
	IF(NEW.status <> OLD.status) THEN INSERT INTO log_update_status(dt_alteracao, status_antigo, status_novo)
    VALUES(NOW(), old.status, new.status);
END IF;
END //
DELIMITER ;

SELECT * FROM log_update_status;
