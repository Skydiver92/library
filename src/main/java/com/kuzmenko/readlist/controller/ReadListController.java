package com.kuzmenko.readlist.controller;

import com.kuzmenko.readlist.dao.ReadListDAO;
import com.kuzmenko.readlist.dao.ReadListDAOImpl;
import com.kuzmenko.readlist.service.ReadListService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */
public class ReadListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReadListService readListService;



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        ReadListDAOImpl readListDAO = (ReadListDAOImpl) getServletContext().getAttribute("readListDAO");
        readListService = new ReadListService(readListDAO);


        try {
            switch (action) {
                case "/new":
                    readListService.showNewForm(request, response);
                    break;
                case "/insert":
                    readListService.insertBook(request, response);
                    break;
                case "/delete":
                    readListService.deleteBook(request, response);
                    break;
                case "/edit":
                    readListService.showEditForm(request, response);
                    break;
                case "/update":
                    readListService.updateBook(request, response);
                    break;
                default:
                    readListService.listBook(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    public void destroy(){
        readListService.closeConnection();


    }

}