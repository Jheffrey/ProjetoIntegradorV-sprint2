package projetointegradorv.imigrandes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import projetointegradorv.imigrandes.domain.entity.Vaga;
import projetointegradorv.imigrandes.domain.service.VagaService;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
public class VagaController {
	
	private final VagaService vagaService;
	
	@PostMapping("/vagas")
	public Vaga save(@RequestBody Vaga vaga) {
		
		var saved = vagaService.save(vaga);
		
		return saved;
	}

	@PutMapping("/vagas/{id}")
	public Vaga update(@PathVariable String id, @RequestBody Vaga vaga) {
		
		var saved = vagaService.save(vaga);
		
		return saved;
	}

	@GetMapping("/vagas/{id}")
	public Vaga getById(@PathVariable String id) {
		
		var vaga = vagaService.getById(id);
		
		return vaga;
	}	

	@GetMapping("/vagas")
	public List<Vaga> getAll() {
		
		return vagaService.getAll();
	}	

	@DeleteMapping("/vagas/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		vagaService.delete(id);
		
		return new ResponseEntity<Void>(NO_CONTENT);
	}
	
}
