# JPA Custom Query Demo Application

A comprehensive Spring Boot application demonstrating various JPA (Java Persistence API) query methods and patterns using Spring Data JPA. This project showcases different approaches to database querying including method name-based queries, custom JPQL queries, and various search patterns with robust error handling and input validation.

## 🚀 Features

### Query Types Demonstrated
- **Method Name-based Queries**: Using Spring Data JPA naming conventions
- **Custom JPQL Queries**: Using `@Query` annotation
- **Search Patterns**: Contains, starts with, ends with, case-insensitive
- **Price Range Queries**: Greater than, less than, between ranges
- **Sorting Operations**: Ascending and descending order
- **Complex Queries**: Multiple criteria combinations

### REST API Endpoints
- **GET** operations for various search criteria
- **POST** operations for complex search scenarios
- Support for path variables, request parameters, and request bodies
- Comprehensive product search and retrieval operations
- **Proper HTTP Status Codes**: 200, 400, 404 responses
- **Input Validation**: Request parameter validation
- **Error Handling**: Global exception handling with detailed error messages

### Enhanced Features
- **Input Validation**: Bean validation with custom error messages
- **Error Handling**: Global exception handler with consistent error responses
- **Specific Exceptions**: Custom exception types for different error scenarios
- **CORS Support**: Cross-origin resource sharing enabled
- **ResponseEntity**: Proper HTTP response handling
- **Parameter Validation**: Null checks and business logic validation

## 🏗️ Architecture

The application follows a standard layered architecture with enhanced error handling:

```
┌─────────────────┐
│   Controller    │ ← REST API endpoints with validation
├─────────────────┤
│    Service      │ ← Business logic layer
├─────────────────┤
│   Repository    │ ← Data access layer
├─────────────────┤
│   Entity        │ ← Database mapping with validation
└─────────────────┘
```

### Technology Stack
- **Java 21**: Latest LTS version
- **Spring Boot 3.5.4**: Application framework
- **Spring Data JPA**: Data access layer
- **Spring Boot Validation**: Input validation support
- **Hibernate**: JPA implementation
- **Oracle Database**: Primary database
- **Lombok**: Boilerplate code reduction
- **Maven**: Build tool and dependency management

## 📋 Prerequisites

Before running this application, ensure you have:

- **Java 21** or higher installed
- **Oracle Database** running locally or accessible
- **Maven 3.6+** for building the project
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code recommended)

### Database Setup
1. Ensure Oracle Database is running on `localhost:1521`
2. Create a database user with appropriate permissions
3. Update database credentials in `application.properties` if needed

## 🛠️ Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd jpa-custom-query
```

### 2. Configure Database
Update the database configuration in `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/XEPDB1
```

### 3. Build the Project
```bash
mvn clean install
```

### 4. Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8888`

## 📚 API Documentation

### Base URL
```
http://localhost:8888/products
```

### Response Format
All endpoints return `ResponseEntity` with appropriate HTTP status codes:
- **200 OK**: Successful operation
- **400 Bad Request**: Invalid input parameters
- **404 Not Found**: Resource not found
- **500 Internal Server Error**: Unexpected server error

### Error Response Format
```json
{
  "timestamp": "2024-12-19T10:30:00",
  "message": "Error description",
  "details": "Detailed error information",
  "path": "/products/search/contains",
  "errorType": "ProductNotFoundException"
}
```

### Exception Types
The application includes specific exception types for different error scenarios:

- **ProductNotFoundException**: When a product is not found (404)
- **InvalidInputException**: When input parameters are invalid (400)
- **DatabaseOperationException**: When database operations fail (500)
- **IllegalArgumentException**: For invalid arguments (400)
- **NullPointerException**: For missing required parameters (400)

### Available Endpoints

#### Basic Operations
| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET | `/products` | Get all products | 200 |

#### Search by Name
| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET | `/products/name/{name}` | Get product by exact name | 200, 404 |
| GET | `/products/search/contains?keyword={keyword}` | Search products containing keyword | 200, 400 |
| GET | `/products/search/starts?prefix={prefix}` | Search products starting with prefix | 200, 400 |
| GET | `/products/search/ends?suffix={suffix}` | Search products ending with suffix | 200, 400 |
| GET | `/products/search/ignore-case?name={name}` | Case-insensitive name search | 200, 400 |

#### Search by Price
| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET | `/products/price?price={price}` | Get products with exact price | 200 |
| GET | `/products/price/greater?price={price}` | Get products with price greater than | 200 |
| GET | `/products/price/less?price={price}` | Get products with price less than | 200 |
| GET | `/products/price/between?min={min}&max={max}` | Get products within price range | 200, 400 |

#### Combined Search
| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET | `/products/name-price?name={name}&price={price}` | Get product by name and price | 200, 404 |
| GET | `/products/search/contains-price?name={name}&price={price}` | Search by name containing and price greater | 200, 400 |
| POST | `/products/search/names-in-price-range?min={min}&max={max}` | Search by names list and price range | 200, 400 |

#### Sorting Operations
| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET | `/products/sort/asc` | Get all products sorted by price (ascending) | 200 |
| GET | `/products/sort/desc` | Get all products sorted by price (descending) | 200 |
| GET | `/products/search/contains-sort-asc?keyword={keyword}` | Search by name containing and sort by price (ascending) | 200, 400 |

#### Custom Queries
| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET | `/products/custom/price-range?minPrice={min}&maxPrice={max}` | Custom JPQL query for price range | 200, 400 |

## 💾 Database Schema

