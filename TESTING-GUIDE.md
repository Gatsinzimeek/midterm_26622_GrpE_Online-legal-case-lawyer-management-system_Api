# Testing Guide - Online Legal Case Management System

## ✅ Pre-Testing Checklist

- [ ] PostgreSQL installed and running
- [ ] Database `legal_case_db` created
- [ ] Application.properties configured with correct credentials
- [ ] Maven dependencies downloaded
- [ ] Application running on port 8080

## 🧪 Testing Sequence

### Step 1: Create Location Hierarchy

#### 1.1 Create Province
```bash
curl -X POST http://localhost:8080/api/provinces \
  -H "Content-Type: application/json" \
  -d '{"name":"Western Province"}'
```
**Expected Response:** Province object with id=1

#### 1.2 Create District
```bash
curl -X POST http://localhost:8080/api/districts \
  -H "Content-Type: application/json" \
  -d '{"name":"Colombo","province":{"id":1}}'
```
**Expected Response:** District object with id=1

#### 1.3 Verify Location Setup
```bash
curl http://localhost:8080/api/provinces
curl http://localhost:8080/api/districts
```

---

### Step 2: Register Users

#### 2.1 Register Admin User
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "username":"admin",
    "password":"admin123",
    "email":"admin@system.com",
    "role":"ADMIN",
    "district":{"id":1}
  }'
```

#### 2.2 Register Clerk User
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "username":"clerk1",
    "password":"clerk123",
    "email":"clerk1@system.com",
    "role":"CLERK",
    "district":{"id":1}
  }'
```

#### 2.3 Verify Users
```bash
curl http://localhost:8080/api/users
curl http://localhost:8080/api/users/username/admin
curl http://localhost:8080/api/users/district/1
```

---

### Step 3: Register Clients

#### 3.1 Register Client 1
```bash
curl -X POST http://localhost:8080/api/clients \
  -H "Content-Type: application/json" \
  -d '{
    "name":"John Doe",
    "email":"john@example.com",
    "phone":"0771234567",
    "address":"123 Main St, Colombo",
    "district":{"id":1}
  }'
```

#### 3.2 Register Client 2
```bash
curl -X POST http://localhost:8080/api/clients \
  -H "Content-Type: application/json" \
  -d '{
    "name":"Jane Smith",
    "email":"jane@example.com",
    "phone":"0779876543",
    "address":"456 Temple Rd, Colombo",
    "district":{"id":1}
  }'
```

#### 3.3 Verify Clients
```bash
curl http://localhost:8080/api/clients
curl http://localhost:8080/api/clients/1
curl http://localhost:8080/api/clients/district/1
```

---

### Step 4: Register Lawyers

#### 4.1 Register Criminal Lawyer
```bash
curl -X POST http://localhost:8080/api/lawyers \
  -H "Content-Type: application/json" \
  -d '{
    "name":"Sarah Johnson",
    "email":"sarah@lawfirm.com",
    "phone":"0712345678",
    "specialization":"Criminal Law",
    "licenseNumber":"LAW001",
    "district":{"id":1}
  }'
```

#### 4.2 Register Civil Lawyer
```bash
curl -X POST http://localhost:8080/api/lawyers \
  -H "Content-Type: application/json" \
  -d '{
    "name":"Michael Brown",
    "email":"michael@lawfirm.com",
    "phone":"0723456789",
    "specialization":"Civil Law",
    "licenseNumber":"LAW002",
    "district":{"id":1}
  }'
```

#### 4.3 Verify Lawyers
```bash
curl http://localhost:8080/api/lawyers
curl http://localhost:8080/api/lawyers/1
curl http://localhost:8080/api/lawyers/district/1
curl http://localhost:8080/api/lawyers/specialization/Criminal%20Law
```

---

### Step 5: File Legal Cases

#### 5.1 File Criminal Case
```bash
curl -X POST http://localhost:8080/api/cases \
  -H "Content-Type: application/json" \
  -d '{
    "caseNumber":"CASE-2024-001",
    "title":"Theft Case",
    "description":"Theft of personal property",
    "caseType":"Criminal",
    "status":"Open",
    "filingDate":"2024-01-15",
    "hearingDate":"2024-02-20",
    "client":{"id":1}
  }'
```

#### 5.2 File Civil Case
```bash
curl -X POST http://localhost:8080/api/cases \
  -H "Content-Type: application/json" \
  -d '{
    "caseNumber":"CASE-2024-002",
    "title":"Property Dispute",
    "description":"Land ownership dispute",
    "caseType":"Civil",
    "status":"Open",
    "filingDate":"2024-01-20",
    "hearingDate":"2024-03-10",
    "client":{"id":2}
  }'
```

#### 5.3 Verify Cases
```bash
curl http://localhost:8080/api/cases
curl http://localhost:8080/api/cases/1
curl http://localhost:8080/api/cases/client/1
curl http://localhost:8080/api/cases/status/Open
```

---

### Step 6: Assign Lawyers to Cases

