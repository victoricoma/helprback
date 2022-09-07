package com.api.helprback.repositories;

import com.api.helprback.domain.FuturosClientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuturosClientesRepository extends JpaRepository<FuturosClientes, Integer> {
}