### Products Table
```sql
CREATE TABLE products (
    id INTEGER PRIMARY KEY,
    name VARCHAR2(255) NOT NULL,
    price NUMBER(10,2) NOT NULL CHECK (price > 0)
);
```

### Sample Data
```sql
INSERT INTO products (id, name, price) VALUES (1, 'Laptop', 999.99);
INSERT INTO products (id, name, price) VALUES (2, 'Smartphone', 599.99);
INSERT INTO products (id, name, price) VALUES (3, 'Tablet', 299.99);
INSERT INTO products (id, name, price) VALUES (4, 'Headphones', 199.99);
INSERT INTO products (id, name, price) VALUES (5, 'Keyboard', 89.99);
```

## 🔍 Query Examples

### Method Name-based Queries
```java
// Find by exact name
Product product = productRepository.findByName("Laptop");

// Find by price range
List<Product> products = productRepository.findByPriceBetween(100.0, 500.0);

// Find by name containing keyword
List<Product> products = productRepository.findByNameContaining("phone");

// Case-insensitive search
List<Product> products = productRepository.findByNameIgnoreCase("laptop");
```

### Custom JPQL Queries
```java
// Custom query with @Query annotation
@Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
List<Product> searchByPriceRange(@Param("minPrice") Double minPrice, 
                                @Param("maxPrice") Double maxPrice);
```

## 🧪 Testing the API

### Using cURL

#### Get all products
```bash
curl -X GET http://localhost:8888/products
```

#### Search by name containing
```bash
curl -X GET "http://localhost:8888/products/search/contains?keyword=phone"
```

#### Search by price range
```bash
curl -X GET "http://localhost:8888/products/price/between?min=100&max=500"
```

#### Complex search with POST
```bash
curl -X POST "http://localhost:8888/products/search/names-in-price-range?min=100&max=1000" \
     -H "Content-Type: application/json" \
     -d '["Laptop", "Smartphone", "Tablet"]'
```

#### Error handling examples
```bash
# Invalid price range (min > max)
curl -X GET "http://localhost:8888/products/price/between?min=500&max=100"

# Empty keyword
curl -X GET "http://localhost:8888/products/search/contains?keyword="

# Product not found
curl -X GET "http://localhost:8888/products/name/NonExistentProduct"
```

### Using Postman
1. Import the collection (if available)
2. Set base URL to `http://localhost:8888`
3. Test different endpoints with various parameters
4. Check response status codes and error messages

## 🔧 Configuration

### Application Properties
Key configuration options in `application.properties`:

```properties
# Server configuration
server.port=8888

# Database configuration
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/XEPDB1
spring.datasource.username=c##scott
spring.datasource.password=tiger

# JPA configuration
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update

# Validation configuration
spring.jpa.properties.hibernate.validator.apply_to_ddl=false
```

### DDL Auto Options
- `update`: Create schema once, update on subsequent runs (recommended for production)
- `create`: Create schema every time application starts (good for development)
- `create-drop`: Create schema at startup and drop at shutdown (good for testing)

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           ├── JpaCustomQueryApplication.java
│   │           ├── controller/
│   │           │   └── ProductController.java
│   │           ├── entity/
│   │           │   └── Product.java
│   │           ├── exception/
│   │           │   ├── GlobalExceptionHandler.java
│   │           │   ├── ProductNotFoundException.java
│   │           │   ├── InvalidInputException.java
│   │           │   └── DatabaseOperationException.java
│   │           ├── repository/
│   │           │   └── ProductRepository.java
│   │           └── service/
│   │               └── ProductService.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── example/
                └── JpaCustomQueryApplicationTests.java
```

## 🚀 Running the Application

### Development Mode
```bash
mvn spring-boot:run
```

### Production Mode
```bash
mvn clean package
java -jar target/jpa-custom-query-0.0.1-SNAPSHOT.jar
```

### Docker (if Dockerfile available)
```bash
docker build -t jpa-custom-query .
docker run -p 8888:8888 jpa-custom-query
```

## 📊 Monitoring and Logging

### SQL Query Logging
The application is configured to log all SQL queries to the console for debugging and learning purposes. This can be disabled by setting:

```properties
spring.jpa.show-sql=false
```

### Application Logs
Monitor application logs for:
- SQL query execution
- HTTP request/response details
- Database connection status
- Application startup information
- Validation errors
- Exception handling

### Error Monitoring
The application includes comprehensive error handling:
- Global exception handler for consistent error responses
- Input validation with detailed error messages
- HTTP status code mapping for different error scenarios
- Timestamp and request path information in error responses

## 🔒 Security Considerations

### Input Validation
- All request parameters are validated
- Bean validation annotations on entity fields
- Custom validation logic in controller methods
- Null checks and business rule validation

### Error Handling
- No sensitive information exposed in error messages
- Consistent error response format
- Proper HTTP status codes
- Detailed logging for debugging

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Code Quality Guidelines
- Follow Java coding conventions
- Add comprehensive JavaDoc comments
- Include unit tests for new features
- Validate input parameters
- Handle exceptions appropriately
- Use proper HTTP status codes

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Tamojeet** - *Initial work* - [Tamojeet]

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Spring Data JPA for simplified data access
- Spring Boot Validation for input validation support
- Oracle for the database technology
- Lombok for reducing boilerplate code

## 📞 Support

For support and questions:
- Create an issue in the repository
- Contact the development team
- Check the documentation for common solutions

---

**Note**: This application is designed for educational purposes and demonstrates various JPA query patterns with robust error handling and input validation. For production use, consider implementing additional security measures, comprehensive testing, and monitoring solutions. 