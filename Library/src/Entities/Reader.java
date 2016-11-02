package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reader extends Person implements Serializable {
    private List<Book> books;

    public Reader() {
    }

    public Reader(String fName, String lName, String isik, List<Book> books) {
        super(fName, lName, isik);
        this.books = books;
    }
    
    public void addBook(Book book) {
        this.books.add(book);
    }
    
    public void rmBook(Book book) {
        for (int i = 0, len = books.size(); i < len; i++) {
            if (book.equals(books.get(i))) {
                books.remove(i);
            }
        }
    }
    
    public void getBooks(Book book) {
        for (int i = 0, len = books.size(); i < len; i++) {
            System.out.println(books.get(i));
        }
    }
    
    
}
