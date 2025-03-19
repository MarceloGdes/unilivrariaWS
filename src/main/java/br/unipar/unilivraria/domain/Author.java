package br.unipar.unilivraria.domain;

import br.unipar.unilivraria.dtos.AuthorInsertRequestDTO;

public class Author {
    private Integer id;
    private String nome; //TODO: Alterar o nome do metodo para name

    public Author(AuthorInsertRequestDTO authorDTO) {
        nome = authorDTO.getNome();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
