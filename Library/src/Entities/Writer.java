package Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Writer extends Person implements Serializable {

    private Book book;
    
    public Writer() {
    }

    public Writer(String fName, String lName, String isik, Book book) {
        super(fName, lName, isik);
        this.book = book;
    }
}
