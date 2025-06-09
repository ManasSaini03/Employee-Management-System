# 🧑‍💼 Employee Management System (Spring Boot + Angular)

A backend **Employee Management System** with secure JWT authentication, role-based access (Admin/User).

> Developed using Java Spring Boot, Supabase PostgreSQL, and JWT-based authentication.

---

## 📌 Features

### ✅ Authentication
- User & Admin registration and login
- JWT-based token authentication
- Role-based access control (ADMIN / USER)

### 🧑‍💼 Admin Features
- Create, Read, Update, Delete (CRUD) Employees
- Manage user accounts

### 👤 User Features
- View their employee information

### 🌐 API & UI
- Swagger UI integration for testing APIs

---

## 🛠️ Tech Stack

| Layer     | Technology                                      |
|-----------|--------------------------------------------------|
| Backend   | Spring Boot, Spring Security, JWT, JPA, Hibernate |
| Database  | Supabase (PostgreSQL)                            |
| Tools     | IntelliJ IDEA, Postman, Swagger, GitHub          |

---

## 🔐 Authentication Flow

1. **Register/Login** via `/api/auth`
2. Receive a **JWT token**
3. Use the token in the `Authorization: Bearer <token>` header for secure endpoints
4. Role-based access to `/api/admin/**` or `/api/user/**` APIs

---

## 📸 Screenshots

> (You can insert screenshots or screen recordings here using markdown like below.)

```markdown
![Login Page](screenshots/login.png)
![Admin Dashboard](screenshots/admin-dashboard.png)
