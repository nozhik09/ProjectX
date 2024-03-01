package view;

import java.util.Scanner;


import RepositoryLayer.BookRepository;
import model.Book;
import service.BookService;
import util.MyList;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);

    private final BookService service;

    public Menu(BookService service) {
        this.service = service;
    }

    public void displayMenu() {
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


                    // Ввод информации о книге и добавление в библиотеку
                    break;
                case 2:
                    MyList<Book> booksList = service.getAllBooks();
                    for (Book book : booksList.toArray()) {
                        System.out.println(book);
                    }


                    break;
                case 3:
                    System.out.println("Введите искомую книгу: ");
                    service.searchBook(scanner.nextLine());
                    scanner.nextLine();


                    // Поиск книги
                    break;
                case 4:
                    // Взятие книги
                    break;
                case 5:
                    // Возврат книги
                    break;
                case 6:
//                    displayAvailableBooks();
                    break;
                case 7:
//                    displayCheckedOutBooks();
                    break;
                case 8:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный ввод. Пожалуйста, выберите существующую опцию.");
            }
        }
    }


}
