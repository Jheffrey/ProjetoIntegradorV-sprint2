package projetointegradorv.imigrandes.domain.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import projetointegradorv.imigrandes.domain.entity.Vaga;

public interface VagaRepository extends MongoRepository<Vaga, String>{
	
	

}
