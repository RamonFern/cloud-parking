package br.com.rf.parking.estacionamento.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.rf.parking.estacionamento.dto.EstacionamentoCreateDTO;
import br.com.rf.parking.estacionamento.dto.EstacionamentoDTO;
import br.com.rf.parking.estacionamento.models.Estacionamento;

@Component
public class EstacionamentoMapper {
	
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public EstacionamentoDTO toEstacionamentoDTO(Estacionamento estacionamento) {
        return MODEL_MAPPER.map(estacionamento, EstacionamentoDTO.class);
    }

    public List<EstacionamentoDTO> toEstacionamentoDTOList(List<Estacionamento> estacionamentoList) {
        return estacionamentoList.stream().map(this::toEstacionamentoDTO).collect(Collectors.toList());
    }
    
    public Estacionamento toEstacionamento(EstacionamentoDTO dto) {
        return MODEL_MAPPER.map(dto, Estacionamento.class);
    }
    
    public Estacionamento toEstacionamentoCreate(EstacionamentoCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Estacionamento.class);
    }

}
