import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction =entityManager.getTransaction();
        transaction.begin();

        Author author = new Author();
        author.setName("Anthony Burgess");
        author.setBirthDate(LocalDate.ofEpochDay(1917-2-25));
        author.setCountry("English");
        entityManager.persist(author);


        Publisher publisher = new Publisher();
        publisher.setName("Türkiye İş Bankası ");
        publisher.setAddress("İstanbul");
        publisher.setEstablishmentYear(2019);
        entityManager.persist(publisher);


        Category categoryHistory = new Category();
        categoryHistory.setName("Dystopian Fiction");
        categoryHistory.setDescription("test");
        entityManager.persist(categoryHistory);

        ArrayList<Category> categoryArrayList = new ArrayList<>();
        categoryArrayList.add(categoryHistory);


        Book book = new Book();
        book.setName("Savaş ve Barış");
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setCategoryList(categoryArrayList);
        book.setStock(20);
        book.setPublicationYear(1982);
        entityManager.persist(book);


        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Deniz AKIN");
        bookBorrowing.setBorrowingDate(LocalDate.ofEpochDay(2024-02-21));
        bookBorrowing.setReturnDate(LocalDate.ofEpochDay(2024-03-12));
        bookBorrowing.setBook(book);
        entityManager.persist(bookBorrowing);



        System.out.println(book);
        transaction.commit();

    }
}
