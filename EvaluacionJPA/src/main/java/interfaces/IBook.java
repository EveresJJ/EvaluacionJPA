package interfaces;

import models.Book;

import java.util.List;

public interface IBook {
    void save(Book book);
    Book getBook(Integer id);
    void update(Book book);
    void delete(Book book);
    List<Book> getBooks();
}
