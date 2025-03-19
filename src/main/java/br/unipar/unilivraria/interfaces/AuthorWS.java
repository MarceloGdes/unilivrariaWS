package br.unipar.unilivraria.interfaces;

import br.unipar.unilivraria.domain.Author;
import br.unipar.unilivraria.dtos.AuthorInsertRequestDTO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface AuthorWS {

    @WebMethod
    Author insert(AuthorInsertRequestDTO authorDTO);
}
