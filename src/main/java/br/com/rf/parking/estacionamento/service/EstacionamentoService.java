package br.com.rf.parking.estacionamento.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.rf.parking.estacionamento.exception.EstacionamentoNotFoundException;
import br.com.rf.parking.estacionamento.models.Estacionamento;

@Service
public class EstacionamentoService {

	private static Map<String, Estacionamento> estacionamentoMap = new HashMap<String, Estacionamento>();

//	static {
//		var id = getUUID();
//		var id1 = getUUID();
//
//		Estacionamento estacionamento = new Estacionamento(id, "DDD-7878", "SC", "PALIO", "PRATA");
//		Estacionamento estacionamento1 = new Estacionamento(id1, "DHG-8776", "MA", "CORSA", "AZUL");
//
//		estacionamentoMap.put(id, estacionamento);
//		estacionamentoMap.put(id1, estacionamento1);
//	}

	public List<Estacionamento> findAll() {
		return estacionamentoMap.values().stream().collect(Collectors.toList());
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public Estacionamento findById(String id) {
		Estacionamento estacionamento = estacionamentoMap.get(id);
	        if (estacionamento == null) {
	            throw new EstacionamentoNotFoundException(id);
	        }
	        return estacionamento;
	}

	public Estacionamento create(Estacionamento estacionamentoCreate) {
		String uuid = getUUID();
		estacionamentoCreate.setId(uuid);
		estacionamentoCreate.setDataEntrada(LocalDateTime.now());
		estacionamentoMap.put(uuid, estacionamentoCreate);
		return estacionamentoCreate;
	}

	public void delete(String id) {
		findById(id);
		estacionamentoMap.remove(id);

	}

	public Estacionamento update(String id, Estacionamento estacionamentoCreate) {
		Estacionamento estacionamento = findById(id);
		estacionamento.setCor(estacionamentoCreate.getCor());
	        estacionamentoMap.replace(id, estacionamento);
	        return estacionamento;
	
	}

	 public Estacionamento exit(String id) {
	        //recuperar o estacionado
	        //atualizar data de saida
	        //calcular o valor

	        return null;
	    }
}
