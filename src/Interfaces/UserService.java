package Interfaces;

import model.User;

public interface UserService {
    public User registerUser(String email, String password);
    public User getActiveUser();
    public User authorize(String email, String password);



}
