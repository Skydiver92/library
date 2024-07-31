package com.kuzmenko.readlist.service;

import com.kuzmenko.readlist.dao.InMemoryDAO;
import com.kuzmenko.readlist.dao.ReadListDAO;
import com.kuzmenko.readlist.model.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ReadListService {

    private final ReadListDAO readListDAO = new InMemoryDAO();


    public void listBook(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Book> bookList = readListDAO.getAll();
            request.setAttribute("bookList", bookList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ReadList.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("ReadListForm.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            Book existingBook = readListDAO.getByID(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ReadListForm.jsp");
            request.setAttribute("book", existingBook);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void insertBook(HttpServletRequest request, HttpServletResponse response) {
        try {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String genre = request.getParameter("genre");
            Integer mark = Integer.parseInt(request.getParameter("mark"));
            String comment = request.getParameter("comment");

            Book newBook = new Book(title, author, genre, mark, comment.trim());
            if (newBook.validate()) {
                readListDAO.add(newBook);
                response.sendRedirect("list");
            } else {
                try {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("ReadListFormInvalid.jsp");
                    dispatcher.forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();


            try {
                RequestDispatcher dispatcher = request.getRequestDispatcher("ReadListFormInvalid.jsp");
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }


        }

    }

    public void updateBook(HttpServletRequest request, HttpServletResponse response) {
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String genre = request.getParameter("genre");
            Integer mark = Integer.parseInt(request.getParameter("mark"));
            String comment = request.getParameter("comment");

            Book newBook = new Book(id, title, author, genre, mark, comment.trim());
            if (newBook.validate()) {
                readListDAO.update(newBook);
            }
            response.sendRedirect("list");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }


        try {
            Long id = Long.valueOf(request.getParameter("id"));
            Book existingBook = readListDAO.getByID(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ReadListFormInvalid.jsp");
            request.setAttribute("book", existingBook);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response) {
        try {
            Long id = Long.valueOf(request.getParameter("id"));

            readListDAO.remove(id);
            response.sendRedirect("list");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
