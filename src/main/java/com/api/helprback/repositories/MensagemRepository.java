package com.api.helprback.repositories;

import com.api.helprback.domain.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {}