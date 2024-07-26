package com.kuzmenko.readlist.service;

import com.kuzmenko.readlist.dao.ReadListDAOImpl;
import com.kuzmenko.readlist.model.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ReadListService extends ReadListDAOImpl {

    private ReadListDAOImpl readListDAO;

    public ReadListService(ReadListDAOImpl readListDAO) {
        this.readListDAO = readListDAO;


    }

    public void listBook(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Book> listBook = readListDAO.getAll();
            request.setAttribute("listBook", listBook);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ReadList.jsp");
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
            int id = Integer.parseInt(request.getParameter("id"));
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
            String date = request.getParameter("date");
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String genre = request.getParameter("genre");
            Integer mark = Integer.parseInt(request.getParameter("mark"));
            String comment = request.getParameter("comment");

            Book newBook = new Book(date, title, author, genre, mark, comment);
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
            int id = Integer.parseInt(request.getParameter("id"));
            String date = request.getParameter("date");
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String genre = request.getParameter("genre");
            Integer mark = Integer.parseInt(request.getParameter("mark"));
            String comment = request.getParameter("comment");

            Book newBook = new Book(id, date, title, author, genre, mark, comment);
            if (newBook.validate()) {
                readListDAO.add(newBook);
                response.sendRedirect("list");
            } else {
                try {
                    Book existingBook = readListDAO.getByID(id);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("ReadListForm.jsp");
                    request.setAttribute("book", existingBook);
                    dispatcher.forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
            readListDAO.update(newBook);
            response.sendRedirect("list");
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();


            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Book existingBook = readListDAO.getByID(id);
                RequestDispatcher dispatcher = request.getRequestDispatcher("ReadListFormInvalid.jsp");
                request.setAttribute("book", existingBook);
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            readListDAO.remove(id);
            response.sendRedirect("list");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
