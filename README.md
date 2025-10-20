# Library Management System

A RESTful API-based Library Management System built with Spring Boot for managing books, members, staff, and lending operations.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Project Structure](#project-structure)
- [Database Schema](#database-schema)
- [Usage Examples](#usage-examples)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)

## 🎯 Overview

The Library Management System is a comprehensive backend application that provides REST APIs to manage library operations including:
- Book inventory management
- Member registration and management
- Staff management
- Book lending and return operations
- Fine calculation for overdue books

**Version:** 1.0.0  
**Application Context Path:** `/booklib`  
**Default Port:** 8081 (dev profile)

## ✨ Features

- **Book Management**
  - Add, update, delete, and search books
  - Track total and available quantities
  - Automatic inventory updates on lending/return

- **Member Management**
  - Register new members
  - Update member information
  - Track membership dates

- **Staff Management**
  - Add and manage library staff
  - Role-based access (via Role enum)

- **Lending Operations**
  - Issue books to members
  - Track lending dates and return dates
  - Automatic book quantity deduction
  - Fine calculation for overdue returns

- **Additional Features**
  - Health check endpoint
  - Custom logging with Logback
  - Profile-based configuration (dev, prod)
  - Custom application banner

## 🛠 Technologies Used

- **Java 21**
- **Spring Boot 3.5.6**
  - Spring Web (REST API)
  - Spring Data JPA (Data Access)
  - Spring MVC
- **MySQL 8** (Database)
- **Hibernate** (ORM)
- **Lombok** (Boilerplate reduction)
- **ModelMapper** (DTO-Entity mapping)
- **Log4j2** (Logging)
- **Maven** (Build tool)

## 📦 Prerequisites

Before running this application, ensure you have:

- **Java Development Kit (JDK) 21** or higher
- **Maven 3.6+**
- **MySQL 8.0+** installed and running
- **Git** (optional, for cloning)

## 🚀 Installation & Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd LibManagement
```

### 2. Configure Database

Create a MySQL database or let the application auto-create it:

```sql
CREATE DATABASE booklib2025;
```

### 3. Update Database Credentials

Edit `src/main/resources/application-dev.properties`:

```properties
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.url=jdbc:mysql://localhost:3306/booklib2025?createDatabaseIfNotExist=true
```

### 4. Build the Project

```bash
mvnw clean install
```

### 5. Run the Application

```bash
mvnw spring-boot:run
```

The application will start at: `http://localhost:8081/booklib`

## 📡 API Endpoints

### Health Check

```
GET /api/v1/health
```

### Books

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/books` | Add a new book |
| GET | `/api/v1/books` | Get all books |
| GET | `/api/v1/books?bookId={id}` | Get book by ID |
| PATCH | `/api/v1/books?bookId={id}` | Update a book |
| DELETE | `/api/v1/books?bookId={id}` | Delete a book |

### Members

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/members` | Add a new member |
| GET | `/api/v1/members` | Get all members |
| GET | `/api/v1/members?memberId={id}` | Get member by ID |
| PATCH | `/api/v1/members?memberId={id}` | Update a member |
| DELETE | `/api/v1/members?memberId={id}` | Delete a member |

### Staff

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/staff` | Add a new staff member |
| GET | `/api/v1/staff` | Get all staff |
| GET | `/api/v1/staff?staffId={id}` | Get staff by ID |
| PATCH | `/api/v1/staff?staffId={id}` | Update staff |
| DELETE | `/api/v1/staff?staffId={id}` | Delete staff |

### Lending

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/lendings` | Issue a book |
| GET | `/api/v1/lendings` | Get all lending records |
| GET | `/api/v1/lendings?lendingId={id}` | Get lending by ID |
| PATCH | `/api/v1/lendings?lendingId={id}` | Update lending (return) |
| DELETE | `/api/v1/lendings?lendingId={id}` | Delete lending record |

## 📝 Usage Examples

### Add a New Book

```bash
POST http://localhost:8081/booklib/api/v1/books
Content-Type: application/json

{
  "bookName": "Java Programming",
  "author": "John Doe",
  "edition": "3rd",
  "publisher": "Tech Publications",
  "isbn": "978-1234567890",
  "price": 1500.00,
  "totalQty": 10,
  "availableQty": 10
}
```

### Add a New Member

```bash
POST http://localhost:8081/booklib/api/v1/members
Content-Type: application/json

{
  "name": "John Doe",
  "email": "johndoe@gmail.com"
}
```

### Issue a Book (Lending)

```bash
POST http://localhost:8081/booklib/api/v1/lendings
Content-Type: application/json

{
  "bookId": "B001",
  "memberId": "M001",
  "lendingDate": "2025-10-20"
}
```

## ⚙ Configuration

### Application Profiles

The application supports multiple profiles:

- **dev** (Development) - Default active profile
- **prod** (Production)

### Key Configuration Properties

**application.properties:**
```properties
spring.application.name=LibManagement
server.servlet.context-path=/booklib
spring.profiles.active=dev
```

**application-dev.properties:**
```properties
server.port=8081
perDayFine=5.0
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Fine Calculation

Default fine per day for overdue books: **Rs. 5.00** (configurable in `application-dev.properties`)

## 📁 Project Structure

```
LibManagement/
├── src/
│   ├── main/
│   │   ├── java/lk/puLeeNa/LibManagement/
│   │   │   ├── controller/          # REST Controllers
│   │   │   │   ├── BookControler.java
│   │   │   │   ├── MemberController.java
│   │   │   │   ├── StaffController.java
│   │   │   │   ├── LengdingController.java
│   │   │   │   └── HealthTest.java
│   │   │   ├── dao/                 # Data Access Objects (Repositories)
│   │   │   │   ├── BookDao.java
│   │   │   │   ├── MemberDao.java
│   │   │   │   ├── StaffDao.java
│   │   │   │   └── LendingDao.java
│   │   │   ├── dto/                 # Data Transfer Objects
│   │   │   │   ├── BookDTO.java
│   │   │   │   ├── MemberDTO.java
│   │   │   │   ├── StaffDTO.java
│   │   │   │   ├── LendingDTO.java
│   │   │   │   └── Role.java
│   │   │   ├── entities/            # JPA Entities
│   │   │   │   ├── BookEntity.java
│   │   │   │   ├── MemberEntity.java
│   │   │   │   ├── StaffEntity.java
│   │   │   │   └── LendingEntity.java
│   │   │   ├── exception/           # Custom Exceptions
│   │   │   │   ├── BookNotFoundException.java
│   │   │   │   ├── MemberNotFoundException.java
│   │   │   │   ├── StaffNotFoundException.java
│   │   │   │   ├── LendingDataNotFoundException.java
│   │   │   │   ├── DataPersistException.java
│   │   │   │   └── EnoughBooksNotFoundException.java
│   │   │   ├── service/             # Business Logic
│   │   │   │   ├── impl/
│   │   │   │   ├── BookService.java
│   │   │   │   ├── MemberService.java
│   │   │   │   ├── StaffService.java
│   │   │   │   └── LendingService.java
│   │   │   ├── util/                # Utility Classes
│   │   │   │   ├── EntityDTOConvert.java
│   │   │   │   ├── LendingMapping.java
│   │   │   │   └── UtilData.java
│   │   │   └── LibManagementApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-dev.properties
│   │       ├── application-prod.properties
│   │       ├── banner.txt
│   │       └── logback-spring.xml
│   └── test/
├── Logs/                            # Application logs
├── pom.xml
└── README.md
```

## 🗄 Database Schema

The application uses the following main entities:

### BookEntity
- bookId (PK)
- bookName
- author
- edition
- publisher
- isbn
- price
- totalQty
- availableQty
- lastUpdateDate
- lastUpdateTime

### MemberEntity
- memberId (PK)
- name
- email
- membershipDate

### StaffEntity
- staffId (PK)
- name
- email
- role

### LendingEntity
- lendingId (PK)
- bookId (FK)
- memberId (FK)
- lendingDate
- returnDate
- fine

## 🐛 Troubleshooting

### Common Issues

**1. Missing Request Parameter Error**
```
Required request parameter 'bookId' for method parameter type String is not present
```
**Solution:** Ensure you're passing the required query parameters in your requests.

**2. Update/Delete Query Error**
```
Query executed via 'getResultList()' must be a 'select' query
```
**Solution:** Add `@Modifying` and `@Transactional` annotations to custom query methods in DAO that perform UPDATE or DELETE operations.

**3. ModelMapper Configuration Error**
```
The destination property matches multiple source property hierarchies
```
**Solution:** Configure ModelMapper with custom type maps or use manual mapping for complex relationships.

**4. Transaction Required Error**
```
Executing an update/delete query requires a transaction
```
**Solution:** Add `@Transactional` annotation to service methods that modify data.

### Database Connection Issues

- Verify MySQL is running
- Check database credentials in `application-dev.properties`
- Ensure the database exists or `createDatabaseIfNotExist=true` is set

### Port Already in Use

If port 8081 is already in use, change it in `application-dev.properties`:
```properties
server.port=8082
```

## 📊 Logging

Application logs are stored in the `Logs/` directory. Configure logging in `logback-spring.xml`.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 👨‍💻 Author

**puLeeNa**  
Library Management System - 2025

## 📞 Support

For issues and questions, please create an issue in the repository.

---

**Built with ❤️ using Spring Boot**

