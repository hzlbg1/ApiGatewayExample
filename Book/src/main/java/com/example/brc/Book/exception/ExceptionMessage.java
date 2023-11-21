package com.example.brc.Book.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class ExceptionMessage {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ExceptionMessage() {
        timestamp = new Date();
    }

    public ExceptionMessage(HttpStatus httpStatus, String message) {
        this();
        this.status = httpStatus.value();
        this.error = httpStatus.name();
        this.message = message;
    }

    public ExceptionMessage(HttpStatus httpStatus, String message, String path) {
        this(httpStatus, message);
        this.error = httpStatus.name();
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
