/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miki
 */
class UnknownCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            System.out.println(" --- UnknownCommand --- ");
            forward("/commandUnknown.jsp");

        } catch (Exception e) {
            System.out.println("forward error");
            Logger.getLogger(UnknownCommand.class.getName()).log(Level.SEVERE, null, e);
            forward("/commandErrorPage.jsp");
        }
    }

}
