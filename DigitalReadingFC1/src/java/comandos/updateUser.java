/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Comentarios.ModelComment;
import Controller.FrontCommand;
import User.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miki
 */
public class updateUser extends FrontCommand {

    static String MSG = "updateUser";

    @Override
    public void process() {

        System.out.println(MSG);
        try {

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            User newUser = updateUserForm();

            newUser.setId(user.getId());

            if (ModelUser.update(newUser)) {

                ModelComment.updateUserWhoComment(newUser);
                
                session.setAttribute("user", ModelUser.getUser(newUser.getId()));

            }

            forward("/showMyProfile.jsp");

        } catch (Exception e) {
            System.out.println("ERROR en" + MSG);
            Logger.getLogger(updateUser.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }
    }

    private User updateUserForm() {
        String name = request.getParameter("username");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return new User(name, lastname, email, password, 0);
    }
}
