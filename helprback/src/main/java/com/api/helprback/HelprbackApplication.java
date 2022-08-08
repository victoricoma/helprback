package com.api.helprback;

import com.api.helprback.repositories.ChamadoRepository;
import com.api.helprback.repositories.ClienteRepository;
import com.api.helprback.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class HelprbackApplication{

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelprbackApplication.class, args);
		System.out.println("API do Web App Helpr rodando!");
	}


	}


