package com.kuzmenko.readlist.model;

import com.kuzmenko.readlist.dao.Factory;
import com.kuzmenko.readlist.dao.ReadListDAOImpl;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ReadListDAOImplTest extends Factory {
//
//    private ReadListDAOImpl readListDAOImpl = new ReadListDAOImpl();
//    private Connection connection = getConnection();
//
//    @ExampleTest
//    public void add() {
//
//        //создаём тестовые данные
//        Book expected = new Book("2017-01-20","Sherlok Holms","Arthur Conan Doil",
//                "detective",5,"Good book about detective");
//
//        readListDAOImpl.add(expected,connection);
//
//
//
//
//        //создаем список expected и заполняем его данными нашего метода
//
//
//        //создаем actual в него помещаем данные для сравнения
//        //то что мы предпологаем метод должен вернуть
//        String sql = "SELECT* FROM BOOK";
//
//        Book actual = new Book();
//        try (
//                Statement statement = connection.createStatement()
//        ) {
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//
//                actual.setDate(String.valueOf(resultSet.getDate("DATE")));
//                actual.setTitle(resultSet.getString("BOOKNAME"));
//                actual.setAuthor(resultSet.getString("AUTHOR"));
//                actual.setGenre(resultSet.getString("GENRE"));
//                actual.setMark(resultSet.getInt("MARK"));
//                actual.setComment(resultSet.getString("COMMENT"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try (
//                Statement statement = connection.createStatement()
//        ) {
//            statement.executeUpdate("DELETE  FROM BOOK");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        //запускаем тест, в случае если список expected и actual не будут равны
//        //тест будет провален, о результатах теста читаем в консоли
//        Assert.assertEquals(expected, actual);
//
//
//    }

//    @ExampleTest
//    public void getAll() {
//
//        Student student1 = new Student();
//        student1.setId(1);
//        student1.setFirstName("Vasia");
//        student1.setSecondName("Pupcin");
//        student1.setBirthDate("1990-03-04");
//        student1.setEnterYear(2013);
//        student1.setSex('m');
//
//        Student student2 = new Student();
//        student2.setId(2);
//        student2.setFirstName("Dima");
//        student2.setSecondName("Petrov");
//        student2.setBirthDate("1992-02-08");
//        student2.setEnterYear(2013);
//        student2.setSex('m');
//
//        Student student3 = new Student();
//        student3.setId(3);
//        student3.setFirstName("Julia");
//        student3.setSecondName("Servantes");
//        student3.setBirthDate("1993-10-04");
//        student3.setEnterYear(2013);
//        student3.setSex('f');
//
//        List<Student> expected = new ArrayList<>();
//        expected.add(student1);
//        expected.add(student2);
//        expected.add(student3);
//
//        studentDAO.add(student1);
//        studentDAO.add(student2);
//        studentDAO.add(student3);
//
//        List<Student> actual = studentDAO.getAll();
//
//        try (
//                Statement statement = connection.createStatement()
//        ) {
//            statement.executeUpdate("DELETE  FROM STUDENT");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        Assert.assertEquals(expected, actual);
//
//    }
//
//    @ExampleTest
//    public void getByID() {
//
//        Student expected = new Student();
//        expected.setId(13);
//        expected.setFirstName("Vasia");
//        expected.setSecondName("Pupcin");
//        expected.setBirthDate("1992-02-04");
//        expected.setEnterYear(2013);
//        expected.setSex('m');
//
//
//        studentDAO.add(expected);
//
//        Student actual = studentDAO.getByID(13);
//
//        try (
//                Statement statement = connection.createStatement()
//        ) {
//            statement.executeUpdate("DELETE  FROM STUDENT");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        Assert.assertEquals(expected, actual);
//
//    }
//
//    @ExampleTest
//    public void update() {
//
//        Student student1 = new Student();
//        student1.setId(1);
//        student1.setFirstName("Vasia");
//        student1.setSecondName("Pupcin");
//        student1.setBirthDate("1990-03-04");
//        student1.setEnterYear(2013);
//        student1.setSex('m');
//
//        Student student2 = new Student();
//        student2.setId(2);
//        student2.setFirstName("Dima");
//        student2.setSecondName("Petrov");
//        student2.setBirthDate("1992-02-08");
//        student2.setEnterYear(2013);
//        student2.setSex('m');
//
//        Student student3 = new Student();
//        student3.setId(2);
//        student3.setFirstName("Julia");
//        student3.setSecondName("Servantes");
//        student3.setBirthDate("1993-10-04");
//        student3.setEnterYear(2013);
//        student3.setSex('f');
//
//        studentDAO.add(student1);
//        studentDAO.add(student2);
//        studentDAO.update(student3);
//
//        List<Student> expected = new ArrayList<>();
//        expected.add(student1);
//        expected.add(student3);
//
//        List<Student> actual = studentDAO.getAll();
//
//        try (
//                Statement statement = connection.createStatement()
//        ) {
//            statement.executeUpdate("DELETE  FROM STUDENT");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        Assert.assertEquals(expected, actual);
//
//
//    }
//
//    @ExampleTest
//    public void remove() {
//
//        Student student1 = new Student();
//        student1.setId(1);
//        student1.setFirstName("Vasia");
//        student1.setSecondName("Pupcin");
//        student1.setBirthDate("1990-03-04");
//        student1.setEnterYear(2013);
//        student1.setSex('m');
//
//        Student student2 = new Student();
//        student2.setId(2);
//        student2.setFirstName("Dima");
//        student2.setSecondName("Petrov");
//        student2.setBirthDate("1992-02-08");
//        student2.setEnterYear(2013);
//        student2.setSex('m');
//
//        studentDAO.add(student1);
//        studentDAO.add(student2);
//        studentDAO.remove(student2);
//
//        List<Student> expected = new ArrayList<>();
//        expected.add(student1);
//
//        List<Student> actual = studentDAO.getAll();
//
//        try (
//                Statement statement = connection.createStatement()
//        ) {
//            statement.executeUpdate("DELETE  FROM STUDENT");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        Assert.assertEquals(expected, actual);
//    }




}