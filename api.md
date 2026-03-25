# LearnOw API Design Document

## 1. API Response Format

### Success Response
```json
{
  "code": 1000,
  "message": "Thành công",
  "result": { ... }
}
```

### Error Response
```json
{
  "code": 1001,
  "message": "Mô tả lỗi"
}
```

---

## 2. Status Code Definition

### 2.1 Success Codes (1xxx)

| Code | Name | Message | HTTP Status |
|------|------|---------|-------------|
| 1000 | SUCCESS | Thành công | 200 OK |

### 2.2 User Errors (1xxx)

| Code | Name | Message | HTTP Status |
|------|------|---------|-------------|
| 1001 | USER_EXISTED | Người dùng đã tồn tại | 400 Bad Request |
| 1002 | USER_NOT_EXISTED | Người dùng không tồn tại | 404 Not Found |
| 1003 | UNAUTHENTICATED | Chưa đăng nhập hoặc token không hợp lệ | 401 Unauthorized |
| 1004 | INVALID_KEY | Mã lỗi không hợp lệ | 400 Bad Request |
| 1005 | INVALID_PASSWORD | Mật khẩu không đúng | 400 Bad Request |
| 1006 | ACCOUNT_LOCKED | Tài khoản đã bị khóa | 403 Forbidden |
| 1007 | ACCOUNT_BANNED | Tài khoản đã bị cấm | 403 Forbidden |
| 1008 | EMAIL_NOT_VERIFIED | Email chưa được xác thực | 403 Forbidden |
| 1009 | INVALID_TOKEN | Token không hợp lệ hoặc đã hết hạn | 401 Unauthorized |
| 1010 | PERMISSION_DENIED | Bạn không có quyền thực hiện hành động này | 403 Forbidden |

### 2.3 Validation Errors (2xxx)

| Code | Name | Message | HTTP Status |
|------|------|---------|-------------|
| 2001 | INVALID_EMAIL | Email không hợp lệ | 400 Bad Request |
| 2002 | INVALID_PASSWORD_FORMAT | Mật khẩu phải có ít nhất 6 ký tự | 400 Bad Request |
| 2003 | INVALID_PHONE | Số điện thoại không hợp lệ | 400 Bad Request |
| 2004 | REQUIRED_FIELD_MISSING | Thiếu trường bắt buộc | 400 Bad Request |
| 2005 | INVALID_INPUT | Dữ liệu đầu vào không hợp lệ | 400 Bad Request |
| 2006 | INVALID_DATE_FORMAT | Định dạng ngày không hợp lệ | 400 Bad Request |
| 2007 | INVALID_FILE_TYPE | Loại file không được hỗ trợ | 400 Bad Request |
| 2008 | FILE_TOO_LARGE | File quá lớn | 400 Bad Request |

### 2.4 Course Errors (3xxx)

| Code | Name | Message | HTTP Status |
|------|------|---------|-------------|
| 3001 | COURSE_NOT_FOUND | Khóa học không tồn tại | 404 Not Found |
| 3002 | COURSE_ALREADY_ENROLLED | Bạn đã đăng ký khóa học này | 400 Bad Request |
| 3003 | COURSE_NOT_ENROLLED | Bạn chưa đăng ký khóa học này | 400 Bad Request |
| 3004 | COURSE_NOT_PUBLISHED | Khóa học chưa được công bố | 400 Bad Request |
| 3005 | COURSE_FULL | Khóa học đã đầy | 400 Bad Request |
| 3006 | COURSE_EXPIRED | Khóa học đã hết hạn | 400 Bad Request |
| 3007 | LESSON_NOT_FOUND | Bài học không tồn tại | 404 Not Found |
| 3008 | LESSON_LOCKED | Bài học bị khóa, hãy hoàn thành bài trước | 403 Forbidden |
| 3009 | CHAPTER_NOT_FOUND | Chương không tồn tại | 404 Not Found |

### 2.5 Quiz/Assignment Errors (4xxx)

