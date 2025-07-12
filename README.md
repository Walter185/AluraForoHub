# 🛡️ Java Spring API - JWT Authentication + Topic CRUD

This project is a RESTful API built with Java 21 and Spring Boot. It demonstrates secure authentication using **JWT tokens**, user registration/login, and a complete **CRUD system for managing topics**.

## 🚀 Features

### ✅ Authentication
- `POST /register` → Register a new user with username and password.
- `POST /login` → Authenticate and receive a **JWT token**.
- Token must be included in the `Authorization: Bearer <token>` header for protected endpoints.

### 🧑‍💻 User Registration & Login
- Users are stored securely with **BCrypt-hashed passwords**.
- On login, users receive a signed JWT token with expiration and claims.

### 📚 Topic Management (CRUD)
All `/topics` endpoints are protected by JWT.

- `GET /topics` → List all topics
- `GET /topics/{id}` → Get topic by ID
- `POST /topics` → Create a new topic
- `PUT /topics/{id}` → Update topic
- `DELETE /topics/{id}` → Delete topic

### 🔐 Security
- Endpoints are protected with Spring Security.
- Only authenticated users with valid JWTs can access topic management.

## 🧪 Tech Stack
- Java 21
- Spring Boot 3+
- Spring Security
- Spring Data JPA
- PostgreSQL or H2 (test)
- JWT (jjwt or similar)

## 🛠️ How to Run

1. Clone the repo
2. Configure your `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/yourdb
   jwt.secret=your-secret-key
   ```
3. Run the app:
   ```bash
   ./mvnw spring-boot:run
   ```

## 📫 API Example (using curl)

### Register
```bash
curl -X POST http://localhost:8080/register -H "Content-Type: application/json" -d '{"username":"user", "password":"123456"}'
```

### Login
```bash
curl -X POST http://localhost:8080/login -H "Content-Type: application/json" -d '{"username":"user", "password":"123456"}'
```

### Use token to access topics
```bash
curl -H "Authorization: Bearer <your_token>" http://localhost:8080/topics
```

## 👨‍💻 Author

Walter Liendo — Alura Latam — 2025

---

For questions or improvements, feel free to contribute or reach out.
