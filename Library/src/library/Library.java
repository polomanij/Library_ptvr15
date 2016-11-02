package library;

import Entities.Book;
import Entities.Reader;
import Entities.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Library {
    
    public static void main(String[] args) {
        Book book1 = new Book("Java EE", 30.0F, "All about java", "H2G2", 100, true, new Writer());
        Reader reader1 = new Reader("Lena", "Zelenova", "39402152230", new ArrayList<Book>());
        
        reader1.addBook(book1);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
        EntityManager em = emf.createEntityManager();
        
        //Reader r  = em.find(Reader.class, 52L);
        //Book b = em.find(Book.class, 51L);
        
        try {
            em.getTransaction().begin();
            
            em.persist(book1);
            em.persist(reader1);
            
            //em.remove(r);
            //em.remove(b);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
    
}
