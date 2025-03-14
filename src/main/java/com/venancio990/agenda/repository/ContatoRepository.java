package com.venancio990.agenda.repository;

import com.venancio990.agenda.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
