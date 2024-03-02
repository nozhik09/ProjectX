package view;

import java.util.Scanner;
import RepositoryLayer.BookRepository;
import service.BookService;

public class Menu {
    BookService bookService = new BookService(new BookRepository());

   public void run (){
        Scanner scanner = new Scanner(System.in);



        while (true) {

        displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Ввод информации о книге и добавление в библиотеку
                    System.out.print("Введите название книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите имя автора: ");
                    String author = scanner.nextLine();
                    bookService.addBook(title, author, 1);
                    System.out.println("Книга была успешно добавленна");
                    break;
                /* Нужен метод добавления книги, который принимает только название книги и автора книги
                Так же довавить механизм если книга есть значит выкинуть ошбку что такая книга есть */
                case 2:
                    //Список всех книг
                    System.out.println("Список книг которые есть в библиотеке:");
                    bookService.getAllBooks();
                    break;
                // нужен метод который возвращает список всех книг
                case 3:
                    // Поиск книги
                    System.out.println("Книга найдена!");
                    System.out.println(bookService.getAllBooks() + "Книга свобода!");
                    break;
//                    Нужен метод который возвращает список книг отфильтрованный по строке поиска
                case 4:
                    // Взятие книги
                    System.out.println("Вы успешно взяли книгу!");
                    String borrowTitle = scanner.nextLine();
                    bookService.takeBook();
                    break;
//                    Нужен метод который принимает в себя айди книги которую берут, айди пользока который берёт книгу
//                      Если книга уже кем-то взята - выкинуть ошибку, если книга свободна - пометить что её взял данный пользак
                case 5:
                    // Возврат книги
                    System.out.println("Вы успешно вернули книгу!");
                    String returnTitle = scanner.nextLine();
                    bookService.returnBook();
                    break;
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