| Code | Name | Message | HTTP Status |
|------|------|---------|-------------|
| 4001 | QUIZ_NOT_FOUND | Bài kiểm tra không tồn tại | 404 Not Found |
| 4002 | QUIZ_ALREADY_SUBMITTED | Bạn đã nộp bài kiểm tra này | 400 Bad Request |
| 4003 | QUIZ_TIME_EXPIRED | Đã hết thời gian làm bài | 400 Bad Request |
| 4004 | ASSIGNMENT_NOT_FOUND | Bài tập không tồn tại | 404 Not Found |
| 4005 | ASSIGNMENT_DEADLINE_PASSED | Đã quá hạn nộp bài | 400 Bad Request |
| 4006 | QUESTION_NOT_FOUND | Câu hỏi không tồn tại | 404 Not Found |

### 2.6 Payment Errors (5xxx)

| Code | Name | Message | HTTP Status |
|------|------|---------|-------------|
| 5001 | PAYMENT_FAILED | Thanh toán thất bại | 400 Bad Request |
| 5002 | INSUFFICIENT_BALANCE | Số dư không đủ | 400 Bad Request |
| 5003 | ORDER_NOT_FOUND | Đơn hàng không tồn tại | 404 Not Found |
| 5004 | ORDER_ALREADY_PAID | Đơn hàng đã được thanh toán | 400 Bad Request |
| 5005 | COUPON_INVALID | Mã giảm giá không hợp lệ | 400 Bad Request |
| 5006 | COUPON_EXPIRED | Mã giảm giá đã hết hạn | 400 Bad Request |
| 5007 | COUPON_USAGE_LIMIT | Mã giảm giá đã hết lượt sử dụng | 400 Bad Request |

### 2.7 Category/Tag Errors (6xxx)

| Code | Name | Message | HTTP Status |
|------|------|---------|-------------|
| 6001 | CATEGORY_NOT_FOUND | Danh mục không tồn tại | 404 Not Found |
| 6002 | CATEGORY_ALREADY_EXISTS | Danh mục đã tồn tại | 400 Bad Request |
| 6003 | TAG_NOT_FOUND | Tag không tồn tại | 404 Not Found |

### 2.8 Notification/Comment Errors (7xxx)

| Code | Name | Message | HTTP Status |
|------|------|---------|-------------|
| 7001 | NOTIFICATION_NOT_FOUND | Thông báo không tồn tại | 404 Not Found |
| 7002 | COMMENT_NOT_FOUND | Bình luận không tồn tại | 404 Not Found |
| 7003 | REVIEW_NOT_FOUND | Đánh giá không tồn tại | 404 Not Found |
| 7004 | ALREADY_REVIEWED | Bạn đã đánh giá khóa học này | 400 Bad Request |

### 2.9 System Errors (9xxx)

| Code | Name | Message | HTTP Status |
|------|------|---------|-------------|
| 9999 | UNCATEGORIZED_EXCEPTION | Lỗi chưa xác định | 500 Internal Server Error |
| 9998 | DATABASE_ERROR | Lỗi cơ sở dữ liệu | 500 Internal Server Error |
| 9997 | EXTERNAL_SERVICE_ERROR | Lỗi dịch vụ bên ngoài | 502 Bad Gateway |
| 9996 | RATE_LIMIT_EXCEEDED | Vượt quá giới hạn request | 429 Too Many Requests |

---

## 3. API Endpoints

### 3.1 Authentication APIs

#### POST /api/auth/register
Đăng ký tài khoản mới

**Request:**
```json
{
  "email": "user@example.com",
  "password": "password123",
  "fullName": "Nguyễn Văn A",
  "phone": "0901234567"
}
```

**Response (Success):**
```json
{
  "code": 1000,
  "message": "Đăng ký thành công",
  "result": {
    "id": 1,
    "email": "user@example.com",
    "fullName": "Nguyễn Văn A",
    "phone": "0901234567",
    "status": "ACTIVE",
    "createdAt": "2026-03-23T10:00:00"
  }
}
```

#### POST /api/auth/login
Đăng nhập

