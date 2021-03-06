package br.com.rf.parking.estacionamento.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.com.rf.parking.estacionamento.models.Estacionamento;

public class EstacionamentoCheckOut {

	public static final int UMA_HORA = 60;
	public static final int VINTE_QUATRO_HORAS = 24 * UMA_HORA;
	public static final double VALOR_UMA_HORA = 5.00;
	public static final double VALOR_ADICIONAL_POR_HORA = 2.00;
	public static final double VALOR_DIARIA = 20.00;

	public static Double getBill(Estacionamento estacionamento) {
		return getBill(estacionamento.getDataEntrada(), estacionamento.getDatasaida());
	}
	
	 private static Double getBill(LocalDateTime dataEntrada, LocalDateTime dataSaida) {
	        long minutes = dataEntrada.until(dataSaida, ChronoUnit.MINUTES);
	        Double bill = 0.0;
	        if (minutes <= UMA_HORA) {
	            return VALOR_UMA_HORA;
	        }
	        if (minutes <= VINTE_QUATRO_HORAS) {
	            bill = VALOR_UMA_HORA;
	            int hours = (int) (minutes / UMA_HORA);
	            for (int i = 0; i < hours; i++) {
	                bill += VALOR_ADICIONAL_POR_HORA;
	            }
	            return bill;
	        }
	        int days = (int) (minutes / VINTE_QUATRO_HORAS);
	        for (int i = 0; i < days; i++) {
	            bill += VALOR_DIARIA;
	        }
	        return bill;
	    }

}
