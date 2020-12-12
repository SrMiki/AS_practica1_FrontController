/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Book.Book;
import Book.ModelBook;
import Controller.FrontCommand;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miki
 */
public class showCatalog extends FrontCommand {

    static String MSG = "showAllBooks";

    @Override
    public void process() {

        System.out.println(MSG);

        try {

            List<Book> catalogo = ModelBook.getCatalogo();

            HttpSession session = request.getSession();
            session.setAttribute("catalogo", catalogo);

            forward("/showCatalog.jsp");

        } catch (Exception e) {
            System.out.println("ERROR en" + MSG);
            Logger.getLogger(showCatalog.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }
    }

}
