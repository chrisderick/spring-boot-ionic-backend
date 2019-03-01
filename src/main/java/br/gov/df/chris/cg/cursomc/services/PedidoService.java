package br.gov.df.chris.cg.cursomc.services;

import br.gov.df.chris.cg.cursomc.domain.Pedido;
import br.gov.df.chris.cg.cursomc.repositories.PedidoRepository;
import br.gov.df.chris.cg.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
