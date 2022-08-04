use empregado_db;

select * from empregado
inner join dependente
on empregado.cod_empregado = dependente.cod_empregado
where empregado.nome like "%Zetti%";

select * from empregado e
left join dependente d
on e.cod_empregado = d.cod_empregado
;

select * from empregado e
right join dependente d
on e.cod_empregado = d.cod_empregado;

select * from empregado e
cross join dependente d
on e.cod_empregado = d.cod_empregado;

select emp.nome, ifnull(dep.nome, "sem dependente") as dependente,
if(dep.dt_nascimento < "2005-01-01", "quase maior", "dep menor") as estatus
from empregado emp 
left join dependente dep 
on emp.cod_empregado = dep.cod_empregado;

/*Exercício JOINs*/
/*Monte um filtro que liste todos os empregados da empresa,
neste filtro deverá ter uma coluna onde mostre o numero de dependentes, os
empregados sem dependetes deve aparecer 0 e em um próxima coluna
deve aparecer o IRPF onde os empregdos com dependentes tem mensagem Com Abatimento e os
sem Sem Abatimento.
*/

select depto.nome as deptoNome, 
emp.nome as empNome, emp.dt_nascimento as empDn, emp.sexo as empSexo, emp.dt_admissao, emp.civil as empCivil, emp.salario as empSalario, 
dep.nome as depNome, dep.dt_nascimento as depDN, dep.sexo as depSexo, 
count(dep.cod_empregado) as n_dependentes, if(count(dep.cod_empregado) <= 0, "Sem Abatimento", "Com Abatimento") as IRPF
from departamento as depto
inner join empregado as emp on depto.cod_depto = emp.cod_depto
left join dependente as dep on emp.cod_empregado = dep.cod_empregado
group by emp.nome
order by empNome asc
;
