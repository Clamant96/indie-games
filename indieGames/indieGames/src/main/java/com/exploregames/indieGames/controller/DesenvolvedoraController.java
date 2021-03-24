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

import com.exploregames.indieGames.model.Desenvolvedora;
import com.exploregames.indieGames.repository.DesenvolvedoraRepository;

@RestController
@RequestMapping("/desenvolvedoras")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DesenvolvedoraController {
	
	@Autowired
	private DesenvolvedoraRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Desenvolvedora>> findAllDesenvolvedora(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Desenvolvedora> findById(@PathVariable long id){
		
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Desenvolvedora>> findByNome(@PathVariable String nome){
		
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Desenvolvedora> postDesenvolvedora(@RequestBody Desenvolvedora desenvolvedora){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(desenvolvedora));
	}
	
	@PutMapping
	public ResponseEntity<Desenvolvedora> putDesenvolvedora(@RequestBody Desenvolvedora desenvolvedora){
		
		return ResponseEntity.ok(repository.save(desenvolvedora));
	}
	
	@DeleteMapping("/{id}")
	public void deleteDesenvolvedora(@PathVariable long id) {
		
		repository.deleteById(id);
	}
}
