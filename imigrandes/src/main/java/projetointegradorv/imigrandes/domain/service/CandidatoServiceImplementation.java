package projetointegradorv.imigrandes.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import projetointegradorv.imigrandes.domain.entity.Candidato;
import projetointegradorv.imigrandes.domain.repository.CandidatoRepository;
import projetointegradorv.imigrandes.exception.NotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CandidatoServiceImplementation implements CandidatoService {
	
	private final CandidatoRepository candidatoRepository;

	@Override
	public List<Candidato> getAll() {
	
		return candidatoRepository.findAll();
	}

	@Override
	public Candidato getById(String id) {
		
		var candidato = candidatoRepository.findById(id);
		
		if (candidato.isEmpty()) {
			throw new NotFoundException("Candidato with ID " + id + " not found");
		}
		
		return candidato.get();
	}

	@Override
	public Candidato save(Candidato candidato) {
		
		if (candidato.getId() != null) {
			//UPDATE
			var existing = getById(candidato.getId());
			
			log.info("Existing: {}", existing);
			
			existing.setNome(candidato.getNome());
			existing.setCpf(candidato.getCpf());
			existing.setDtNascimento(candidato.getDtNascimento());
			existing.setSenha(candidato.getSenha());
			existing.setUsuario(candidato.getUsuario());
			existing.setOrigem(candidato.getOrigem());
			existing.setModifiedAt(LocalDateTime.now());
			
			candidatoRepository.save(existing);
			
			log.info("Saved: {}", existing);
			
			return existing;
		} 
		
		if (candidato.getCreatedAt() == null) {
			candidato.setCreatedAt(LocalDateTime.now());
		}
		
		candidato.setModifiedAt(LocalDateTime.now());
		
		candidatoRepository.save(candidato);
		
		return candidato;
	}

	@Override
	public void delete(String id) {
		
		getById(id);
		
		candidatoRepository.deleteById(id);

	}

}
