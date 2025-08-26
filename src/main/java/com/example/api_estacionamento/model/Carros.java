package com.example.api_estacionamento.model;

import jakarta.persistence.*;

import java.security.Timestamp;
import java.time.Duration;
import java.time.Year;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DecimalStyle;

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
    private Year ano;

    @Column(nullable = false)
    private LocalDateTime entrada;

    @Column(nullable = false)
    private LocalDateTime saida;

    @Column(nullable = false)
    private Double valor_hora;

    @Column(nullable = false)
    private Integer permanencia;

    @Column(nullable = false)
    private Double valor_total;

    public Carros(){ //Construtores
    }

    public Carros(String id_placa, String marca, String modelo, String cor, Year ano, LocalDateTime entrada, LocalDateTime saida, Double valor_hora, Integer permanencia, Double valor_total) {
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

    public String getId() {
        return id_placa;
    }
    public void setId() {
        this.id_placa=id_placa;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca() {
        this.marca=marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo() {
        this.modelo=modelo;
    }

    public String getCor() {
        return cor;
    }
    public void setCor() {
        this.cor=cor;
    }

    public Year getAno() {
        return ano;
    }
    public void setAno() {
        this.ano=ano;
    }

    public LocalDateTime getEntrada() { return entrada; }
    public void setEntrada() { this.entrada=entrada; }

    public LocalDateTime getSaida() { return saida; }
    public void setSaida() { this.saida=saida; }

    public Double getValor_hora() { return valor_hora; }
    public void setValor_hora() { this.valor_hora=valor_hora; }

    public Integer getPermanencia() { return permanencia; }
    public void setPermanencia() { this.permanencia=permanencia; }

    public Double getValor_total() { return valor_total; }
    public void setValor_total() { this.valor_total=valor_total; }

    public void calcularValor() {
        if (entrada != null && saida != null){
            Duration duracao = Duration.between(entrada,saida);
            this.horas_permanencia = (int) Math.ceil((double) duracao.toMinutes()/60);
            this.valor_total = this.permanencia * this.valor_hora;
        }
    }
}