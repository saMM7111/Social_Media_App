# 📱 Social Media App

A full-stack social media application. Backend APIs are built and ready — currently working on the frontend with React and Redux.

---

## 🚧 Status

| Layer | Status |
|---|---|
| Backend (Spring Boot) | ✅ Done — all model APIs implemented |
| Frontend (React + Redux) | 🔨 In Progress |

---

## 🛠️ Tech Stack

**Backend**
- Java 17
- Spring Boot 4
- Spring Security + JWT — auth & protected routes
- Spring Data JPA — database layer
- MySQL — relational database
- Lombok — less boilerplate
- Maven — build tool

**Frontend (planned)**
- React
- Redux — global state management
- Axios — API calls to the backend

---

## 🏗️ Backend

The backend is a REST API built with Spring Boot. JWT authentication is wired in via Spring Security — so every protected route requires a valid token in the `Authorization` header.

All the core models have their full CRUD APIs implemented and ready to be consumed by the frontend.

### Running the backend

1. Clone the repo
   ```bash
   git clone https://github.com/saMM7111/Social_Media_App.git
   cd Social_Media_App
   ```

2. Set up MySQL — create a database and update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/social_media_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. Build and run
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

API runs at: `http://localhost:8080`

---

## 🎨 Frontend

> Coming soon — being built with React + Redux.

**What's planned:**
- Component-based UI with React
- Redux store for managing auth state, posts, users, etc.
- Axios interceptors to attach JWT token to every request
- React Router for page navigation

The frontend will live in a `/frontend` folder once work starts.

---

## 📁 Project Structure

```
Social_Media_App/
├── src/
│   └── main/
│       ├── java/com/sam/socialMediaApp/
│       │   ├── controller/     # REST API endpoints
│       │   ├── service/        # Business logic
│       │   ├── repository/     # JPA repositories
│       │   ├── model/          # Entity classes
│       │   ├── dto/            # Request / Response objects
│       │   └── config/         # Security & JWT config
│       └── resources/
│           └── application.properties
├── pom.xml
└── (frontend/ coming soon)
```

---

## 🔑 Auth

Uses JWT. After logging in, include the token in every request:

```
Authorization: Bearer <your_token>
```

---

*Still a work in progress. Will update as the frontend gets built out.* 🙂
