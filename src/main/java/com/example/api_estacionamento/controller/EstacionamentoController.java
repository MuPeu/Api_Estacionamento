package com.example.api_estacionamento.controller;

import com.example.api_estacionamento.model.Carros;
import com.example.api_estacionamento.service.CarrosService;
import org.springframework.beans.factory.annotation.Autowired; //Essa anotação é usada para realizar a injeção de dependencia. Ela pede ao SpringBoot para fornecer uma instancia de uma classe
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/estacionamento") //Define o caminho base para todas as requisições mapeadas neste controlador

public class EstacionamentoController {
    @Autowired
    //Utiliza a injeção de despendencias do Spring para obter uma instancia do AlunoRepository, permitindo que o controlador interaja com o banco de dados
    private CarrosService carroService;

    @PostMapping("/entrada")

    public ResponseEntity<Carros> registrarEntrada(@RequestBody Carros carro) {
        carro.setValor_hora(25.00);
        Carros carroRegistrado = carroService.registrarEntrada(carro);
        return new ResponseEntity<>(carroRegistrado, HttpStatus.CREATED);
    }

    @PutMapping("/saida/{id_placa}")
    public ResponseEntity<Carros> registrarSaida(@PathVariable String id_placa) {
        try {
            Carros carroSaida = carroService.registrarSaida(id_placa);
            return new ResponseEntity<>(carroSaida, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping //Mapeia requisições HTTP GET para o metodo ListarAlunos()
    public ResponseEntity <List<Carros>> listarCarros() {
        List<Carros> carro = carroService.listarCarros();
        return new ResponseEntity<>(carro, HttpStatus.OK);
    }
}
