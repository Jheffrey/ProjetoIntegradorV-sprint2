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
import projetointegradorv.imigrandes.domain.entity.Curriculo;
import projetointegradorv.imigrandes.domain.service.CurriculoService;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
public class CurriculoController {
	
	private final CurriculoService curriculoService;
	
	@PostMapping("/curriculos")
	public Curriculo save(@RequestBody Curriculo curriculo) {
		
		var saved = curriculoService.save(curriculo);
		
		return saved;
	}

	@PutMapping("/curriculos/{id}")
	public Curriculo update(@PathVariable String id, @RequestBody Curriculo curriculo) {
		
		var saved = curriculoService.save(curriculo);
		
		return saved;
	}

	@GetMapping("/curriculos/{id}")
	public Curriculo getById(@PathVariable String id) {
		
		var curriculo = curriculoService.getById(id);
		
		return curriculo;
	}	

	@GetMapping("/curriculos")
	public List<Curriculo> getAll() {
		
		return curriculoService.getAll();
	}	

	@DeleteMapping("/curriculos/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		curriculoService.delete(id);
		
		return new ResponseEntity<Void>(NO_CONTENT);
	}
	
}
