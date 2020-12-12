/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Book.Book;
import Book.ModelBook;
import Controller.FrontCommand;
import User.User;
import cart.Cart;
import Biblioteca.ModelBiblioteca;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miki
 */
public class addBookToCart extends FrontCommand {

    static String MSG = "addBookToCart";

    @Override
    public void process() {

        System.out.println(MSG);

        try {

            HttpSession session = request.getSession();

            User user = (User) session.getAttribute("user");
            Cart carrito = (Cart) session.getAttribute("carrito");

            int bookID = Integer.parseInt(request.getParameter("bookID"));

            List<Book> bookShelf = ModelBiblioteca.getBookShelf(user.getId());

            Book bookToBuy = ModelBook.getBook(bookID);
            if (!carrito.contains(bookToBuy) & !aux(bookShelf, bookToBuy)) {

                carrito.addBookToCart(bookToBuy);

                session.setAttribute("carrito", carrito);
            }
            forward("/mainPage.jsp");
        } catch (Exception e) {
            System.out.println("ERROR en" + MSG);
            Logger.getLogger(addBookToCart.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }

    }

    private boolean aux(List<Book> bookShelf, Book o) {
        for (Book book : bookShelf) {
            if (book.getId() == o.getId()) {
                return true;
            }
        }
        return false;
    }

}
