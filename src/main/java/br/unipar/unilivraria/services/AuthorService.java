package br.unipar.unilivraria.services;

import br.unipar.unilivraria.domain.Author;
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
        if(author.getName() == null || author.getName().isEmpty()){
            throw  new BusinessException("O Nome do autor é obrigatório");
        }

        if(author.getName().length() > 100){
            throw new BusinessException("O nome do autor é maior que 100 caracteres");
        }

        return repository.insert(author);
    }

    public ArrayList<Author> getAll() throws SQLException, NamingException {
        return repository.getAll();
    }

    public Author getById(int id) throws SQLException, NamingException, BusinessException {
        var author = repository.getById(id);

        if(author == null) throw new BusinessException("Autor não encontrado");

        return author;
    }

    public ArrayList<Author> getByName(String name) throws SQLException, NamingException, BusinessException {
        if(name == null || name.isEmpty()){
            throw new BusinessException("Você não inseriu um nome!");
        }

        return repository.getByName(name);
    }
}
