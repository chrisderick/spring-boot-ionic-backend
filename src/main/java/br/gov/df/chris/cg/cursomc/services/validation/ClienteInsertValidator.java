package br.gov.df.chris.cg.cursomc.services.validation;

import br.gov.df.chris.cg.cursomc.api.exceptions.FieldMessage;
import br.gov.df.chris.cg.cursomc.domain.Cliente;
import br.gov.df.chris.cg.cursomc.domain.enums.TipoCliente;
import br.gov.df.chris.cg.cursomc.dto.ClienteNewDTO;
import br.gov.df.chris.cg.cursomc.repositories.ClienteRepository;
import br.gov.df.chris.cg.cursomc.services.validation.util.BR;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository repo;

    @Override
    public void initialize(ClienteInsert ann) {
    }
    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())){
            list.add((new FieldMessage("cpfOuCnpj", "CPF inválido")));
        }
        if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())){
            list.add((new FieldMessage("cpfOuCnpj", "CNPJ inválido")));
        }

        Cliente aux = repo.findByEmail(objDto.getEmail());
        if (aux != null) {
            list.add(new FieldMessage("email", "Email já existente!"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}