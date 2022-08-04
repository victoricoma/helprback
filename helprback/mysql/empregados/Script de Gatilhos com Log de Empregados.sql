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

ALTER TABLE log_empregado
ADD depto_novo INT;
ALTER TABLE log_empregado
ADD depto_antigo INT;

DELIMITER //
CREATE TRIGGER tg_log_empregado_salario BEFORE UPDATE ON empregado
FOR EACH ROW
	BEGIN
    IF(NEW.salario <> OLD.salario) THEN
		INSERT INTO log_empregado(cod_empregado, dt_alteracao, valor_antigo, valor_novo, correcao_legal, cod_correcao, depto_novo, depto_antigo)
        VALUES(OLD.cod_empregado, NOW(), OLD.salario, NEW.salario, IF(NEW.salario > OLD.salario, "Legal", "Ilegal") , 0, NULL, NULL);
	END IF;
    END //
DELIMITER ;
DELIMITER //
CREATE TRIGGER tg_log_empregado_depto BEFORE UPDATE ON empregado
FOR EACH ROW
	BEGIN
    IF(NEW.cod_depto <> OLD.cod_depto) THEN
		INSERT INTO log_empregado(cod_empregado, dt_alteracao, valor_antigo, valor_novo, correcao_legal, cod_correcao, depto_novo, depto_antigo)
        VALUES(OLD.cod_empregado, NOW(), NULL, NULL, NULL, 0, NEW.cod_depto, OLD.cod_depto);
	END IF;
    END //
DELIMITER ;
DROP TRIGGER tg_log_empregado;

SELECT *, (FLOOR(DATEDIFF(NOW(), dt_admissao)/365)) AS tempo_empresa FROM empregado;
SELECT * FROM log_empregado;
START TRANSACTION;
DELETE FROM log_empregado WHERE cod_log>0;

START TRANSACTION;
UPDATE empregado SET salario = (salario * 1.15) WHERE cod_empregado IN (6, 12, 14);
ROLLBACK;
COMMIT;

START TRANSACTION;
UPDATE empregado SET salario = (salario / 1.15) WHERE cod_empregado IN (6, 12, 14);
ROLLBACK;
COMMIT;

SELECT * FROM empregado;
SELECT * FROM departamento;

START TRANSACTION;
UPDATE empregado SET salario = (salario * 1.47) WHERE cod_empregado IN (1, 4);
UPDATE empregado SET cod_depto = 8 WHERE cod_empregado IN (1, 4);
ROLLBACK;
COMMIT;