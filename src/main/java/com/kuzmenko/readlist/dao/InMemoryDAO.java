package com.kuzmenko.readlist.dao;

import com.kuzmenko.readlist.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDAO implements ReadListDAO {

    private static final Map<Long, Book> BOOK_BY_ID = new HashMap<>();

    static {
        long id1 = System.currentTimeMillis();
        long id2 = System.currentTimeMillis() + 100;
        BOOK_BY_ID.put(id1, new Book(id1, "dsfvfdsv", "evrrvrv", "Detective", 4, "ewcfevc"));
        BOOK_BY_ID.put(id2, new Book(id2, "dsd", "sss", "Detective", 3, "dfvdv"));
    }

    public void add(Book book) {
        var id = System.currentTimeMillis();
        book.setId(id);
        BOOK_BY_ID.put(id, book);
    }


    public List<Book> getAll() {
        return new ArrayList<>(BOOK_BY_ID.values());
    }


    public Book getByID(Long id) {
        return BOOK_BY_ID.get(id);
    }


    public void update(Book book) {
        BOOK_BY_ID.replace(book.getId(), book);
    }


    public void remove(Long id) {
        BOOK_BY_ID.remove(id);
    }

}
