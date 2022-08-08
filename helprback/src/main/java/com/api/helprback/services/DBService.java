package com.api.helprback.services;

import com.api.helprback.domain.Chamado;
import com.api.helprback.domain.Cliente;
import com.api.helprback.domain.Tecnico;
import com.api.helprback.domain.enums.Perfil;
import com.api.helprback.domain.enums.Prioridade;
import com.api.helprback.domain.enums.Status;
import com.api.helprback.repositories.ChamadoRepository;
import com.api.helprback.repositories.ClienteRepository;
import com.api.helprback.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;
    //Método de Injeção de Dados nno Banco
    public void instanciadB(){
        Tecnico tec1 = new Tecnico(null, "Victor Icoma", "969.863.750-85", "victor.icoma@gmail.com", "gordinho123");
        tec1.addPerfis(Perfil.TECNICO);
        tec1.addPerfis(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Salazar Sonserina", "324.527.750-45", "ofideoglota@gmail.com", "VenenoOfidiano");

        Chamado ch1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Conserto de laptop", "Cliente reclama da conexão de internet em seu laptop", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(ch1));
    }
}
