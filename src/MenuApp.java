import RepositoryLayer.BookRepository;
import RepositoryLayer.UserRepository;
import service.BookService;
import service.UserService;
//import view.Menu;

public class MenuApp {
    public static void main(String[] args) {


        BookRepository bookRepository = new BookRepository();
        BookService bookService =new BookService(bookRepository);




//        Menu menu= new Menu(bookService);
//
//        menu.run();

        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        userService.registerUser("test@test.te", "Passw@rd1");
        System.out.println(userService.getAllUsers());

        System.out.println(userService.authorize("test@test.te", "Passw@rd1"));


    }
}
