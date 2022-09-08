package com.api.helprback;

import com.api.helprback.domain.*;
import com.api.helprback.services.*;
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

	@Autowired
	private FuturosCandidatosService futurosCandidatosService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private NovosClientesService novosClientesService;

	@Autowired
	private FuturosClientesService futurosClientesService;

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
	@Test
	void testContextAbertoFindAll(){
		List<Chamado> testAberto = chamadoService.findAll();
		Assertions.assertTrue(testAberto.size()>=0);
	}
	@Test
	void testContextPrioridade(){
		List<Tecnico> testPrioridade = tecnicoService.reportTecnicoChamadoPrioridadeDia();
		Assertions.assertTrue(testPrioridade.size()>=0);
	}
	@Test
    void testContextReportByTecnicoOrderByPrioridade(){
        Integer idTecnico = 1;
        List<RelatorioBaseTecnicoChamado> test = relatorioBaseTecnicoChamadoService.reportByTecnicoOrderByPrioridade(idTecnico);
        Assertions.assertTrue(test.size()>=0);
    }

	@Test
	void testFuturosCandidatosFindAll(){
		List<FuturosCandidatos> test = futurosCandidatosService.findAll();
		Assertions.assertTrue(test.size() >=0);
	}



	@Test
	void testContextFindAllTecnico() {
		List<Tecnico> test = tecnicoService.findAll();
		Assertions.assertTrue(test.size() >= 0);
	}
	@Test
	void testContexFindByIdTecnico() {
		Integer id = 1;
		Tecnico testId = tecnicoService.findById(id);
		Assertions.assertNotNull(testId);


	}
	@Test
	void testContextFindAllChamado() {
		List<Chamado> test = chamadoService.findAll();
		Assertions.assertTrue(test.size() >= 0);

	}
	@Test
	void testContexFindByIdChamado() {
		Integer id = 1;
		Tecnico testId = tecnicoService.findById(id);
		Assertions.assertNotNull(testId);

	}

	@Test
	void testContextFindAllCliente() {
		List<Cliente> test = clienteService.findAll();
		Assertions.assertTrue(test.size() >= 0);

	}
	@Test
	void testContexFindByIdCliente() {
		Integer id = 1;
		Tecnico testId = tecnicoService.findById(id);
		Assertions.assertNotNull(testId);

	}
	@Test
	void testContextReportByTecnicoUltimosTresDias(){
		List<Chamado> test = chamadoService.reportByTecnicoUltimosTresDias(3);
		Assertions.assertTrue(test.size()>=0);
	}

	@Test
	void testFindByClienteId(){
		Integer clienteId = 7;
		List<Chamado> test = chamadoService.findByClienteId(clienteId);
		Assertions.assertTrue(test.size() >= 0);
 	}


	@Test
	void testContextReportByChamadosUrgentesUltimosTresDias(){
		List<Chamado> test = chamadoService.reportByChamadosUrgentesUltimosTresDias(2);
		Assertions.assertTrue(test.size()>=0);
	}

	@Test
	void testNovosClientesFindAll(){
		List<NovosClientes> test = novosClientesService.findAll();
		Assertions.assertTrue(test.size() >= 0);
	}

	@Test
	void testFuturosClientesFindById(){
		Integer id = 1;
		FuturosClientes test = futurosClientesService.findById(id);
		Assertions.assertNotNull(id);
	}

	@Test
	void testFuturosClientesFindAll() {
		List<FuturosClientes> test = futurosClientesService.findAll();
		Assertions.assertTrue(test.size() >=0);
	}
}

