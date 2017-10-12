package br.unicesumar.cor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cores")
public class CorController {
	
	@Autowired
	private CorRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Cor>> obterTodas(){
		return ResponseEntity.ok().body(repo.findAll());
	}
	
	@PutMapping
	public ResponseEntity<String> alterar(@RequestBody Cor nova){
		repo.save(nova);
		return ResponseEntity.ok().body(nova.getId());
	}
	
	@PostMapping
	public ResponseEntity<String> incluir(@RequestBody Cor nova){
		repo.save(nova);
		return ResponseEntity.ok().body(nova.getId());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover (@PathVariable String id){
		repo.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cor> recuperarPeloId(@PathVariable String id){
		Cor cor = repo.findOne(id);
		
		if(cor == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(repo.findOne(id));
	}
	
}
