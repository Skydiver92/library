package com.kuzmenko.readlist.dao;

import com.kuzmenko.readlist.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReadListDAOImpl extends Factory implements ReadListDAO  {
    private Connection connection;

    public ReadListDAOImpl() {
        connection = getConnection();

    }

    public void add(Book book) {
        String sql = "INSERT INTO BOOK (DATE, BOOKNAME, AUTHOR, GENRE, MARK, COMMENT) VALUES (?,?,?,?,?,?);";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, book.getDate());
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
                book.setId(resultSet.getInt("ID"));
                book.setDate(String.valueOf(resultSet.getDate("DATE")));
                book.setTitle(resultSet.getString("BOOKNAME"));
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


    public Book getByID(int id) {

        Book book = new Book();
        String sql = "SELECT ID, DATE, BOOKNAME, AUTHOR, GENRE, MARK, COMMENT FROM BOOK WHERE ID=?;";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                book.setId(resultSet.getInt("ID"));
                book.setDate(resultSet.getString("DATE"));
                book.setTitle(resultSet.getString("BOOKNAME"));
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

        String sql = "UPDATE BOOK SET DATE=?, BOOKNAME=?, AUTHOR=?, GENRE=?, MARK=?, COMMENT=? WHERE ID=?;";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, book.getDate());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getGenre());
            preparedStatement.setInt(5, book.getMark());
            preparedStatement.setString(6, book.getComment());
            preparedStatement.setInt(7, book.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void remove(int id) {

        String sql = "DELETE FROM BOOK WHERE ID=?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
