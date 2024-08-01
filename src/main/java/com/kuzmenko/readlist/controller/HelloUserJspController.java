package com.kuzmenko.readlist.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(value = "/helloUser") // Can be used instead web.xml
public class HelloUserJspController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("demo/HelloUser.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
    }


    @Override
    protected void doPatch(HttpServletRequest request, HttpServletResponse response) {
    }


    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
    }

}
