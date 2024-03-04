package RepositoryLayer;

import util.MyArrayList;
import model.Book;
import util.MyList;

import java.util.concurrent.atomic.AtomicInteger;

public class BookRepository {

    private final AtomicInteger currentId = new AtomicInteger(1);
    private MyList<Book> books;



    public BookRepository() {
        this.books = new MyArrayList<>();
        bookList();
    }

    public void bookList() {


        Book book1 = new Book("Мастер и Маргарита", "Михаил Булгаков", currentId.getAndIncrement(), true);
        Book book2 = new Book("Маленький принц", "Антуан де Сент-Экзюпери", currentId.getAndIncrement(), true);
        Book book3 = new Book("Война и мир", "Лев Толстой", currentId.getAndIncrement(), true);
        Book book4 = new Book("Преступление и наказание", "Федор Достоевский", currentId.getAndIncrement(), true);
        Book book5 = new Book("Герой нашего времени", "Михаил Лермонтов", currentId.getAndIncrement(), true);
        Book book6 = new Book("Двенадцать стульев", "Илья Ильф, Евгений Петров", currentId.getAndIncrement(), true);
        Book book7 = new Book("Евгений Онегин", "Александр Пушкин", currentId.getAndIncrement(), true);
        Book book8 = new Book("Сто лет одиночества", "Габриэль Гарсиа Маркес", currentId.getAndIncrement(), true);
        Book book9 = new Book("Рассказы", "Антон Чехов", currentId.getAndIncrement(), true);
        Book book10 = new Book("Мёртвые души", "Николай Гоголь", currentId.getAndIncrement(), true);
        Book book11 = new Book("Собачье сердце", "Михаил Булгаков", currentId.getAndIncrement(), true);
        books.addAll(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10 , book11);
    }


    public MyList<Book> getAllBooks() {
        return books;
    }

    public Book addNewBook(String title, String author) {
        Book book = new Book(title, author, currentId.getAndIncrement(), true);
        if (book.getAuthor() == null || book.getTitle() == null) return null;
        books.add(book);
        return book;

    }

    public Book findBook(String title) {

        for (int i = 0; i < books.size(); i++) {
            boolean bookFound =false;
            Book book = books.get(i);
            if (book.getTitle().contains(title) || book.getAuthor().contains(title)) {
                System.out.println("Книга найдена " + book);
                bookFound=true;
            }
        }
        System.out.println("Такой книги не существует: ");
        return null;
    }

    public Book findBookById(int id) {

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;


    }

    public Book takeBook(int bookId) {
        Book b = findBookById(bookId);
        if (b.isAvailable()) {
            b.setAvailable(false);
        }
        return b;
    }

    public MyList<Book> getAvailableBooks() {
        MyList<Book> getAvailableBooks = new MyArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.isAvailable()) {
                getAvailableBooks.add(book);

            }
        }
        return getAvailableBooks;
    }

    public MyList<Book> booksByReader() {
        MyList<Book> booksByReader = new MyArrayList<>();

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (!book.isAvailable()) {
                booksByReader.add(book);
            }
        }
        return booksByReader;
    }

    public Book returnBook(int bookId){
        Book book=findBookById(bookId);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return book;
        } else {
            return null;
        }




    }





}

