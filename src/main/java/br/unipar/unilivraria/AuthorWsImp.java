package br.unipar.unilivraria;

import br.unipar.unilivraria.domain.Author;
import br.unipar.unilivraria.dtos.AuthorInsertRequestDTO;
import br.unipar.unilivraria.exception.BusinessException;
import br.unipar.unilivraria.interfaces.AuthorWS;
import br.unipar.unilivraria.services.AuthorService;
import jakarta.jws.WebService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebService(endpointInterface = "br.unipar.unilivraria.interfaces.AuthorWS")
public class AuthorWsImp implements AuthorWS {
    private final AuthorService authorService = new AuthorService();
    @Override
    public Author insert(AuthorInsertRequestDTO authorDTO) throws BusinessException, SQLException, NamingException {
        Author author = new Author(authorDTO);

        return authorService.insert(author);
    }

    @Override
    public ArrayList<Author> getAll() throws SQLException, NamingException {
        return authorService.getAll();
    }

    @Override
    public Author get(int id) {
        return null;
    }
}
