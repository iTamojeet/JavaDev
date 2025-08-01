# Spring Payment Gateway

A robust and extensible payment gateway system built with Spring Framework that supports multiple payment providers including Google Pay, PayPal, and PhonePe. This project demonstrates advanced Spring concepts including dependency injection, ORM with Hibernate, and database integration with Oracle.

## 🚀 Features

- **Multi-Provider Support**: Seamlessly switch between different payment gateways
- **Festival Offers**: Built-in cashback and discount calculation for each provider
- **Database Integration**: Oracle database integration with Hibernate ORM
- **Payment Tracking**: Complete payment record storage and retrieval
- **Spring Framework**: Leverages Spring's dependency injection and component scanning
- **Extensible Architecture**: Easy to add new payment providers

## 🏗️ Architecture

The project follows a clean, modular architecture:

```
src/main/java/payment/gateway/
├── config/          # Database configuration
├── DAO/            # Data Access Objects
├── entity/         # JPA entities
├── provider/       # Main payment provider logic
├── service/        # Payment gateway implementations
└── storehouse/     # Payment storage utilities
```

## 🛠️ Technology Stack

- **Java**: 23
- **Spring Framework**: 6.2.7
- **Hibernate ORM**: 6.2.6.Final
- **Oracle Database**: 19.8.0.0
- **JPA**: 3.1.0
- **Lombok**: 1.18.38
- **JUnit**: 4.13.2
- **Maven**: Build tool

## 📋 Prerequisites

Before running this project, ensure you have:

- Java 23 or higher
- Maven 3.6+
- Oracle Database (XE or higher)
- Oracle JDBC Driver

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd spring-payment-gateway
```

### 2. Database Setup

1. Install Oracle Database (XE recommended for development)
2. Create a user with the following credentials:
   - Username: `scott`
   - Password: `tiger`
   - Database: `xe`
   - Port: `1521`

### 3. Configure Database Connection

The database configuration is in `src/main/java/payment/gateway/config/OracleConfig.java`. Update the connection properties if needed:

```java
properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:oracle:thin:@localhost:1521:xe");
properties.put(Environment.JAKARTA_JDBC_USER, "scott");
properties.put(Environment.JAKARTA_JDBC_PASSWORD, "tiger");
```

### 4. Build the Project

```bash
mvn clean compile
```

### 5. Run Tests

```bash
mvn test
```

### 6. Run the Application

```bash
mvn exec:java -Dexec.mainClass="PaymentGatewayTest"
```

## 💳 Supported Payment Providers

### Google Pay
- **Cashback**: 8% of transaction amount
- **Component Name**: `googlepay`

### PayPal
- **Cashback**: 1% of transaction amount
- **Component Name**: `paypal`

### PhonePe
- **Cashback**: 7% of transaction amount
- **Component Name**: `phonepay`

## 🔧 Usage Example

```java
// Create Spring context
ApplicationContext context = new AnnotationConfigApplicationContext(PaymentProvider.class);

// Get payment provider
PaymentProvider provider = context.getBean(PaymentProvider.class);

// Set payment gateway (dynamically injectable)
provider.setPaymentGateway(new GooglePay());

// Process payment
provider.processPayment("John Doe", 1000.0);
```

## 📊 Database Schema

The application creates a `PAYMENT_RECORDS` table with the following structure:

| Column | Type | Description |
|--------|------|-------------|
| ID | INT | Primary key (auto-generated) |
| CUSTOMER_NAME | VARCHAR | Customer name |
| AMOUNT | DOUBLE | Transaction amount |

## 🧪 Testing

The project includes comprehensive tests in `src/test/java/PaymentGatewayTest.java`. Run tests using:

```bash
mvn test
```

## 🔄 Adding New Payment Providers

To add a new payment provider:

1. Create a new class implementing `PaymentGateway` interface
2. Add `@Component` annotation with a unique name
3. Implement `payment()` and `festivalOffer()` methods
4. The provider will be automatically available for injection

Example:
```java
@Component("newprovider")
public class NewProvider implements PaymentGateway {
    @Override
    public void payment(double amount) {
        System.out.println("NewProvider processed: " + amount);
    }

    @Override
    public double festivalOffer(double amount) {
        return amount * 0.05; // 5% cashback
    }
}
```

## 📁 Project Structure

```
spring-payment-gateway/
├── pom.xml                                    # Maven configuration
├── README.md                                  # This file
├── src/
│   ├── main/java/payment/gateway/
│   │   ├── config/
│   │   │   └── OracleConfig.java             # Database configuration
│   │   ├── DAO/
│   │   │   └── PaymentDAO.java               # Data access layer
│   │   ├── entity/
│   │   │   └── PaymentRecord.java            # JPA entity
│   │   ├── provider/
│   │   │   └── PaymentProvider.java          # Main payment logic
│   │   ├── service/
│   │   │   ├── PaymentGateway.java           # Payment interface
│   │   │   ├── GooglePay.java                # Google Pay implementation
│   │   │   ├── PayPal.java                   # PayPal implementation
│   │   │   └── PhonePay.java                 # PhonePe implementation
│   │   └── storehouse/
│   │       └── PaymentStorage.java           # Storage utilities
│   └── test/java/
│       └── PaymentGatewayTest.java           # Test cases
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

For support and questions:
- Create an issue in the repository
- Contact the development team

## 🔮 Future Enhancements

- [ ] REST API endpoints
- [ ] Web interface
- [ ] Payment gateway plugins
- [ ] Transaction history
- [ ] User authentication
- [ ] Payment analytics
- [ ] Multi-currency support

---

**Note**: This is a demonstration project showcasing Spring Framework concepts. For production use, additional security measures, error handling, and logging should be implemented. 