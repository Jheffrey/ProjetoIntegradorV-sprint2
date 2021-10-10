package projetointegradorv.imigrandes.domain.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import projetointegradorv.imigrandes.domain.entity.Candidato;

public interface CandidatoRepository extends MongoRepository<Candidato, String>{
	
	

}
