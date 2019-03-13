package br.gov.df.chris.cg.cursomc.dto;

import br.gov.df.chris.cg.cursomc.domain.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class ProdutoDTO implements Serializable {
    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDTO(Produto obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.preco = obj.getPreco();
    }
}
