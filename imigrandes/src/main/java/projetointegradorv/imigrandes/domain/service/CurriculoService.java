package projetointegradorv.imigrandes.domain.service;

import java.util.List;

import projetointegradorv.imigrandes.domain.entity.Curriculo;

public interface CurriculoService {
	
	//GET all
	List<Curriculo> getAll();
	
	//GET by ID
	Curriculo getById(String id);
	
	//CREATE, UPDATE
	Curriculo save(Curriculo curriculo);
	
	//DELETE
	void delete(String id);

}
