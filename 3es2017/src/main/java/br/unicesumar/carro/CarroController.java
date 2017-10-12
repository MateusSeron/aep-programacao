package br.unicesumar.carro;

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
@RequestMapping("/carros")
public class CarroController {
	
	@Autowired
	private CarroRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Carro>>  obterTodos(){
		return ResponseEntity.ok().body(repo.findAll());
	}
	
	@GetMapping("/{placa}")
	public ResponseEntity<Carro> obterPeloId(@PathVariable String placa){
		Carro carro = repo.findOne(placa);
		
		if( carro == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(repo.findOne(placa));
	}
	
	@PostMapping
	public ResponseEntity<String> adicionar(@RequestBody Carro novoCarro){
		repo.save(novoCarro);
		return ResponseEntity.ok().body(novoCarro.getPlaca());
	}
	
	@DeleteMapping("/{placa}")
	public ResponseEntity<Void> removerCarro(@PathVariable String placa){
		repo.delete(placa);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<String> alterarCarro(@RequestBody Carro novoCarro){
		repo.save(novoCarro);
		return ResponseEntity.ok().body(novoCarro.getPlaca());
	}
	
}
