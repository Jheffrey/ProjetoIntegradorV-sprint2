package projetointegradorv.imigrandes.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import projetointegradorv.imigrandes.domain.entity.Vaga;
import projetointegradorv.imigrandes.domain.repository.VagaRepository;
import projetointegradorv.imigrandes.exception.NotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class VagaServiceImplementation implements VagaService {
	
	private final VagaRepository vagaRepository;

	@Override
	public List<Vaga> getAll() {
	
		return vagaRepository.findAll();
	}

	@Override
	public Vaga getById(String id) {
		
		var vaga = vagaRepository.findById(id);
		
		if (vaga.isEmpty()) {
			throw new NotFoundException("Vaga with ID " + id + " not found");
		}
		
		return vaga.get();
	}

	@Override
	public Vaga save(Vaga vaga) {
		
		if (vaga.getId() != null) {
			//UPDATE
			var existing = getById(vaga.getId());
			
			log.info("Existing: {}", existing);
			
			existing.setCargo(vaga.getCargo());
			existing.setEmpresa(vaga.getEmpresa());
			existing.setEscolaridade(vaga.getEscolaridade());
			existing.setSalario(vaga.getSalario());
			existing.setCargaHorariaSemanal(vaga.getCargaHorariaSemanal());
			existing.setModifiedAt(LocalDateTime.now());
			
			vagaRepository.save(existing);
			
			log.info("Saved: {}", existing);
			
			return existing;
		} 
		
		if (vaga.getCreatedAt() == null) {
			vaga.setCreatedAt(LocalDateTime.now());
		}
		
		vaga.setModifiedAt(LocalDateTime.now());
		
		vagaRepository.save(vaga);
		
		return vaga;
	}

	@Override
	public void delete(String id) {
		
		getById(id);
		
		vagaRepository.deleteById(id);

	}

}
