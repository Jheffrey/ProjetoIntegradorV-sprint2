package projetointegradorv.imigrandes.domain.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import projetointegradorv.imigrandes.domain.entity.Curriculo;

public interface CurriculoRepository extends MongoRepository<Curriculo, String>{

}
