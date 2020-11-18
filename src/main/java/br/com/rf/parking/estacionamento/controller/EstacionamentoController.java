package br.com.rf.parking.estacionamento.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rf.parking.estacionamento.controller.mapper.EstacionamentoMapper;
import br.com.rf.parking.estacionamento.dto.EstacionamentoDTO;
import br.com.rf.parking.estacionamento.models.Estacionamento;
import br.com.rf.parking.estacionamento.service.EstacionamentoService;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {
	
	private final EstacionamentoService estacionamentoService;
	private final EstacionamentoMapper estacionamentoMapper;
	
	public EstacionamentoController(EstacionamentoService estacionamentoService,
			EstacionamentoMapper estacionamentoMapper) {
		this.estacionamentoService = estacionamentoService;
		this.estacionamentoMapper = estacionamentoMapper;
	}
	
	@GetMapping
    public List<EstacionamentoDTO> findAll() {
        List<Estacionamento> estacioanamentoList = estacionamentoService.findAll();
        List<EstacionamentoDTO> result = estacionamentoMapper.toEstacionamentoDTOList(estacioanamentoList);
        return result;
    }
	
	
	

}
