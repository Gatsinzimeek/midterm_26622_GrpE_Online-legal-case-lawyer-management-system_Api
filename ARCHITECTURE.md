# System Architecture Diagram

## Layered Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                     CLIENT (Browser/Postman)                 │
└─────────────────────────────────────────────────────────────┘
                              ↓ HTTP Requests
┌─────────────────────────────────────────────────────────────┐
│                    CONTROLLER LAYER (REST API)               │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │   Province   │  │   District   │  │    Client    │      │
│  │  Controller  │  │  Controller  │  │  Controller  │      │
│  └──────────────┘  └──────────────┘  └──────────────┘      │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │    Lawyer    │  │  LegalCase   │  │CaseAssignment│      │
│  │  Controller  │  │  Controller  │  │  Controller  │      │
│  └──────────────┘  └──────────────┘  └──────────────┘      │
│  ┌──────────────┐                                           │
│  │     User     │                                           │
│  │  Controller  │                                           │
│  └──────────────┘                                           │
└─────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────┐
│                    SERVICE LAYER (Business Logic)            │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │   Province   │  │   District   │  │    Client    │      │
│  │   Service    │  │   Service    │  │   Service    │      │
│  └──────────────┘  └──────────────┘  └──────────────┘      │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │    Lawyer    │  │  LegalCase   │  │CaseAssignment│      │
│  │   Service    │  │   Service    │  │   Service    │      │
│  └──────────────┘  └──────────────┘  └──────────────┘      │
│  ┌──────────────┐                                           │
│  │     User     │                                           │
│  │   Service    │                                           │
│  └──────────────┘                                           │
└─────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────┐
│              REPOSITORY LAYER (Data Access)                  │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │   Province   │  │   District   │  │    Client    │      │
│  │  Repository  │  │  Repository  │  │  Repository  │      │
│  └──────────────┘  └──────────────┘  └──────────────┘      │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │    Lawyer    │  │  LegalCase   │  │CaseAssignment│      │
│  │  Repository  │  │  Repository  │  │  Repository  │      │
│  └──────────────┘  └──────────────┘  └──────────────┘      │
│  ┌──────────────┐                                           │
│  │     User     │                                           │
│  │  Repository  │                                           │
│  └──────────────┘                                           │
└─────────────────────────────────────────────────────────────┘
                              ↓ JPA/Hibernate
┌─────────────────────────────────────────────────────────────┐
│                    ENTITY LAYER (Domain Model)               │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │   Province   │  │   District   │  │    Client    │      │
│  │    Entity    │  │    Entity    │  │    Entity    │      │
│  └──────────────┘  └──────────────┘  └──────────────┘      │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │    Lawyer    │  │  LegalCase   │  │CaseAssignment│      │
│  │    Entity    │  │    Entity    │  │    Entity    │      │
│  └──────────────┘  └──────────────┘  └──────────────┘      │
│  ┌──────────────┐                                           │
│  │     User     │                                           │
│  │    Entity    │                                           │
│  └──────────────┘                                           │
└─────────────────────────────────────────────────────────────┘
                              ↓ SQL
┌─────────────────────────────────────────────────────────────┐
│                    DATABASE (PostgreSQL)                     │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │   province   │  │   district   │  │    client    │      │
│  │    table     │  │    table     │  │    table     │      │
│  └──────────────┘  └──────────────┘  └──────────────┘      │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │    lawyer    │  │ legal_case   │  │case_assignment│     │
│  │    table     │  │    table     │  │    table     │      │
│  └──────────────┘  └──────────────┘  └──────────────┘      │
│  ┌──────────────┐                                           │
│  │    users     │                                           │
│  │    table     │                                           │
│  └──────────────┘                                           │
└─────────────────────────────────────────────────────────────┘
```

## Entity Relationships

```
                    ┌──────────────┐
                    │   Province   │
                    │  (id, name)  │
                    └──────┬───────┘
                           │ 1
                           │
                           │ Many
                    ┌──────▼───────┐
                    │   District   │
                    │(id, name, FK)│
                    └──────┬───────┘
                           │ 1
              ┌────────────┼────────────┐
              │            │            │
              │ Many       │ Many       │ Many
       ┌──────▼──────┐ ┌──▼────────┐ ┌─▼──────┐
       │   Client    │ │  Lawyer   │ │  User  │
       │(id, name,   │ │(id, name, │ │(id,    │
       │ email, FK)  │ │ spec, FK) │ │user,FK)│
       └──────┬──────┘ └─────┬─────┘ └────────┘
              │ 1            │ 1
              │              │
              │ Many         │ Many
       ┌──────▼──────┐       │
       │ Legal Case  │       │
       │(id, number, │       │
       │ status, FK) │       │
       └──────┬──────┘       │
              │ 1            │
              │              │
              │ Many    Many │
       ┌──────▼──────────────▼─────┐
       │    Case Assignment        │
       │(id, date, role, FK, FK)   │
       └───────────────────────────┘
```

## Real-World Workflow

```
1. ADMIN SETUP
   ┌─────────────────────────────────────┐
   │ Create Provinces & Districts        │
   │ POST /api/provinces                 │
   │ POST /api/districts                 │
   └─────────────────────────────────────┘

2. REGISTRATION
   ┌─────────────────────────────────────┐
   │ Clients Register Online             │
   │ POST /api/clients                   │
   │                                     │
   │ Lawyers Register with Specialization│
   │ POST /api/lawyers                   │
   └─────────────────────────────────────┘

3. CASE FILING
   ┌─────────────────────────────────────┐
   │ Client Files Legal Case             │
   │ POST /api/cases                     │
   │ (Status: Open)                      │
   └─────────────────────────────────────┘

4. ASSIGNMENT
   ┌─────────────────────────────────────┐
   │ Admin Assigns Lawyer to Case        │
   │ POST /api/assignments               │
   │ (Links Lawyer + Case)               │
   └─────────────────────────────────────┘

5. TRACKING
   ┌─────────────────────────────────────┐
   │ Track Case Status                   │
   │ GET /api/cases/status/Open          │
   │ PUT /api/cases/{id}                 │
   │ (Update status: In Progress/Closed) │
   └─────────────────────────────────────┘

6. REPORTING
   ┌─────────────────────────────────────┐
   │ View by Location                    │
   │ GET /api/clients/district/{id}      │
   │ GET /api/lawyers/district/{id}      │
   │ GET /api/users/district/{id}        │
   └─────────────────────────────────────┘
```

## API Request Flow Example

```
Client Request: POST /api/cases
        ↓
LegalCaseController.createCase()
        ↓
LegalCaseService.createCase()
        ↓
LegalCaseRepository.save()
        ↓
Spring Data JPA
        ↓
Hibernate SQL Generation
        ↓
PostgreSQL Database
        ↓
Response: Created Case Object
```
