package org.codekage.pma.model;

public class ResponseObject<T> {
    private String message;
    private T data;
    private boolean success;

    public ResponseObject() {
    }

    public ResponseObject(String message, T data, boolean success) {
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public ResponseObject(String message) {
        this.message = message;
    }

    public ResponseObject(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public ResponseObject<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseObject<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
