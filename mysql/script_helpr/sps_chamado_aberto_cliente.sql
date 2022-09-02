use helpr_bda;
DELIMITER //
CREATE PROCEDURE sps_chamado_aberto_cliente(
IN dt_hoje DATE
)
BEGIN
CREATE TEMPORARY TABLE tmp_chamados_aberto_cliente_diario
    AS
    SELECT * FROM pessoa
    WHERE id IN (
    SELECT cliente_id FROM chamado WHERE prioridade= 2 AND data_abertura = dt_hoje
    );
    SELECT * FROM tmp_chamados_aberto_cliente_diario;
    DROP TABLE tmp_chamados_aberto_cliente_diario;
END //
DELIMITER ;

CALL sps_chamado_aberto_cliente("2022-08-26");
