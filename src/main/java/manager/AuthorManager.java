package manager;

import dbConnection.DatabaseConnectionProvider;
import model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorManager {

    private final Connection connection = DatabaseConnectionProvider.getConnector().getConnection();

    public void addAuthor(Author author) {
        String sql = "INSERT INTO author(`name`, surname, email, age, profile_picture) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, author.getName());
            ps.setString(2, author.getSurname());
            ps.setString(3, author.getEmail());
            ps.setInt(4, author.getAge());
            ps.setString(5, author.getProfilePicture());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) author.setId(keys.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Author> showAuthors() {
        List<Author> authorList = new ArrayList<>();
        String sql = "SELECT * FROM author";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Author author = Author.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .age(resultSet.getInt(5))
                        .profilePicture(resultSet.getString(6))
                        .build();
                authorList.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorList;
    }

    public void removeAuthorById(int id) {
        String sql = "DELETE FROM author WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Author getAuthorById(int id) {
        String sql = "SELECT * FROM author WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Author.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .age(resultSet.getInt(5))
                        .profilePicture(resultSet.getString(6))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void edit(Author author) {
        String sql = "UPDATE author SET `name`=?, surname=?, email=?, age=?, profile_picture=? WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, author.getName());
            ps.setString(2, author.getSurname());
            ps.setString(3, author.getEmail());
            ps.setInt(4, author.getAge());
            ps.setString(5, author.getProfilePicture());
            ps.setInt(6, author.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
