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
🧪 How to Use This Project :
1) Use /api/auth/register to create a new user

2) Use /api/auth/login to get a JWT token

3) Click Authorize in Swagger and paste the JWT

4) Now you can access protected endpoints.

# Sample Accounts -
1) ADMIN account :
    
{
    "username" : "admin",
    "password" : "admin123"
}

2) User accounts - 

{
    "username" : "Test User 2",
    "password" : "user123"
}

{
    "username" : "Test User 2",
    "password" : "user123"
}

#🔐 Auth Endpoints (/api/auth)
These are public endpoints — no JWT token needed.

Method	Endpoint	Description	Payload
POST	/auth/login	Authenticate user & return JWT	AuthRequest (username, password)
POST	/auth/register	Register a new user	AuthRequest (username, password)

 #🧑‍💼 Admin Endpoints (/api/admin)

| Method   | Endpoint                    | Description                       | Payload (Request Body) | Response DTO        |
| -------- | --------------------------- | --------------------------------- | ---------------------- | ------------------- |
| `POST`   | `/api/admin/employees`      | Create a new employee             | `Employee`             | `EmployeeDTO`       |
| `GET`    | `/api/admin/employees`      | Get list of all employees         | —                      | `List<EmployeeDTO>` |
| `GET`    | `/api/admin/employees/{id}` | Get employee by ID                | —                      | `EmployeeDTO`       |
| `PUT`    | `/api/admin/employees/{id}` | Update an existing employee by ID | `Employee`             | `EmployeeDTO`       |
| `DELETE` | `/api/admin/employees/{id}` | Delete an employee by ID          | —                      |                     |


| Method   | Endpoint                | Description                      | Payload (Request Body) | Response DTO     |
| -------- | ----------------------- | -------------------------------- | ---------------------- | ---------------- |
| `GET`    | `/api/admin/users`      | Get list of all registered users | —                      | `List<UserDTO>`  |
| `GET`    | `/api/admin/users/{id}` | Get user details by ID           | —                      | `UserDTO`        |
| `PUT`    | `/api/admin/users/{id}` | Update user details by ID        | `User`                 | `UserDTO`        |
| `DELETE` | `/api/admin/users/{id}` | Delete a user by ID              | —                      |                  |

