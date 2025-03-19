package br.unipar.unilivraria;

import br.unipar.unilivraria.domain.Author;
import br.unipar.unilivraria.dtos.AuthorInsertRequestDTO;
import br.unipar.unilivraria.exception.BusinessException;
import br.unipar.unilivraria.interfaces.AuthorWS;
import br.unipar.unilivraria.services.AuthorService;
import jakarta.jws.WebService;

import javax.naming.NamingException;
import java.sql.SQLException;

@WebService(endpointInterface = "br.unipar.unilivraria.interfaces.AuthorWS")
public class AuthorWsImp implements AuthorWS {
    @Override
    public Author insert(AuthorInsertRequestDTO authorDTO) throws BusinessException, SQLException, NamingException {
        Author author = new Author(authorDTO);

        AuthorService authorService = new AuthorService();
        return authorService.insert(author);
    }
}
