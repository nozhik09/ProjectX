package service;

import RepositoryLayer.BookRepository;
import model.Book;
import util.MyList;


public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(String title, String author, int id) {

        Book book = bookRepository.addNewBook(title, author);
        return book;
    }

    public MyList<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

//    public Book searchBook() {
//
//
//
//
//    }
//
//    public Book takeBook() {
//
//    }
//
//    public Book returnBook() {
//
//    }
//
//    public Book availableBooks() {
//
//    }
//
//    public Book checkoutBooks() {
//
//    }



}
