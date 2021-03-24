package com.exploregames.indieGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exploregames.indieGames.model.Plataforma;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long>{
	public List<Plataforma> findAllByNomeContainingIgnoreCase(String nome);
	
}
