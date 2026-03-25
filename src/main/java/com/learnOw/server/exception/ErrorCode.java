package com.learnOw.server.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Lỗi chưa xác định", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXISTED(1001, "Người dùng đã tồn tại", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1002, "Người dùng không tồn tại", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1003, "Chưa đăng nhập hoặc token không hợp lệ", HttpStatus.UNAUTHORIZED),
    INVALID_INPUT(1004, "Dữ liệu nhập vào không hợp lệ", HttpStatus.BAD_REQUEST),
    INVALID_KEY(1005, "Mã lỗi không hợp lệ", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1006, "Mật khẩu không chính xác", HttpStatus.BAD_REQUEST)
    ;

    private int code;
    private String message;
    private HttpStatus statusCode;

    ErrorCode(int code, String message, HttpStatus statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}