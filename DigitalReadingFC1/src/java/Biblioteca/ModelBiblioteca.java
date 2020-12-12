package Biblioteca;

import Book.Book;
import Book.ModelBook;
import Controller.ConexionBBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miki
 *
 * el nombre de esta clase es complicado de concretizar
 *
 * es la lista de libros que tiene cada usuario
 */
public class ModelBiblioteca {

    static String classMSG = "#== ModelBiblioteca.";

    /**
     * @param userID
     * @return List<Book> the user have purchased
     * @throws Exception
     */
    public static List<Book> getBookShelf(int userID) throws Exception {

        String methodMSG = "getBookShelf(" + userID + ")";

        List<Book> bookPurchased = new ArrayList<>();

        PreparedStatement DBstatement = null;
        Connection DBconnection = null;

        ConexionBBDD conexionConLaBBDD = new ConexionBBDD();

        try {
            DBconnection = conexionConLaBBDD.getConnection();

            // --- sql sentences --- //
            //prepared statemnet(prevent SQL injection) 
            DBstatement = DBconnection.prepareStatement("SELECT * FROM BIBLIOTECAS WHERE IDuser=?");

            DBstatement.setInt(1, userID);

            // --- execution of sql --- // 
            ResultSet DBresultset = DBstatement.executeQuery();

            while (DBresultset.next()) {
                int bookID = DBresultset.getInt("IDbook");

                Book tempBook = ModelBook.getBook(bookID);

                bookPurchased.add(tempBook);
            }
        } catch (SQLException e) {
            System.out.println(classMSG + methodMSG + " SQL ERROR");
        } finally {
            DBstatement.close();
            DBconnection.close();
        }

        System.out.println(classMSG + methodMSG);

        return bookPurchased;
    }

    /**
     * Insert a new Book into the user's bookshelf
     *
     * @param userID
     * @param bookID
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void insertBookInBookShelf(int userID, int bookID) throws ClassNotFoundException, SQLException {

        String methodMSG = "insertBookInBookShelf(" + userID + "," + bookID + ")";

        PreparedStatement DBstatement = null;
        Connection DBconnection = null;

        ConexionBBDD conexionConLaBBDD = new ConexionBBDD();

        try {
            DBconnection = conexionConLaBBDD.getConnection();
            DBstatement = DBconnection.prepareStatement("INSERT INTO BIBLIOTECAS (IDuser, IDbook)"
                    + "VALUES(?,?)");

            DBstatement.setInt(1, userID);
            DBstatement.setInt(2, bookID);

            DBstatement.execute();

        } catch (SQLException e) {
            System.out.println(classMSG + methodMSG + " SQL ERROR");
        } finally {
            DBstatement.close();
            DBconnection.close();
        }
        System.out.println(classMSG + methodMSG);
    }

    /**
     *
     * @param userID
     * @param bookID
     * @return true if the user's bookshelf already have the book
     * @throws SQLException
     */
    public static boolean isAlreadyContains(int userID, int bookID) throws SQLException {

        String methodMSG = "isAlreadyContains(" + userID + "," + bookID + ")";

        PreparedStatement DBstatement = null;
        Connection DBconnection = null;

        ConexionBBDD conexionConLaBBDD = new ConexionBBDD();

        try {
            DBconnection = conexionConLaBBDD.getConnection();

            DBstatement = DBconnection.prepareStatement("SELECT * FROM BIBLIOTECAS WHERE IDuser=? AND IDbook=?");

            DBstatement.setInt(1, userID);
            DBstatement.setInt(2, bookID);

            ResultSet DBresultset = DBstatement.executeQuery();

            if (DBresultset.first()) {
                System.out.println(classMSG + methodMSG);
                return true;
            }
        } catch (SQLException e) {
            System.out.println(classMSG + methodMSG + " SQL ERROR");
            return false;
        } finally {
            DBstatement.close();
            DBconnection.close();
        }
        System.out.println(classMSG + methodMSG + " NOT");
        return false;
    }

    /**
     *
     * Delete a book from user's bookshelf
     *
     * @param userID
     * @param bookID
     * @throws Exception
     */
    public static void deleteBookFromBookShelf(int userID, int bookID) throws Exception {

        String methodMSG = "deleteBookFromBookShelf(" + userID + "," + bookID + ")";

        PreparedStatement DBstatement = null;
        Connection DBconnection = null;

        ConexionBBDD conexionConLaBBDD = new ConexionBBDD();

        try {
            DBconnection = conexionConLaBBDD.getConnection();

            DBstatement = DBconnection.prepareStatement("SELECT * FROM BIBLIOTECAS WHERE IDuser=? AND IDbook=?");

            DBstatement.setInt(1, userID);
            DBstatement.setInt(2, bookID);

            ResultSet DBresultset = DBstatement.executeQuery();

            if (DBresultset.first()) { //the book to delete exist

                DBstatement = DBconnection.prepareStatement("DELETE FROM bibliotecas WHERE ID=?");

                int id = DBresultset.getInt("ID");
                DBstatement.setInt(1, id);

                DBstatement.execute();

            }
        } catch (SQLException e) {
            System.out.println(classMSG + methodMSG + " SQL ERROR");
        } finally {
            DBstatement.close();
            DBconnection.close();
        }
        System.out.println(classMSG + methodMSG);
    }

    public static void deleteBookFromAllBookShelf(int bookID) throws Exception {

        String methodMSG = "deleteBookFromAllBookShelf(" + bookID + ")";

        PreparedStatement DBstatement = null;
        Connection DBconnection = null;

        ConexionBBDD conexionConLaBBDD = new ConexionBBDD();

        try {
            DBconnection = conexionConLaBBDD.getConnection();

            DBstatement = DBconnection.prepareStatement("DELETE FROM bibliotecas WHERE IDbook=?");

            DBstatement.setInt(1, bookID);

            DBstatement.execute();

        } catch (SQLException e) {
            System.out.println(classMSG + methodMSG + " SQL ERROR");
        } finally {
            DBstatement.close();
            DBconnection.close();
        }
        System.out.println(classMSG + methodMSG);
    }

}
