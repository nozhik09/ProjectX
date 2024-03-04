package model;

import util.MyArrayList;
import util.MyLinkedList;
import util.MyList;

public class Reader {
private Book book;
private User user;

private final MyList<Reader> readerMyLinkedList;

    public Reader(Book book, User user) {
        this.book = book;
        this.user = user;
        this.readerMyLinkedList = new MyArrayList<>();
    }




    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
