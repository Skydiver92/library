//package com.kuzmenko.readlist.controller;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.sql.Connection;
//
//@WebServlet("/")
//public class TestController extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("page.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//
//        HttpSession session = req.getSession();
//        session.setAttribute("user", name);
//
//        System.out.println("============SESSION============> " + session.getAttribute("CONNECT"));
//
//        //Connection connection = (Connection) session.getAttribute("CONNECT");
//
//
//        RequestDispatcher rd = req.getRequestDispatcher("page.jsp");
//        rd.forward(req, resp);
//    }
//}
