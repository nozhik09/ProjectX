package tests;

import RepositoryLayer.BookRepository;
import RepositoryLayer.UserRepository;
import model.Book;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.BookService;
import service.UserService;
import util.MyLinkedList;
import util.MyList;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

 BookRepository bookRepository = new BookRepository();
 UserRepository userRepository = new UserRepository();
 BookService bookService = new BookService(bookRepository);
 UserService userService = new UserService(userRepository);


 User user;
 String testStartEmail = "test@test.te";
 String testStartPassword = "Testing123!";

 @Test
    void  testCreateUser(){
     User user;
     String testStartEmail = "test@test.te";
     String testStartPassword = "Testing123!";

     user = userRepository.createUser(testStartEmail, testStartPassword);
     System.out.println(user);
     assertNotNull(user);
 }


 @Test
  void allUsers(){
  User user = new User( 1,"testing1@testing.te", "12345Awes21!");
  User user1 = new User( 2,"testing2@testing.te", "12345Awes21!");
  User user2 = new User( 3,"testing3@testing.te", "12345Awes21!");

  System.out.println(user);
  System.out.println(user1);
  System.out.println(user2);

  assertNotNull(user);
  assertNotNull(user1);
  assertNotNull(user2);
 }

 @Test
 void testGetAllBooks(){
  assertNotNull(bookRepository.getAllBooks());
 }

 @Test

 void availableBooks(){
  MyLinkedList<Book> testBook = new MyLinkedList<>();
  MyList<Book> books = bookRepository.getAllBooks();
  for (int i = 0; i < books.size(); i++) {
   if (books.get(i) != null){
    testBook.add(bookRepository.getAvailableBooks().get(i));
   }
   Assertions.assertNotNull(testBook);
  }

 }

}