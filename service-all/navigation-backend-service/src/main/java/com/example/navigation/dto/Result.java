package com.example.navigation.dto;

public record Result<T>(
        Integer code,
        String message,
        T data) {
    private static final Integer SUCCESS_CODE = 200;
    private static final Integer FAIL_CODE = 500;

    private static final String SUCCESS_MESSAGE = "success";
    private static final String FAIL_MESSAGE = "fail";

    public static <T> Result<T> success() {
        return new Result<>(SUCCESS_CODE, SUCCESS_MESSAGE, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<T>(SUCCESS_CODE, message, data);
    }

    public static Result<Void> fail() {
        return new Result<Void>(FAIL_CODE, FAIL_MESSAGE, null);
    }

    public static Result<Void> fail(String message) {
        return new Result<Void>(FAIL_CODE, message, null);
    }

    public static Result<Void> fail(Integer code, String message) {
        return new Result<Void>(code, message, null);
    }

    public static <T> Result<T> fail(Integer code, String message, T data) {
        return new Result<T>(code, message, data);
    }
}
