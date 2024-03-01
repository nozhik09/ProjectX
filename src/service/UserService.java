package service;

import RepositoryLayer.UserRepository;
import model.User;
import util.MyList;

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

        //Можно здесь в сервисе написать методы валидации email и password
        //B случае успешного прохождения - отправляем на запись в хранилище данных


        User user = userRepository.createUser(email, password);
        return user;
    }

    public User getActiveUser() {
        return activeUser;
    }


    // Должен прийти email и password
    public User authorize() {
        //Todo править метод
//        User user = userRepository.getUserByEmail("test@email.net");
        // проверка существования пользователя
        // сверить пароли
        //и если все ОК-

        User user = userRepository.getRandomUser();
        activeUser = user;
        return user;
    }

    @Override
    public User authorise(String email, String password) {
        return null;
    }

}
