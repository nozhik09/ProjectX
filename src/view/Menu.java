package view;

import java.util.Scanner;


import RepositoryLayer.BookRepository;
import service.BookService;

public class Menu {
 /*
   public void run (){
        Scanner scanner = new Scanner(System.in);



        while (true) {


            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Ввод информации о книге и добавление в библиотеку
                    System.out.print("Введите название книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите имя автора: ");
                    String author = scanner.nextLine();
                    BookService.addBook(title, author);
                    break;
                case 2:
                    //Список всех книг
                    System.out.println("Список книг которые есть в библиотеке:");
                    BookService.getAllBooks();
                    break;
                case 3:
                    // Поиск книги
                    System.out.println("Книга найдена!");
                    System.out.println(BookRepository.BookList + "Книга свобода!");
                    break;
                case 4:
                    // Взятие книги
                    System.out.println("Вы успешно взяли книгу!");
                    String borrowTitle = scanner.nextLine();
                    BookService.takeBook(borrowTitle);
                    break;
                case 5:
                    // Возврат книги
                    System.out.println("Вы успешно вернули книгу!");
                    String returnTitle = scanner.nextLine();
                    BookService.returnBook(returnTitle);
                    break;
                case 6:
                    BookService.displayAvailableBooks();
                    System.out.println("Все доступные книги:");
                    break;
                case 7:
                    BookService.displayCheckedOutBooks();
                    System.out.println("Все взятые книги:");
                    break;
                case 8:
                    System.out.println("Программа завершена!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный ввод. Пожалуйста, выберите существующую опцию.");
            }
        }
    }*/

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
