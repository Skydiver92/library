package com.kuzmenko.readlist.dao;

import com.kuzmenko.readlist.model.Book;

import java.sql.Connection;
import java.util.List;

public interface ReadListDAO {

    public void add(Book book);

    public List<Book> getAll();

    public Book getByID(int id);

    public void update(Book book);

    public void remove(int id);

}
