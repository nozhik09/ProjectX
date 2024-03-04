package service;

import Interfaces.UserServiceInterface;
import RepositoryLayer.UserRepository;
import model.User;
import util.MyList;

public class UserService implements UserServiceInterface {

    private User activeUser;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MyList<User> getAllUsers() {
        return userRepository.getAllUsers();
    }



    @Override
    public User getActiveUser(String email, String password) {
        if (activeUser == null) {
            activeUser = authorize(email, password);
        }
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






}
