package RepositoryLayer;

import model.Role;
import model.User;
import util.MyArrayList;
import util.MyList;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {

    private final MyList<User> users;

    private final AtomicInteger currentId = new AtomicInteger(1);
    public UserRepository(){
        this.users = new MyArrayList<>();
    }


    // метод заполнения начальными или тестовыми данными
    private void initUser() {
        User user = new User(currentId.getAndIncrement(), "stream11@gmail.com", "Str@ng0ne!26");
        User user1 = new User(currentId.getAndIncrement(), "log1nsga@gmail.com", "Sjwahuew7362!");
        User user2 = new User(currentId.getAndIncrement(), "vindicator42@yahoo.com", "ospdiaiwuaoDAW3821@");
        User user3 = new User(currentId.getAndIncrement(), "college.swing@aol.com", "JAhsdhkwa2183@321dsa");
        User user4 = new User(currentId.getAndIncrement(), "kerr1gun@yandex.ru", "Jandsu@1(ds13");
        user.setRole(Role.ADMIN);

        users.addAll(user, user1, user2, user3, user4);

    }

    private boolean isEmailValid(String email){
        if (email == null || email.isEmpty()) return false;

        int indexAt = email.indexOf('@');

        if (indexAt <= 0 || indexAt != email.lastIndexOf('@')) return false;


        int indexFirstDotAfterAt = email.indexOf('.', indexAt);
        if (email.indexOf('.',indexAt) == -1 || indexFirstDotAfterAt == indexAt +1) return false;

        if (email.lastIndexOf('.') >= email.length() -2) return false;

        if (!Character.isAlphabetic(email.charAt(0))) return false;

        boolean isCharAlphbetic = Character.isAlphabetic(email.charAt(0));

        if(!isCharAlphbetic) return false;

        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);


            boolean isCharValid = (Character.isAlphabetic(c)
                    || Character.isDigit(c)
                    || c == '-'
                    || c == '_'
                    || c == '.'
                    || c == '@');

            if (!isCharValid) return false;



        }

        return true;


    }

    private boolean isPasswordValid(String password){
        if (password == null || password.isEmpty()) return false;

        if (password.length() < 8){
            return false;
        }

        boolean isLowerCase = false;
        boolean isUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < password.length(); i++) {
            char a = password.charAt(i);

            if (Character.isLowerCase(a)){
                isLowerCase = true;
                continue;
            }

            if (Character.isUpperCase(a)) {
                isUpperCase = true;
                continue;
            }

            if (Character.isDigit(a)) {
                hasDigit = true;
                continue;
            }

            if ("!%$@&*()[]".indexOf(a) >= 0) {
                hasSpecialChar = true;
                continue;
            }


        }

        return isLowerCase && isUpperCase && hasDigit && hasSpecialChar;
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
        User user = new User(currentId.getAndIncrement(), email, password);
        if (user.getEmail() == null || user.getPassword() == null) return null;
        users.add(user);
        return user;

    }

    public User getRandomUser() {
        Random random = new Random();
        int index = random.nextInt(users.size());
        return users.get(index);
    }

}
