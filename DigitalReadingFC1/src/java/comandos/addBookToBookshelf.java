/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Book.Book;
import Controller.FrontCommand;
import User.ModelUser;
import cart.Cart;
import Biblioteca.ModelBiblioteca;
import javax.servlet.http.HttpSession;
import User.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miki
 */
public class addBookToBookshelf extends FrontCommand {

    //addBookToBookShelf equivale a comprar los libros
    
    static String MSG = "addBookToBookshelf";

    @Override
    public void process() {

        System.out.println(MSG);

        try {

            HttpSession session = request.getSession();

            Cart carrito = (Cart) session.getAttribute("carrito");
            User user = (User) session.getAttribute("user");

            int userID = user.getId();

            //ya está comprobado en el addToCart 
            //pero por precausión
            
            if (carrito.getTotalPrice() > user.getAccount()) {
                forward("/mainPage.jsp");
            }

            double totalprice = 0.0;
            for (Book book : carrito.getCart()) {
                if (!ModelBiblioteca.isAlreadyContains(userID, book.getId())) {

                    totalprice += book.getPrice();
                    ModelBiblioteca.insertBookInBookShelf(user.getId(), book.getId());
                }
            }
            System.out.println(user.getAccount());
            user.setAccount(user.getAccount() - totalprice);
            System.out.println(user.getAccount());
            ModelUser.changeAccount(userID, user.getAccount());

            carrito.clearCartBook();

            session.setAttribute("user", user);
            session.setAttribute("carrito", carrito);

            session.setAttribute("biblioteca", ModelBiblioteca.getBookShelf(userID));

            forward("/showMyBookShelf.jsp");

        } catch (Exception e) {
            System.out.println("ERROR en" + MSG);
            Logger.getLogger(addBookToBookshelf.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }
    }

}
