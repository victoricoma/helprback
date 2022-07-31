use empregados_db;
CREATE TABLE log_empregado (
	cod_log INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	cod_empregado INT NOT NULL,
    dt_alteracao DATETIME,
    valor_antigo DECIMAL(10,2),
    valor_novo DECIMAL(10,2),
    correcao_legal VARCHAR(100),
    cod_correcao INT
);
DELIMITER //
CREATE TRIGGER tg_log_empregado BEFORE UPDATE ON empregado
FOR EACH ROW
BEGIN
    IF(NEW.salario <> OLD.salario) THEN
		INSERT INTO log_empregado(cod_empregado, dt_alteracao, valor_antigo, valor_novo, correcao_legal, cod_correcao)
        VALUES(OLD.cod_empregado, NOW(), OLD.salario, NEW.salario, null, 0);
	END IF;
END //
DELIMITER ;
SELECT * , (FLOOR(DATEDIFF(NOW(), dt_admissao)/365)) AS tempo_empresa FROM empregado;
SELECT * FROM log_empregado;
START TRANSACTION;
DELETE FROM log_empregado WHERE cod_log>0;
START TRANSACTION;
UPDATE empregado SET salario = (salario * 1.15) WHERE cod_empregado IN (6, 12, 14);
ROLLBACK;
COMMIT;
