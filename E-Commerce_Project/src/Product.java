// Product should have following attributes : name, product id, description and price

public class Product {
    private String name;
    private int productID;
    private String description;
    private double price;
    private int inventory;
    public Product() {
        this.name = null;
        this.productID = 0;
        this.description = null;
        this.price = 0.0;
        this.inventory = 0;
    }
    public Product(int id) {
        this.name = null;
        this.productID = id;
        this.description = null;
        this.price = 0.0;
        this.inventory = 0;
    }
    public Product(String name, String description, int id, double price, int inventory) {
        this.name = name;
        this.productID = id;
        this.description = null;
        this.price = 0.0;
    }
    // getters
    public int getProductID() {
        return this.productID;
    }
    public String getName() {
        return this.name;
    }

    // setters

}
