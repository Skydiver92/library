package com.kuzmenko.readlist.dao;

import java.util.List;

import com.kuzmenko.readlist.model.Book;

 public interface ReadListDAO {

     void add(Book book);


     List<Book> getAll();


     Book getByID(Long id);


     void update(Book book);


     void remove(Long id);

}
