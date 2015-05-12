package problem1;
public class Main {
    public static void main(String[] args) {

        User user1 = new User("Ivan");
        User user2 = new User("Mariq");
        User user3 = new User("");
        User user4 = new User("Rosi");

        DataBase db = new DataBase();

        try {
            db.add(user1);
            db.add(user2);
            db.add(user3);
            db.add(user4);

        } catch (DatabaseCorruptedException dbe) {
            System.out.println("The username is not valid!");
        }

    }
}
