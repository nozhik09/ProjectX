import RepositoryLayer.BookRepository;
import service.BookService;
import view.Menu;

public class MenuApp {
    public static void main(String[] args) {


        BookRepository bookRepository = new BookRepository();
        BookService bookService =new BookService(bookRepository);




        Menu menu= new Menu(bookService);

        menu.run();



    }
}
