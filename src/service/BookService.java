package service;

import RepositoryLayer.BookRepository;
import model.Book;
import model.Reader;
import model.User;
import util.MyArrayList;
import util.MyList;

import java.util.Arrays;
import java.util.Comparator;


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



    public Book serchBookByID(int bookId){
        return bookRepository.findBookById(bookId);


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

    public MyList<Book> getSorted(Comparator<Book> comparator){

        Book[] books = bookRepository.getAllBooks().toArray();
        Arrays.sort(books, comparator);
        MyList<Book> result = new MyArrayList<>(books);
        return result;
    }





}
