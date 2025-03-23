package br.unipar.unilivraria.interfaces;

import br.unipar.unilivraria.domain.Author;
import br.unipar.unilivraria.dtos.AuthorInsertRequestDTO;
import br.unipar.unilivraria.exception.BusinessException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebService
public interface AuthorWS {

    @WebMethod
    Author insert(AuthorInsertRequestDTO authorDTO) throws BusinessException, SQLException, NamingException;
    ArrayList<Author> getAll() throws SQLException, NamingException;
    Author get(int id);
}
