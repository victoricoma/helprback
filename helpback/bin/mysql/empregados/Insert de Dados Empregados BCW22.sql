use empregados_db;

/*INSERT NA TABELA DEPARTAMENTO*/
INSERT INTO departamento(nome) VALUES("Tecnologia");
INSERT INTO departamento(nome) VALUES("Produto");
INSERT INTO departamento(nome) VALUES("Sustentação");
INSERT INTO departamento(nome) VALUES("Design");
INSERT INTO departamento(nome) VALUES("Financeiro");
INSERT INTO departamento(nome) VALUES("Comercial");
INSERT INTO departamento(nome) VALUES("Infraestrutura");
INSERT INTO departamento(nome) VALUES("Gestão");

/* INSER NA TABELA DE EMPREGADO */
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(1, "Marcos Aparecido", "1994-10-19", 'M', "2005-03-20", 'S', 2560.3);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(2, "Rosemary Clovís", "200-10-19", 'M', "2010-03-20", 'C', 3510.9);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(1, "Antônio Silva", "1990-01-25", 'M', "2009-03-20", 'S', 2960.7);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(3, "Ana Júlia Marcelino", "1984-05-10", 'F', "2005-03-20", 'S', 12580.4);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(4, "Ronaldo Jveliano", "1998-10-01", 'M', "2010-03-14", 'S', 7560.3);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(5, "Marcia Tavares", "1981-04-05", 'F', "2015-01-20", 'S', 8560.3);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(3, "Thamires Arruda", "1974-10-19", 'F', "2005-04-20", 'C', 6560.3);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(7, "Letícia Marques", "2003-10-19", 'H', "2022-03-20", 'U', 2560.3);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(6, "Aparecido Bonadio", "1994-12-20", 'M', "2005-10-20", 'U', 3560.3);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(1, "Felipe Januário", "1998-05-17", 'M', "2005-02-20", 'S', 3560.3);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(1, "Alexandra Pereira", "1988-03-25", 'M', "2005-04-20", 'S', 9560.3);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(1, "José Renato Zetti", "1982-09-19", 'M', "2015-03-20", 'C', 3260.3);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(1, "José Renato Zetti", "1984-05-01", 'F', "2005-03-20", 'D', 6260.3);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario) 
values(1, "José Renato Zetti", "1982-06-22", 'F', "2017-03-20", 'D', 4260.3);
INSERT INTO empregado(cod_depto, nome, dt_nascimento, sexo, dt_admissao, civil, salario)
values(8,"Emiliana Caxias","1980-04-20",'F',"2009-02-04",'C', 32874.50);

/*INSERT NA TABELA DE DEPENDENTES*/
INSERT INTO dependente(cod_empregado, nome, dt_nascimento, sexo) 
values(1, "Ana Júlia Clovis", "2019-03-22", 'F');
INSERT INTO dependente(cod_empregado, nome, dt_nascimento, sexo) 
values(2, "Romário Clóviss", "2016-07-02", 'M');
INSERT INTO dependente(cod_empregado, nome, dt_nascimento, sexo) 
values(7, "Ana Carla Arruda", "2019-07-12", 'F');
INSERT INTO dependente(cod_empregado, nome, dt_nascimento, sexo) 
values(7, "Alex Arruda", "2015-08-05", 'M');
INSERT INTO dependente(cod_empregado, nome, dt_nascimento, sexo) 
values(8, "Pedro Henrique Marques", "2019-12-22", 'M');
INSERT INTO dependente(cod_empregado, nome, dt_nascimento, sexo) 
values(9, "Valentina Bonadio", "2019-03-22", 'F');
INSERT INTO dependente(cod_empregado, nome, dt_nascimento, sexo) 
values(12, "Enzo Zetti", "2015-05-22", 'M');
INSERT INTO dependente(cod_empregado, nome, dt_nascimento, sexo) 
values(12, "Ana Júlia Zetti", "2017-03-18", 'F');
INSERT INTO dependente(cod_empregado, nome, dt_nascimento, sexo) 
values(12, "Vicenti Zetti", "2012-05-07", 'M');
INSERT INTO dependente(cod_empregado, nome, dt_nascimento, sexo) 
values(14, "Alexandrina Marcondes", "2018-05-10", 'F');
INSERT INTO dependente(cod_empregado, nome, dt_nascimento, sexo) 
values(14, "Simone Di Marcondes", "2018-07-15", 'F');
INSERT INTO dependente(cod_empregado, nome, dt_nascimento, sexo)
values(15, "Enzo Caxias Queiros", "2010-03-01",'M');