**Request:**
```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

**Response (Success):**
```json
{
  "code": 1000,
  "message": "Đăng nhập thành công",
  "result": {
    "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "refreshToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "tokenType": "Bearer",
    "expiresIn": 3600,
    "user": {
      "id": 1,
      "email": "user@example.com",
      "fullName": "Nguyễn Văn A",
      "avatarUrl": null,
      "roles": ["STUDENT"]
    }
  }
}
```

#### POST /api/auth/refresh
Làm mới token

**Request:**
```json
{
  "refreshToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

#### POST /api/auth/logout
Đăng xuất

**Headers:** `Authorization: Bearer {accessToken}`

#### POST /api/auth/forgot-password
Quên mật khẩu

**Request:**
```json
{
  "email": "user@example.com"
}
```

#### POST /api/auth/reset-password
Đặt lại mật khẩu

**Request:**
```json
{
  "token": "reset_token_here",
  "newPassword": "newpassword123"
}
```

#### POST /api/auth/verify-email
Xác thực email

**Request:**
```json
{
  "token": "verification_token_here"
}
```

---

### 3.2 User APIs

#### GET /api/users/me
Lấy thông tin user hiện tại

**Headers:** `Authorization: Bearer {accessToken}`

**Response:**
```json
{
  "code": 1000,
  "result": {
    "id": 1,
    "email": "user@example.com",
    "fullName": "Nguyễn Văn A",
    "phone": "0901234567",
    "avatarUrl": "https://...",
    "bio": "Mô tả về tôi",
    "status": "ACTIVE",
    "emailVerifiedAt": "2026-03-23T10:00:00",
    "lastLoginAt": "2026-03-23T09:00:00",
    "createdAt": "2026-03-20T10:00:00",
    "roles": ["STUDENT"]
  }
}
```

#### PUT /api/users/me
Cập nhật thông tin user

**Headers:** `Authorization: Bearer {accessToken}`

**Request:**
```json
{
  "fullName": "Nguyễn Văn B",
  "phone": "0909876543",
  "bio": "Mô tả mới"
}
```

#### PUT /api/users/me/password
Đổi mật khẩu

**Request:**
```json
{
  "currentPassword": "oldpassword",
  "newPassword": "newpassword123"
}
```

#### PUT /api/users/me/avatar
Upload avatar

**Request:** `multipart/form-data`
- `file`: Image file (JPG, PNG, max 5MB)

#### GET /api/users/{id}
Lấy thông tin user công khai (cho instructor profile)

---

### 3.3 Course APIs

#### GET /api/courses
Danh sách khóa học

**Query Parameters:**
- `page` (default: 0)
- `size` (default: 10)
- `sort` (default: createdAt,desc)
- `categoryId` (optional)
- `level` (optional): BEGINNER, INTERMEDIATE, ADVANCED
- `priceMin` (optional)
- `priceMax` (optional)
- `search` (optional): keyword
- `instructorId` (optional)

**Response:**
```json
{
  "code": 1000,
  "result": {
    "content": [
      {
        "id": 1,
        "title": "Lập trình Java cơ bản",
        "slug": "lap-trinh-java-co-ban",
        "description": "Mô tả ngắn...",
        "thumbnailUrl": "https://...",
        "price": 500000,
        "discountPrice": 350000,
        "level": "BEGINNER",
        "duration": 1200,
        "totalLessons": 50,
        "totalStudents": 1200,
        "rating": 4.5,
        "totalReviews": 200,
        "instructor": {
          "id": 5,
          "fullName": "Trần Văn B",
          "avatarUrl": "https://..."
        },
        "category": {
          "id": 1,
          "name": "Lập trình"
        },
        "tags": ["java", "programming"],
        "status": "PUBLISHED",
        "createdAt": "2026-01-15T10:00:00"
      }
    ],
    "page": 0,
    "size": 10,
    "totalElements": 100,
    "totalPages": 10
  }
}
```

#### GET /api/courses/{id}
Chi tiết khóa học

**Response:**
```json
{
  "code": 1000,
  "result": {
    "id": 1,
    "title": "Lập trình Java cơ bản",
    "slug": "lap-trinh-java-co-ban",
    "description": "Mô tả chi tiết...",
    "thumbnailUrl": "https://...",
    "previewVideoUrl": "https://...",
    "price": 500000,
    "discountPrice": 350000,
    "level": "BEGINNER",
    "duration": 1200,
    "totalLessons": 50,
    "totalStudents": 1200,
    "rating": 4.5,
    "totalReviews": 200,
    "requirements": ["Biết sử dụng máy tính", "Không cần kinh nghiệm"],
    "whatYouWillLearn": ["Java cơ bản", "OOP", "Exception handling"],
    "instructor": {
      "id": 5,
      "fullName": "Trần Văn B",
      "avatarUrl": "https://...",
      "bio": "10 năm kinh nghiệm...",
      "totalCourses": 5,
      "totalStudents": 5000,
      "rating": 4.7
    },
    "category": {
      "id": 1,
      "name": "Lập trình",
      "parentId": null
    },
    "tags": ["java", "programming"],
    "chapters": [
      {
        "id": 1,
        "title": "Giới thiệu Java",
        "order": 1,
        "lessons": [
          {
            "id": 1,
            "title": "Java là gì?",
            "type": "VIDEO",
            "duration": 600,
            "order": 1,
            "isFree": true
          },
          {
            "id": 2,
            "title": "Cài đặt môi trường",
            "type": "VIDEO",
            "duration": 900,
            "order": 2,
            "isFree": false
          }
        ]
      }
    ],
    "status": "PUBLISHED",
    "createdAt": "2026-01-15T10:00:00",
    "updatedAt": "2026-03-20T10:00:00"
  }
}
```

#### GET /api/courses/slug/{slug}
Lấy khóa học theo slug

---

### 3.4 Enrollment APIs

#### POST /api/enrollments
Đăng ký khóa học

**Headers:** `Authorization: Bearer {accessToken}`

**Request:**
```json
{
  "courseId": 1,
  "couponCode": "SALE50"
}
```

**Response:**
```json
{
  "code": 1000,
  "message": "Đăng ký khóa học thành công",
  "result": {
    "id": 1,
    "courseId": 1,
    "userId": 1,
    "status": "ACTIVE",
    "progress": 0,
    "enrolledAt": "2026-03-23T10:00:00",
    "expiresAt": null
  }
}
```

#### GET /api/enrollments/my-courses
Danh sách khóa học đã đăng ký

**Query Parameters:**
- `page`, `size`
- `status`: ACTIVE, COMPLETED, EXPIRED

**Response:**
```json
{
  "code": 1000,
  "result": {
    "content": [
      {
        "id": 1,
        "course": {
          "id": 1,
          "title": "Lập trình Java cơ bản",
          "thumbnailUrl": "https://...",
          "totalLessons": 50
        },
        "progress": 45,
        "completedLessons": 23,
        "lastAccessedAt": "2026-03-22T15:00:00",
        "lastLesson": {
          "id": 23,
          "title": "Exception Handling"
        },
        "status": "ACTIVE",
        "enrolledAt": "2026-02-10T10:00:00"
      }
    ],
    "page": 0,
    "size": 10,
    "totalElements": 5,
    "totalPages": 1
  }
}
```

#### GET /api/enrollments/{courseId}/check
Kiểm tra đã đăng ký khóa học chưa

---

### 3.5 Lesson APIs

#### GET /api/courses/{courseId}/lessons/{lessonId}
Xem chi tiết bài học

**Headers:** `Authorization: Bearer {accessToken}` (required if not free lesson)

**Response:**
```json
{
  "code": 1000,
  "result": {
    "id": 1,
    "title": "Java là gì?",
    "type": "VIDEO",
    "content": "Nội dung bài học...",
    "videoUrl": "https://...",
    "duration": 600,
    "order": 1,
    "isFree": true,
    "resources": [
      {
        "id": 1,
        "name": "Slide bài giảng",
        "url": "https://...",
        "type": "PDF"
      }
    ],
    "nextLesson": {
      "id": 2,
      "title": "Cài đặt môi trường"
    },
    "prevLesson": null
  }
}
```

#### POST /api/courses/{courseId}/lessons/{lessonId}/complete
Đánh dấu hoàn thành bài học

**Headers:** `Authorization: Bearer {accessToken}`

#### GET /api/courses/{courseId}/progress
Lấy tiến độ học của khóa học

---

### 3.6 Quiz APIs

#### GET /api/courses/{courseId}/quizzes/{quizId}
Lấy thông tin quiz

**Response:**
```json
{
  "code": 1000,
  "result": {
    "id": 1,
    "title": "Kiểm tra chương 1",
    "description": "Kiểm tra kiến thức cơ bản",
    "timeLimit": 1800,
    "totalQuestions": 20,
    "passingScore": 70,
    "maxAttempts": 3,
    "attemptCount": 1,
    "bestScore": 85,
    "status": "AVAILABLE"
  }
}
```

#### POST /api/courses/{courseId}/quizzes/{quizId}/start
Bắt đầu làm quiz

**Response:**
```json
{
  "code": 1000,
  "result": {
    "attemptId": 1,
    "startedAt": "2026-03-23T10:00:00",
    "endsAt": "2026-03-23T10:30:00",
    "questions": [
      {
        "id": 1,
        "order": 1,
        "content": "Java là ngôn ngữ lập trình?",
        "type": "SINGLE_CHOICE",
        "options": [
          {"id": 1, "content": "Biên dịch"},
          {"id": 2, "content": "Thông dịch"},
          {"id": 3, "content": "Lai (vừa biên dịch vừa thông dịch)"},
          {"id": 4, "content": "Không phải các đáp án trên"}
        ]
      }
    ]
  }
}
```

#### POST /api/courses/{courseId}/quizzes/{quizId}/submit
Nộp bài quiz

**Request:**
```json
{
  "attemptId": 1,
  "answers": [
    {"questionId": 1, "selectedOptions": [3]},
    {"questionId": 2, "selectedOptions": [1, 2]}
  ]
}
```

**Response:**
```json
{
  "code": 1000,
  "result": {
    "attemptId": 1,
    "score": 85,
    "totalQuestions": 20,
    "correctAnswers": 17,
    "passed": true,
    "timeTaken": 1500,
    "submittedAt": "2026-03-23T10:25:00"
  }
}
```

---

### 3.7 Review APIs

#### GET /api/courses/{courseId}/reviews
Danh sách đánh giá

**Query Parameters:**
- `page`, `size`
- `rating`: 1-5

**Response:**
```json
{
  "code": 1000,
  "result": {
    "summary": {
      "averageRating": 4.5,
      "totalReviews": 200,
      "distribution": {
        "5": 120,
        "4": 50,
        "3": 20,
        "2": 5,
        "1": 5
      }
    },
    "content": [
      {
        "id": 1,
        "rating": 5,
        "comment": "Khóa học rất hay...",
        "user": {
          "id": 10,
          "fullName": "Nguyễn A",
          "avatarUrl": "https://..."
        },
        "createdAt": "2026-03-20T10:00:00",
        "updatedAt": null
      }
    ],
    "page": 0,
    "size": 10,
    "totalElements": 200,
    "totalPages": 20
  }
}
```

#### POST /api/courses/{courseId}/reviews
Tạo đánh giá mới

**Headers:** `Authorization: Bearer {accessToken}`

**Request:**
```json
{
  "rating": 5,
  "comment": "Khóa học rất hay, giảng viên nhiệt tình"
}
```

#### PUT /api/courses/{courseId}/reviews/{reviewId}
Cập nhật đánh giá

#### DELETE /api/courses/{courseId}/reviews/{reviewId}
Xóa đánh giá

---

### 3.8 Comment/Discussion APIs

#### GET /api/courses/{courseId}/lessons/{lessonId}/comments
Danh sách bình luận của bài học

**Query Parameters:**
- `page`, `size`

**Response:**
```json
{
  "code": 1000,
  "result": {
    "content": [
      {
        "id": 1,
        "content": "Bài học rất dễ hiểu",
        "user": {
          "id": 10,
          "fullName": "Nguyễn A",
          "avatarUrl": "https://..."
        },
        "replies": [
          {
            "id": 2,
            "content": "Cảm ơn bạn!",
            "user": {
              "id": 5,
              "fullName": "Trần Văn B",
              "avatarUrl": "https://..."
            },
            "createdAt": "2026-03-21T11:00:00"
          }
        ],
        "createdAt": "2026-03-21T10:00:00"
      }
    ],
    "page": 0,
    "size": 10,
    "totalElements": 50,
    "totalPages": 5
  }
}
```

#### POST /api/courses/{courseId}/lessons/{lessonId}/comments
Tạo bình luận

**Request:**
```json
{
  "content": "Bài học rất hay!",
  "parentId": null
}
```

---

### 3.9 Category APIs

#### GET /api/categories
Danh sách danh mục

**Response:**
```json
{
  "code": 1000,
  "result": [
    {
      "id": 1,
      "name": "Lập trình",
      "slug": "lap-trinh",
      "icon": "code",
      "courseCount": 150,
      "children": [
        {
          "id": 2,
          "name": "Web Development",
          "slug": "web-development",
          "courseCount": 80
        },
        {
          "id": 3,
          "name": "Mobile Development",
          "slug": "mobile-development",
          "courseCount": 45
        }
      ]
    }
  ]
}
```

---

### 3.10 Payment/Order APIs

#### POST /api/orders
Tạo đơn hàng

**Headers:** `Authorization: Bearer {accessToken}`

**Request:**
```json
{
  "courseId": 1,
  "couponCode": "SALE50"
}
```

**Response:**
```json
{
  "code": 1000,
  "result": {
    "id": 1,
    "orderCode": "ORD-20260323-001",
    "courseId": 1,
    "originalPrice": 500000,
    "discountAmount": 150000,
    "finalPrice": 350000,
    "couponCode": "SALE50",
    "status": "PENDING",
    "paymentUrl": "https://payment.vnpay.vn/...",
    "expiresAt": "2026-03-23T11:00:00",
    "createdAt": "2026-03-23T10:00:00"
  }
}
```

#### GET /api/orders/{orderCode}
Lấy thông tin đơn hàng

#### GET /api/orders/my-orders
Lịch sử đơn hàng

#### POST /api/payments/vnpay/callback
VNPay callback (webhook)

#### POST /api/payments/momo/callback
MoMo callback (webhook)

---

### 3.11 Notification APIs

#### GET /api/notifications
Danh sách thông báo

**Headers:** `Authorization: Bearer {accessToken}`

**Query Parameters:**
- `page`, `size`
- `isRead`: true/false

**Response:**
```json
{
  "code": 1000,
  "result": {
    "unreadCount": 5,
    "content": [
      {
        "id": 1,
        "title": "Khóa học mới",
        "message": "Khóa học Java nâng cao đã được cập nhật",
        "type": "COURSE_UPDATE",
        "data": {
          "courseId": 1
        },
        "isRead": false,
        "createdAt": "2026-03-23T09:00:00"
      }
    ],
    "page": 0,
    "size": 10,
    "totalElements": 20,
    "totalPages": 2
  }
}
```

#### PUT /api/notifications/{id}/read
Đánh dấu đã đọc

#### PUT /api/notifications/read-all
Đánh dấu tất cả đã đọc

---

### 3.12 Instructor APIs (Teacher Role)

#### GET /api/instructor/courses
Danh sách khóa học của instructor

#### POST /api/instructor/courses
Tạo khóa học mới

**Request:**
```json
{
  "title": "Lập trình Java nâng cao",
  "description": "Mô tả chi tiết...",
  "categoryId": 1,
  "level": "ADVANCED",
  "price": 800000,
  "requirements": ["Biết Java cơ bản"],
  "whatYouWillLearn": ["Design patterns", "Multithreading"],
  "tags": ["java", "advanced"]
}
```

#### PUT /api/instructor/courses/{id}
Cập nhật khóa học

#### DELETE /api/instructor/courses/{id}
Xóa khóa học

#### POST /api/instructor/courses/{courseId}/chapters
Tạo chương mới

#### POST /api/instructor/courses/{courseId}/chapters/{chapterId}/lessons
Tạo bài học mới

#### PUT /api/instructor/courses/{id}/publish
Công bố khóa học

#### GET /api/instructor/analytics
Thống kê instructor

**Response:**
```json
{
  "code": 1000,
  "result": {
    "totalCourses": 5,
    "totalStudents": 1200,
    "totalRevenue": 50000000,
    "averageRating": 4.7,
    "monthlyStats": [
      {
        "month": "2026-03",
        "enrollments": 150,
        "revenue": 7500000
      }
    ]
  }
}
```

---

### 3.13 Admin APIs

#### GET /api/admin/users
Danh sách users (Admin only)

**Query Parameters:**
- `page`, `size`
- `status`: ACTIVE, BANNED
- `role`: STUDENT, INSTRUCTOR, ADMIN
- `search`: keyword

#### PUT /api/admin/users/{id}/ban
Ban user

#### PUT /api/admin/users/{id}/unban
Unban user

#### PUT /api/admin/users/{id}/roles
Gán role cho user

**Request:**
```json
{
  "roles": ["INSTRUCTOR"]
}
```

#### GET /api/admin/courses
Quản lý khóa học

#### PUT /api/admin/courses/{id}/approve
Duyệt khóa học

#### PUT /api/admin/courses/{id}/reject
Từ chối khóa học

#### GET /api/admin/dashboard
Dashboard thống kê

**Response:**
```json
{
  "code": 1000,
  "result": {
    "totalUsers": 10000,
    "totalCourses": 500,
    "totalRevenue": 500000000,
    "newUsersToday": 50,
    "newEnrollmentsToday": 100,
    "revenueToday": 5000000,
    "topCourses": [...],
    "topInstructors": [...],
    "recentOrders": [...]
  }
}
```

---

## 4. Database Schema Overview

### Core Tables
- `users` - Thông tin người dùng
- `roles` - Vai trò (STUDENT, INSTRUCTOR, ADMIN)
- `user_roles` - Phân quyền user

### Course Module
- `categories` - Danh mục khóa học
- `courses` - Khóa học
- `chapters` - Chương
- `lessons` - Bài học
- `lesson_resources` - Tài nguyên bài học

### Enrollment Module
- `enrollments` - Đăng ký khóa học
- `lesson_progress` - Tiến độ học

### Quiz Module
- `quizzes` - Bài kiểm tra
- `questions` - Câu hỏi
- `question_options` - Đáp án
- `quiz_attempts` - Lượt làm bài
- `quiz_answers` - Câu trả lời

### Payment Module
- `orders` - Đơn hàng
- `payments` - Thanh toán
- `coupons` - Mã giảm giá

### Interaction Module
- `reviews` - Đánh giá
- `comments` - Bình luận
- `notifications` - Thông báo

---

## 5. Authentication Flow

### JWT Token Flow
1. User đăng nhập với email/password
2. Server xác thực và trả về `accessToken` + `refreshToken`
3. Client gửi `accessToken` trong header `Authorization: Bearer {token}`
4. Khi `accessToken` hết hạn, dùng `refreshToken` để lấy token mới
5. Khi `refreshToken` hết hạn, user phải đăng nhập lại

### Token Configuration
- `accessToken`: expires in 1 hour
- `refreshToken`: expires in 7 days

---

## 6. Role-Based Access Control (RBAC)

| Endpoint Pattern | STUDENT | INSTRUCTOR | ADMIN |
|------------------|---------|------------|-------|
| /api/auth/** | ✓ | ✓ | ✓ |
| /api/courses (GET) | ✓ | ✓ | ✓ |
| /api/enrollments/** | ✓ | ✓ | ✓ |
| /api/instructor/** | ✗ | ✓ | ✓ |
| /api/admin/** | ✗ | ✗ | ✓ |

---

## 7. Pagination Response Format

```json
{
  "content": [...],
  "page": 0,
  "size": 10,
  "totalElements": 100,
  "totalPages": 10,
  "first": true,
  "last": false
}
```

---

## 8. Common Headers

| Header | Description | Required |
|--------|-------------|----------|
| `Authorization` | Bearer token for authentication | For protected endpoints |
| `Content-Type` | application/json | For POST/PUT requests |
| `Accept-Language` | vi, en | Optional (default: vi) |
