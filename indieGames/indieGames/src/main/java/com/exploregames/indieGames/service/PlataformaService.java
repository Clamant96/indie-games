package com.exploregames.indieGames.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploregames.indieGames.model.Jogo;
import com.exploregames.indieGames.model.Plataforma;
import com.exploregames.indieGames.repository.JogoRepository;
import com.exploregames.indieGames.repository.PlataformaRepository;

@Service
public class PlataformaService {
	
	@Autowired
	private JogoRepository jogoRepository;
	
	@Autowired
	private PlataformaRepository plataformaRepository;
	
	public Plataforma cadastroJogoPlataforma(long idPlataforma, long idJogo) {
		
		Optional<Jogo> jogoExistente = jogoRepository.findById(idJogo);
		Optional<Plataforma> plataformaExistente = plataformaRepository.findById(idPlataforma);
		
		if(jogoExistente.isPresent() && plataformaExistente.isPresent()) {
			plataformaExistente.get().getJogos().add(jogoExistente.get());
			
			plataformaRepository.save(plataformaExistente.get());
			
			return plataformaRepository.save(plataformaExistente.get());
			
		}
		
		return null;
	
	}

}
