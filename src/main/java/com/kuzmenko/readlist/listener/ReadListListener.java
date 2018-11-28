package com.kuzmenko.readlist.listener;

import com.kuzmenko.readlist.dao.ReadListDAOImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ReadListListener implements ServletContextListener {



    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        ReadListDAOImpl readListDAO = new ReadListDAOImpl();
        readListDAO.getConnection();
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
