package com.kuzmenko.readlist.model;

import java.util.Objects;

public class Book {

    public Long id;

    public String title;

    public String author;

    public String genre;

    public Integer mark;

    public String comment;


    public Book(String title, String author, String genre, Integer mark, String comment) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.mark = mark;
        this.comment = comment;
    }


    public Book(String title, String author, String genre, Integer mark) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.mark = mark;
    }


    public Book() {
    }


    public Book(Long id, String title, String author, String genre, Integer mark, String comment) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.mark = mark;
        this.comment = comment;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
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


    public void setMark(Integer mark) {
        this.mark = mark;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return id == book.id && Objects.equals(title, book.title) && Objects.equals(author, book.author) &&
                Objects.equals(genre, book.genre) && Objects.equals(mark, book.mark) &&
                Objects.equals(comment, book.comment);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, genre, mark, comment);
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", mark=" + mark +
                ", comment='" + comment + '\'' +
                '}';
    }


    public boolean validate() {
        return this.title != null && this.author != null &&
                this.genre != null && this.mark != null && this.comment != null;

    }

}
