package Comentarios;

import User.ModelUser;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miki
 */
public class Comment {

    protected int id;
    protected int bookID;
    protected int userID;
    
    protected String username;
    protected String comment;

    public Comment(int id, int bookID, int userID, String comment, String username) {
        this.id = id;
        this.bookID = bookID;
        this.userID = userID;
        this.comment = comment;
        this.username = username;
    }

    public Comment(int bookID, int userID, String comment, String username) {
        this.bookID = bookID;
        this.userID = userID;
        this.comment = comment;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
     public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
       return comment;
    }

}
