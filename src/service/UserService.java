package service;

import Interfaces.UserServiceInterface;
import RepositoryLayer.UserRepository;
import model.User;
import util.MyArrayList;
import util.MyList;

public class UserService implements UserServiceInterface {

    private User activeUser;

    private final UserRepository userRepository;
    private String email;
    private String password;

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


    public User getActiveUser() {
        return activeUser;
    }



    @Override
    public User registerUser(String email, String password){
        return userRepository.isRegistered(email, password);
}
@Override
    public User authorize(String email, String password){
        return userRepository.isAuthorized(email, password);
}


    // Должен прийти email и password



}
