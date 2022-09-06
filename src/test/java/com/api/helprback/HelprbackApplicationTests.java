package com.api.helprback;

import com.api.helprback.domain.Chamado;
import com.api.helprback.domain.Pessoa;
import com.api.helprback.domain.RelatorioBaseTecnicoChamado;
import com.api.helprback.domain.Tecnico;
import com.api.helprback.services.ChamadoService;
import com.api.helprback.services.PessoaService;
import com.api.helprback.services.RelatorioBaseTecnicoChamadoService;
import com.api.helprback.services.TecnicoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HelprbackApplicationTests {

	@Autowired
	private ChamadoService chamadoService;

	@Autowired
	private TecnicoService tecnicoService;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	RelatorioBaseTecnicoChamadoService relatorioBaseTecnicoChamadoService;

	@Test
	void testContextReportChamadosTecnicoSemanal() {
		Integer idTecnico = 1;
		List<Chamado> testObj = chamadoService.reportSemanalChamadosTecnico(idTecnico);
		Assertions.assertTrue(testObj.size()>0);
	}

	@Test
	void testContextReportTecnicoUrgenciaDia(){
		List<Tecnico> test = tecnicoService.reportTecnicoChamadoPrioridadeDia();
		Assertions.assertTrue(test.size()>=0);
	}

	@Test
	void testContextFindById(){
		String email = "victor.icoma@gmail.com";
		Pessoa testEmail = pessoaService.findByEmail(email);
		Assertions.assertNotNull(testEmail);
	}

	@Test
	void testContextReportByTecnicoGroupByStatus(){
		Integer idTecnico = 1;
		List<RelatorioBaseTecnicoChamado> test = relatorioBaseTecnicoChamadoService.reportByTecnicoGroupByStatus(idTecnico);
		Assertions.assertNotNull(test);
	}
}
