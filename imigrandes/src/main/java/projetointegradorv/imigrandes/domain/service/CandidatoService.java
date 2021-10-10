package projetointegradorv.imigrandes.domain.service;

import java.util.List;

import projetointegradorv.imigrandes.domain.entity.Candidato;

public interface CandidatoService {
	
	//GET all
	List<Candidato> getAll();
	
	//GET by ID
	Candidato getById(String id);
	
	//CREATE, UPDATE
	Candidato save(Candidato candidato);
	
	//DELETE
	void delete(String id);

}
