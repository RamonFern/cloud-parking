package br.com.rf.parking.estacionamento.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rf.parking.estacionamento.controller.mapper.EstacionamentoMapper;
import br.com.rf.parking.estacionamento.dto.EstacionamentoCreateDTO;
import br.com.rf.parking.estacionamento.dto.EstacionamentoDTO;
import br.com.rf.parking.estacionamento.models.Estacionamento;
import br.com.rf.parking.estacionamento.service.EstacionamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/estacionamento")
@Api(tags = "Estacionamento Controller")
public class EstacionamentoController {

	private final EstacionamentoService estacionamentoService;
	private final EstacionamentoMapper estacionamentoMapper;

	public EstacionamentoController(EstacionamentoService estacionamentoService,
			EstacionamentoMapper estacionamentoMapper) {
		this.estacionamentoService = estacionamentoService;
		this.estacionamentoMapper = estacionamentoMapper;
	}

	@GetMapping
	@ApiOperation("Buscar todos Estacionamentos")
	public ResponseEntity<List<EstacionamentoDTO>> findAll() {

		List<Estacionamento> estacioanamentoList = estacionamentoService.findAll();
		List<EstacionamentoDTO> result = estacionamentoMapper.toEstacionamentoDTOList(estacioanamentoList);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstacionamentoDTO> findById(@PathVariable String id) {
		Estacionamento estacionamento = estacionamentoService.findById(id);
		EstacionamentoDTO result = estacionamentoMapper.toEstacionamentoDTO(estacionamento);
		return ResponseEntity.ok(result);
	}

	@PostMapping
	public ResponseEntity<EstacionamentoDTO> create(@RequestBody EstacionamentoCreateDTO dto) {
		var estacionamentoCreate = estacionamentoMapper.toEstacionamentoCreate(dto);
		var estacionamento = estacionamentoService.create(estacionamentoCreate);
		var result = estacionamentoMapper.toEstacionamentoDTO(estacionamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable String id) {
		estacionamentoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
