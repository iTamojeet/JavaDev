# Graceful

A Spring Boot application demonstrating graceful shutdown capabilities with Actuator integration.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Configuration](#configuration)
- [Development](#development)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## 🚀 Overview

Graceful is a Spring Boot application that showcases proper application lifecycle management with graceful shutdown capabilities. The application includes Spring Boot Actuator for monitoring and management endpoints, making it suitable for production deployments where controlled shutdowns are essential.

## ✨ Features

- **Spring Boot 3.5.4** - Latest stable version with Java 21 support
- **Spring Boot Actuator** - Production-ready monitoring and management
- **Graceful Shutdown** - Proper application lifecycle management
- **RESTful API** - Simple web service with health check endpoint
- **Maven Build System** - Standard Java project structure

## 🔧 Prerequisites

Before running this application, ensure you have the following installed:

- **Java 21** or higher
- **Maven 3.6+** or use the included Maven wrapper
- **Git** (for cloning the repository)

### Verify Installation

```bash
java -version
mvn -version
```

## 📦 Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd graceful
   ```

2. **Build the project**
   ```bash
   ./mvnw clean install
   ```

## 🏃‍♂️ Usage

### Running the Application

#### Using Maven Wrapper (Recommended)
```bash
./mvnw spring-boot:run
```

#### Using Java JAR
```bash
./mvnw clean package
java -jar target/graceful-0.0.1-SNAPSHOT.jar
```

#### Using Maven (if installed globally)
```bash
mvn spring-boot:run
```

### Accessing the Application

Once the application is running, you can access:

- **Main Application**: http://localhost:8080
- **Actuator Health**: http://localhost:8080/actuator/health
- **Shutdown Endpoint**: http://localhost:8080/actuator/shutdown (POST)

## 📚 API Documentation

### Endpoints

| Method | Endpoint | Description | Response |
|--------|----------|-------------|----------|
| GET | `/` | Main application endpoint | "Hello World" |
| GET | `/actuator/health` | Application health status | JSON health info |
| POST | `/actuator/shutdown` | Gracefully shutdown application | 200 OK |

### Example Usage

```bash
# Get main response
curl http://localhost:8080/

# Check health status
curl http://localhost:8080/actuator/health

# Gracefully shutdown (requires POST)
curl -X POST http://localhost:8080/actuator/shutdown
```

## ⚙️ Configuration

The application configuration is located in `src/main/resources/application.properties`:

```properties
spring.application.name=graceful
management.endpoint.shutdown.access=unrestricted
management.endpoints.web.exposure.include=shutdown
```

### Key Configuration Options

- `spring.application.name`: Application name for identification
- `management.endpoint.shutdown.access`: Access control for shutdown endpoint
- `management.endpoints.web.exposure.include`: Exposed actuator endpoints

## 🛠️ Development

### Project Structure

```
graceful/
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   └── GracefulApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/example/
│           └── GracefulApplicationTests.java
├── pom.xml
├── mvnw
└── README.md
```

### Adding New Features

1. Create new controller classes in the `com.example` package
2. Add new dependencies to `pom.xml` if needed
3. Update configuration in `application.properties`
4. Write corresponding tests

## 🧪 Testing

### Running Tests

```bash
# Run all tests
./mvnw test

# Run tests with coverage
./mvnw test jacoco:report
```

### Test Structure

- Unit tests are located in `src/test/java/com/example/`
- Test resources can be added to `src/test/resources/`

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Development Guidelines

- Follow Java coding conventions
- Write unit tests for new features
- Update documentation as needed
- Ensure all tests pass before submitting PR

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

If you encounter any issues or have questions:

1. Check the [Spring Boot documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
2. Review the [Spring Boot Actuator guide](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
3. Open an issue in the project repository

## 🔗 Related Links

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
- [Maven Documentation](https://maven.apache.org/guides/)

---

**Note**: This is a demonstration project showcasing Spring Boot best practices for graceful shutdown and application lifecycle management. 