package br.gov.df.chris.cg.cursomc.dto;

import br.gov.df.chris.cg.cursomc.domain.Cliente;
import br.gov.df.chris.cg.cursomc.services.validation.ClienteUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @ClienteUpdate
public class ClienteDTO implements Serializable {
    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max= 120, message = "O tamanho deve ser entre 5 e 120 caracteres.")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    public ClienteDTO(Cliente obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();

    }

}
