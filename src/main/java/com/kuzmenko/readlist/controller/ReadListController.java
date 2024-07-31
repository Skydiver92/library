package com.kuzmenko.readlist.controller;

import com.kuzmenko.readlist.service.ReadListService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReadListController extends HttpServlet {

    private final ReadListService readListService = new ReadListService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();

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
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

}
