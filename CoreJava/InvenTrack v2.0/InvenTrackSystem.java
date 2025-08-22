import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * InvenTrack v2.0 - Advanced Inventory Management System
 * Enhanced with Collections Framework and Rich Console UI
 * 
 * New Features:
 * - Collections framework (ArrayList, HashMap)
 * - Enhanced UI with colors and formatting
 * - Advanced search and filtering
 * - Statistics and analytics
 * - Bulk operations
 * - Data validation and error handling
 */
public class InvenTrackSystem {
    // Core data structures
    private static List<Product> products = new ArrayList<>();
    private static Map<String, List<Product>> categoryIndex = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "inventrackv2_products.txt";
    private static final String VERSION = "2.0";

    public static void main(String[] args) {
        displayWelcome();
        loadFromFile();

        int choice;
        do {
            displayMainMenu();
            choice = getValidChoice(1, 11);

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewAllProducts();
                case 3 -> searchProducts();
                case 4 -> updateProduct();
                case 5 -> deleteProduct();
                case 6 -> sortingMenu();
                case 7 -> filteringMenu();
                case 8 -> bulkOperations();
                case 9 -> showStatistics();
                case 10 -> showSystemInfo();
                case 11 -> exitSystem();
            }
        } while (choice != 11);
    }

    /**
     * Display welcome screen
     */
    private static void displayWelcome() {
        UIConstants.clearScreen();
        UIConstants.printHeader("INVENTTRACK v" + VERSION + " - ADVANCED INVENTORY MANAGEMENT");
        UIConstants.printInfo("Loading system components...");

        // Simulate loading animation
        String[] loadingSteps = { "Initializing data structures", "Loading UI components", "Preparing file system",
                "Ready!" };
        for (String step : loadingSteps) {
            System.out.print(UIConstants.CYAN + UIConstants.ARROW_RIGHT + " " + step + UIConstants.RESET);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
            UIConstants.printSuccess(" ✓");
        }

        UIConstants.waitForEnter();
    }

    /**
     * Display main menu with enhanced formatting
     */
    private static void displayMainMenu() {
        UIConstants.clearScreen();
        UIConstants.printHeader("MAIN MENU");

        System.out.println(UIConstants.CYAN
                + "┌─────────────────────────────────────────────────────────────────────────────────────┐"
                + UIConstants.RESET);
        System.out.println(UIConstants.CYAN + "│" + UIConstants.RESET + UIConstants.BOLD + "  CORE OPERATIONS"
                + UIConstants.RESET + " ".repeat(70) + UIConstants.CYAN + "│" + UIConstants.RESET);
        System.out.println(UIConstants.CYAN
                + "├─────────────────────────────────────────────────────────────────────────────────────┤"
                + UIConstants.RESET);
        System.out.printf(
                UIConstants.CYAN + "│" + UIConstants.RESET + "  %s1.%s Add New Product        %s6.%s Advanced Sorting"
                        + " ".repeat(35) + UIConstants.CYAN + "│" + UIConstants.RESET + "\n",
                UIConstants.GREEN, UIConstants.RESET, UIConstants.GREEN, UIConstants.RESET);
        System.out.printf(
                UIConstants.CYAN + "│" + UIConstants.RESET + "  %s2.%s View All Products      %s7.%s Smart Filtering"
                        + " ".repeat(35) + UIConstants.CYAN + "│" + UIConstants.RESET + "\n",
                UIConstants.GREEN, UIConstants.RESET, UIConstants.GREEN, UIConstants.RESET);
        System.out.printf(
                UIConstants.CYAN + "│" + UIConstants.RESET + "  %s3.%s Search Products        %s8.%s Bulk Operations"
                        + " ".repeat(35) + UIConstants.CYAN + "│" + UIConstants.RESET + "\n",
                UIConstants.GREEN, UIConstants.RESET, UIConstants.GREEN, UIConstants.RESET);
        System.out.printf(
                UIConstants.CYAN + "│" + UIConstants.RESET + "  %s4.%s Update Product         %s9.%s Show Statistics"
                        + " ".repeat(34) + UIConstants.CYAN + "│" + UIConstants.RESET + "\n",
                UIConstants.GREEN, UIConstants.RESET, UIConstants.GREEN, UIConstants.RESET);
        System.out.printf(
                UIConstants.CYAN + "│" + UIConstants.RESET
                        + "  %s5.%s Delete Product         %s10.%s System Information" + " ".repeat(30)
                        + UIConstants.CYAN + "│" + UIConstants.RESET + "\n",
                UIConstants.GREEN, UIConstants.RESET, UIConstants.GREEN, UIConstants.RESET);
        System.out.println(UIConstants.CYAN
                + "├─────────────────────────────────────────────────────────────────────────────────────┤"
                + UIConstants.RESET);
        System.out.printf(
                UIConstants.CYAN + "│" + UIConstants.RESET + "  %s11.%s Save & Exit" + " ".repeat(68) + UIConstants.CYAN
                        + "│" + UIConstants.RESET + "\n",
                UIConstants.RED, UIConstants.RESET);
        System.out.println(UIConstants.CYAN
                + "└─────────────────────────────────────────────────────────────────────────────────────┘"
                + UIConstants.RESET);

        System.out.printf("\n%sTotal Products: %s%d%s | %sCategories: %s%d%s\n",
                UIConstants.YELLOW, UIConstants.BOLD, products.size(), UIConstants.RESET,
                UIConstants.YELLOW, UIConstants.BOLD, categoryIndex.size(), UIConstants.RESET);

        System.out.print(UIConstants.BOLD + "\nEnter your choice (1-11): " + UIConstants.RESET);
    }

    /**
     * Add new product with enhanced validation
     */
    private static void addProduct() {
        UIConstants.printHeader("ADD NEW PRODUCT");

        try {
            // Get and validate ID
            System.out.print("Enter Product ID: ");
            int id = scanner.nextInt();

            if (findProductById(id) != null) {
                UIConstants.printError("Product ID " + id + " already exists!");
                UIConstants.waitForEnter();
                return;
            }

            scanner.nextLine(); // consume newline

            // Get product details
            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                UIConstants.printError("Product name cannot be empty!");
                UIConstants.waitForEnter();
                return;
            }

            System.out.print("Enter Price ($): ");
            double price = scanner.nextDouble();
            if (price < 0) {
                UIConstants.printError("Price cannot be negative!");
                UIConstants.waitForEnter();
                return;
            }

            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            if (quantity < 0) {
                UIConstants.printError("Quantity cannot be negative!");
                UIConstants.waitForEnter();
                return;
            }

            scanner.nextLine(); // consume newline

            // Display category options
            System.out.println("\nAvailable Categories:");
            for (int i = 0; i < Product.VALID_CATEGORIES.length; i++) {
                System.out.printf("%d. %s  ", i + 1, Product.VALID_CATEGORIES[i]);
                if ((i + 1) % 3 == 0)
                    System.out.println();
            }
            System.out.println();

            System.out.print("Enter Category: ");
            String category = scanner.nextLine().trim();

            // Create and add product
            Product product = new Product(id, name, price, quantity, category);
            products.add(product);
            updateCategoryIndex(product);

            UIConstants.printSuccess("Product added successfully!");
            System.out.println("\nProduct Details:");
            product.displayDetailed();

        } catch (InputMismatchException e) {
            UIConstants.printError("Invalid input format!");
            scanner.nextLine(); // clear invalid input
        }

        UIConstants.waitForEnter();
    }

    /**
     * View all products with enhanced formatting
     */
    private static void viewAllProducts() {
        UIConstants.printHeader("ALL PRODUCTS");

        if (products.isEmpty()) {
            UIConstants.printWarning("No products found in inventory!");
            UIConstants.waitForEnter();
            return;
        }

        // Display summary statistics
        System.out.printf("%sInventory Summary:%s\n", UIConstants.BOLD, UIConstants.RESET);
        System.out.printf("Total Products: %s%d%s | Total Value: %s$%.2f%s | Categories: %s%d%s\n\n",
                UIConstants.GREEN, products.size(), UIConstants.RESET,
                UIConstants.GREEN, getTotalInventoryValue(), UIConstants.RESET,
                UIConstants.GREEN, categoryIndex.size(), UIConstants.RESET);

        // Table header
        System.out.println(UIConstants.CYAN + UIConstants.TABLE_BORDER + UIConstants.RESET);
        System.out.printf("%s%-8s %-20s %-12s %-8s %-15s %-12s%s\n",
                UIConstants.BOLD + UIConstants.CYAN,
                "ID", "NAME", "PRICE ($)", "QTY", "CATEGORY", "STOCK STATUS",
                UIConstants.RESET);
        System.out.println(UIConstants.CYAN + UIConstants.TABLE_BORDER + UIConstants.RESET);

        // Display products
        for (Product product : products) {
            product.display();
        }

        System.out.println(UIConstants.CYAN + UIConstants.TABLE_BORDER + UIConstants.RESET);

        // Stock status legend
        System.out.println("\n" + UIConstants.BOLD + "Stock Status Legend:" + UIConstants.RESET);
        System.out.println(UIConstants.RED + "● OUT OF STOCK (0)" + UIConstants.RESET + " | " +
                UIConstants.YELLOW + "● LOW STOCK (1-5)" + UIConstants.RESET + " | " +
                UIConstants.CYAN + "● MEDIUM STOCK (6-20)" + UIConstants.RESET + " | " +
                UIConstants.GREEN + "● HIGH STOCK (20+)" + UIConstants.RESET);

        UIConstants.waitForEnter();
    }

    /**
     * Enhanced search functionality
     */
    private static void searchProducts() {
        UIConstants.printHeader("SEARCH PRODUCTS");

        if (products.isEmpty()) {
            UIConstants.printWarning("No products available to search!");
            UIConstants.waitForEnter();
            return;
        }

        System.out.println("Search Options:");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Price Range");
        System.out.println("4. Advanced Search");

        int choice = getValidChoice(1, 4);
        List<Product> results = new ArrayList<>();

        switch (choice) {
            case 1 -> results = searchById();
            case 2 -> results = searchByName();
            case 3 -> results = searchByPriceRange();
            case 4 -> results = advancedSearch();
        }

        displaySearchResults(results);
        UIConstants.waitForEnter();
    }

    /**
     * Search by ID
     */
    private static List<Product> searchById() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        Product product = findProductById(id);
        return product != null ? Arrays.asList(product) : new ArrayList<>();
    }

    /**
     * Search by name (partial matching)
     */
    private static List<Product> searchByName() {
        scanner.nextLine(); // consume newline
        System.out.print("Enter product name (partial matching): ");
        String name = scanner.nextLine().toLowerCase();

        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name))
                .collect(Collectors.toList());
    }

    /**
     * Search by price range
     */
    private static List<Product> searchByPriceRange() {
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        return products.stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    /**
     * Advanced search with multiple criteria
     */
    private static List<Product> advancedSearch() {
        scanner.nextLine(); // consume newline
        System.out.print("Enter category (or press Enter to skip): ");
        String category = scanner.nextLine().trim();

        System.out.print("Enter minimum quantity (or -1 to skip): ");
        int minQty = scanner.nextInt();

        System.out.print("Enter maximum price (or -1 to skip): ");
        double maxPrice = scanner.nextDouble();

        return products.stream()
                .filter(p -> category.isEmpty() || p.getCategory().equalsIgnoreCase(category))
                .filter(p -> minQty == -1 || p.getQuantity() >= minQty)
                .filter(p -> maxPrice == -1 || p.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    /**
     * Display search results
     */
    private static void displaySearchResults(List<Product> results) {
        if (results.isEmpty()) {
            UIConstants.printWarning("No products found matching your criteria!");
            return;
        }

        UIConstants.printSuccess("Found " + results.size() + " product(s):");
        UIConstants.printSeparator();

        System.out.printf("%-8s %-20s %-12s %-8s %-15s %-12s\n",
                "ID", "NAME", "PRICE ($)", "QTY", "CATEGORY", "STOCK STATUS");
        UIConstants.printSeparator();

        for (Product product : results) {
            product.display();
        }
    }

    /**
     * Update product with enhanced interface
     */
    private static void updateProduct() {
        UIConstants.printHeader("UPDATE PRODUCT");

        if (products.isEmpty()) {
            UIConstants.printWarning("No products available to update!");
            UIConstants.waitForEnter();
            return;
        }

        System.out.print("Enter Product ID to update: ");
        int id = scanner.nextInt();

        Product product = findProductById(id);
        if (product == null) {
            UIConstants.printError("Product with ID " + id + " not found!");
            UIConstants.waitForEnter();
            return;
        }

        System.out.println("\nCurrent Product Details:");
        product.displayDetailed();

        scanner.nextLine(); // consume newline

        // Update fields
        System.out.print("Enter new name (press Enter to keep current): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            product.setName(newName);
        }

        System.out.print("Enter new price (press -1 to keep current): ");
        double newPrice = scanner.nextDouble();
        if (newPrice >= 0) {
            product.setPrice(newPrice);
        }

        System.out.print("Enter new quantity (press -1 to keep current): ");
        int newQuantity = scanner.nextInt();
        if (newQuantity >= 0) {
            product.setQuantity(newQuantity);
        }

        scanner.nextLine(); // consume newline
        System.out.print("Enter new category (press Enter to keep current): ");
        String newCategory = scanner.nextLine().trim();
        if (!newCategory.isEmpty()) {
            removeCategoryIndex(product);
            product.setCategory(newCategory);
            updateCategoryIndex(product);
        }

        UIConstants.printSuccess("Product updated successfully!");
        System.out.println("\nUpdated Product Details:");
        product.displayDetailed();

        UIConstants.waitForEnter();
    }

    /**
     * Delete product with confirmation
     */
    private static void deleteProduct() {
        UIConstants.printHeader("DELETE PRODUCT");

        if (products.isEmpty()) {
            UIConstants.printWarning("No products available to delete!");
            UIConstants.waitForEnter();
            return;
        }

        System.out.print("Enter Product ID to delete: ");
        int id = scanner.nextInt();

        Product product = findProductById(id);
        if (product == null) {
            UIConstants.printError("Product with ID " + id + " not found!");
            UIConstants.waitForEnter();
            return;
        }

        System.out.println("\nProduct to be deleted:");
        product.displayDetailed();

        scanner.nextLine(); // consume newline
        System.out.print(
                UIConstants.YELLOW + "Are you sure you want to delete this product? (yes/no): " + UIConstants.RESET);
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("yes") || confirm.equals("y")) {
            products.remove(product);
            removeCategoryIndex(product);
            UIConstants.printSuccess("Product deleted successfully!");
        } else {
            UIConstants.printInfo("Delete operation cancelled.");
        }

        UIConstants.waitForEnter();
    }

    /**
     * Sorting menu with multiple options
     */
    private static void sortingMenu() {
        UIConstants.printHeader("SORTING OPTIONS");

        if (products.isEmpty()) {
            UIConstants.printWarning("No products available to sort!");
            UIConstants.waitForEnter();
            return;
        }

        System.out.println("Sort by:");
        System.out.println("1. ID (Ascending)");
        System.out.println("2. ID (Descending)");
        System.out.println("3. Name (A-Z)");
        System.out.println("4. Name (Z-A)");
        System.out.println("5. Price (Low to High)");
        System.out.println("6. Price (High to Low)");
        System.out.println("7. Quantity (Low to High)");
        System.out.println("8. Quantity (High to Low)");
        System.out.println("9. Category");
        System.out.println("10. Stock Status");

        int choice = getValidChoice(1, 10);

        switch (choice) {
            case 1 -> products.sort(Comparator.comparingInt(Product::getId));
            case 2 -> products.sort(Comparator.comparingInt(Product::getId).reversed());
            case 3 -> products.sort(Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER));
            case 4 -> products.sort(Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER).reversed());
            case 5 -> products.sort(Comparator.comparingDouble(Product::getPrice));
            case 6 -> products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
            case 7 -> products.sort(Comparator.comparingInt(Product::getQuantity));
            case 8 -> products.sort(Comparator.comparingInt(Product::getQuantity).reversed());
            case 9 -> products.sort(Comparator.comparing(Product::getCategory, String.CASE_INSENSITIVE_ORDER));
            case 10 -> products.sort(Comparator.comparing(Product::getStockStatus));
        }

        UIConstants.printSuccess("Products sorted successfully!");
        viewAllProducts();
    }

    /**
     * Advanced filtering menu
     */
    private static void filteringMenu() {
        UIConstants.printHeader("FILTERING OPTIONS");

        if (products.isEmpty()) {
            UIConstants.printWarning("No products available to filter!");
            UIConstants.waitForEnter();
            return;
        }

        System.out.println("Filter by:");
        System.out.println("1. Category");
        System.out.println("2. Stock Status");
        System.out.println("3. Price Range");
        System.out.println("4. Low Stock Alert (≤5 items)");
        System.out.println("5. Out of Stock");
        System.out.println("6. High Value Items (>$1000)");

        int choice = getValidChoice(1, 6);
        List<Product> filtered = new ArrayList<>();

        switch (choice) {
            case 1 -> filtered = filterByCategory();
            case 2 -> filtered = filterByStockStatus();
            case 3 -> filtered = filterByPriceRange();
            case 4 -> filtered = filterLowStock();
            case 5 -> filtered = filterOutOfStock();
            case 6 -> filtered = filterHighValue();
        }

        displayFilterResults(filtered);
        UIConstants.waitForEnter();
    }

    /**
     * Filter by category
     */
    private static List<Product> filterByCategory() {
        System.out.println("\nAvailable Categories:");
        Set<String> categories = products.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet());

        int index = 1;
        Map<Integer, String> categoryMap = new HashMap<>();
        for (String category : categories) {
            System.out.println(index + ". " + category);
            categoryMap.put(index++, category);
        }

        System.out.print("Select category number: ");
        int catChoice = getValidChoice(1, categories.size());
        String selectedCategory = categoryMap.get(catChoice);

        return products.stream()
                .filter(p -> p.getCategory().equals(selectedCategory))
                .collect(Collectors.toList());
    }

    /**
     * Filter by stock status
     */
    private static List<Product> filterByStockStatus() {
        System.out.println("\nStock Status Options:");
        System.out.println("1. Out of Stock");
        System.out.println("2. Low Stock");
        System.out.println("3. Medium Stock");
        System.out.println("4. High Stock");

        int choice = getValidChoice(1, 4);
        String[] statuses = { "OUT_OF_STOCK", "LOW_STOCK", "MEDIUM_STOCK", "HIGH_STOCK" };
        String selectedStatus = statuses[choice - 1];

        return products.stream()
                .filter(p -> p.getStockStatus().equals(selectedStatus))
                .collect(Collectors.toList());
    }

    /**
     * Filter by price range
     */
    private static List<Product> filterByPriceRange() {
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        return products.stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    /**
     * Filter low stock items
     */
    private static List<Product> filterLowStock() {
        return products.stream()
                .filter(p -> p.getQuantity() <= 5 && p.getQuantity() > 0)
                .collect(Collectors.toList());
    }

    /**
     * Filter out of stock items
     */
    private static List<Product> filterOutOfStock() {
        return products.stream()
                .filter(p -> p.getQuantity() == 0)
                .collect(Collectors.toList());
    }

    /**
     * Filter high value items
     */
    private static List<Product> filterHighValue() {
        return products.stream()
                .filter(p -> p.getPrice() > 1000)
                .collect(Collectors.toList());
    }

    /**
     * Display filter results
     */
    private static void displayFilterResults(List<Product> filtered) {
        if (filtered.isEmpty()) {
            UIConstants.printWarning("No products match the selected filter!");
            return;
        }

        UIConstants.printSuccess("Found " + filtered.size() + " product(s):");
        UIConstants.printSeparator();

        System.out.printf("%-8s %-20s %-12s %-8s %-15s %-12s\n",
                "ID", "NAME", "PRICE ($)", "QTY", "CATEGORY", "STOCK STATUS");
        UIConstants.printSeparator();

        for (Product product : filtered) {
            product.display();
        }
        UIConstants.printSeparator();
    }

    /**
     * Bulk operations menu
     */
    private static void bulkOperations() {
        UIConstants.printHeader("BULK OPERATIONS");

        if (products.isEmpty()) {
            UIConstants.printWarning("No products available for bulk operations!");
            UIConstants.waitForEnter();
            return;
        }

        System.out.println("Bulk Operations:");
        System.out.println("1. Update prices by category (% increase/decrease)");
        System.out.println("2. Update quantities by category");
        System.out.println("3. Delete products by category");
        System.out.println("4. Apply discount to high-value items");
        System.out.println("5. Restock low inventory items");

        int choice = getValidChoice(1, 5);

        switch (choice) {
            case 1 -> bulkUpdatePrices();
            case 2 -> bulkUpdateQuantities();
            case 3 -> bulkDeleteByCategory();
            case 4 -> applyBulkDiscount();
            case 5 -> restockLowInventory();
        }

        UIConstants.waitForEnter();
    }

    /**
     * Bulk update prices
     */
    private static void bulkUpdatePrices() {
        System.out.println("\nAvailable Categories:");
        Set<String> categories = categoryIndex.keySet();
        categories.forEach(cat -> System.out.println("- " + cat));

        scanner.nextLine(); // consume newline
        System.out.print("Enter category: ");
        String category = scanner.nextLine().trim();

        if (!categories.contains(category)) {
            UIConstants.printError("Category not found!");
            return;
        }

        System.out.print("Enter percentage change (+/-): ");
        double percentage = scanner.nextDouble();

        List<Product> categoryProducts = categoryIndex.get(category);
        int updated = 0;

        for (Product product : categoryProducts) {
            double oldPrice = product.getPrice();
            double newPrice = oldPrice * (1 + percentage / 100);
            product.setPrice(newPrice);
            updated++;
        }

        UIConstants.printSuccess("Updated prices for " + updated + " products in category '" + category + "'");
    }

    /**
     * Bulk update quantities
     */
    private static void bulkUpdateQuantities() {
        System.out.println("\nAvailable Categories:");
        categoryIndex.keySet().forEach(cat -> System.out.println("- " + cat));

        scanner.nextLine(); // consume newline
        System.out.print("Enter category: ");
        String category = scanner.nextLine().trim();

        if (!categoryIndex.containsKey(category)) {
            UIConstants.printError("Category not found!");
            return;
        }

        System.out.print("Enter quantity to add (can be negative): ");
        int quantityChange = scanner.nextInt();

        List<Product> categoryProducts = categoryIndex.get(category);
        int updated = 0;

        for (Product product : categoryProducts) {
            int newQuantity = Math.max(0, product.getQuantity() + quantityChange);
            product.setQuantity(newQuantity);
            updated++;
        }

        UIConstants.printSuccess("Updated quantities for " + updated + " products in category '" + category + "'");
    }

    /**
     * Bulk delete by category
     */
    private static void bulkDeleteByCategory() {
        System.out.println("\nAvailable Categories:");
        categoryIndex.keySet().forEach(cat -> System.out.println("- " + cat));

        scanner.nextLine(); // consume newline
        System.out.print("Enter category to delete: ");
        String category = scanner.nextLine().trim();

        if (!categoryIndex.containsKey(category)) {
            UIConstants.printError("Category not found!");
            return;
        }

        List<Product> categoryProducts = new ArrayList<>(categoryIndex.get(category));

        System.out.print(
                UIConstants.YELLOW + "Delete " + categoryProducts.size() + " products? (yes/no): " + UIConstants.RESET);
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("yes") || confirm.equals("y")) {
            products.removeAll(categoryProducts);
            categoryIndex.remove(category);
            UIConstants
                    .printSuccess("Deleted " + categoryProducts.size() + " products from category '" + category + "'");
        } else {
            UIConstants.printInfo("Bulk delete cancelled.");
        }
    }

    /**
     * Apply bulk discount
     */
    private static void applyBulkDiscount() {
        System.out.print("Enter minimum price for discount eligibility: ");
        double minPrice = scanner.nextDouble();

        System.out.print("Enter discount percentage: ");
        double discount = scanner.nextDouble();

        List<Product> eligibleProducts = products.stream()
                .filter(p -> p.getPrice() >= minPrice)
                .collect(Collectors.toList());

        if (eligibleProducts.isEmpty()) {
            UIConstants.printWarning("No products eligible for discount!");
            return;
        }

        for (Product product : eligibleProducts) {
            double newPrice = product.getPrice() * (1 - discount / 100);
            product.setPrice(newPrice);
        }

        UIConstants.printSuccess("Applied " + discount + "% discount to " + eligibleProducts.size() + " products");
    }

    /**
     * Restock low inventory items
     */
    private static void restockLowInventory() {
        System.out.print("Enter restock quantity: ");
        int restockQty = scanner.nextInt();

        List<Product> lowStockProducts = products.stream()
                .filter(p -> p.getQuantity() <= 5)
                .collect(Collectors.toList());

        if (lowStockProducts.isEmpty()) {
            UIConstants.printInfo("No low stock items found!");
            return;
        }

        for (Product product : lowStockProducts) {
            product.setQuantity(product.getQuantity() + restockQty);
        }

        UIConstants.printSuccess(
                "Restocked " + lowStockProducts.size() + " low inventory items with " + restockQty + " units each");
    }

    /**
     * Show comprehensive statistics
     */
    private static void showStatistics() {
        UIConstants.printHeader("INVENTORY STATISTICS");

        if (products.isEmpty()) {
            UIConstants.printWarning("No products available for statistics!");
            UIConstants.waitForEnter();
            return;
        }

        // Basic statistics
        int totalProducts = products.size();
        double totalValue = getTotalInventoryValue();
        int totalQuantity = products.stream().mapToInt(Product::getQuantity).sum();
        double avgPrice = products.stream().mapToDouble(Product::getPrice).average().orElse(0);

        System.out.printf("%s📊 GENERAL STATISTICS%s\n", UIConstants.BOLD + UIConstants.CYAN, UIConstants.RESET);
        UIConstants.printSeparator();
        System.out.printf("Total Products: %s%d%s\n", UIConstants.GREEN, totalProducts, UIConstants.RESET);
        System.out.printf("Total Inventory Value: %s$%.2f%s\n", UIConstants.GREEN, totalValue, UIConstants.RESET);
        System.out.printf("Total Units in Stock: %s%d%s\n", UIConstants.GREEN, totalQuantity, UIConstants.RESET);
        System.out.printf("Average Price: %s$%.2f%s\n", UIConstants.GREEN, avgPrice, UIConstants.RESET);

        // Category statistics
        System.out.printf("\n%s📈 CATEGORY BREAKDOWN%s\n", UIConstants.BOLD + UIConstants.CYAN, UIConstants.RESET);
        UIConstants.printSeparator();
        for (Map.Entry<String, List<Product>> entry : categoryIndex.entrySet()) {
            String category = entry.getKey();
            List<Product> categoryProducts = entry.getValue();
            double categoryValue = categoryProducts.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();

            System.out.printf("%-15s: %s%2d products%s | %sValue: $%.2f%s\n",
                    category,
                    UIConstants.YELLOW, categoryProducts.size(), UIConstants.RESET,
                    UIConstants.GREEN, categoryValue, UIConstants.RESET);
        }

        // Stock status statistics
        System.out.printf("\n%s⚠️ STOCK STATUS%s\n", UIConstants.BOLD + UIConstants.CYAN, UIConstants.RESET);
        UIConstants.printSeparator();

        Map<String, Long> stockStats = products.stream()
                .collect(Collectors.groupingBy(Product::getStockStatus, Collectors.counting()));

        stockStats.forEach((status, count) -> {
            String color = getStockStatusDisplayColor(status);
            System.out.printf("%-15s: %s%d products%s\n",
                    status.replace("_", " "),
                    color, count, UIConstants.RESET);
        });

        // Top products
        System.out.printf("\n%s🏆 TOP PRODUCTS%s\n", UIConstants.BOLD + UIConstants.CYAN, UIConstants.RESET);
        UIConstants.printSeparator();

        System.out.println(UIConstants.BOLD + "Most Expensive:" + UIConstants.RESET);
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(3)
                .forEach(p -> System.out.printf("  %s%s%s - $%.2f\n", UIConstants.GREEN, p.getName(), UIConstants.RESET,
                        p.getPrice()));

        System.out.println(UIConstants.BOLD + "\nHighest Stock:" + UIConstants.RESET);
        products.stream()
                .sorted(Comparator.comparingInt(Product::getQuantity).reversed())
                .limit(3)
                .forEach(p -> System.out.printf("  %s%s%s - %d units\n", UIConstants.CYAN, p.getName(),
                        UIConstants.RESET, p.getQuantity()));

        UIConstants.waitForEnter();
    }

    /**
     * Show system information
     */
    private static void showSystemInfo() {
        UIConstants.printHeader("SYSTEM INFORMATION");

        System.out.printf("%s🚀 InvenTrack v%s%s\n", UIConstants.BOLD + UIConstants.CYAN, VERSION, UIConstants.RESET);
        System.out.println("Advanced Inventory Management System");

        System.out.printf("\n%sSystem Features:%s\n", UIConstants.BOLD, UIConstants.RESET);
        System.out.println("✅ Collections Framework (ArrayList, HashMap)");
        System.out.println("✅ Rich Console UI with Colors");
        System.out.println("✅ Advanced Search & Filtering");
        System.out.println("✅ Bulk Operations");
        System.out.println("✅ Real-time Statistics");
        System.out.println("✅ Data Persistence");
        System.out.println("✅ Input Validation");

        System.out.printf("\n%sFile Information:%s\n", UIConstants.BOLD, UIConstants.RESET);
        System.out.printf("Data File: %s%s%s\n", UIConstants.CYAN, FILE_NAME, UIConstants.RESET);

        File dataFile = new File(FILE_NAME);
        if (dataFile.exists()) {
            System.out.printf("File Size: %s%.2f KB%s\n", UIConstants.GREEN, dataFile.length() / 1024.0,
                    UIConstants.RESET);
            System.out.printf("Last Modified: %s%s%s\n", UIConstants.GREEN, new Date(dataFile.lastModified()),
                    UIConstants.RESET);
        } else {
            System.out
                    .println(UIConstants.YELLOW + "Data file not found (will be created on save)" + UIConstants.RESET);
        }

        System.out.printf("\n%sRuntime Information:%s\n", UIConstants.BOLD, UIConstants.RESET);
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.printf("Used Memory: %s%.2f MB%s\n", UIConstants.YELLOW, usedMemory / 1024.0 / 1024.0,
                UIConstants.RESET);
        System.out.printf("Free Memory: %s%.2f MB%s\n", UIConstants.GREEN, freeMemory / 1024.0 / 1024.0,
                UIConstants.RESET);
        System.out.printf("Total Memory: %s%.2f MB%s\n", UIConstants.CYAN, totalMemory / 1024.0 / 1024.0,
                UIConstants.RESET);

        UIConstants.waitForEnter();
    }

    /**
     * Exit system with save confirmation
     */
    private static void exitSystem() {
        UIConstants.printHeader("SAVE & EXIT");

        System.out.print("Save data before exiting? (yes/no): ");
        scanner.nextLine(); // consume any remaining newline
        String save = scanner.nextLine().trim().toLowerCase();

        if (save.equals("yes") || save.equals("y") || save.isEmpty()) {
            saveToFile();
        }

        UIConstants.printSuccess("Thank you for using InvenTrack v" + VERSION + "!");
        UIConstants.printInfo("Session ended.");
        System.exit(0);
    }

    // Utility Methods

    /**
     * Get valid choice within range
     */
    private static int getValidChoice(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.printf("Please enter a number between %d and %d: ", min, max);
                }
            } catch (InputMismatchException e) {
                UIConstants.printError("Invalid input! Please enter a number.");
                scanner.nextLine(); // clear invalid input
                System.out.print("Enter choice: ");
            }
        }
    }

    /**
     * Find product by ID
     */
    private static Product findProductById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Update category index
     */
    private static void updateCategoryIndex(Product product) {
        categoryIndex.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
    }

    /**
     * Remove from category index
     */
    private static void removeCategoryIndex(Product product) {
        List<Product> categoryProducts = categoryIndex.get(product.getCategory());
        if (categoryProducts != null) {
            categoryProducts.remove(product);
            if (categoryProducts.isEmpty()) {
                categoryIndex.remove(product.getCategory());
            }
        }
    }

    /**
     * Calculate total inventory value
     */
    private static double getTotalInventoryValue() {
        return products.stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }

    /**
     * Get display color for stock status
     */
    private static String getStockStatusDisplayColor(String status) {
        switch (status) {
            case "OUT_OF_STOCK":
                return UIConstants.RED;
            case "LOW_STOCK":
                return UIConstants.YELLOW;
            case "MEDIUM_STOCK":
                return UIConstants.CYAN;
            case "HIGH_STOCK":
                return UIConstants.GREEN;
            default:
                return UIConstants.RESET;
        }
    }

    /**
     * Save products to file
     */
    private static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product product : products) {
                writer.write(product.toFileString());
                writer.newLine();
            }
            UIConstants.printSuccess("Data saved successfully to " + FILE_NAME);
        } catch (IOException e) {
            UIConstants.printError("Error saving file: " + e.getMessage());
        }
    }

    /**
     * Load products from file
     */
    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            UIConstants.printInfo("No existing data file found. Starting with empty inventory.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int lineNumber = 0;
            int loadedCount = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                if (line.isEmpty())
                    continue;

                try {
                    Product product = Product.fromFileString(line);
                    products.add(product);
                    updateCategoryIndex(product);
                    loadedCount++;
                } catch (Exception e) {
                    System.err.println("Error parsing line " + lineNumber + ": " + line);
                    System.err.println("Reason: " + e.getMessage());
                }
            }

            UIConstants.printSuccess("Successfully loaded " + loadedCount + " products from " + FILE_NAME);
        } catch (IOException e) {
            UIConstants.printError("Error loading file: " + e.getMessage());
        }
    }
}