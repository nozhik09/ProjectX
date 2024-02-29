package view;

import java.util.Scanner;


import RepositoryLayer.BookRepository;

public class Menu {


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

   public void run (){
        Scanner scanner = new Scanner(System.in);


        while (true) {


            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Ввод информации о книге и добавление в библиотеку
                    break;
                case 2:

                    break;
                case 3:
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
