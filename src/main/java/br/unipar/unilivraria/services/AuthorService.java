package br.unipar.unilivraria.services;

import br.unipar.unilivraria.domain.Author;
import br.unipar.unilivraria.dtos.AuthorInsertRequestDTO;
import br.unipar.unilivraria.exception.BusinessException;
import br.unipar.unilivraria.repositories.AuthorRepository;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorService {

    private AuthorRepository repository;
    public AuthorService() {
        repository = new AuthorRepository();
    }

    public Author insert(Author author) throws BusinessException, SQLException, NamingException {
        if(author.getNome() == null || author.getNome().isEmpty()){
            throw  new BusinessException("O Nome do autor é obrigatório");
        }

        if(author.getNome().length() > 100){
            throw new BusinessException("O nome do autor é maior que 100 caracteres");
        }

        return repository.insert(author);
    }

    public ArrayList<Author> getAll() throws SQLException, NamingException {
        return repository.getAll();
    }
}
