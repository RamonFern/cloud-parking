package br.com.rf.parking.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rf.parking.estacionamento.models.Estacionamento;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, String>{

}
