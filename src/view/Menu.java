package view;

import java.util.Scanner;

import RepositoryLayer.BookRepository;
import RepositoryLayer.UserRepository;
import model.User;
import service.BookService;
import model.Book;
import service.BookService;
import service.UserService;
import util.MyLinkedList;
import util.MyList;

// ПОЖАЛУЙСТА НЕ ПУШТЕ МЕНЮ В РЕПОЗИТОРИЙ!!!!! ЕСЛИ ХОТИТЕ ЗАПУШИТЬ СВОЙ КОД ИЗ СВОИХ ЗАДАЧ ДЕЛАЙТЕ ЭТО ВЫБИРАЯ ФАЙЛ
// git add Название файла!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Menu {
    enum MenuItem {
        AUTORIZE("Авторизация"),
        REGISTRATION("Регистрация"),
        ADD_BOOK("Добавить Книгу"),
        DISPLAY_ALL_BOOKS("Отобразить все книги"),
        SEARCH_BOOK("Найти книгу"),
        GET_BOOK("Взять Книгу"),
        RETURN_BOOK("Вернуть книгу"),
        BOOKS_BY_READER("Книги взятые вами"),
        DISPLAY_ALL_AVAILABLE_BOOKS("Список доступных книг"),
        DISPLAY_TAKEN_BOOKS("Список взятых книг"),
        EXIT("Выход");

        private final String title;

        MenuItem(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }

    }

    // Private properties
    private final Scanner scanner = new Scanner(System.in);
    private MyLinkedList<MenuItem> menu = new MyLinkedList<>();
    private UserService userService = new UserService(new UserRepository());
    private BookService bookService = new BookService(new BookRepository());

    // Public methods
    public void run() {
        createAuthMenu();
        while (true) {
            displayMenu();
            inputUserAction();
        }

    }

    // Private methods
    private void displayMenu() {
        System.out.println("\nМеню:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), menu.get(i));
        }
    }

    private void inputUserAction() {
        System.out.print("Выберите опцию: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        MenuItem menuItem = menu.get(choice - 1);
        menuAction(menuItem);
    }

    private void menuAction(MenuItem menuItem) {
        switch (menuItem) {
            case AUTORIZE:
                loginAction();
                break;
            case REGISTRATION:
                registerAction();
                break;
            case ADD_BOOK:
                addBookAction();
                break;
            case DISPLAY_ALL_BOOKS:
                displayAllBooksAction();
                break;
            case SEARCH_BOOK:
                searchBookAction();
                break;
            case GET_BOOK:
                break;
            case RETURN_BOOK:
                break;
            case BOOKS_BY_READER:
                break;
            case DISPLAY_ALL_AVAILABLE_BOOKS:
                break;
            case DISPLAY_TAKEN_BOOKS:
                break;
            case EXIT:
                break;
        }
    }

    // Private create menu methods
    private void createAuthMenu() {
        menu = new MyLinkedList<>();
        menu.addAll(
                MenuItem.AUTORIZE,
                MenuItem.REGISTRATION,
                MenuItem.EXIT);
    }

    private void createLibraryMenu() {
        menu = new MyLinkedList<>();
        menu.addAll(
                MenuItem.DISPLAY_ALL_BOOKS,
                MenuItem.SEARCH_BOOK,
                MenuItem.GET_BOOK,
                MenuItem.RETURN_BOOK,
                MenuItem.BOOKS_BY_READER,
                MenuItem.DISPLAY_ALL_AVAILABLE_BOOKS,
                MenuItem.DISPLAY_TAKEN_BOOKS,
                MenuItem.EXIT);
    }
    private void createAdminLibraryMenu() {
        menu = new MyLinkedList<>();
        menu.addAll(
                MenuItem.ADD_BOOK,
                MenuItem.DISPLAY_ALL_BOOKS,
                MenuItem.SEARCH_BOOK,
                MenuItem.GET_BOOK,
                MenuItem.RETURN_BOOK,
                MenuItem.BOOKS_BY_READER,
                MenuItem.DISPLAY_ALL_AVAILABLE_BOOKS,
                MenuItem.DISPLAY_TAKEN_BOOKS,
                MenuItem.EXIT);
    }

    // Private menu actions
    private void loginAction() {
        System.out.print("Введите ваш Email: ");
        String email = scanner.nextLine();
        System.out.print("Введите ваш Пароль: ");
        String password = scanner.nextLine();
        User user = userService.authorize(email, password);
        if (user == null) {
            System.out.println("Неверный логин или пароль!");
        } else {
            System.out.println("Вход прошёл успешно!");
            switch (user.getRole()){
                case USER:
                    createLibraryMenu();
                    break;
                case ADMIN:
                    createAdminLibraryMenu();
                    break;
                case DEBTOR:
                    break;
                case GUEST:
                    break;
            }
        }
    }

    private void registerAction() {
        System.out.print("Введите ваш Email: ");
        String email = scanner.nextLine();
        System.out.print("Введите ваш Пароль: ");
        String password = scanner.nextLine();
        User user = userService.registerUser(email, password);
        if (user == null) {
            System.out.println("Упсс.... ты накосячил");
        } else {
            System.out.println("Вы успешно стали членом клуба");
            System.out.println("Вход в мир");
            switch (user.getRole()){
                case USER:
                    createLibraryMenu();
                    break;
                case ADMIN:
                    createAdminLibraryMenu();
                    break;
                case DEBTOR:
                    break;
                case GUEST:
                    break;
            }
        }
    }

    private void addBookAction() {
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();
        System.out.print("Введите имя автора: ");
        String author = scanner.nextLine();
        bookService.addBook(title, author);
        System.out.println("Книга была успешно добавленна");
    }
    private void displayAllBooksAction() {
        System.out.println("Список книг которые есть в библиотеке:");
        MyList<Book> books = bookService.getAllBooks();
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
    private void searchBookAction() {
        System.out.println("Введите поисковой запрос: ");
        String search = scanner.nextLine();
        Book book = bookService.searchBook(search);
        if (book == null) {
            System.out.println("Книга не найдена");
        } else {
            System.out.println("Вот ваша книга: ");
            System.out.printf("%s %s %d", book.getTitle(), book.getAuthor(), book.getBookId());
        }
    }
    private  void takeBookAction() {
        System.out.println("Напишите ID книги которую хотите взять:");
        String search = scanner.nextLine();
        Book book = bookService.searchBook(search);
        if (book == null) {
            System.out.println("Книга не найдена");
        } else if (book.isAvailable()) {
            bookService.takeBook(book.getBookId());
            System.out.println("Книга успешно взята!");
        } else {
            System.out.println("Книга взята другим пользователем");
        }

    }
    private void returnBookAction() {
        System.out.println("Напишите название книги которую хотите вернуть:");
        String returnBook = scanner.nextLine();
        Book book = bookService.searchBook(returnBook);
        if (book == null) {
            System.out.println("Книга не найдена");
        } else if (!book.isAvailable()) {
            //TODO использовать метод когда будет готов
//            bookService.takeBook(book.getBookId());
            System.out.println("Книга успешно возвращена!");
        } else {
            System.out.println("Книга уже в библиотеке");
        }
    }
    private void booksByReaderAction() {
        System.out.println("Книги которые вы взяли:");
        MyList<Book> books = bookService.booksByRead();
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
    private void displayAllAvailableBooksAction() {
        System.out.println("Все доступные книги в библиотеке:");
        MyList<Book> books = bookService.availableBooks();
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
    private  void displayTakenBooksAction() {
        System.out.println("Все занятые книги:");
        MyList<Book> books = bookService.checkoutBooks();
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
    private void exitAction() {
        System.exit(0);
    }


//    private final Scanner scanner = new Scanner(System.in);
//    BookService bookService = new BookService(new BookRepository());
//
//    private final BookService service;
//
//    public Menu(BookService service) {
//        this.service = service;
//    }
//
//    public void displayMenu() {
//        System.out.println("1. Добавить книгу");
//        System.out.println("2. Вывести список всех книг");
//        System.out.println("3. Поиск книги");
//        System.out.println("4. Взять книгу");
//        System.out.println("5. Вернуть книгу");
//        System.out.println("6. Список свободных книг");
//        System.out.println("7. Список взятых книг");
//        System.out.println("8. Выход");
//        System.out.print("Выберите опцию: ");
//    }
//
//    public void library() {
//
//        while (true) {
//
//            displayMenu();
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline character
//
//            switch (choice) {
//                case 1:
//                    // Ввод информации о книге и добавление в библиотеку
//                    System.out.print("Введите название книги: ");
//                    String title = scanner.nextLine();
//                    System.out.print("Введите имя автора: ");
//                    String author = scanner.nextLine();
//                    bookService.addBook(title, author);
//                    System.out.println("Книга была успешно добавленна");
//                    break;
//                /* Нужен метод добавления книги, который принимает только название книги и автора книги
//                Так же довавить механизм если книга есть значит выкинуть ошбку что такая книга есть */
//                case 2:
//                    //Список всех книг
//                    System.out.println("Список книг которые есть в библиотеке:");
//                    MyList<Book> books = bookService.getAllBooks();
//                    for (int i = 0; i <books.size(); i++) {
//                        System.out.println(books.get(i));
//                    }
//                    break;
//                // нужен метод который возвращает список всех книг
//                case 3:
//                    // Поиск книги
//                    System.out.println("Книга найдена!");
//                    System.out.println(bookService.getAllBooks() + "Книга свобода!");
//                    break;
////                    Нужен метод который возвращает список книг отфильтрованный по строке поиска
//                case 4:
//                    // Взятие книги
//                    System.out.println("Вы успешно взяли книгу!");
//                    String borrowTitle = scanner.nextLine();
//                    bookService.takeBook();
//                    break;
////                    Нужен метод который принимает в себя айди книги которую берут, айди пользока который берёт книгу
////                      Если книга уже кем-то взята - выкинуть ошибку, если книга свободна - пометить что её взял данный пользак
//                case 5:
//                    // Возврат книги
//                    System.out.println("Вы успешно вернули книгу!");
//                    String returnTitle = scanner.nextLine();
//                    bookService.returnBook();
//                    break;
////                Нужен метод который принимает в себя айди книги которую возвращают, айди пользока который бвозвращает книгу
////                Если книга была взята данным пользаком - посетить что книга стала свободна
////                если книга была взята другим пользаком - выкинуть ошибку что у него небыло этой книги
////                если книгу никто не брал - выкинуть ошибку о том что Книга в библиотеке
//
//                case 6:
//                    System.out.println("Все доступные книги:");
//                    bookService.availableBooks();
//                    break;
////                    нужен метод который возвращает список всех доступных книг
//                case 7:
//                    System.out.println("Все взятые книги:");
//                    bookService.checkoutBooks();
//                    break;
////                    нужен метод который возвращает список всех взятых книг
//                case 8:
//                    System.out.println("Программа завершена!");
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Некорректный ввод. Пожалуйста, выберите существующую опцию.");
//            }
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public void LoginRegistration() {
//
//        while (true) {
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                    System.out.println("Вход");
//                    userService.authorize();
//                    break;
//                case 2:
//                    System.out.println("Регистация");
//                    if () {
//                        System.out.println("Введите Email:");
//                        String email;
//                        System.out.println("Введите Пароль:");
//                        String password;
//                        userService.registerUser(String email, String password);
//                    }
//                    break;
//            }
//        }
//    }
//
//    public void userMenu() {
//        displayMenu();
//
//
//    }
//
//    public void adminMenu() {
//
//    }
}
