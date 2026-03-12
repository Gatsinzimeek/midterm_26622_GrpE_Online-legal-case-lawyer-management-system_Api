# Quick Start Guide

## Prerequisites
- Java 21 or higher
- PostgreSQL 12 or higher
- Maven 3.6+

## Setup Steps

### 1. Database Setup
```bash
# Login to PostgreSQL
psql -U postgres

# Create database
CREATE DATABASE legal_case_db;

# Exit
\q
```

### 2. Configure Application
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### 3. Build & Run
```bash
# Build project
mvn clean install

# Run application
mvn spring-boot:run
```

### 4. Load Sample Data (Optional)
```bash
psql -U postgres -d legal_case_db -f src/main/resources/sample-data.sql
```

### 5. Test API
Open browser or Postman:
```
http://localhost:8080/api/provinces
http://localhost:8080/api/lawyers
http://localhost:8080/api/clients
http://localhost:8080/api/cases
```

## Common Issues

### Port Already in Use
Change port in `application.properties`:
```properties
server.port=8081
```

### Database Connection Failed
- Verify PostgreSQL is running
- Check username/password
- Ensure database exists

### Build Errors
```bash
mvn clean
mvn install -U
```

## Testing Workflow

1. Create Province: `POST /api/provinces`
2. Create District: `POST /api/districts`
3. Register Client: `POST /api/clients`
4. Register Lawyer: `POST /api/lawyers`
5. File Case: `POST /api/cases`
6. Assign Lawyer: `POST /api/assignments`
7. Track Status: `GET /api/cases/status/Open`

## API Testing with cURL

```bash
# Create Province
curl -X POST http://localhost:8080/api/provinces \
  -H "Content-Type: application/json" \
  -d '{"name":"Western Province"}'

# Get All Lawyers
curl http://localhost:8080/api/lawyers

# Get Cases by Status
curl http://localhost:8080/api/cases/status/Open
```
