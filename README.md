# Online Legal Case & Lawyer Management System

A Spring Boot RESTful application for managing legal cases, lawyers, clients, and case assignments with location-based organization.

## Features

✅ **Lawyer Management** - Register and manage lawyers with specializations
✅ **Client Management** - Register clients online with location tracking
✅ **Legal Case Management** - Track case status, filing dates, and hearings
✅ **Case Assignments** - Assign lawyers to cases
✅ **Location Management** - Province and District hierarchy
✅ **User Profiles** - User management grouped by location
✅ **Admin Dashboard** - Manage all system entities

## Technology Stack

- **Java 21**
- **Spring Boot 4.0.3**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**

## Database Setup

1. Install PostgreSQL
2. Create database:
```sql
CREATE DATABASE legal_case_db;
```

3. Update credentials in `application.properties`:
```properties
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

Application runs on: `http://localhost:8080`

## API Endpoints

### Province Management
- `GET /api/provinces` - Get all provinces
- `GET /api/provinces/{id}` - Get province by ID
- `POST /api/provinces` - Create province
- `PUT /api/provinces/{id}` - Update province
- `DELETE /api/provinces/{id}` - Delete province

### District Management
- `GET /api/districts` - Get all districts
- `GET /api/districts/{id}` - Get district by ID
- `GET /api/districts/province/{provinceId}` - Get districts by province
- `POST /api/districts` - Create district
- `PUT /api/districts/{id}` - Update district
- `DELETE /api/districts/{id}` - Delete district

### Client Management
- `GET /api/clients` - Get all clients
- `GET /api/clients/{id}` - Get client by ID
- `GET /api/clients/district/{districtId}` - Get clients by district
- `POST /api/clients` - Register new client
- `PUT /api/clients/{id}` - Update client
- `DELETE /api/clients/{id}` - Delete client

### Lawyer Management
- `GET /api/lawyers` - Get all lawyers
- `GET /api/lawyers/{id}` - Get lawyer by ID
- `GET /api/lawyers/district/{districtId}` - Get lawyers by district
- `GET /api/lawyers/specialization/{specialization}` - Get lawyers by specialization
- `POST /api/lawyers` - Register new lawyer
- `PUT /api/lawyers/{id}` - Update lawyer
- `DELETE /api/lawyers/{id}` - Delete lawyer

### Legal Case Management
- `GET /api/cases` - Get all cases
- `GET /api/cases/{id}` - Get case by ID
- `GET /api/cases/client/{clientId}` - Get cases by client
- `GET /api/cases/status/{status}` - Get cases by status
- `POST /api/cases` - Register new case
- `PUT /api/cases/{id}` - Update case status
- `DELETE /api/cases/{id}` - Delete case

### Case Assignment Management
- `GET /api/assignments` - Get all assignments
- `GET /api/assignments/{id}` - Get assignment by ID
- `GET /api/assignments/lawyer/{lawyerId}` - Get assignments by lawyer
- `GET /api/assignments/case/{caseId}` - Get assignments by case
- `POST /api/assignments` - Assign lawyer to case
- `PUT /api/assignments/{id}` - Update assignment
- `DELETE /api/assignments/{id}` - Delete assignment

### User Management
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `GET /api/users/username/{username}` - Get user by username
- `GET /api/users/district/{districtId}` - Get users by district
- `POST /api/users` - Create user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

## Example API Requests

### Create Province
```json
POST /api/provinces
{
  "name": "Central Province"
}
```

### Create District
```json
POST /api/districts
{
  "name": "Colombo",
  "province": {
    "id": 1
  }
}
```

### Register Client
```json
POST /api/clients
{
  "name": "John Doe",
  "email": "john@example.com",
  "phone": "0771234567",
  "address": "123 Main St",
  "district": {
    "id": 1
  }
}
```

### Register Lawyer
```json
POST /api/lawyers
{
  "name": "Jane Smith",
  "email": "jane@example.com",
  "phone": "0779876543",
  "specialization": "Criminal Law",
  "licenseNumber": "LAW12345",
  "district": {
    "id": 1
  }
}
```

### Register Legal Case
```json
POST /api/cases
{
  "caseNumber": "CASE-2024-001",
  "title": "Property Dispute",
  "description": "Land ownership dispute",
  "caseType": "Civil",
  "status": "Open",
  "filingDate": "2024-01-15",
  "hearingDate": "2024-02-20",
  "client": {
    "id": 1
  }
}
```

### Assign Lawyer to Case
```json
POST /api/assignments
{
  "legalCase": {
    "id": 1
  },
  "lawyer": {
    "id": 1
  },
  "assignedDate": "2024-01-16",
  "role": "Lead Attorney",
  "status": "Active"
}
```

## Database Schema

### Tables
- `province` - Province information
- `district` - District information (linked to province)
- `client` - Client details (linked to district)
- `lawyer` - Lawyer details (linked to district)
- `legal_case` - Case information (linked to client)
- `case_assignment` - Lawyer-case assignments
- `users` - User profiles (linked to district)

## Real-World Workflow

1. **Admin** creates provinces and districts
2. **Clients** register online with their location
3. **Lawyers** register with specialization and location
4. **Clients** file legal cases online
5. **Admin** assigns lawyers to cases
6. **System** tracks case status and updates
7. **Users** grouped by location for easy management

## Project Structure

```
src/main/java/com/example/OnlineLegalCaseMs/
├── entity/          # Database entities
├── repository/      # Data access layer
├── service/         # Business logic
└── controller/      # REST API endpoints
```
