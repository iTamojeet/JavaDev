# JPA Custom Query Demo Application

A comprehensive Spring Boot application demonstrating various JPA (Java Persistence API) query methods and patterns using Spring Data JPA. This project showcases different approaches to database querying including method name-based queries, custom JPQL queries, and various search patterns.

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

## 🏗️ Architecture

The application follows a standard layered architecture:

```
┌─────────────────┐
│   Controller    │ ← REST API endpoints
├─────────────────┤
│    Service      │ ← Business logic layer
├─────────────────┤
│   Repository    │ ← Data access layer
├─────────────────┤
│   Entity        │ ← Database mapping
└─────────────────┘
```

### Technology Stack
- **Java 21**: Latest LTS version
- **Spring Boot 3.5.4**: Application framework
- **Spring Data JPA**: Data access layer
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

### Available Endpoints

#### Basic Operations
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/products` | Get all products |

#### Search by Name
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/products/name/{name}` | Get product by exact name |
| GET | `/products/search/contains?keyword={keyword}` | Search products containing keyword |
| GET | `/products/search/starts?prefix={prefix}` | Search products starting with prefix |
| GET | `/products/search/ends?suffix={suffix}` | Search products ending with suffix |
| GET | `/products/search/ignore-case?name={name}` | Case-insensitive name search |

#### Search by Price
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/products/price?price={price}` | Get products with exact price |
| GET | `/products/price/greater?price={price}` | Get products with price greater than |
| GET | `/products/price/less?price={price}` | Get products with price less than |
| GET | `/products/price/between?min={min}&max={max}` | Get products within price range |

#### Combined Search
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/products/name-price?name={name}&price={price}` | Get product by name and price |
| GET | `/products/search/contains-price?name={name}&price={price}` | Search by name containing and price greater |
| POST | `/products/search/names-in-price-range?min={min}&max={max}` | Search by names list and price range |

#### Sorting Operations
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/products/sort/asc` | Get all products sorted by price (ascending) |
| GET | `/products/sort/desc` | Get all products sorted by price (descending) |
| GET | `/products/search/contains-sort-asc?keyword={keyword}` | Search by name containing and sort by price (ascending) |

#### Custom Queries
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/products/custom/price-range?minPrice={min}&maxPrice={max}` | Custom JPQL query for price range |

## 💾 Database Schema

### Products Table
```sql
CREATE TABLE products (
    id INTEGER PRIMARY KEY,
    name VARCHAR2(255),
    price NUMBER(10,2)
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

### Using Postman
1. Import the collection (if available)
2. Set base URL to `http://localhost:8888`
3. Test different endpoints with various parameters

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

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Tamojeet** - *Initial work* - [Tamojeet]

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Spring Data JPA for simplified data access
- Oracle for the database technology
- Lombok for reducing boilerplate code

## 📞 Support

For support and questions:
- Create an issue in the repository
- Contact the development team
- Check the documentation for common solutions

---

**Note**: This application is designed for educational purposes and demonstrates various JPA query patterns. For production use, consider implementing proper security, validation, and error handling. 