package br.com.rf.parking.estacionamento.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

//import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.rf.parking.estacionamento.exception.EstacionamentoNotFoundException;
import br.com.rf.parking.estacionamento.models.Estacionamento;
import br.com.rf.parking.estacionamento.repository.EstacionamentoRepository;

@Service
public class EstacionamentoService {

	private final EstacionamentoRepository estacionamentoRepository;

	public EstacionamentoService(EstacionamentoRepository estacionamentoRepository) {
		this.estacionamentoRepository = estacionamentoRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Estacionamento> findAll() {
		return estacionamentoRepository.findAll();
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	@Transactional(readOnly = true)
	public Estacionamento findById(String id) {
		return estacionamentoRepository.findById(id).orElseThrow(() -> new EstacionamentoNotFoundException(id));
	}

	@Transactional
	public Estacionamento create(Estacionamento estacionamentoCreate) {
		String uuid = getUUID();
		estacionamentoCreate.setId(uuid);
		estacionamentoCreate.setDataEntrada(LocalDateTime.now());
		estacionamentoRepository.save(estacionamentoCreate);
		return estacionamentoCreate;
	}

	@Transactional
	public void delete(String id) {
		findById(id);
		estacionamentoRepository.deleteById(id);

	}

	@Transactional
	public Estacionamento update(String id, Estacionamento estacionamentoCreate) {
		Estacionamento estacionamento = findById(id);
		estacionamento.setCor(estacionamentoCreate.getCor());
		estacionamento.setEstado(estacionamentoCreate.getEstado());
		estacionamento.setModelo(estacionamentoCreate.getModelo());
		estacionamento.setPlaca(estacionamentoCreate.getPlaca());
		estacionamentoRepository.save(estacionamento);
		return estacionamento;

	}

	
	@Transactional
	public Estacionamento checkOut(String id) {
		Estacionamento estacionamento = findById(id);
		estacionamento.setDatasaida(LocalDateTime.now());
		estacionamento.setValor(EstacionamentoCheckOut.getBill(estacionamento));
		estacionamentoRepository.save(estacionamento);
		return estacionamento;
	}
}
