package Interfaces;

import model.User;

public interface UserService {
    public User registerUser(String email, String password); // Masha
    public User getActiveUser(); // Pasha
    public User authorise(String email, String password);



}
