/**
 * Product class representing a single product in the inventory system
 * Contains product details and methods for display and file operations
 */
public class Product {
    int id;
    String name;
    double price;
    int quantity;
    String category;

    /**
     * Constructor to create a new Product
     * 
     * @param id       Product ID
     * @param name     Product name
     * @param price    Product price
     * @param quantity Product quantity
     * @param category Product category
     */
    public Product(int id, String name, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    /**
     * Display product information in formatted table row
     */
    public void display() {
        System.out.printf("%-10d %-15s %-10.2f %-10d %-15s\n", id, name, price, quantity, category);
    }

    /**
     * Convert product to CSV string for file storage
     * 
     * @return CSV formatted string
     */
    public String toFileString() {
        return id + "," + name + "," + price + "," + quantity + "," + category;
    }

    /**
     * Create Product object from CSV string
     * 
     * @param line CSV formatted string
     * @return Product object
     */
    public static Product fromFileString(String line) {
        String[] parts = line.split(",");
        return new Product(
                Integer.parseInt(parts[0]),
                parts[1],
                Double.parseDouble(parts[2]),
                Integer.parseInt(parts[3]),
                parts[4]);
    }
}