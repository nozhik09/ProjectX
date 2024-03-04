package Interfaces;

import model.User;
import service.UserService;

public interface UserServiceInterface {
    public User registerUser(String email, String password);
    public User getActiveUser(String email, String password);
    public User authorize(String email, String password);



}
