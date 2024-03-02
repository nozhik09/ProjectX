package view;

import java.util.Scanner;
import RepositoryLayer.BookRepository;

import service.BookService;
import model.Book;
import service.BookService;
import util.MyList;



public class Menu {
    BookService bookService = new BookService(new BookRepository());
    private final Scanner scanner = new Scanner(System.in);

    private final BookService service;

    public Menu(BookService service) {
        this.service = service;
    }



    public void run() {
//




        while (true) {

        displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Введите автора книги");
                    String title = scanner.nextLine();
                    System.out.println("Введите название книги");
                    String author = scanner.nextLine();
                    scanner.nextLine();
                    service.addBook(title, author);
                    break;
                /* Нужен метод добавления книги, который принимает только название книги и автора книги
                Так же довавить механизм если книга есть значит выкинуть ошбку что такая книга есть */
                case 2:

                    MyList<Book> booksList = service.getAllBooks();
                    for (Book book : booksList.toArray()) {
                        System.out.println(book);
                    }


                    break;
                // нужен метод который возвращает список всех книг
                case 3:
                    System.out.println("Введите искомую книгу: ");
                    service.searchBook(scanner.nextLine());
                    scanner.nextLine();


                    // Поиск книги
                    System.out.println("Книга найдена!");
                    System.out.println(bookService.getAllBooks() + "Книга свобода!");
                    break;
//                    Нужен метод который возвращает список книг отфильтрованный по строке поиска
                case 4:
//                    // Взятие книги
//                    System.out.println("Вы успешно взяли книгу!");
//                    String borrowTitle = scanner.nextLine();
//                    bookService.takeBook();
//                    break;
//                    Нужен метод который принимает в себя айди книги которую берут, айди пользока который берёт книгу
//                      Если книга уже кем-то взята - выкинуть ошибку, если книга свободна - пометить что её взял данный пользак
                case 5:
//                    // Возврат книги
//                    System.out.println("Вы успешно вернули книгу!");
//                    String returnTitle = scanner.nextLine();
//                    bookService.returnBook();
//                    break;
//                Нужен метод который принимает в себя айди книги которую возвращают, айди пользока который бвозвращает книгу
//                Если книга была взята данным пользаком - посетить что книга стала свободна
//                если книга была взята другим пользаком - выкинуть ошибку что у него небыло этой книги
//                если книгу никто не брал - выкинуть ошибку о том что Книга в библиотеке

                case 6:
                    System.out.println("Все доступные книги:");
                    break;
//                    нужен метод который возвращает список всех доступных книг
                case 7:
                    System.out.println("Все взятые книги:");
                    break;
//                    нужен метод который возвращает список всех взятых книг
                case 8:
                    System.out.println("Программа завершена!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный ввод. Пожалуйста, выберите существующую опцию.");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("1. Добавить книгу");
        System.out.println("2. Вывести список всех книг");
        System.out.println("3. Поиск книги");
        System.out.println("4. Взять книгу");
        System.out.println("5. Вернуть книгу");
        System.out.println("6. Список свободных книг");
        System.out.println("7. Список взятых книг");
        System.out.println("8. Выход");
        System.out.print("Выберите опцию: ");
    }


}
