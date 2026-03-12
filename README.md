
Names: Gatsinzi Ernest 
ID: 26622

# ⚖️ Online Legal Case & Lawyer Management System

A Spring Boot RESTful application designed to manage legal cases, lawyers, clients, and locations using modern database relationship modeling and Spring Data JPA.

This project demonstrates advanced backend development concepts including entity relationships, pagination, sorting, and optimized database querying.

---

## 📌 Project Overview

The **Online Legal Case & Lawyer Management System** digitizes legal case management by allowing administrators, lawyers, and clients to interact within a centralized platform.

The system enables:

- Management of lawyers and clients
- Legal case registration and tracking
- Assignment of lawyers to cases
- Location-based user organization
- Efficient data retrieval using pagination and sorting

This project was developed as a practical assessment to demonstrate understanding of **Spring Boot**, **JPA relationships**, and **database design principles**.

---

## 🧱 System Architecture

```
Controller Layer  → Handles HTTP Requests
Service Layer     → Business Logic
Repository Layer  → Database Access (JPA)
Entity Layer      → Database Tables
Database          → MySQL/PostgreSQL
```

---

## 🗄️ Database Design (ERD)

The system contains the following main entities:

1. **User**
2. **Province (Location)**
3. **LawyerProfile**
4. **Case**
5. **Lawyer_Case (Join Table)**

### Relationships Implemented

| Relationship Type | Description |
|-------------------|-------------|
| One-to-Many | One Province has many Users |
| One-to-One | One User has one Lawyer Profile |
| Many-to-Many | Lawyers handle multiple Cases |

---

## 🔗 Entity Relationship Logic

### ✅ One-to-Many (Province → Users)
A province can contain multiple users, but each user belongs to only one province.

### ✅ One-to-One (User ↔ LawyerProfile)
Each lawyer has exactly one professional profile.

### ✅ Many-to-Many (Lawyer ↔ Case)
A legal case may involve multiple lawyers, and a lawyer may handle multiple cases.  
This relationship is implemented using a join table.

---

## ⚙️ Features Implemented

### 📍 Location Management
- Users are linked to provinces using foreign keys.
- Prevents duplication of location data.

### 🔎 Existence Checking
Uses Spring Data JPA `existsBy()` method to verify records before saving.

Example:

```java
boolean existsByEmail(String email);
```

---

### 📄 Pagination

Pagination divides results into smaller pages to improve performance.

```java
PageRequest.of(page, size);
```

Benefits:
- Faster queries
- Reduced memory usage
- Scalable API responses

---

### 🔄 Sorting

Sorting is implemented using Spring Data JPA `Sort`.

```java
Sort.by("name").ascending();
```

Allows ordered data retrieval.

---

### 🔍 Retrieve Users by Province

Users can be retrieved using:

- Province Code
- Province Name

Repository example:

```java
List<User> findByProvince_Code(String code);
```

Spring automatically generates SQL JOIN queries.

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL / PostgreSQL
- Maven
- REST APIs

---

## 📂 Project Structure

```
src/main/java/com/legal/system
│
├── controller
├── service
├── repository
├── entity
└── LegalSystemApplication.java
```

---

## 🚀 How to Run the Project

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/online-legal-case-lawyer-management-system.git
```

### 2️⃣ Open Project

Open using:
- IntelliJ IDEA
- VS Code
- Eclipse

### 3️⃣ Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/legal_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 4️⃣ Run Application

Run:

```
LegalSystemApplication.java
```

Server runs at:

```
http://localhost:8080
```

---

## 🧪 Example API Endpoints

| Method | Endpoint | Description |
|-------|---------|-------------|
| POST | /users | Create user |
| GET | /users | Get all users |
| GET | /users/province/{code} | Users by province |
| POST | /cases | Create legal case |

---

## 🎓 Learning Outcomes

This project demonstrates:

- Database normalization
- JPA relationship mapping
- REST API development
- Performance optimization using pagination
- Clean layered architecture

---

## 📊 Assessment Coverage

| Requirement | Status |
|------------|--------|
| ERD Design | ✅ |
| One-to-Many | ✅ |
| One-to-One | ✅ |
| Many-to-Many | ✅ |
| Pagination | ✅ |
| Sorting | ✅ |
| existsBy() | ✅ |
| Query by Province | ✅ |

---

## 👨‍💻 Author

**Ernest Gatsinzi**  
Software Engineering Student  
Spring Boot & Full Stack Developer

---

## 📜 License

This project is developed for academic and educational purposes.
