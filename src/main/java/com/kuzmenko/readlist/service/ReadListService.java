package com.kuzmenko.readlist.service;

import java.io.IOException;

import com.kuzmenko.readlist.dao.InMemoryDAO;
import com.kuzmenko.readlist.dao.ReadListDAO;
import com.kuzmenko.readlist.model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReadListService {

    private final ReadListDAO readListDAO = new InMemoryDAO();


    public void listBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var bookList = readListDAO.getAll();
        request.setAttribute("bookList", bookList);

        var dispatcher = request.getRequestDispatcher("ReadList.jsp");
        dispatcher.forward(request, response);
    }


    public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var dispatcher = request.getRequestDispatcher("ReadListForm.jsp");

        dispatcher.forward(request, response);
    }


    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = Long.valueOf(request.getParameter("id"));
        var existingBook = readListDAO.getByID(id);
        request.setAttribute("book", existingBook);

        var dispatcher = request.getRequestDispatcher("ReadListForm.jsp");
        dispatcher.forward(request, response);
    }


    public void insertBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        var title = request.getParameter("title");
        var author = request.getParameter("author");
        var genre = request.getParameter("genre");
        var mark = Integer.parseInt(request.getParameter("mark"));
        var comment = request.getParameter("comment");
        var newBook = new Book(title, author, genre, mark, comment.trim());
        readListDAO.add(newBook);

        response.sendRedirect("list");
    }


    public void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        var id = Long.valueOf(request.getParameter("id"));
        var title = request.getParameter("title");
        var author = request.getParameter("author");
        var genre = request.getParameter("genre");
        var mark = Integer.parseInt(request.getParameter("mark"));
        var comment = request.getParameter("comment");
        var newBook = new Book(id, title, author, genre, mark, comment.trim());
        readListDAO.update(newBook);

        response.sendRedirect("list");
    }


    public void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var id = Long.valueOf(request.getParameter("id"));
        readListDAO.remove(id);

        response.sendRedirect("list");
    }
}
