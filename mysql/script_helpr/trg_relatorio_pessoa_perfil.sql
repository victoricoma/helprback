USE helpr_bda;

CREATE TABLE log_pessoa (
	cod_log INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dt_alteracao DATETIME,
    tipo_alteracao VARCHAR(100),
    id INT,
    perfil_add INT, 
    perfil_del INT
);
DELIMITER //
CREATE TRIGGER tg_log_perfil_add AFTER INSERT ON perfis
FOR EACH ROW
BEGIN
		INSERT INTO log_pessoa(dt_alteracao, tipo_alteracao, id, perfil_add, perfil_del)
        VALUES(NOW(), "ADIÇÃO", NEW.pessoa_id, NEW.perfis, null);
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER tg_log_perfil_del AFTER DELETE ON perfis
FOR EACH ROW
BEGIN
		INSERT INTO log_pessoa(dt_alteracao, tipo_alteracao, id, perfil_add, perfil_del)
        VALUES(NOW(), "REMOÇÃO", OLD.pessoa_id, null, OLD.perfis);
END //
DELIMITER ;

SELECT * FROM log_pessoa;