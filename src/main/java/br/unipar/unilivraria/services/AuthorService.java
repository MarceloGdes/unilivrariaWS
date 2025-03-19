package br.unipar.unilivraria.services;

import br.unipar.unilivraria.domain.Author;
import br.unipar.unilivraria.dtos.AuthorInsertRequestDTO;
import br.unipar.unilivraria.exception.BusinessException;

public class AuthorService {

    public Author insert(Author author) throws BusinessException{
        if(author.getNome() == null || author.getNome().isEmpty()){
            throw  new BusinessException("O Nome do autor é obrigatório");
        }

        if(author.getNome().length() > 100){
            throw new BusinessException("O nome do autor é maior que 100 caracteres");
        }

        return null;
    }
}
