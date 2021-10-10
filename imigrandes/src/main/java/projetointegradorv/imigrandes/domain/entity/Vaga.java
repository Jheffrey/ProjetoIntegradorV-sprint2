package projetointegradorv.imigrandes.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {
	
	@Id
	private String id;
	
	private String cargo;
	
	private String empresa;
	
	private String escolaridade;
	
	private Double salario;
	
	private int cargaHorariaSemanal;
	
	private LocalDateTime createdAt;
    
    private LocalDateTime modifiedAt; 

}
