package com.example.api_estacionamento.repository;

import com.example.api_estacionamento.model.Carros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EstacionamentoRepository extends JpaRepository<Carros, Long> {
    // Aqui você pode adicionar métodos personalizados se necessário
}
