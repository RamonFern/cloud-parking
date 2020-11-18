package br.com.rf.parking.estacionamento.models;

import java.time.LocalDateTime;

public class Estacionamento {
	
	private String id;
    private String placa;
    private String estado;
    private String modelo;
    private String cor;
    private LocalDateTime dataEntrada;
    private LocalDateTime datasaida;
    private Double valor;
    
    
    
	public Estacionamento(String id, String placa, String estado, String modelo, String cor) {
		this.id = id;
		this.placa = placa;
		this.estado = estado;
		this.modelo = modelo;
		this.cor = cor;
	}
	
	public Estacionamento() {
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public LocalDateTime getDatasaida() {
		return datasaida;
	}
	public void setDatasaida(LocalDateTime datasaida) {
		this.datasaida = datasaida;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
    
    

}
