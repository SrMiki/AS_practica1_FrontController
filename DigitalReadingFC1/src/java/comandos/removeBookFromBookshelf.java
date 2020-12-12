/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Controller.FrontCommand;
import User.User;
import Biblioteca.ModelBiblioteca;
import Book.ModelBook;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miki
 */
public class removeBookFromBookshelf extends FrontCommand {

    static String MSG = "removeBookFromBookshelf";

    @Override
    public void process() {

        System.out.println(MSG);
        
        try {

            HttpSession session = request.getSession();

            int bookID = Integer.parseInt(request.getParameter("bookID"));
            User user = (User) session.getAttribute("user");

            int userID = user.getId();

            ModelBiblioteca.deleteBookFromBookShelf(userID, bookID);
            
            user.setAccount(user.getAccount() + ModelBook.getBook(bookID).getPrice());
            
            session.setAttribute("biblioteca", ModelBiblioteca.getBookShelf(userID));
            session.setAttribute("user", user);
            

            forward("/showMyBookShelf.jsp");

        } catch (Exception e) {
            System.out.println("ERROR en" + MSG);
            Logger.getLogger(removeBookFromBookshelf.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }

    }

}
