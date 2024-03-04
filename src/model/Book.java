package model;

public class Book {

    private String title;
    private String author;
    private int bookId;

    private boolean isAvailable;

    public Book(String title, String author, int id , boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.bookId = id;
        this.isAvailable =isAvailable;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return
                "Название книги: " + title + '\'' +
                ", Автор: " + author + '\'' +
                ", id: " + bookId;
    }


}
