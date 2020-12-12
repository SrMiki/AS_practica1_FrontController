/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import Book.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miki
 */
public class Cart {

    List<Book> cartBook;

    public Cart() {
        cartBook = new ArrayList<>();
    }

    public void clearCartBook() {
        cartBook.clear();
    }

    public void addBookToCart(Book book) {
        try {
            cartBook.add(book);
        } catch (Exception e) {
            System.out.println("ERROR en Cart.addBookToCart");
        }
    }
    
    public boolean isEmpty(){
        return cartBook.isEmpty();
    }

    public List<Book> getCart() {
        return cartBook;
    }

    public void removeBookFromCart(Book bookToRemove) {
        int i = 0;
        for (Book book : cartBook) {
            if(book.getId() == bookToRemove.getId()){
                cartBook.remove(i);
                return;
            }
            i++;
        }
    }

    public boolean contains(Object o) {
        Book oBook = (Book) o;
        for (Book book : cartBook) {
            if (book.getId() == oBook.getId()) {
                return true;
            }
        }
        return false;
    }

    public double getTotalPrice() {
        double result = 0.0;
        for (Book book : cartBook) {
            result += book.getPrice();
        }
        return result;
    }

    @Override
    public String toString() {
        String res = " ";
        for (Book book : cartBook) {
            res += book + " ";
        }
        return res.trim();
    }

}
