package br.gov.df.chris.cg.cursomc.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter @Setter @Embeddable
public class ItemPedidoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemPedidoPK that = (ItemPedidoPK) o;

        if (!pedido.equals(that.pedido)) return false;
        return produto.equals(that.produto);
    }

    @Override
    public int hashCode() {
        int result = pedido.hashCode();
        result = 31 * result + produto.hashCode();
        return result;
    }
}
