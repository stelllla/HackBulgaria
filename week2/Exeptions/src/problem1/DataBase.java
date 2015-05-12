package problem1;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private List<User> users = new ArrayList<User>();
    
    public void add(User user) {
        if (user.getUserName().equals("")) {
            throw new DatabaseCorruptedException();
        }

        users.add(user);
    }

    public void remove(User user) {
        users.remove(user);
    }

    public void printUsers() {
        for (int i = 0; i < users.size(); i++) {
            System.out.print(users.get(i) + " ");
        }
    }

}
