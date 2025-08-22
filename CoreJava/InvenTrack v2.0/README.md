# InvenTrack v2.0 - Advanced Inventory Management System

<div align="center">

![Java](https://img.shields.io/badge/Java-11+-orange.svg)
![Version](https://img.shields.io/badge/Version-2.0-blue.svg)
![License](https://img.shields.io/badge/License-MIT-green.svg)
![Platform](https://img.shields.io/badge/Platform-Cross--Platform-lightgrey.svg)
![Console](https://img.shields.io/badge/Interface-Console-red.svg)

_A sophisticated, enterprise-grade inventory management system built with advanced Java programming techniques_

[Features](#-features) • [Installation](#-installation) • [Usage](#-usage) • [Architecture](#-architecture) • [API Reference](#-api-reference) • [Contributing](#-contributing)

</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Key Features](#-key-features)
- [Technical Highlights](#-technical-highlights)
- [Prerequisites](#-prerequisites)
- [Installation & Setup](#-installation--setup)
- [Quick Start Guide](#-quick-start-guide)
- [Detailed Usage](#-detailed-usage)
- [System Architecture](#-system-architecture)
- [Code Structure](#-code-structure)
- [Advanced Features](#-advanced-features)
- [Performance & Optimization](#-performance--optimization)
- [File Format Specification](#-file-format-specification)
- [Error Handling](#-error-handling)
- [Troubleshooting](#-troubleshooting)
- [Development Guide](#-development-guide)
- [Contributing](#-contributing)
- [License](#-license)
- [Acknowledgments](#-acknowledgments)

---

## 🎯 Overview

**InvenTrack v2.0** is a comprehensive, command-line inventory management system engineered with enterprise-level Java programming practices. This advanced system demonstrates sophisticated software engineering principles, including object-oriented design patterns, functional programming with Java 8+ streams, comprehensive error handling, and rich console user interfaces.

Built for scalability and maintainability, InvenTrack v2.0 serves as both a practical inventory management solution and a showcase of advanced Java development techniques, making it ideal for educational purposes, small to medium businesses, and developers seeking to understand modern Java application architecture.

### 🎖️ Design Philosophy

- **Clean Architecture**: Separation of concerns with distinct layers for presentation, business logic, and data persistence
- **Functional Programming**: Extensive use of Java 8+ streams, lambda expressions, and method references
- **Type Safety**: Comprehensive use of generics and parameterized types throughout the codebase
- **Error Resilience**: Robust exception handling with graceful degradation and user-friendly error messages
- **User Experience**: Rich console interface with ANSI color coding and intuitive navigation

---

## 🚀 Key Features

### Core Inventory Operations

- ✅ **CRUD Operations**: Complete Create, Read, Update, Delete functionality for products
- ✅ **Advanced Search**: Multi-criteria search with partial matching and range queries
- ✅ **Dynamic Filtering**: Real-time filtering by category, stock status, price range, and custom criteria
- ✅ **Multi-Level Sorting**: Sort by any product attribute with ascending/descending options
- ✅ **Bulk Operations**: Mass updates, deletions, and pricing modifications

### Data Management & Analytics

- 📊 **Real-Time Statistics**: Comprehensive inventory analytics and reporting
- 📈 **Category Analytics**: Detailed breakdown by product categories
- 📉 **Stock Level Monitoring**: Automated low-stock alerts and out-of-stock tracking
- 💰 **Financial Analytics**: Total inventory value, average pricing, and trend analysis
- 🏆 **Top Products Analysis**: Identification of highest-value and best-stocked items

### Advanced Technical Features

- 🔍 **Stream-Based Processing**: Leverages Java 8+ streams for efficient data operations
- 🗂️ **HashMap Indexing**: Category-based indexing for O(1) lookup performance
- 💾 **CSV Persistence**: Robust file I/O with automatic serialization/deserialization
- 🎨 **Rich Console UI**: ANSI color-coded interface with formatted tables and visual feedback
- ⚡ **Memory Optimization**: Efficient memory usage with automatic resource management

---

## 🔧 Technical Highlights

### Java Programming Concepts Demonstrated

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

#### Collections Framework Mastery

```java
// Generic collections with type safety
private static List<Product> products = new ArrayList<>();
private static Map<String, List<Product>> categoryIndex = new HashMap<>();

// Advanced collection operations
Map<String, Long> stockStats = products.stream()
    .collect(Collectors.groupingBy(Product::getStockStatus, Collectors.counting()));
```

#### Modern Java Features

- **Switch Expressions**: Clean, lambda-style switch statements
- **Try-with-Resources**: Automatic resource management for file operations
- **Optional Class**: Safe null handling with functional-style operations
- **LocalDateTime API**: Modern date/time handling with formatting
- **String Methods**: Advanced string manipulation and validation

---

## 📋 Prerequisites

### System Requirements

- **Java Development Kit (JDK)**: Version 11 or higher
- **Operating System**: Windows, macOS, or Linux
- **Memory**: Minimum 512 MB RAM
- **Storage**: 50 MB available disk space
- **Terminal**: ANSI color support recommended for optimal UI experience

### Development Environment (Optional)

- **IDE**: IntelliJ IDEA, Eclipse, or VS Code with Java extensions
- **Build Tools**: Maven or Gradle (for future enhancements)
- **Version Control**: Git for source code management

---

## 🛠️ Installation & Setup

### Method 1: Direct Compilation

```bash
# Clone or download the project files
git clone <repository-url>
cd inventtrack-v2

# Compile all Java files
javac *.java

# Run the application
java InvenTrackSystem
```

### Method 2: IDE Setup

1. Import the project into your preferred Java IDE
2. Ensure JDK 11+ is configured
3. Add all `.java` files to your project
4. Run `InvenTrackSystem.main()` method

### Method 3: JAR Creation (Advanced)

```bash
# Compile and create JAR file
javac *.java
jar cfe InvenTrack.jar InvenTrackSystem *.class

# Run JAR file
java -jar InvenTrack.jar
```

---

## 🚀 Quick Start Guide

### First Launch

1. **Start the Application**: Run `java InvenTrackSystem`
2. **Welcome Screen**: Navigate through the animated loading sequence
3. **Main Menu**: Choose from 11 different operations

### Basic Operations Workflow

```
1. Add New Product → Enter product details → Confirmation
2. View All Products → Browse inventory → Stock status legend
3. Search Products → Choose search criteria → Review results
4. Update Product → Select by ID → Modify fields → Confirmation
5. Delete Product → Select by ID → Confirmation dialog → Removal
```

### Sample Data Entry

```
Product ID: 1001
Name: Wireless Bluetooth Headphones
Price: $149.99
Quantity: 25
Category: Electronics
```

---

## 📖 Detailed Usage

### Product Management

#### Adding Products

The system validates all input data and provides immediate feedback:

- **ID Validation**: Ensures unique product identifiers
- **Name Validation**: Prevents empty or null product names
- **Price Validation**: Enforces non-negative pricing
- **Quantity Validation**: Ensures non-negative stock levels
- **Category Validation**: Validates against predefined categories

#### Advanced Search Capabilities

1. **ID Search**: Direct lookup by product identifier
2. **Name Search**: Partial matching with case-insensitive comparison
3. **Price Range**: Filter products within specified price bounds
4. **Advanced Search**: Multi-criteria filtering with optional parameters

#### Bulk Operations

- **Price Updates**: Percentage-based price modifications by category
- **Quantity Updates**: Mass stock level adjustments
- **Category Deletion**: Remove entire product categories
- **Discount Application**: Apply discounts to high-value items
- **Inventory Restocking**: Automated low-stock replenishment

### Data Analytics

#### Statistical Analysis

The system provides comprehensive analytics including:

- **Inventory Valuation**: Total monetary value of all products
- **Category Distribution**: Product count and value by category
- **Stock Status Analysis**: Distribution across stock levels
- **Top Products**: Highest-value and best-stocked items

#### Real-Time Monitoring

- **Stock Level Indicators**: Color-coded visual feedback
- **Low Stock Alerts**: Automatic identification of items needing restocking
- **Out of Stock Tracking**: Zero-quantity product monitoring

---

## 🏗️ System Architecture

### Design Patterns Implemented

#### Model-View-Controller (MVC)

```
Model (Product.java)
├── Data representation
├── Business logic
└── Validation rules

View (Console Interface)
├── User interaction
├── Display formatting
└── Input handling

Controller (InvenTrackSystem.java)
├── Application flow
├── User input processing
└── Business logic coordination
```

#### Utility Pattern

```
UIConstants.java
├── ANSI color codes
├── Formatting constants
├── Display helper methods
└── Cross-platform compatibility
```

### Data Flow Architecture

```
User Input → Validation → Business Logic → Data Update → Display → File Persistence
     ↑                                                                      ↓
     └─────────────────── Error Handling ←─────────────────────────────────┘
```

---

## 📁 Code Structure

### Class Hierarchy and Responsibilities

#### `InvenTrackSystem.java` (Main Controller)

- **Core Functionality**: 42+ methods handling all user interactions
- **Menu System**: Hierarchical navigation with validation
- **Data Operations**: CRUD operations with error handling
- **File I/O**: Persistent storage management
- **Analytics**: Statistical calculations and reporting

#### `Product.java` (Data Model)

- **Entity Representation**: Complete product data model
- **Validation Logic**: Data integrity enforcement
- **Display Methods**: Multiple output formats (table, detailed, CSV)
- **Comparison Logic**: Natural ordering implementation
- **Timestamp Management**: Creation and modification tracking

#### `UIConstants.java` (Utility Class)

- **ANSI Color Codes**: Complete color palette for console output
- **Formatting Constants**: Table borders, separators, icons
- **Helper Methods**: Display utilities and cross-platform support
- **UI Components**: Reusable interface elements

---

## 🎨 Advanced Features

### Rich Console Interface

- **ANSI Color Support**: 8 foreground colors, 8 background colors
- **Text Formatting**: Bold, italic, underline styles
- **Visual Elements**: Unicode borders, icons, and symbols
- **Cross-Platform**: Windows, macOS, and Linux compatibility
- **Screen Management**: Clear screen functionality with fallbacks

### Performance Optimizations

- **HashMap Indexing**: O(1) category-based lookups
- **Stream Processing**: Lazy evaluation for large datasets
- **Memory Management**: Try-with-resources for automatic cleanup
- **Efficient Sorting**: Built-in Comparator implementations

### Data Validation and Safety

- **Type Safety**: Comprehensive generic type usage
- **Input Sanitization**: Trim whitespace, validate ranges
- **Error Recovery**: Graceful handling of invalid input
- **Data Consistency**: Automatic timestamp updates

---

## 📊 Performance & Optimization

### Scalability Considerations

- **Collection Choice**: ArrayList for sequential access, HashMap for lookups
- **Stream Operations**: Parallel processing capability for large datasets
- **Memory Usage**: Efficient object allocation and garbage collection
- **I/O Operations**: Buffered readers/writers for file operations

### Performance Metrics

```java
// Efficient category indexing
Map<String, List<Product>> categoryIndex = new HashMap<>();
// Average lookup time: O(1)

// Stream-based filtering
products.stream()
    .filter(predicate)
    .collect(Collectors.toList());
// Time complexity: O(n)
```

---

## 📄 File Format Specification

### CSV Data Structure

```csv
ID,Name,Price,Quantity,Category,CreatedAt,UpdatedAt
1001,Wireless Headphones,149.99,25,Electronics,2024-01-15 10:30:00,2024-01-15 10:30:00
```

### Field Specifications

- **ID**: Integer, unique identifier
- **Name**: String, product name (trimmed)
- **Price**: Double, monetary value (non-negative)
- **Quantity**: Integer, stock level (non-negative)
- **Category**: String, predefined categories
- **CreatedAt**: LocalDateTime, creation timestamp
- **UpdatedAt**: LocalDateTime, last modification timestamp

### Backward Compatibility

The system supports both v1.0 (5 fields) and v2.0 (7 fields) file formats with automatic migration.

---

## 🛡️ Error Handling

### Exception Management Strategy

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

### Error Categories

- **Input Validation Errors**: Invalid data types, out-of-range values
- **File I/O Errors**: Missing files, permission issues, disk space
- **Business Logic Errors**: Duplicate IDs, invalid operations
- **System Errors**: Memory issues, runtime exceptions

---

## 🔧 Troubleshooting

### Common Issues and Solutions

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

#### File Permission Errors

```bash
# Ensure write permissions in application directory
chmod 755 /path/to/inventtrack/
```

#### Compilation Errors

```bash
# Verify JDK version
java -version
javac -version

# Should be 11 or higher
```

---

## 👨‍💻 Development Guide

### Code Style Guidelines

- **Naming Conventions**: camelCase for variables, PascalCase for classes
- **Method Length**: Keep methods focused and under 30 lines
- **Documentation**: Comprehensive JavaDoc for all public methods
- **Error Handling**: Specific exception types with meaningful messages

### Testing Recommendations

```java
// Unit test example
@Test
public void testProductCreation() {
    Product product = new Product(1, "Test Item", 10.0, 5, "Electronics");
    assertEquals(1, product.getId());
    assertEquals("Test Item", product.getName());
}
```

### Future Enhancement Ideas

- **Database Integration**: Replace file storage with SQL database
- **REST API**: Web service endpoints for remote access
- **GUI Interface**: JavaFX or Swing graphical interface
- **Reporting**: PDF/Excel report generation
- **Multi-User Support**: Concurrent access with user authentication

---

## 🤝 Contributing

### Contribution Guidelines

1. **Fork the Repository**: Create your own copy
2. **Create Feature Branch**: `git checkout -b feature/amazing-feature`
3. **Commit Changes**: `git commit -m 'Add amazing feature'`
4. **Push to Branch**: `git push origin feature/amazing-feature`
5. **Open Pull Request**: Submit for review

### Code Review Checklist

- [ ] Code follows style guidelines
- [ ] All tests pass
- [ ] Documentation updated
- [ ] Error handling implemented
- [ ] Performance impact assessed

### Development Setup

```bash
# Clone repository
git clone <repository-url>
cd inventtrack-v2

# Create development branch
git checkout -b develop

# Make changes and test
javac *.java && java InvenTrackSystem
```

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

## 🙏 Acknowledgments

### Technologies and Libraries

- **Java SE**: Core platform and APIs
- **Java Collections Framework**: Data structure implementations
- **Java 8+ Streams**: Functional programming capabilities
- **ANSI Escape Codes**: Console formatting and colors

### Educational Resources

- Oracle Java Documentation
- Effective Java by Joshua Bloch
- Java: The Complete Reference by Herbert Schildt
- Modern Java in Action by Raoul-Gabriel Urma

### Community Support

Special thanks to the Java developer community for continuous inspiration and knowledge sharing through forums, tutorials, and open-source contributions.

---

<div align="center">

### 🌟 Star this repository if you found it helpful!

[Report Bug](../../issues) • [Request Feature](../../issues) • [Documentation](../../wiki)

**Built with ❤️ using Advanced Java Programming Techniques**

</div>
