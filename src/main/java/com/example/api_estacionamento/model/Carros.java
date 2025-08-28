package com.example.api_estacionamento.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.Year;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_carros")

public class Carros{
    @Id
    private String id_placa;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = true)
    private LocalDateTime entrada;

    @Column(nullable = true)
    private LocalDateTime saida;

    @Column(nullable = true)
    private Double valor_hora;

    @Column(nullable = true)
    private Integer permanencia;

    @Column(nullable = true)
    private Double valor_total;

    public Carros(){

    }

    public Carros(String id_placa, String marca, String modelo, String cor, Integer ano, LocalDateTime entrada, LocalDateTime saida, Double valor_hora, Integer permanencia, Double valor_total) {
        this.id_placa=id_placa;
        this.marca=marca;
        this.modelo=modelo;
        this.cor=cor;
        this.ano=ano;
        this.entrada=entrada;
        this.saida=saida;
        this.valor_hora=valor_hora;
        this.permanencia=permanencia;
        this.valor_total=valor_total;
    }

    @JsonProperty("id_placa") public String getId() {
        return id_placa;
    }
    @JsonProperty("id_placa") public void setId(String id_placa) {
        this.id_placa=id_placa;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca=marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) { this.modelo=modelo; }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor=cor;
    }

    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano=ano;
    }

    public LocalDateTime getEntrada() { return entrada; }
    public void setEntrada(LocalDateTime entrada) { this.entrada=entrada; }

    public LocalDateTime getSaida() { return saida; }
    public void setSaida(LocalDateTime saida) { this.saida=saida; }

    public Double getValor_hora() { return valor_hora; }
    public void setValor_hora(Double valor_hora) { this.valor_hora=valor_hora; }

    public Integer getPermanencia() { return permanencia; }
    public void setPermanencia(Integer permanencia) { this.permanencia=permanencia; }

    public Double getValor_total() { return valor_total; }
    public void setValor_total(Double valor_total) { this.valor_total=valor_total; }

    public void calcularValor() {
        if (entrada != null && saida != null){
            Duration duracao = Duration.between(entrada,saida);
            this.permanencia = (int) Math.ceil((double) duracao.toMinutes()/60);
            this.valor_total = this.permanencia * this.valor_hora;
        }
    }
}
