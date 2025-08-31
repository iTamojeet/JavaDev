# InvenTrack v2.0 - Advanced Inventory Management System

<div align="center">

![Java](https://img.shields.io/badge/Java-11+-orange.svg)
![Version](https://img.shields.io/badge/Version-2.0-blue.svg)
![License](https://img.shields.io/badge/License-MIT-green.svg)
![Platform](https://img.shields.io/badge/Platform-Cross--Platform-lightgrey.svg)
![Console](https://img.shields.io/badge/Interface-Console-red.svg)

_A sophisticated command-line inventory management system built with advanced Java programming techniques_

[Features](#-features) • [Installation](#-installation) • [Usage](#-usage) • [Architecture](#-architecture) • [Contributing](#-contributing)

</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Quick Start](#-quick-start)
- [Usage Guide](#-usage-guide)
- [System Architecture](#-system-architecture)
- [Technical Details](#-technical-details)
- [Troubleshooting](#-troubleshooting)
- [Contributing](#-contributing)
- [License](#-license)

---

## 🎯 Overview

**InvenTrack v2.0** is a comprehensive command-line inventory management system that demonstrates advanced Java programming concepts. Built with enterprise-level practices, it showcases object-oriented design, functional programming with Java 8+ streams, robust error handling, and a rich console user interface.

### Key Highlights

- **11 Core Operations**: Complete CRUD functionality with advanced features
- **Rich Console UI**: ANSI color-coded interface with formatted tables
- **Advanced Search & Filtering**: Multi-criteria search with real-time filtering
- **Data Analytics**: Comprehensive inventory statistics and reporting
- **Bulk Operations**: Mass updates and batch processing capabilities
- **CSV Persistence**: Automatic data serialization and file management

---

## 🚀 Features

### Core Operations
- ✅ **Add Products**: Create new inventory items with validation
- ✅ **View All Products**: Browse complete inventory with status indicators
- ✅ **Search Products**: Find items by ID, name, price range, or category
- ✅ **Update Products**: Modify existing product details
- ✅ **Delete Products**: Remove items with confirmation

### Advanced Features
- 🔍 **Advanced Sorting**: Sort by any attribute (ID, name, price, quantity, category)
- 🎯 **Smart Filtering**: Filter by stock status, price range, and categories
- 📊 **Bulk Operations**: Mass updates, price modifications, and category management
- 📈 **Statistics & Analytics**: Real-time inventory insights and reporting
- 💾 **Data Persistence**: Automatic CSV file storage and loading

### Technical Features
- 🎨 **Rich Console UI**: ANSI colors, formatted tables, and visual feedback
- ⚡ **Performance Optimized**: HashMap indexing for O(1) category lookups
- 🛡️ **Robust Validation**: Comprehensive input validation and error handling
- 📅 **Timestamp Tracking**: Creation and modification timestamps
- 🔄 **Backward Compatibility**: Supports both v1.0 and v2.0 file formats

---

## 📋 Prerequisites

- **Java Development Kit (JDK)**: Version 11 or higher
- **Operating System**: Windows, macOS, or Linux
- **Terminal**: ANSI color support recommended for optimal experience
- **Memory**: Minimum 512 MB RAM
- **Storage**: 50 MB available disk space

---

## 🛠️ Installation

### Method 1: Direct Compilation

```bash
# Navigate to project directory
cd CoreJava/InvenTrack\ v2.0/

# Compile all Java files
javac *.java

# Run the application
java InvenTrackSystem
```

### Method 2: IDE Setup

1. Import the project into your Java IDE (IntelliJ IDEA, Eclipse, VS Code)
2. Ensure JDK 11+ is configured
3. Add all `.java` files to your project
4. Run `InvenTrackSystem.main()` method

### Method 3: JAR Creation

```bash
# Compile and create JAR file
javac *.java
jar cfe InvenTrack.jar InvenTrackSystem *.class

# Run JAR file
java -jar InvenTrack.jar
```

---

## 🚀 Quick Start

### First Launch

1. **Start the Application**: Run `java InvenTrackSystem`
2. **Welcome Screen**: Watch the animated loading sequence
3. **Main Menu**: Choose from 11 different operations

### Sample Workflow

```
1. Add New Product → Enter details → Confirmation
2. View All Products → Browse inventory → Status indicators
3. Search Products → Choose criteria → Review results
4. Update Product → Select by ID → Modify fields → Save
5. Delete Product → Select by ID → Confirm → Remove
```

### Sample Data Entry

```
Product ID: 1001
Name: Wireless Bluetooth Headphones
Price: 149.99
Quantity: 25
Category: Electronics
```

---

## 📖 Usage Guide

### Product Management

#### Adding Products
- **ID Validation**: Ensures unique product identifiers
- **Name Validation**: Prevents empty or null product names
- **Price Validation**: Enforces non-negative pricing
- **Quantity Validation**: Ensures non-negative stock levels
- **Category Validation**: Validates against predefined categories

#### Search Capabilities
- **ID Search**: Direct lookup by product identifier
- **Name Search**: Partial matching with case-insensitive comparison
- **Price Range**: Filter products within specified price bounds
- **Category Search**: Find all products in a specific category

#### Advanced Operations
- **Sorting**: Sort by ID, name, price, quantity, or category (ascending/descending)
- **Filtering**: Filter by stock status (In Stock, Low Stock, Out of Stock)
- **Bulk Operations**: Mass updates, price modifications, category management
- **Statistics**: View inventory analytics and financial summaries

### Data Analytics

The system provides comprehensive analytics including:
- **Inventory Valuation**: Total monetary value of all products
- **Category Distribution**: Product count and value by category
- **Stock Status Analysis**: Distribution across stock levels
- **Top Products**: Highest-value and best-stocked items

---

## 🏗️ System Architecture

### Design Pattern: MVC (Model-View-Controller)

```
Model (Product.java)
├── Data representation and validation
├── Business logic and comparison
└── Display formatting methods

View (Console Interface)
├── User interaction and input handling
├── ANSI color formatting and display
└── Menu navigation system

Controller (InvenTrackSystem.java)
├── Application flow and menu management
├── Business logic coordination
└── File I/O operations
```

### Data Structures

```java
// Core collections
private static List<Product> products = new ArrayList<>();
private static Map<String, List<Product>> categoryIndex = new HashMap<>();

// Product categories
public static final String[] VALID_CATEGORIES = {
    "Electronics", "Clothing", "Grocery", "Books", "Sports", 
    "Home & Garden", "Beauty", "Automotive", "Others"
};
```

### File Format

```csv
ID,Name,Price,Quantity,Category,CreatedAt,UpdatedAt
1001,Wireless Headphones,149.99,25,Electronics,2024-01-15 10:30:00,2024-01-15 10:30:00
```

---

## 🔧 Technical Details

### Java Programming Concepts

#### Object-Oriented Programming
```java
// Encapsulation with private fields and public accessors
private int id;
private String name;
private double price;

// Interface implementation for natural ordering
public class Product implements Comparable<Product>

// Method overriding for custom behavior
@Override
public int compareTo(Product other) {
    return Integer.compare(this.id, other.id);
}
```

#### Functional Programming (Java 8+)
```java
// Stream API with lambda expressions
products.stream()
    .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
    .sorted(Comparator.comparingDouble(Product::getPrice))
    .collect(Collectors.toList());

// Method references for cleaner code
products.sort(Comparator.comparingInt(Product::getId));
```

#### Collections Framework
```java
// Generic collections with type safety
private static List<Product> products = new ArrayList<>();
private static Map<String, List<Product>> categoryIndex = new HashMap<>();

// Advanced collection operations
Map<String, Long> stockStats = products.stream()
    .collect(Collectors.groupingBy(Product::getStockStatus, Collectors.counting()));
```

### Performance Optimizations

- **HashMap Indexing**: O(1) category-based lookups
- **Stream Processing**: Lazy evaluation for large datasets
- **Memory Management**: Try-with-resources for automatic cleanup
- **Efficient Sorting**: Built-in Comparator implementations

### Error Handling

```java
try {
    // Risky operation
} catch (InputMismatchException e) {
    UIConstants.printError("Invalid input format!");
    scanner.nextLine(); // Clear invalid input
} catch (IOException e) {
    UIConstants.printError("File operation failed: " + e.getMessage());
}
```

---

## 🔧 Troubleshooting

### Common Issues

#### Color Display Issues
```bash
# Terminal doesn't support ANSI colors
# Solution: Use terminal with ANSI support or disable colors in code
```

#### Memory Issues
```bash
# Increase JVM heap size
java -Xmx512m InvenTrackSystem
```

#### Compilation Errors
```bash
# Verify JDK version
java -version
javac -version
# Should be 11 or higher
```

#### File Permission Errors
```bash
# Ensure write permissions in application directory
chmod 755 /path/to/inventtrack/
```

---

## 🤝 Contributing

### Getting Started

1. **Fork the Repository**: Create your own copy
2. **Create Feature Branch**: `git checkout -b feature/amazing-feature`
3. **Make Changes**: Follow the code style guidelines
4. **Test Your Changes**: Ensure all functionality works
5. **Commit Changes**: `git commit -m 'Add amazing feature'`
6. **Push to Branch**: `git push origin feature/amazing-feature`
7. **Open Pull Request**: Submit for review

### Code Style Guidelines

- **Naming Conventions**: camelCase for variables, PascalCase for classes
- **Method Length**: Keep methods focused and under 30 lines
- **Documentation**: Comprehensive JavaDoc for all public methods
- **Error Handling**: Specific exception types with meaningful messages

### Future Enhancement Ideas

- **Database Integration**: Replace file storage with SQL database
- **REST API**: Web service endpoints for remote access
- **GUI Interface**: JavaFX or Swing graphical interface
- **Reporting**: PDF/Excel report generation
- **Multi-User Support**: Concurrent access with user authentication

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2024 InvenTrack Development Team

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
```

---

<div align="center">

### 🌟 Star this repository if you found it helpful!

[Report Bug](../../issues) • [Request Feature](../../issues) • [Documentation](../../wiki)

**Built with ❤️ using Advanced Java Programming Techniques**

</div>
