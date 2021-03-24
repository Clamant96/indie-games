package com.exploregames.indieGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exploregames.indieGames.model.Desenvolvedora;

@Repository
public interface DesenvolvedoraRepository extends JpaRepository<Desenvolvedora, Long>{
	public List<Desenvolvedora> findAllByNomeContainingIgnoreCase(String nome);

}
