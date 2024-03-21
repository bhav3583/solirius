package org.technical.constants;

public enum HttpStatusCode {
    OK(200),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500),
    CREATED(201);

    private final int code;

    HttpStatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
