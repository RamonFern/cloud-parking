package br.com.rf.parking.estacionamento.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.rf.parking.estacionamento.models.Estacionamento;

@Service
public class EstacionamentoService {
	
	private static Map<String, Estacionamento> estacionamentoMap = new HashMap<String, Estacionamento>();
	
	static {
		var id = getUUID();
		Estacionamento estacionamento = new Estacionamento(id, "DDD-7878", "SC", "PALIO","PRATA");
		estacionamentoMap.put(id, estacionamento);
	}
	public List<Estacionamento> findAll(){
		return estacionamentoMap.values().stream().collect(Collectors.toList());
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
