/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Book.ModelBook;
import Controller.FrontCommand;
import User.ModelUser;
import User.User;
import cart.Cart;
import Biblioteca.ModelBiblioteca;
import Comentarios.ModelComment;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miki
 */
public class login extends FrontCommand {

    static String MSG = "login";

    @Override
    public void process() {

        System.out.println(MSG);

        try {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            int userID = ModelUser.login(username, password);

            if (userID > 0) {
                HttpSession session = request.getSession(true);

                User user = ModelUser.getUser(userID);

                session.setAttribute("user", user);
                session.setAttribute("catalogo", ModelBook.getCatalogo());
                session.setAttribute("biblioteca", ModelBiblioteca.getBookShelf(userID));
                session.setAttribute("carrito", new Cart());
                
                forward("/mainPage.jsp");
            } else {
                forward("/index.jsp");
            }

        } catch (Exception e) {
            System.out.println("ERROR en " + MSG);
            System.out.println("check DB connection");
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }

    }

}
