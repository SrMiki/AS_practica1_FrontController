/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Controller.FrontCommand;
import User.ModelUser;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miki
 */
public class insertUser extends FrontCommand {
    
    //register User

    static String MSG = "insertUser";

    @Override
    public void process() {

        System.out.println(MSG);
        try {
            String name = request.getParameter("username");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if (!ModelUser.isExists(name, lastname)) {
                ModelUser.register(name, lastname, email, password);

                forward("/index.jsp");
            } else {
                forward("/register.jsp");
            }

        } catch (Exception e) {
            System.out.println("ERROR en" + MSG);
            Logger.getLogger(insertUser.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }

    }

}
