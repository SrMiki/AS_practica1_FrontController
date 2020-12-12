/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Book;

import Comentarios.Comment;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Miki
 */
public class Book {

    private int id;
    private String title;
    private String author;
    private String genre;
    private Date sellingDate;
    private double price;
    private int likes;

    private List<Comment> comentarios;
    
    public Book(int id, String title, String author, String genre, Date sellingDate, double price, int likes, String portada) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.sellingDate = sellingDate;
        this.price = price;
        this.likes = likes;
        this.portada = portada;

    }

    //sin ID
    public Book(String title, String author, String genre, Date sellingDate, double price, int likes, String portada) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.sellingDate = sellingDate;
        this.price = price;
        this.likes = likes;
        this.portada = portada;
    }

    //contrusctor base: sin ID, likes y portada
    public Book(String title, String author, String genre, Date sellingDate, double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.sellingDate = sellingDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public Double getPrice() {
        return price;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    private String portada;

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
    
    public List<Comment> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comment> comentarios) {
        this.comentarios = comentarios;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return title + "\nAuthor: " + author + "\nPrice: " + price;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        Book compare = (Book) o;

        if(!this.getTitle().equals(compare.getTitle()) 
                & !this.getAuthor().equals(compare.getAuthor()) 
                & this.getSellingDate() != compare.getSellingDate()){
            return false;
        }
        return true;
    }
    
    public boolean isAlreadyContains(List<Book> books){
        for (Book book : books) {
            if(this.getId() == book.getId()){
                return true;
            }
        }
        return false;
    }

}
