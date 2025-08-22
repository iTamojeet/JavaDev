import java.io.*;
import java.util.*;

/**
 * Advanced Product Management System using Arrays in Core Java
 * Features: CRUD operations, sorting, filtering, and file persistence
 */
public class AdvancedProductManagementSystem {
    // Array to store products (max 100)
    static Product[] products = new Product[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "products.txt";

    public static void main(String[] args) {
        // Load existing data on startup
        loadFromFile();

        int choice;
        do {
            displayMenu();
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> searchProduct();
                case 4 -> updateProduct();
                case 5 -> deleteProduct();
                case 6 -> sortByPrice();
                case 7 -> sortByName();
                case 8 -> filterByCategory();
                case 9 -> {
                    saveToFile();
                    System.out.println("Data saved. Exiting...");
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 9);
    }

    /**
     * Display the main menu
     */
    public static void displayMenu() {
        System.out.println("\n=== Advanced Product Management System ===");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Search Product by ID");
        System.out.println("4. Update Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Sort Products by Price");
        System.out.println("7. Sort Products by Name");
        System.out.println("8. Filter Products by Category");
        System.out.println("9. Save & Exit");
    }

    /**
     * Add a new product to the system
     */
    public static void addProduct() {
        if (count >= products.length) {
            System.out.println("Product list is full! Maximum 100 products allowed.");
            return;
        }

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        // Check if ID already exists
        for (int i = 0; i < count; i++) {
            if (products[i].id == id) {
                System.out.println("Product ID already exists! Please use a different ID.");
                return;
            }
        }

        sc.nextLine(); // consume newline
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        if (price < 0) {
            System.out.println("Price cannot be negative!");
            return;
        }

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        if (qty < 0) {
            System.out.println("Quantity cannot be negative!");
            return;
        }

        sc.nextLine(); // consume newline
        System.out.print("Enter Category (Electronics/Clothing/Grocery/Books/Others): ");
        String category = sc.nextLine();

        products[count++] = new Product(id, name, price, qty, category);
        System.out.println("Product added successfully!");
    }

    /**
     * View all products in the system
     */
    public static void viewProducts() {
        if (count == 0) {
            System.out.println("No products available!");
            return;
        }

        System.out.println("\n" + "=".repeat(75));
        System.out.printf("%-10s %-15s %-10s %-10s %-15s\n", "ID", "Name", "Price", "Quantity", "Category");
        System.out.println("=".repeat(75));

        for (int i = 0; i < count; i++) {
            products[i].display();
        }
        System.out.println("=".repeat(75));
        System.out.println("Total products: " + count);
    }

    /**
     * Search for a product by ID
     */
    public static void searchProduct() {
        if (count == 0) {
            System.out.println("No products available to search!");
            return;
        }

        System.out.print("Enter Product ID to search: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (products[i].id == id) {
                System.out.println("\nProduct found:");
                System.out.printf("%-10s %-15s %-10s %-10s %-15s\n", "ID", "Name", "Price", "Quantity", "Category");
                System.out.println("-".repeat(75));
                products[i].display();
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found!");
    }

    /**
     * Update an existing product
     */
    public static void updateProduct() {
        if (count == 0) {
            System.out.println("No products available to update!");
            return;
        }

        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (products[i].id == id) {
                System.out.println("Current product details:");
                System.out.printf("%-10s %-15s %-10s %-10s %-15s\n", "ID", "Name", "Price", "Quantity", "Category");
                System.out.println("-".repeat(75));
                products[i].display();

                sc.nextLine(); // consume newline
                System.out.print("Enter New Name: ");
                products[i].name = sc.nextLine();

                System.out.print("Enter New Price: ");
                double newPrice = sc.nextDouble();
                if (newPrice >= 0) {
                    products[i].price = newPrice;
                } else {
                    System.out.println("Invalid price! Keeping old price.");
                }

                System.out.print("Enter New Quantity: ");
                int newQty = sc.nextInt();
                if (newQty >= 0) {
                    products[i].quantity = newQty;
                } else {
                    System.out.println("Invalid quantity! Keeping old quantity.");
                }

                sc.nextLine(); // consume newline
                System.out.print("Enter New Category: ");
                products[i].category = sc.nextLine();

                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found!");
    }

    /**
     * Delete a product from the system
     */
    public static void deleteProduct() {
        if (count == 0) {
            System.out.println("No products available to delete!");
            return;
        }

        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (products[i].id == id) {
                System.out.println("Product to be deleted:");
                products[i].display();

                System.out.print("Are you sure you want to delete this product? (y/n): ");
                sc.nextLine(); // consume newline
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                    // Shift elements to fill the gap
                    for (int j = i; j < count - 1; j++) {
                        products[j] = products[j + 1];
                    }
                    products[--count] = null; // Clear the last element
                    System.out.println("Product deleted successfully!");
                } else {
                    System.out.println("Delete operation cancelled.");
                }
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found!");
    }

    /**
     * Sort products by price (ascending order)
     */
    public static void sortByPrice() {
        if (count == 0) {
            System.out.println("No products available to sort!");
            return;
        }

        Arrays.sort(products, 0, count, Comparator.comparingDouble(p -> p.price));
        System.out.println("Products sorted by price (ascending order)!");
        viewProducts();
    }

    /**
     * Sort products by name (alphabetical order)
     */
    public static void sortByName() {
        if (count == 0) {
            System.out.println("No products available to sort!");
            return;
        }

        Arrays.sort(products, 0, count, Comparator.comparing(p -> p.name.toLowerCase()));
        System.out.println("Products sorted by name (alphabetical order)!");
        viewProducts();
    }

    /**
     * Filter products by category (case-insensitive)
     */
    public static void filterByCategory() {
        if (count == 0) {
            System.out.println("No products available to filter!");
            return;
        }

        sc.nextLine(); // consume newline
        System.out.print("Enter Category to filter: ");
        String cat = sc.nextLine();
        boolean found = false;

        System.out.println("\nFiltered products for category: " + cat);
        System.out.println("=".repeat(75));
        System.out.printf("%-10s %-15s %-10s %-10s %-15s\n", "ID", "Name", "Price", "Quantity", "Category");
        System.out.println("=".repeat(75));

        for (int i = 0; i < count; i++) {
            if (products[i].category.equalsIgnoreCase(cat)) {
                products[i].display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found in category: " + cat);
        } else {
            System.out.println("=".repeat(75));
        }
    }

    /**
     * Save all products to file
     */
    public static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < count; i++) {
                bw.write(products[i].toFileString());
                bw.newLine();
            }
            System.out.println("Data saved successfully to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    /**
     * Load products from file on startup
     */
    public static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No existing data file found. Starting with empty inventory.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            count = 0; // Reset count
            int lineNumber = 0;
            while ((line = br.readLine()) != null && count < products.length) {
                lineNumber++;
                line = line.trim(); // Remove leading/trailing whitespace

                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                try {
                    Product product = Product.fromFileString(line);
                    if (product != null) {
                        products[count++] = product;
                    }
                } catch (Exception e) {
                    System.out.println("Error parsing line " + lineNumber + ": " + line);
                    System.out.println("Reason: " + e.getMessage() + ". Skipping this line.");
                }
            }
            System.out.println("Successfully loaded " + count + " products from " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}