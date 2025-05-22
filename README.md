# Spring Boot Authentication Service

This is a JWT-based authentication and authorization service built using **Spring Boot**, **Spring Security**, **JWT**, and **MySQL**. It supports secure login, registration, and role-based access control using a MySQL database.

---

## 🚀 Features

- JWT authentication and authorization
- Role-based access control
- Secure password hashing with Spring Security
- Stateless API using Spring Security filters
- MySQL database integration via JPA/Hibernate
- Custom `UserDetails` and `UserDetailsService`

---

## 🧰 Technologies Used

- Java 17+
- Spring Boot
- Spring Security
- JSON Web Tokens (JWT)
- MySQL 8+
- Gradle
- Lombok

---

## ⚙️ Prerequisites

Make sure the following are installed on your machine:

- [Java 17+](https://adoptopenjdk.net/)
- [Gradle](https://gradle.org/install/)
- [MySQL 8+](https://dev.mysql.com/downloads/mysql/)
- API testing tool like [Postman](https://www.postman.com/)

---

## 🧾 Database Setup

1. **Create the MySQL database**:
   Open your MySQL client and run:

   ```sql
   CREATE DATABASE authservice;
