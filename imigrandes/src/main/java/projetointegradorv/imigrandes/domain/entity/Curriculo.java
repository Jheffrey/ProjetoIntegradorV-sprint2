package projetointegradorv.imigrandes.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curriculo {
	
	@Id
	private String id;

	private String nome;

	private String email;

	private String telefone;
	
	private String escolaridade;

	private String nacionalidade;
	
	private Double pretensaoSalarial;

	private String experiencias;

	private String habilidades;

	private String idiomas;

	private LocalDateTime createdAt;
    
    private LocalDateTime modifiedAt;

}
