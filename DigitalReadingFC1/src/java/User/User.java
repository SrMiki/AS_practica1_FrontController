/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Miki
 */
public class User {

    private int id;

    private String username;
    private String lastname;
    private String email;
    private String password;

    private int admin;

    double account;

    public User(int id, String username, String lastname, String email, String password, int admin, double account) {
        this.id = id;
        this.username = username;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.account = account;

    }

    public User(String username, String lastname, String email, String password, double account) {
        this.username = username;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.account = account;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getLastname() {
        return lastname;
    }

    public int isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "\n " + username
                + "\n " + lastname
                + "\n " + email
                + "\n " + admin
                + "\n " + account;
    }

    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return this.username.equals(user.username) & this.lastname.equals(user.lastname);

    }

}
