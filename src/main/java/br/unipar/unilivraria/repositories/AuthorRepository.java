package br.unipar.unilivraria.repositories;

import br.unipar.unilivraria.domain.Author;
import br.unipar.unilivraria.infra.ConnectionFactory;

import javax.naming.NamingException;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    private static final String INSERT =
            "INSERT INTO author(nome) VALUES(?)";
    private static final String SELECT_ALL =
            "SELECT * FROM author";

    public Author insert(Author author) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();

            pstmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, author.getNome());
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();

            rs.next();
            author.setId(rs.getInt(1));

        }finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }

        return author;
    }

    public ArrayList<Author> getAll() throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<Author> authors = new ArrayList<Author>();

        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(SELECT_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()){
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setNome(rs.getString("nome"));

                authors.add(author);
            }
        }finally {
            if(rs != null){
                rs.close();
            }
            if(pstmt != null){
                pstmt.close();
            }
            if (conn != null){
                conn.close();
            }
        }

        return authors;
    }

    //editar
    //excluir
    //listar
    //buscarPorNome
}
