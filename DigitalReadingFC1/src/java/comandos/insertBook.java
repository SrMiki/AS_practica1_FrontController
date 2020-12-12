/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Book.Book;
import Book.ModelBook;
import Controller.FrontCommand;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miki
 */
public class insertBook extends FrontCommand {

    static String MSG = "insertBook";

    @Override
    public void process() {

        System.out.println(MSG);

        try {

            Book newBook = insertBookForm();

            List<Book> catalogo = ModelBook.getCatalogo();

            for (Book book : catalogo) {
                if (newBook.equals(book)) {
                    forward("/showCatalog.jsp");
                }
            }

            ModelBook.insert(newBook);

            HttpSession session = request.getSession();
            session.setAttribute("catalogo", ModelBook.getCatalogo());

            forward("/showCatalog.jsp");

        } catch (Exception e) {
            System.out.println("ERROR en" + MSG);
            Logger.getLogger(insertBook.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }

    }

    /**
     * lee el formulario y crea un nuevo Book
     * @return
     */
    private Book insertBookForm() {
        // --- leer el formulario de insertBook --- //
        String title = request.getParameter("title");

        String author = request.getParameter("author");

        String genre = request.getParameter("genre");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sellingDate = null;
        try {
            sellingDate = dateFormat.parse(request.getParameter("sellingDate"));
        } catch (Exception e) {
            System.out.print("error con el formato de fecha");
            forward("/commandErrorPage.jsp");
        }

        double price = Double.parseDouble(request.getParameter("price"));

        // --- Creamos un nuevo objeto Book --- //
        return new Book(title, author, genre, sellingDate, price, 0, "");
    }

}
