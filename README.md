# LearnOw Server

Backend API cho ứng dụng học trực tuyến LearnOw.

## Tech Stack

- **Java 21** - LTS version
- **Spring Boot 4.0.3** - Framework
- **PostgreSQL** - Database
- **JWT (Nimbus JOSE)** - Authentication
- **MapStruct** - Object mapping
- **Lombok** - Boilerplate reduction
- **Swagger/OpenAPI** - API documentation

## Yêu cầu

- Java 21+
- Maven 3.9+
- PostgreSQL 15+

## Cài đặt

### 1. Clone repository

```bash
git clone https://github.com/socodo/leanOw-server.git
cd leanOw-server
```

### 2. Tạo database PostgreSQL

```sql
CREATE DATABASE learnOw;
```

### 3. Cấu hình environment

Tạo file `.env` ở thư mục gốc:

```properties
JWT_SECRET=your-256-bit-secret-key-here
```

> **Lưu ý:** JWT_SECRET phải có ít nhất 256 bits (32 ký tự)

### 4. Cấu hình database (tùy chọn)

Chỉnh sửa `src/main/resources/application.properties` nếu cần:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/learnOw
spring.datasource.username=postgres
spring.datasource.password=your-password
```

### 5. Chạy ứng dụng

```bash
./mvnw spring-boot:run
```

Hoặc trên Windows:

```bash
mvnw.cmd spring-boot:run
```

## API Documentation

Sau khi chạy ứng dụng, truy cập Swagger UI:

```
http://localhost:8081/swagger-ui.html
```

## API Endpoints

### Auth Module

| Method | Endpoint | Mô tả |
|--------|----------|-------|
| POST | `/api/auth/register` | Đăng ký tài khoản |
| POST | `/api/auth/login` | Đăng nhập |

### Request/Response Examples

#### Đăng ký

```bash
POST /api/auth/register
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "123456",
  "fullName": "Nguyen Van A",
  "phone": "0901234567"
}
```

#### Đăng nhập

```bash
POST /api/auth/login
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "123456"
}
```

Response:

```json
{
  "code": 1000,
  "message": "Đăng nhập thành công",
  "result": {
    "token": "eyJhbGciOiJIUzI1NiJ9...",
    "authenticated": true
  }
}
```

## Cấu trúc dự án

```
src/main/java/com/learnOw/server/
├── config/                 # Cấu hình (Security, OpenAPI)
├── dto/response/           # DTO dùng chung
├── exception/              # Exception handling
└── module/
    ├── auth/               # Authentication module
    │   ├── controller/
    │   ├── dto/
    │   │   ├── request/
    │   │   └── response/
    │   └── service/
    └── user/               # User module
        ├── dto/response/
        ├── mapper/
        ├── model/
        ├── repository/
        └── service/
```

## Build

```bash
./mvnw clean package
```

File JAR sẽ được tạo tại `target/server-0.0.1-SNAPSHOT.jar`

## Chạy Production

```bash
java -jar target/server-0.0.1-SNAPSHOT.jar
```

## License

MIT
