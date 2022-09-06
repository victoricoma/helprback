CREATE TABLE log_chamado_prioridade(
id INT NOT NULL AUTO_INCREMENT,
dt_alteracao DATETIME,
prioridade_antigo INT NOT NULL,
prioridade_novo INT NOT NULL,
PRIMARY KEY(id)
); 
DELIMITER //
CREATE TRIGGER trigger_update_prioridade_chamado BEFORE UPDATE ON chamado
FOR EACH ROW 
BEGIN
    IF(NEW.prioridade <> OLD.prioridade) THEN INSERT INTO log_chamado_prioridade(dt_alteracao, prioridade_antigo, prioridade_novo)
    VALUES(NOW(), old.prioridade, new.prioridade);
END IF;
END //
DELIMITER ; 

START TRANSACTION;
UPDATE chamado SET prioridade = 2 WHERE id IN(1,2);

SELECT * FROM log_chamado_prioridade;

INSERT INTO chamado(id, data_abertura, data_fechamento, observacoes, prioridade, status, titulo, cliente_id, tecnico_id) 
values(6, "2022-09-02", null, "Este é um chamado para sistema", 2, 0, "Chamado Inaugural", 7, 1);

SELECT * FROM chamado;
