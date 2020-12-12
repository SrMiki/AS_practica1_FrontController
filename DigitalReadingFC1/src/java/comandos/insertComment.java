/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Book.Book;
import Book.ModelBook;
import Comentarios.Comment;
import Comentarios.ModelComment;
import Controller.FrontCommand;
import User.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miki
 */
public class insertComment extends FrontCommand {

    static String MSG = "insertComment";

    @Override
    public void process() {

        System.out.println(MSG);

        try {

            HttpSession session = request.getSession();

            String comment = request.getParameter("comment");
            User user = (User) session.getAttribute("user");

            Book book = (Book) session.getAttribute("libro");

            Comment newComment = new Comment(book.getId(), user.getId(), comment, user.getUsername());

            ModelComment.insertComment(newComment);

            book.setComentarios(ModelComment.getCommentsFromThisBook(book.getId()));

            session.setAttribute("libro", book);
            forward("/showBookDetails.jsp");

        } catch (Exception e) {
            System.out.println("ERROR en" + MSG);
            Logger.getLogger(insertBook.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }

    }

}
