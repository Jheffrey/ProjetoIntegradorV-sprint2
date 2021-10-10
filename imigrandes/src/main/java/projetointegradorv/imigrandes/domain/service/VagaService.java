package projetointegradorv.imigrandes.domain.service;

import java.util.List;

import projetointegradorv.imigrandes.domain.entity.Vaga;

public interface VagaService {
	
	//GET all
	List<Vaga> getAll();
	
	//GET by ID
	Vaga getById(String id);
	
	//CREATE, UPDATE
	Vaga save(Vaga vaga);
	
	//DELETE
	void delete(String id);

}
