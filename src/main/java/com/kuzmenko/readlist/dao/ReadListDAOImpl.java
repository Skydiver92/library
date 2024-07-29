package com.kuzmenko.readlist.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kuzmenko.readlist.model.Book;

public class ReadListDAOImpl extends Factory implements ReadListDAO {


    public void add(Book book) {
        String sql = "INSERT INTO BOOK (ID, TITLE, AUTHOR, GENRE, MARK, COMMENT) VALUES (?,?,?,?,?,?);";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setLong(1, System.currentTimeMillis());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getGenre());
            preparedStatement.setInt(5, book.getMark());
            preparedStatement.setString(6, book.getComment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Book> getAll() {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM BOOK";

        try (
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("ID"));
                book.setTitle(resultSet.getString("TITLE"));
                book.setAuthor(resultSet.getString("AUTHOR"));
                book.setGenre(resultSet.getString("GENRE"));
                book.setMark(resultSet.getInt("MARK"));
                book.setComment(resultSet.getString("COMMENT"));

                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }


    public Book getByID(Long id) {

        Book book = new Book();
        String sql = "SELECT ID, TITLE, AUTHOR, GENRE, MARK, COMMENT FROM BOOK WHERE ID=?;";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                book.setId(resultSet.getLong("ID"));
                book.setTitle(resultSet.getString("TITLE"));
                book.setAuthor(resultSet.getString("AUTHOR"));
                book.setGenre(resultSet.getString("GENRE"));
                book.setMark(resultSet.getInt("MARK"));
                book.setComment(resultSet.getString("COMMENT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }


    public void update(Book book) {

        String sql = "UPDATE BOOK SET  TITLE=?, AUTHOR=?, GENRE=?, MARK=?, COMMENT=? WHERE ID=?;";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setInt(4, book.getMark());
            preparedStatement.setString(5, book.getComment());
            preparedStatement.setLong(6, book.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void remove(Long id) {

        String sql = "DELETE FROM BOOK WHERE ID=?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
