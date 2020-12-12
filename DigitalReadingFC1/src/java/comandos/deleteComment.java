/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Book.Book;
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
public class deleteComment extends FrontCommand {

    static String MSG = "updateComment";

    @Override
    public void process() {

        System.out.println(MSG);
        try {
            
            HttpSession session = request.getSession();
            
            User user = (User) session.getAttribute("user");
            int commentID = Integer.parseInt(request.getParameter("commentID"));
            
            ModelComment.deleteComment(commentID);
            
            List<Book> catalogo = (List<Book>) session.getAttribute("catalogo");
            
            // la idea es obtener Todos los comentarios de Todos los libros realizados por el usuario
            for (Book book : catalogo) {
                book.setComentarios(ModelComment.getCommentFromThisUserOfThisBook(user.getId(), book.getId()));
            }
            
            session.setAttribute("catalogo", catalogo);

            forward("/showMyComments.jsp");

        } catch (Exception e) {
            System.out.println("ERROR en" + MSG);
            Logger.getLogger(updateComment.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }
    }
    
}
