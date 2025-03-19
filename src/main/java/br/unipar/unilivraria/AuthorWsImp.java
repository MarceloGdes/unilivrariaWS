package br.unipar.unilivraria;

import br.unipar.unilivraria.domain.Author;
import br.unipar.unilivraria.dtos.AuthorInsertRequestDTO;
import br.unipar.unilivraria.interfaces.AuthorWS;
import br.unipar.unilivraria.services.AuthorService;
import jakarta.jws.WebService;

@WebService(endpointInterface = "br.unipar.unilivraria.interfaces.AuthorWS")
public class AuthorWsImp implements AuthorWS {
    @Override
    public Author insert(AuthorInsertRequestDTO authorDTO) {
        Author author = new Author(authorDTO);

        AuthorService authorService = new AuthorService();
        return authorService.insert(author);
    }
}
