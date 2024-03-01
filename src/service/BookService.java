package service;

import RepositoryLayer.BookRepository;
import model.Book;
import util.MyArrayList;

import java.util.Scanner;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(String title, String author, int id) {
        return addBook();

    }

    public Book getAllBooks() {
        return getAllBooks();
    }

    public Book searchBook() {
    return searchBook();
    }

    public Book takeBook() {
        return takeBook();
    }

    public Book returnBook() {
        return returnBook();
    }

    public Book availableBooks() {
        return availableBooks();
    }

    public Book checkoutBooks() {
        return checkoutBooks();
    }


}
