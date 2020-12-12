/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Miki
 */
public class ConexionBBDD {
    /*
    //Pool de conexiones
    private DataSource datas;

    public DBconnection(DataSource datas) {
        this.datas = datas;
    }
     */

    Connection conexionConLaBBDD;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //driver/manejardor para el acceso a la BBDD
            conexionConLaBBDD = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitalreading", "root", "");

        } catch(Exception e){
            
        }
        return conexionConLaBBDD;
    }
        

}
