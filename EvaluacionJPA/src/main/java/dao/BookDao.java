package dao;

import interfaces.IBook;
import jakarta.persistence.EntityManager;
import models.Book;

import java.util.List;

public class BookDao implements IBook {

    @Override
    public void save(Book book) {
        EntityManager em = EntityManagerAdmin.getInstance();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    @Override
    public Book getBook(Integer id) {
        EntityManager em = EntityManagerAdmin.getInstance();
        return em.find(Book.class, id);
    }

    @Override
    public void update(Book book) {
        EntityManager em = EntityManagerAdmin.getInstance();
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Book book) {
        EntityManager em = EntityManagerAdmin.getInstance();
        em.getTransaction().begin();
        em.remove(em.contains(book) ? book : em.merge(book));
        em.getTransaction().commit();
    }

    @Override
    public List<Book> getBooks() {
        EntityManager em = EntityManagerAdmin.getInstance();
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }
}