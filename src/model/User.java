package model;

import RepositoryLayer.UserRepository;

import static validators.UserValidator.isEmailValid;
import static validators.UserValidator.isPasswordValid;

public class User {

private String password;
private String email;
private Role role;
private int id;

    public User(int id, String email, String password) {
        this.password = password;
        this.email = email;
        this.role=Role.USER;
        this.id=id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (isPasswordValid(password))
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isEmailValid(email)) {
            this.email = email;
        }
    }


    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return "User:" + id + "[ " +
                 password + ' ' +
                 email + ' ' +
                 role + ' ' +
                " ]" + "\n";
    }
}
