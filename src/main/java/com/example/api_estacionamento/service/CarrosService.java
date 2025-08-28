package com.example.api_estacionamento.service;

import com.example.api_estacionamento.model.Carros;
import com.example.api_estacionamento.repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class CarrosService {
    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public Carros registrarEntrada(Carros carro) {
        System.out.println("ID Placa recebido: " + carro.getId());
        carro.setEntrada(LocalDateTime.now());
        return estacionamentoRepository.save(carro);
    }

    public Carros registrarSaida(String id_placa) {
        Optional<Carros> carroOptional = estacionamentoRepository.findById(id_placa);
        if (carroOptional.isPresent()) {
            Carros carro = carroOptional.get();
            carro.setSaida(LocalDateTime.now());
            carro.calcularValor();
            return estacionamentoRepository.save(carro);
        } else {
            throw new RuntimeException("Veículo não encontrado");
        }
    }

    public List<Carros> listarCarros() {
        return estacionamentoRepository.findAll();
    }
}