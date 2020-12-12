/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Controller.ConexionBBDD;
import java.sql.*;
import javax.sql.DataSource;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Miki
 */
public class ModelUser {

    static String MSG = "#== ModelUser.";

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public static int login(String username, String password) throws Exception {

        String methodMSG = "login(" + username + ", " + password + ")";

        PreparedStatement DBstatement = null;
        Connection DBconnection = null;

        ConexionBBDD conexionConLaBBDD = new ConexionBBDD();
        int id = -1;
        try {
            DBconnection = conexionConLaBBDD.getConnection();

            DBstatement = DBconnection.prepareStatement("SELECT * FROM USUARIOS WHERE name=? AND password=?");

            DBstatement.setString(1, username);
            DBstatement.setString(2, password);

            ResultSet DBresultset = DBstatement.executeQuery();
            if (DBresultset.first()) {
                System.out.println(MSG + methodMSG);
                id = DBresultset.getInt("ID");

            } else {
                System.out.println(MSG + methodMSG + " NOT FOUND");
                return -1;
            }

        } catch (SQLException e) {
            System.out.println(MSG + "login(" + username + ", " + password + ") FALLO SQL");
            return -2;
        } finally {
            DBstatement.close();
            DBconnection.close();
        }
        return id;
    }

    public static boolean register(String name, String lastname, String email, String password) throws Exception {

        String methodMSG = "register(" + name + ", " + lastname + ", " + email + ", " + password + ")";
        Statement DBstatement = null;
        Connection DBconnection = null;

        ConexionBBDD conexionConLaBBDD = new ConexionBBDD();

        try {
            DBconnection = conexionConLaBBDD.getConnection();
            DBstatement = DBconnection.createStatement();

            DBstatement.executeUpdate("INSERT INTO USUARIOS (name, lastname, email, password, account) "
                    + "VALUES ('" + name + "','" + lastname + "','" + email + "','" + password + "','" + 0 + "')");

            System.out.println(MSG + methodMSG);
            return true;
        } catch (SQLException e) {
            System.out.println(MSG + methodMSG + " ERROR SQL");
            return false;
        }

    }

    public static boolean isAdmin(int userID) throws Exception {

        String methodMSG = "isAdmin(" + userID + ")";

        PreparedStatement DBstatement = null;
        Connection DBconnection = null;

        ConexionBBDD conexionConLaBBDD = new ConexionBBDD();
        try {
            DBconnection = conexionConLaBBDD.getConnection();

            DBstatement = DBconnection.prepareStatement("SELECT * FROM USUARIOS WHERE ID=?");

            DBstatement.setInt(1, userID);

            ResultSet DBresultset = DBstatement.executeQuery();
            return DBresultset.first();
        } catch (SQLException e) {
            System.out.println(MSG + methodMSG + " ERROR SQL");
            return false;
        }
    }

    public static boolean isExists(String username, String lastname) throws SQLException {

        PreparedStatement DBstatement = null;
        Connection DBconnection = null;

        ConexionBBDD conexionConLaBBDD = new ConexionBBDD();

        try {
            DBconnection = conexionConLaBBDD.getConnection();
            // --- crear sentencia sql --- //
            //statement, preparación de sentencia (impedir inyeccion SQL) 
            DBstatement = DBconnection.prepareStatement("SELECT * FROM usuarios WHERE name=? AND lastname=?");

            DBstatement.setString(1, username);
            DBstatement.setString(2, lastname);

            ResultSet DBresultset = DBstatement.executeQuery();

            if (DBresultset.first()) {
                System.out.println(MSG + " isExists(" + username + ", " + lastname + ")");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(MSG + " isExists(" + username + ", " + lastname + ") FALLO");
        } finally {
            DBstatement.close();
            DBconnection.close();
        }
        return false;
    }

    public static User getUser(int id) throws Exception {

        User user = null;

        PreparedStatement DBstatement = null;
        Connection DBconnection = null;

        ConexionBBDD conexionConLaBBDD = new ConexionBBDD();

        try {
            DBconnection = conexionConLaBBDD.getConnection();
            // --- crear sentencia sql --- //
            //statement, preparación de sentencia (impedir inyeccion SQL) 
            DBstatement = DBconnection.prepareStatement("SELECT * FROM usuarios WHERE id=?");

            DBstatement.setInt(1, id);

            // --- ejecutar sql --- // 
            ResultSet DBresultset = DBstatement.executeQuery();

            //Obtener datos del resulset 
            if (DBresultset.first()) {

                String name = DBresultset.getString("name");
                String lastname = DBresultset.getString("lastname");
                String email = DBresultset.getString("email");
                String password = DBresultset.getString("password");
                int admin = DBresultset.getInt("admin");
                double account = DBresultset.getDouble("account");

                user = new User(id, name, lastname, email, password, admin, account);

            } else {
                System.out.println(MSG + "getUser(id) warning; \n no se encontro al usuario en la BDD");
            }

        } catch (Exception e) {
            System.out.println(MSG + "getUser(id) FALLO");
            return null;
        } finally {
            DBstatement.close();
            DBconnection.close();
        }

        return user;

    }

    public static boolean changeAccount(int userID, double account) throws SQLException {
        
        String methodMSG = "changeAccount("+userID+", " + account + ")";

        PreparedStatement DBstatement = null;
        Connection DBconnection = null;

        ConexionBBDD conexionConLaBBDD = new ConexionBBDD();

        try {
            DBconnection = conexionConLaBBDD.getConnection();
            DBstatement = DBconnection.prepareStatement("UPDATE usuarios SET account=? WHERE id=?");

            DBstatement.setDouble(1, account);
            DBstatement.setInt(2, userID);
            
            DBstatement.execute();

            System.out.println(MSG + methodMSG);
            return true;
        } catch (SQLException e) {
            System.out.println(MSG + methodMSG + " FALLO SQL");
            return false;
        } finally {
            DBstatement.close();
            DBconnection.close();
        }
    }
    
    
    public static boolean update(User newUser) throws ClassNotFoundException, SQLException {

        PreparedStatement DBstatement = null;
        Connection DBconnection = null;

        ConexionBBDD conexionConLaBBDD = new ConexionBBDD();
        
        try {
            DBconnection = conexionConLaBBDD.getConnection();
            DBstatement = DBconnection.prepareStatement("UPDATE usuarios SET name=?, lastname=?, email=?, password=? WHERE id=?");
            
            DBstatement.setString(1, newUser.getUsername());
            DBstatement.setString(2, newUser.getLastname());
            DBstatement.setString(3, newUser.getEmail());
            DBstatement.setString(4, newUser.getPassword());
            

            DBstatement.setInt(5, newUser.getId());

            DBstatement.execute();

            System.out.println(MSG + "update() correcto");
            return true;
        } catch (SQLException e) {
            System.out.println(MSG + "update() FALLO SQL");
            return false;
        } finally {
            DBstatement.close();
            DBconnection.close();
        }

    }

}
