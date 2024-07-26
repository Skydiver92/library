package com.kuzmenko.readlist.listener;

import com.kuzmenko.readlist.dao.ReadListDAOImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;


public class ReadListListener implements ServletContextListener {



    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        ReadListDAOImpl readListDAO = new ReadListDAOImpl();
        readListDAO.establishConnection();
        ctx.setAttribute("readListDAO", readListDAO);
        System.out.println("Listener work");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        ReadListDAOImpl readListDAO = (ReadListDAOImpl) ctx.getAttribute("readListDAO");
        readListDAO.closeConnection();
        System.out.println("Listener down");

    }
}
