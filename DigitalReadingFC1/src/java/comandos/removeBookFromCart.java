/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Book.Book;
import Book.ModelBook;
import Controller.FrontCommand;
import cart.Cart;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miki
 */
public class removeBookFromCart extends FrontCommand {

    static String MSG = "removeBookFromCart";

    @Override
    public void process() {

        System.out.println(MSG);

        try {

            HttpSession session = request.getSession();

            int bookID = Integer.parseInt(request.getParameter("bookID"));
            Cart carrito = (Cart) session.getAttribute("carrito");

            Book bookToRemove = ModelBook.getBook(bookID);
            
            System.out.println(carrito);
            System.out.println(bookID);
            System.out.println(bookToRemove);

            carrito.removeBookFromCart(bookToRemove);
            
            System.out.println(carrito);
            
            session.setAttribute("carrito", carrito);
            
            forward("/mainPage.jsp");
        } catch (Exception e) {
            System.out.println("ERROR en" + MSG);
            Logger.getLogger(removeBookFromCart.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }

    }

}
