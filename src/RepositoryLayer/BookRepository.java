package RepositoryLayer;

import util.MyArrayList;
import model.Book;
import util.MyList;

import java.util.concurrent.atomic.AtomicInteger;


public class BookRepository {

    private final AtomicInteger currentId = new AtomicInteger(1);
    private final MyList<Book> books;


    public BookRepository() {
        this.books = new MyArrayList<>();
        bookList();
    }

    public void bookList() {
        Book book1 = new Book("Мастер и Маргарита", "Михаил Булгаков", currentId.getAndIncrement());
        Book book2 = new Book("Маленький принц", "Антуан де Сент-Экзюпери", currentId.getAndIncrement());
        Book book3 = new Book("Война и мир", "Лев Толстой", currentId.getAndIncrement());
        Book book4 = new Book("Преступление и наказание", "Федор Достоевский", currentId.getAndIncrement());
        Book book5 = new Book("Герой нашего времени", "Михаил Лермонтов", currentId.getAndIncrement());
        Book book6 = new Book("Двенадцать стульев", "Илья Ильф, Евгений Петров", currentId.getAndIncrement());
        Book book7 = new Book("Евгений Онегин", "Александр Пушкин", currentId.getAndIncrement());
        Book book8 = new Book("Сто лет одиночества", "Габриэль Гарсиа Маркес", currentId.getAndIncrement());
        Book book9 = new Book("Рассказы", "Антон Чехов", currentId.getAndIncrement());
        Book book10 = new Book("Мёртвые души", "Николай Гоголь", currentId.getAndIncrement());
        books.addAll(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10);
    }


    public MyList<Book> getAllBooks() {
        return books;
    }

    public Book addNewBook(String title, String author) {
        Book book = new Book(title, author, currentId.getAndIncrement());
        if (book.getAuthor() == null || book.getTitle() == null) return null;
        books.add(book);
        return book;

    }


    public Book findBook(String title) {

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().contains(title)) {
                System.out.println("Книга найдена " + book);
                return book;
            }
        }
        System.out.println("Такой книги не существует: ");
        return null;
    }

    //    public Book takeBook() {
    //
    //
    //    }

}