package com.kuzmenko.readlist.controller;

import com.kuzmenko.readlist.dao.ReadListDAOImpl;
import com.kuzmenko.readlist.service.ReadListService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */
public class ReadListController extends HttpServlet {

    private ReadListService readListService;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        ReadListDAOImpl readListDAO = (ReadListDAOImpl) getServletContext().getAttribute("readListDAO");
        readListService = new ReadListService(readListDAO);


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

    public void destroy(){
        readListService.closeConnection();


    }

}
