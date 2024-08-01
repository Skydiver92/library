package com.kuzmenko.readlist.controller;

import java.io.IOException;

import com.kuzmenko.readlist.service.ReadListService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReadListController extends HttpServlet {

    private final ReadListService readListService = new ReadListService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        var action = request.getServletPath();

        try {
            switch (action) {
                case "/new" -> readListService.showNewForm(request, response);
                case "/insert" -> readListService.insertBook(request, response);
                case "/delete" -> readListService.deleteBook(request, response);
                case "/edit" -> readListService.showEditForm(request, response);
                case "/update" -> readListService.updateBook(request, response);
                default -> readListService.listBook(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            var dispatcher = request.getRequestDispatcher("Error.jsp");
            request.setAttribute("exception", e);

            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException ex) {
                throw new RuntimeException(ex);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

}
