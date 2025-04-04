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
    ArrayList<Author> getByName(String name) throws BusinessException, SQLException, NamingException;
    Author getById(int id) throws BusinessException, SQLException, NamingException;
    void update(int id, AuthorInsertRequestDTO authorInsertRequestDTO);
    void remove(int id);

}
