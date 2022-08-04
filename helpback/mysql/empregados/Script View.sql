use empregados_db;

create or replace view vw_imposto_renda
as 
select e.nome as empregado,
count(d.cod_dep) as n_dependente,
(e.salario * 13) as renda,
(e.salario * 13) * (count(d.cod_dep) * 0.2) as abatimento
from empregado e 
left join dependente d 
on e.cod_empregado = d.cod_empregado
group by e.nome;

select * from vw_imposto_renda where abatimento = 0;