/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miki
 */
public abstract class FrontCommand {

    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.context = context;
        this.request = request;
        this.response = response;
    }

    abstract public void process();

    public void forward(String target) {

        RequestDispatcher dp = context.getRequestDispatcher(target);
        try {
            dp.forward(request, response);

            //RequestDispatcher dp = request.getRequestDispatcher(target);
            //dp.forward(request, response);
            System.out.println("-- close --");

        } catch (ServletException | IOException ex) {
            System.out.println("ERROR AL REDIRECCIONAR (forward)");
            Logger.getLogger(FrontCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
