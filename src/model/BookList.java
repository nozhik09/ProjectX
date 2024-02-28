package model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BookList {
//    public static void main(String[] args) {
//        // Замените "путь_к_файлу.txt" на реальный путь к вашему текстовому файлу
//        String filePath = "C:\\Users\\Nozhik09\\IdeaProjects\\ProjectX\\src\\BookList.txt";
//
//        try {
//            File file = new File(filePath);
//
//            // Создаем FileReader для чтения файла
//            FileReader fileReader = new FileReader(file);
//
//            // Создаем BufferedReader для более эффективного чтения строк
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            String line;
//            // Читаем файл построчно
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            // Закрываем BufferedReader и FileReader
//            bufferedReader.close();
//            fileReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void displayAllBooks() {
        String filePath = "C:\\Users\\Nozhik09\\IdeaProjects\\ProjectX\\src\\BookList.txt";

        try {
            File file = new File(filePath);

            // Создаем FileReader для чтения файла
            FileReader fileReader = new FileReader(file);

            // Создаем BufferedReader для более эффективного чтения строк
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Читаем файл построчно
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Закрываем BufferedReader и FileReader
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
