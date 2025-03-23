package br.unipar.unilivraria.domain;

import br.unipar.unilivraria.dtos.AuthorInsertRequestDTO;

public class Author {
    private Integer id;
    private String name; //TODO: Alterar o nome do metodo para name

    public Author(AuthorInsertRequestDTO authorDTO) {
        name = authorDTO.getName();
    }
    public Author() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
