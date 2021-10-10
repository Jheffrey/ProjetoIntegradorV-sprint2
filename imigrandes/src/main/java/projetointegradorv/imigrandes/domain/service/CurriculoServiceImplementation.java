package projetointegradorv.imigrandes.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import projetointegradorv.imigrandes.domain.entity.Curriculo;
import projetointegradorv.imigrandes.domain.repository.CurriculoRepository;
import projetointegradorv.imigrandes.exception.NotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurriculoServiceImplementation implements CurriculoService {
	
	private final CurriculoRepository curriculoRepository;

	@Override
	public List<Curriculo> getAll() {
	
		return curriculoRepository.findAll();
	}

	@Override
	public Curriculo getById(String id) {
		
		var curriculo = curriculoRepository.findById(id);
		
		if (curriculo.isEmpty()) {
			throw new NotFoundException("Curriculo with ID " + id + " not found");
		}
		
		return curriculo.get();
	}

	@Override
	public Curriculo save(Curriculo curriculo) {
		
		if (curriculo.getId() != null) {
			//UPDATE
			var existing = getById(curriculo.getId());
			
			log.info("Existing: {}", existing);
			
			existing.setNome(curriculo.getNome());
			existing.setEmail(curriculo.getEmail());
			existing.setTelefone(curriculo.getTelefone());
			existing.setEscolaridade(curriculo.getEscolaridade());
			existing.setNacionalidade(curriculo.getNacionalidade());
			existing.setPretensaoSalarial(curriculo.getPretensaoSalarial());
			existing.setExperiencias(curriculo.getExperiencias());
			existing.setHabilidades(curriculo.getHabilidades());
			existing.setIdiomas(curriculo.getIdiomas());
			existing.setModifiedAt(LocalDateTime.now());


			
			curriculoRepository.save(existing);
			
			log.info("Saved: {}", existing);
			
			return existing;
		} 
		
		if (curriculo.getCreatedAt() == null) {
			curriculo.setCreatedAt(LocalDateTime.now());
		}
		
		curriculo.setModifiedAt(LocalDateTime.now());
		
		curriculoRepository.save(curriculo);
		
		return curriculo;
	}

	@Override
	public void delete(String id) {
		
		getById(id);
		
		curriculoRepository.deleteById(id);

	}

}
