package com.kuzmenko.readlistcrud.model;

import java.util.Objects;

public class Book {
    public int id;
    public String date;
    public String bookName;
    public String author;
    public String genre;
    public int mark;
    public String comment;

    public Book(String date, String bookName, String author, String genre, int mark, String comment) {
        this.date = date;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.mark = mark;
        this.comment = comment;
    }

    public Book(String date, String bookName, String author, String genre, int mark) {
        this.date = date;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.mark = mark;
    }

    public Book() {
    }

    public Book(int id, String date, String bookName, String author, String genre, int mark, String comment) {
        this.id = id;
        this.date = date;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.mark = mark;
        this.comment = comment;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



    @Override
    public String toString() {
        return getClass().getSimpleName() + " (id: " +
                id + " date " +
                date + " bookName " +
                bookName + " author " + author + " genre " + genre + " mark " + mark + " comment " + comment + ")";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                mark == book.mark &&
                Objects.equals(date, book.date) &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(author, book.author) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(comment, book.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, bookName, author, genre, mark, comment);
    }
}
