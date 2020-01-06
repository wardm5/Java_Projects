import java.util.*;
// User should have following attributes: name, user id, address, date of birth
public class User {
    private String email;
    private String name;
    private int userID;
    private String address;
    private Date dob;
    private String password;
    private List<Product> shoppingCart;

    public User() {
        this.email = "";
        this.name = "";
        this.userID = 0;
        this.address = "";
        this.dob = null;
        this.password = "";
    }
    public User(int userID) {
        this.email = "";
        this.name = "";
        this.userID = userID;
        this.address = "";
        this.dob = null;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setDoB(Date dob) {
        this.dob = dob;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // getters
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public Date getDoB() {
        return this.dob;
    }
    public String getPassword() {
        return this.password;
    }
    public String getEmail() {
        return this.email;
    }

}
