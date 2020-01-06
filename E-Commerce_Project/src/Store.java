import java.util.*;
public class Store {
    private HashMap<String, User> userMap;  // email : user
    private static HashMap<Integer, Product> storeCatelog;  // productID to product
    private String storeName;
    public Store(String storeName) {
        this.userMap = new HashMap<>();
        this.storeCatelog = new HashMap<>();
        this.storeName = storeName;
        // readUsers();
        // readProducts();
        // readTransactions();
        welcome();
    }
    private void welcome() {
        // regsiter, login, <product search?>
        System.out.println("Welcome to the " + this.storeName);

    }

    private void register(String email) {
        if (userMap.containsKey(email)) {
            System.out.println("You have already registered");
            return;
        } else {
            User newUser = new User(userMap.size() + 1);
            newUser.setName("joe");
            newUser.setAddress("123 ave st");
            newUser.setDoB(new Date("09/10/1990"));
            userMap.put(email, newUser);
        }
    }
    public void login(String email, String password) {
        // check credentials
        User currUser;
        if (userMap.containsKey(email))
            currUser = userMap.get(email);
        else {
            System.out.println("Error: Your email is not valid");
            return;
        }
        if (email.equals(currUser.getEmail()) && password.equals(currUser.getPassword())) {
            loggedIn(true);
        } else {
            System.out.println("Error: Your email or password is not valid, please try again.");
            return;
        }
    }
    public void loggedIn(boolean logInStatus) {
        while (logInStatus) {
            return;
            // product search
            // option for log out
            // option to pay if item in cart
            // option to add item to the cart
        }
    }
    public void logOut() {

    }
    private void printReport() {

    }
}
