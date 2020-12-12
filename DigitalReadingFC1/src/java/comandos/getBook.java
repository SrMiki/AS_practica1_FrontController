/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Book.Book;
import Book.ModelBook;
import Controller.FrontCommand;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miki
 */
public class getBook extends FrontCommand {

    static String MSG = "getBook";

    @Override
    public void process() {

        System.out.println(MSG);

        try {

            int bookId = Integer.parseInt(request.getParameter("bookID"));

            Book uploadBook = ModelBook.getBook(bookId);

            if (uploadBook != null) {
                //atributo especial para actualizar! (muestra los campos en el formulario
                request.setAttribute("bookToUpload", uploadBook);
                forward("/updateBook.jsp");
            } else {
                forward("/showAllBooks.jsp");
            }

        } catch (Exception e) {
            System.out.println("ERROR en " + MSG);
            Logger.getLogger(getBook.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }
    }

}
