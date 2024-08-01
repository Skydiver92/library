package com.kuzmenko.readlist.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;


public class ReadListListener implements ServletContextListener {



    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
//        DatabaseDAO readListDAO = new DatabaseDAO();
//        readListDAO.establishConnection();
//        ctx.setAttribute("readListDAO", readListDAO);
        System.out.println("Listener work");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
//        DatabaseDAO readListDAO = (DatabaseDAO) ctx.getAttribute("readListDAO");
//        readListDAO.closeConnection();
        System.out.println("Listener down");

    }
}
