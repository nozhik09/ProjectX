package service;

import RepositoryLayer.UserRepository;
import model.User;
import util.MyArrayList;
import util.MyList;

import java.util.ArrayList;
import java.util.List;

public class UserService  implements Interfaces.UserService {

    private User activeUser;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MyList<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User createUser(String email, String password) {
        boolean isExist = userRepository.isUserEmailExist(email);
        if (isExist) {
            return null;
        }
        // Мне нужно провалидировать мой email и пароль
        User user = userRepository.createUser(email, password);
        return user;
    }

    public User registerUser(String email, String password) {

        if (email == null || password == null) {
            System.out.println("Пустой email  или пароль");
            return null;
        }
        if (userRepository.isUserEmailExist(email)){
            System.out.println("Пользователь с таким email уже существует");
            return null;
        }



        User user = userRepository.createUser(email, password);
        return user;
    }

    public User getActiveUser() {
        return activeUser;
    }

    @Override
    public User authorize(String email, String password) {
        boolean userExists = userRepository.isUserEmailExist(email);
        MyList<User> users = new MyArrayList<>();

        if (!userExists) {
            return null; // Пользователь не найден
        }



        return null;
    }


    // Должен прийти email и password



}
