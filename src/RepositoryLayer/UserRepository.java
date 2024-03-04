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
        User user = new User(currentId.getAndIncrement(), "stream11@gmail.com", "Str@ng0ne!26");
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
        User user = new User(currentId.getAndIncrement(), email, password);
        if (user.getEmail() == null || user.getPassword() == null) return null;
        user.setRole(Role.USER);
        users.add(user);
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

}
