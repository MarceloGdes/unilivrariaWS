package br.unipar.unilivraria.repositories;

import br.unipar.unilivraria.domain.Author;
import br.unipar.unilivraria.infra.ConnectionFactory;

import javax.naming.NamingException;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRepository {
    private static final String INSERT = "INSERT INTO author(nome) VALUES(?)";

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

    //editar
    //excluir
    //listar
    //buscarPorNome
}
