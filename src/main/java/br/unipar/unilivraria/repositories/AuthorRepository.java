package br.unipar.unilivraria.repositories;

import br.unipar.unilivraria.domain.Author;
import br.unipar.unilivraria.infra.ConnectionFactory;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorRepository {
    private static final String INSERT =
            "INSERT INTO author(name) VALUES(?)";
    private static final String SELECT_ALL =
            "SELECT * FROM author";
    private static final String SELECT_BY_NAME =
            "SELECT * FROM author WHERE name LIKE ?";
    private static final String SELECT_BY_ID =
            "SELECT * FROM author WHERE id = ?";

    public Author insert(Author author) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();

            pstmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, author.getName());
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
                author.setName(rs.getString("name"));

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

    public Author getById(int id) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Author author;

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(SELECT_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));

                return author;
            }

        }finally {
            if(conn != null) conn.close();
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();

        }

        return null;
    }

    public ArrayList<Author> getByName(String name) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        var authors = new ArrayList<Author>();

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(SELECT_BY_NAME);
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();

            while (rs.next()){
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));

                authors.add(author);
            }
        }finally {
            if(conn != null) conn.close();
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
        }

        return authors;
    }
    //editar
    //excluir

}
