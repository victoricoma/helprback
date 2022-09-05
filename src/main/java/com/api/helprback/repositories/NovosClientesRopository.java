package com.api.helprback.repositories;

import com.api.helprback.domain.NovosClientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NovosClientesRopository  extends JpaRepository<NovosClientes, Integer> {
        }



