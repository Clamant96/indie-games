package com.exploregames.indieGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploregames.indieGames.model.Plataforma;
import com.exploregames.indieGames.repository.PlataformaRepository;

@RestController
@RequestMapping("/plataformas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlataformaController {
	
	@Autowired
	private PlataformaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Plataforma>> findAllPlataforma(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Plataforma> findByIdPlataforma(@PathVariable long id){
		
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Plataforma>> findByNomePlataforma(@PathVariable String nome){
		
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Plataforma> postPlataforma(@RequestBody Plataforma plataforma){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(plataforma));
	}
	
	@PutMapping
	public ResponseEntity<Plataforma> putPlataforma(@RequestBody Plataforma plataforma){
		
		return ResponseEntity.ok(repository.save(plataforma));
	}
	
	@DeleteMapping("/{id}")
	public void deletePlataforma(@PathVariable long id){
		
		repository.deleteById(id);
	}

}
