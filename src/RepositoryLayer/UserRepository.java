package RepositoryLayer;

import model.Role;
import model.User;
import util.MyArrayList;
import util.MyList;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {

    private final MyList<User> users;
    private User authorizedUser = null;
    private final AtomicInteger currentId = new AtomicInteger(1);
    public UserRepository(){
        this.users = new MyArrayList<>();
        initUser();
    }


    /** METHOD OF FILLING WITH INITIAL DATA
     *
     */
    private void initUser() {
        User user = new User(currentId.getAndIncrement(), "admin", "admin");
        User user1 = new User(currentId.getAndIncrement(), "log1nsga@gmail.com", "Sjwahuew7362!");
        User user2 = new User(currentId.getAndIncrement(), "vindicator42@yahoo.com", "ospdiaiwuaoDAW3821@");
        User user3 = new User(currentId.getAndIncrement(), "college.swing@aol.com", "JAhsdhkwa2183@321dsa");
        User user4 = new User(currentId.getAndIncrement(), "kerr1gun@yandex.ru", "Jandsu@1(ds13");
        user.setRole(Role.ADMIN);

        users.addAll(user, user1, user2, user3, user4);

    }




    public MyList<User> getAllUsers(){
        return users;
    }

    public boolean isUserEmailExist(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) return true;
        }
        return false;
    }

    public User createUser(String email, String password) {
        User user = null;
        if (isEmailValid(email) && isPasswordValid(password)) {
            user = new User(currentId.getAndIncrement(), email, password);
            if (user.getEmail() == null || user.getPassword() == null) return null;
            user.setRole(Role.USER);
            users.add(user);
        }
        return user;

    }



    public User isRegistered(String email, String password) {

        if (email == null || password == null) {
            System.out.println("Пустой email  или пароль");
            return null;
        }
        if (isUserEmailExist(email)){
            System.out.println("Пользователь с таким email уже существует");
            return null;
        }

        User user = createUser(email, password);

        return user;
    }

    public User isAuthorized(String email, String password){
        if (email == null || password == null){
            return null;
        }
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                authorizedUser = user;
                return authorizedUser;
            }
        }
        return null;
    }

    private boolean isEmailValid(String email) {
        if (email == null || email.isEmpty()){
            return false;
        }

        int indexAt = email.indexOf("@");
        if (indexAt <= 0 || indexAt != email.lastIndexOf("@")) {
            return false;
        }


        int indexFirstDotAfterAt = email.indexOf('.', indexAt);
        if (indexFirstDotAfterAt == -1 || indexFirstDotAfterAt == indexAt + 1){
            return false;
        }

        if (email.lastIndexOf('.') >= email.length() - 2) {
            return false;
        }

        boolean isCharAlphabetic = Character.isAlphabetic(email.charAt(0));

        if (!isCharAlphabetic) {
            return false;
        }

        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);

            boolean isCharValid = (Character.isAlphabetic(c)
                    || Character.isDigit(c)
                    || c == '-'
                    || c == '_'
                    || c == '.'
                    || c == '@');
            if (!isCharValid){
                return false;
            }
        }

        return true;
    }


    private boolean isPasswordValid(String password) {
        if (password == null || password.length() < 8) return false;

        boolean isLowerCase = false;
        boolean isUpperCase = false;
        boolean isDigit = false;
        boolean isSpacialSymbol = false;



        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isDigit(c)) {
                isDigit = true;
                continue;
            }

            if (Character.isLowerCase(c)) {
                isLowerCase = true;
                continue;
            }
            if (Character.isUpperCase(c)) {
                isUpperCase = true;
                continue;
            }

            if ("!%$@&*()[]".indexOf(c) >= 0) {
                isSpacialSymbol = true;
            }

        }

        return isLowerCase && isUpperCase && isDigit && isSpacialSymbol;

    }

}
