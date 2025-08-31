import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Enhanced Product class for InvenTrack v2.0
 * Added features: timestamps, better validation, enhanced display
 */

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Category constants for validation
    public static final String[] VALID_CATEGORIES = {
        "Electronics", "Clothing", "Grocery", "Books", "Sports", 
        "Home & Garden", "Beauty", "Automotive", "Others"
    };

    /**
     * Constructor to create a new Product
     */
    public Product(int id, String name, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Constructor for loading from file with timestamps
     */
    public Product(int id, String name, double price, int quantity, String category, 
                   LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // Setters with validation
    public void setName(String name) {
        this.name = name != null ? name.trim() : "Unknown";
        this.updatedAt = LocalDateTime.now();
    }

    public void setPrice(double price) {
        this.price = Math.max(0, price);
        this.updatedAt = LocalDateTime.now();
    }

    public void setQuantity(int quantity) {
        this.quantity = Math.max(0, quantity);
        this.updatedAt = LocalDateTime.now();
    }

    public void setCategory(String category) {
        this.category = isValidCategory(category) ? category : "Others";
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Check if category is valid
     */
    public static boolean isValidCategory(String category) {
        if (category == null) return false;
        for (String validCat : VALID_CATEGORIES) {
            if (validCat.equalsIgnoreCase(category.trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get stock status based on quantity
     */
    public String getStockStatus() {
        if (quantity == 0) return "OUT_OF_STOCK";
        if (quantity <= 5) return "LOW_STOCK";
        if (quantity <= 20) return "MEDIUM_STOCK";
        return "HIGH_STOCK";
    }

    /**
     * Get stock status color code for console
     */
    public String getStockStatusColor() {
        switch (getStockStatus()) {
            case "OUT_OF_STOCK": return UIConstants.RED;
            case "LOW_STOCK": return UIConstants.YELLOW;
            case "MEDIUM_STOCK": return UIConstants.CYAN;
            case "HIGH_STOCK": return UIConstants.GREEN;
            default: return UIConstants.RESET;
        }
    }

    /**
     * Display product information in formatted table row
     */
    public void display() {
        String stockColor = getStockStatusColor();
        System.out.printf("%-8d %-20s %s%-12.2f%s %s%-8d%s %-15s %-12s\n", 
            id, 
            name.length() > 20 ? name.substring(0, 17) + "..." : name,
            UIConstants.GREEN, price, UIConstants.RESET,
            stockColor, quantity, UIConstants.RESET,
            category,
            getStockStatus().replace("_", " ")
        );
    }

    /**
     * Display detailed product information
     */
    public void displayDetailed() {
        System.out.println(UIConstants.CYAN + "═══════════════════════════════════════════════════════════════════" + UIConstants.RESET);
        System.out.printf("%sProduct ID:%s %d\n", UIConstants.BOLD, UIConstants.RESET, id);
        System.out.printf("%sName:%s %s\n", UIConstants.BOLD, UIConstants.RESET, name);
        System.out.printf("%sPrice:%s %s$%.2f%s\n", UIConstants.BOLD, UIConstants.RESET, UIConstants.GREEN, price, UIConstants.RESET);
        System.out.printf("%sQuantity:%s %s%d%s\n", UIConstants.BOLD, UIConstants.RESET, getStockStatusColor(), quantity, UIConstants.RESET);
        System.out.printf("%sCategory:%s %s\n", UIConstants.BOLD, UIConstants.RESET, category);
        System.out.printf("%sStock Status:%s %s%s%s\n", UIConstants.BOLD, UIConstants.RESET, getStockStatusColor(), getStockStatus().replace("_", " "), UIConstants.RESET);
        System.out.printf("%sCreated:%s %s\n", UIConstants.BOLD, UIConstants.RESET, createdAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        System.out.printf("%sLast Updated:%s %s\n", UIConstants.BOLD, UIConstants.RESET, updatedAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        System.out.println(UIConstants.CYAN + "═══════════════════════════════════════════════════════════════════" + UIConstants.RESET);
    }

    /**
     * Convert product to CSV string for file storage
     */
    public String toFileString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("%d,%s,%.2f,%d,%s,%s,%s",
            id, name, price, quantity, category,
            createdAt.format(formatter),
            updatedAt.format(formatter)
        );
    }

    /**
     * Create Product object from CSV string
     */
    public static Product fromFileString(String line) {
        String[] parts = line.split(",", -1);
        
        if (parts.length < 5) {
            throw new IllegalArgumentException("Invalid CSV format: insufficient fields");
        }

        try {
            int id = Integer.parseInt(parts[0].trim());
            String name = parts[1].trim().isEmpty() ? "Unknown" : parts[1].trim();
            double price = parts[2].trim().isEmpty() ? 0.0 : Double.parseDouble(parts[2].trim());
            int quantity = parts[3].trim().isEmpty() ? 0 : Integer.parseInt(parts[3].trim());
            String category = parts[4].trim().isEmpty() ? "Others" : parts[4].trim();

            LocalDateTime createdAt = null;
            LocalDateTime updatedAt = null;

            // Handle timestamps if available (v2.0 format)
            if (parts.length >= 7) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                try {
                    createdAt = LocalDateTime.parse(parts[5].trim(), formatter);
                    updatedAt = LocalDateTime.parse(parts[6].trim(), formatter);
                } catch (Exception e) {
                    // Use current time if parsing fails
                    createdAt = LocalDateTime.now();
                    updatedAt = LocalDateTime.now();
                }
            }

            return new Product(id, name, price, quantity, category, createdAt, updatedAt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in CSV: " + e.getMessage());
        }
    }

    /**
     * Compare products by ID for natural ordering
     */
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', price=%.2f, quantity=%d, category='%s'}", id, name, price, quantity, category);
    }
}