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
import projetointegradorv.imigrandes.domain.entity.Candidato;
import projetointegradorv.imigrandes.domain.service.CandidatoService;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
public class CandidatoController {
	
	private final CandidatoService candidatoService;
	
	@PostMapping("/candidatos")
	public Candidato save(@RequestBody Candidato candidato) {
		
		var saved = candidatoService.save(candidato);
		
		return saved;
	}

	@PutMapping("/candidatos/{id}")
	public Candidato update(@PathVariable String id, @RequestBody Candidato candidato) {
		
		var saved = candidatoService.save(candidato);
		
		return saved;
	}

	@GetMapping("/candidatos/{id}")
	public Candidato getById(@PathVariable String id) {
		
		var candidato = candidatoService.getById(id);
		
		return candidato;
	}	

	@GetMapping("/candidatos")
	public List<Candidato> getAll() {
		
		return candidatoService.getAll();
	}	

	@DeleteMapping("/candidatos/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		candidatoService.delete(id);
		
		return new ResponseEntity<Void>(NO_CONTENT);
	}
	
}
