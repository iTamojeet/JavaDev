# Advanced Product Management System

A comprehensive console-based inventory management system built in Core Java using arrays for data storage, with advanced features like sorting, filtering, and persistent file storage.

## 🚀 Features

### Core Operations

- **Add Product**: Create new products with validation
- **View Products**: Display all products in formatted table
- **Search Product**: Find products by ID
- **Update Product**: Modify existing product details
- **Delete Product**: Remove products with confirmation

### Advanced Features

- **Sort by Price**: Arrange products in ascending price order
- **Sort by Name**: Alphabetical sorting (case-insensitive)
- **Filter by Category**: Display products from specific categories
- **File Persistence**: Auto-save/load data from `products.txt`

### Data Validation

- Duplicate ID prevention
- Negative price/quantity validation
- Input sanitization and error handling

## 🏗️ System Architecture

### UML Class Diagram

```
+-------------------------------+
|           Product             |
+-------------------------------+
| - id: int                     |
| - name: String                |
| - price: double               |
| - quantity: int               |
| - category: String            |
+-------------------------------+
| + display(): void             |
| + toFileString(): String      |
| + fromFileString(String):     |
|   static Product              |
+-------------------------------+

+----------------------------------------------+
|    AdvancedProductManagementSystem           |
+----------------------------------------------+
| - products: Product[100]                     |
| - count: int                                 |
| - FILE_NAME: String                          |
+----------------------------------------------+
| + addProduct(): void                         |
| + viewProducts(): void                       |
| + searchProduct(): void                      |
| + updateProduct(): void                      |
| + deleteProduct(): void                      |
| + sortByPrice(): void                        |
| + sortByName(): void                         |
| + filterByCategory(): void                   |
| + saveToFile(): void                         |
| + loadFromFile(): void                       |
+----------------------------------------------+
```

## 📋 Requirements

- **Java Version**: Java 8 or higher
- **Memory**: Fixed-size array (max 100 products)
- **Storage**: Text file persistence (CSV format)
- **Dependencies**: Core Java only (no external libraries)

## 🚀 Getting Started

### Compilation

```bash
javac Product.java
javac AdvancedProductManagementSystem.java
```

### Execution

```bash
java AdvancedProductManagementSystem
```

## 📖 Usage Guide

### Menu Navigation

```
=== Advanced Product Management System ===
1. Add Product
2. View All Products
3. Search Product by ID
4. Update Product
5. Delete Product
6. Sort Products by Price
7. Sort Products by Name
8. Filter Products by Category
9. Save & Exit
```

### Sample Operations

#### Adding a Product

```
Enter Product ID: 101
Enter Product Name: Gaming Laptop
Enter Price: 75000.50
Enter Quantity: 5
Enter Category: Electronics
Product added successfully!
```

#### Viewing Products

```
===========================================================================
ID         Name            Price      Quantity   Category
===========================================================================
101        Gaming Laptop   75000.50   5          Electronics
102        T-Shirt         599.99     20         Clothing
103        Rice Bag        850.00     100        Grocery
===========================================================================
Total products: 3
```

#### Filtering by Category

```
Enter Category to filter: Electronics

Filtered products for category: Electronics
===========================================================================
ID         Name            Price      Quantity   Category
===========================================================================
101        Gaming Laptop   75000.50   5          Electronics
104        Smartphone      25000.00   15         Electronics
===========================================================================
```

## 📁 File Structure

```
project/
├── Product.java                           # Product class definition
├── AdvancedProductManagementSystem.java   # Main system class
├── products.txt                          # Data persistence file (auto-generated)
└── README.md                             # Documentation
```

## 💾 Data Persistence

### File Format

Products are stored in `products.txt` using CSV format:

```
101,Gaming Laptop,75000.5,5,Electronics
102,T-Shirt,599.99,20,Clothing
103,Rice Bag,850.0,100,Grocery
```

### Auto-Save Features

- Data automatically loads on application startup
- Data saves when exiting through option 9
- Manual save available through exit option

## 🧪 Test Cases

| Test Case | Action              | Input                                                          | Expected Output                  |
| --------- | ------------------- | -------------------------------------------------------------- | -------------------------------- |
| TC001     | Add Product         | ID: 101, Name: Laptop, Price: 55000, Qty: 10, Cat: Electronics | "Product added successfully!"    |
| TC002     | View Products       | -                                                              | Table showing product 101        |
| TC003     | Search Product      | ID: 101                                                        | Product found and displayed      |
| TC004     | Update Product      | ID: 101, New Name: Gaming Laptop, Price: 60000                 | "Product updated successfully!"  |
| TC005     | Delete Product      | ID: 101                                                        | "Product deleted successfully!"  |
| TC006     | Delete Non-existent | ID: 101                                                        | "Product with ID 101 not found!" |
| TC007     | Sort by Price       | -                                                              | Products arranged by price       |
| TC008     | Sort by Name        | -                                                              | Products arranged alphabetically |
| TC009     | Filter by Category  | Category: Electronics                                          | Only electronics products shown  |
| TC010     | Persistence Test    | Exit and restart                                               | Previously saved data loaded     |

## ⚠️ Limitations & Constraints

- **Maximum Capacity**: 100 products only
- **Data Structure**: Arrays only (no Collections framework)
- **File Format**: Simple CSV (no complex data types)
- **Concurrency**: Single-threaded application
- **UI**: Console-based interface only

## 🔧 Error Handling

- **Input Validation**: Prevents negative prices/quantities
- **Duplicate Prevention**: Checks for existing product IDs
- **File Operations**: Graceful handling of I/O exceptions
- **Array Bounds**: Prevents overflow beyond 100 products
- **Data Parsing**: Safe parsing with exception handling

## 🎯 Future Enhancements

- [ ] GUI interface using Swing/JavaFX
- [ ] Database integration (MySQL/PostgreSQL)
- [ ] Category management system
- [ ] Inventory alerts for low stock
- [ ] Sales tracking and reporting
- [ ] Multi-user support with authentication
- [ ] Advanced search filters (price range, etc.)
- [ ] Export to Excel/PDF formats

## 📝 Sample Data

For testing purposes, you can add these sample products:

```
ID: 101, Name: Gaming Laptop, Price: 75000, Quantity: 5, Category: Electronics
ID: 102, Name: Wireless Mouse, Price: 1200, Quantity: 25, Category: Electronics
ID: 103, Name: Cotton T-Shirt, Price: 599, Quantity: 50, Category: Clothing
ID: 104, Name: Jeans, Price: 2499, Quantity: 30, Category: Clothing
ID: 105, Name: Rice Bag 5kg, Price: 450, Quantity: 100, Category: Grocery
ID: 106, Name: Java Programming Book, Price: 899, Quantity: 15, Category: Books
```

## 👥 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit changes (`git commit -am 'Add new feature'`)
4. Push to branch (`git push origin feature/new-feature`)
5. Create Pull Request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 📞 Support

For questions or issues, please:

- Create an issue in the repository
- Contact the development team
- Refer to Java documentation for core concepts

---

**Made with ❤️ using Core Java**
