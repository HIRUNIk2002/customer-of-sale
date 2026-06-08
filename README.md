# 🛒 Customer of Sale (POS) Backend

This is a robust and scalable **Point of Sale (POS) Backend System** built using **Java** and the **Spring Boot** framework. It manages underlying business logic for product sales, customer relations, inventory, and transaction processing.

---

## 🚀 Features

* **Customer Management:** Create, read, update, and delete (CRUD) customer profiles and track purchasing histories.
* **Product & Inventory Management:** Maintain stocks, monitor product details, and receive low-stock alerts.
* **Order & Billing System:** Process sales transactions, generate invoices, and handle real-time inventory deductions.
* **Secure Architecture:** Clean and organized separation of concerns using the Controller-Service-Repository pattern.
* **Custom Exception Handling:** Centralized global exception handler for smooth API responses and debugging.

---

## 🛠️ Tech Stack & Architecture

* **Language:** Java
* **Framework:** Spring Boot
* **Data Access:** Spring Data JPA / Hibernate
* **Build Tool:** Maven
* **Architecture Pattern:** Layered Architecture (Controller -> Service -> Repository -> Entity)

---

## 📂 Project Structure

The codebase follows standard Spring Boot structures for high maintainability:

```text
src/main/java/com/example/demo/
├── advisor/       # Global exception handling & API response controllers
├── config/        # Application configurations (Security, CORS, ModelMapper, etc.)
├── controller/    # REST API Endpoints 
├── dto/           # Data Transfer Objects for decoupled data sharing
├── entity/        # Database models (JPA Entities)
├── exception/     # Custom runtime business exceptions
├── repo/          # Spring Data JPA Repositories (Database communication)
├── service/       # Business logic layer (Interfaces & Implementations)
└── util/          # Helper classes and utility methods
```

---

## ⚙️ Prerequisites & Setup

Before running the application, ensure you have the following installed:
* **Java Development Kit (JDK 17)**
* **Apache Maven**
* **MySQL** 

### 1. Database Configuration
Create a local database and configure your connection credentials inside `src/main/resources/application.properties` (or `application.yml`):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 2. Run the Application
Open your terminal in the project root directory and execute:

```bash
mvn spring-boot:run
```
The server will start by default on `http://localhost:8082`.

---

 