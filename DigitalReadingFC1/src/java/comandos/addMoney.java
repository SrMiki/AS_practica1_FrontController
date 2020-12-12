/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import Controller.FrontCommand;
import User.ModelUser;
import User.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miki
 */
public class addMoney  extends FrontCommand {

    static String MSG = "addMoney";

    @Override
    public void process() {

        System.out.println(MSG);

        try {

            HttpSession session = request.getSession();

            User user = (User) session.getAttribute("user");

            int userID = user.getId();
            
            double money = Double.parseDouble(request.getParameter("deposit"));

            user.setAccount(user.getAccount() + money);
            ModelUser.changeAccount(userID, user.getAccount());

            session.setAttribute("user", user);

            forward("/showMyProfile.jsp");

        } catch (Exception e) {
            System.out.println("ERROR en" + MSG);
            Logger.getLogger(addMoney.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }
    }

    
}