#### 6.1 Assign Criminal Lawyer to Criminal Case
```bash
curl -X POST http://localhost:8080/api/assignments \
  -H "Content-Type: application/json" \
  -d '{
    "legalCase":{"id":1},
    "lawyer":{"id":1},
    "assignedDate":"2024-01-16",
    "role":"Lead Attorney",
    "status":"Active"
  }'
```

#### 6.2 Assign Civil Lawyer to Civil Case
```bash
curl -X POST http://localhost:8080/api/assignments \
  -H "Content-Type: application/json" \
  -d '{
    "legalCase":{"id":2},
    "lawyer":{"id":2},
    "assignedDate":"2024-01-21",
    "role":"Lead Attorney",
    "status":"Active"
  }'
```

#### 6.3 Verify Assignments
```bash
curl http://localhost:8080/api/assignments
curl http://localhost:8080/api/assignments/lawyer/1
curl http://localhost:8080/api/assignments/case/1
```

---

### Step 7: Update Case Status

#### 7.1 Update Case to "In Progress"
```bash
curl -X PUT http://localhost:8080/api/cases/1 \
  -H "Content-Type: application/json" \
  -d '{
    "caseNumber":"CASE-2024-001",
    "title":"Theft Case",
    "description":"Theft of personal property",
    "caseType":"Criminal",
    "status":"In Progress",
    "filingDate":"2024-01-15",
    "hearingDate":"2024-02-20",
    "client":{"id":1}
  }'
```

#### 7.2 Verify Status Update
```bash
curl http://localhost:8080/api/cases/1
curl http://localhost:8080/api/cases/status/In%20Progress
```

---

### Step 8: Query and Reports

#### 8.1 Get All Open Cases
```bash
curl http://localhost:8080/api/cases/status/Open
```

#### 8.2 Get All Clients in District
```bash
curl http://localhost:8080/api/clients/district/1
```

#### 8.3 Get All Lawyers in District
```bash
curl http://localhost:8080/api/lawyers/district/1
```

#### 8.4 Get Cases by Client
```bash
curl http://localhost:8080/api/cases/client/1
```

#### 8.5 Get Assignments by Lawyer
```bash
curl http://localhost:8080/api/assignments/lawyer/1
```

---

## 🎯 Expected Results Summary

After completing all steps, you should have:

- ✅ 1 Province (Western Province)
- ✅ 1 District (Colombo)
- ✅ 2 Users (admin, clerk1)
- ✅ 2 Clients (John Doe, Jane Smith)
- ✅ 2 Lawyers (Sarah Johnson, Michael Brown)
- ✅ 2 Legal Cases (Criminal, Civil)
- ✅ 2 Case Assignments (Lawyer-Case links)

---

## 🔍 Verification Queries

### Check Database Tables
```sql
SELECT * FROM province;
SELECT * FROM district;
SELECT * FROM users;
SELECT * FROM client;
SELECT * FROM lawyer;
SELECT * FROM legal_case;
SELECT * FROM case_assignment;
```

### Check Relationships
```sql
-- Districts by Province
SELECT d.name, p.name FROM district d 
JOIN province p ON d.province_id = p.id;

-- Clients by District
SELECT c.name, d.name FROM client c 
JOIN district d ON c.district_id = d.id;

-- Cases by Client
SELECT lc.case_number, c.name FROM legal_case lc 
JOIN client c ON lc.client_id = c.id;

-- Assignments (Lawyer + Case)
SELECT l.name, lc.case_number, ca.role 
FROM case_assignment ca
JOIN lawyer l ON ca.lawyer_id = l.id
JOIN legal_case lc ON ca.case_id = lc.id;
```

---

## 🐛 Troubleshooting

### Issue: Connection Refused
**Solution:** Check if application is running on port 8080
```bash
netstat -ano | findstr :8080
```

### Issue: 404 Not Found
**Solution:** Verify endpoint URL and HTTP method

### Issue: 500 Internal Server Error
**Solution:** Check application logs and database connection

### Issue: Foreign Key Constraint
**Solution:** Ensure parent records exist before creating child records

---

## 📊 Performance Testing

### Load Test with Multiple Requests
```bash
# Create 10 clients
for i in {1..10}; do
  curl -X POST http://localhost:8080/api/clients \
    -H "Content-Type: application/json" \
    -d "{\"name\":\"Client$i\",\"email\":\"client$i@test.com\",\"phone\":\"077000000$i\",\"address\":\"Address $i\",\"district\":{\"id\":1}}"
done
```

---

## ✅ Test Completion Checklist

- [ ] All provinces created successfully
- [ ] All districts linked to provinces
- [ ] All users registered with districts
- [ ] All clients registered with districts
- [ ] All lawyers registered with specializations
- [ ] All cases filed with clients
- [ ] All lawyers assigned to cases
- [ ] Case status updates working
- [ ] All query endpoints returning correct data
- [ ] Location-based filtering working

## 🎉 Success Criteria

Your system is working correctly if:
1. All CRUD operations complete without errors
2. Relationships between entities are maintained
3. Location-based queries return filtered results
4. Case status tracking works properly
5. Lawyer assignments link correctly to cases
