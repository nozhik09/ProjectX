package service;

import RepositoryLayer.BookRepository;
import model.Book;
import model.Reader;
import model.User;
import util.MyList;


public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book addBook(String title, String author) {

        Book book = bookRepository.addNewBook(title, author);
        return book;
    }

    public MyList<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book searchBook(String title) {
        return bookRepository.findBook(title);

    }

    //TODO Испаравить
    public Book takeBook(int bookID) {

        return bookRepository.takeBook(bookID);


    }


    public MyList<Book> freeBooks() {
        return bookRepository.getAvailableBooks();
    }


    public MyList<Book> booksByRead() {
        return bookRepository.booksByReader();
    }


    //
//    }
//
    public void returnBook(int bookId) {
        bookRepository.returnBook(bookId);
    }
//
//    public Book availableBooks() {
//
//    }
//
//    public Book checkoutBooks() {
//
//    }


}
