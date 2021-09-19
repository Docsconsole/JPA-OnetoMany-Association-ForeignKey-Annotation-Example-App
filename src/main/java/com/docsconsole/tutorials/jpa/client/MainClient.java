package com.docsconsole.tutorials.jpa.client;

import com.docsconsole.tutorials.jpa.entity.Author;
import com.docsconsole.tutorials.jpa.entity.Book;
import com.docsconsole.tutorials.jpa.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashSet;
import java.util.Set;

public class MainClient {


    public static void main(String[] args) {
        System.out.println("Main method@MainClient");

        try {
            EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            Author author = new Author("Author1");

            Book book1 = new Book("Book1", 100.0);
            Book book2 = new Book("Book2", 200.0);
            Book book3 = new Book("Book3", 300.0);

            Set<Book> books = new HashSet<Book>();
            books.add(book1);
            books.add(book2);
            books.add(book3);

            author.setBooks(books);
            entityManager.persist(author);

            book1.setAuthor(author);
            book2.setAuthor(author);
            book3.setAuthor(author);

            entityManager.persist(book1);
            entityManager.persist(book1);
            entityManager.persist(book1);



            transaction.commit();
            System.out.println("Session is closed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
