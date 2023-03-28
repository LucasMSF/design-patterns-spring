package br.lucasdev.designpatterns.exceptions;

import java.util.Date;

public class ControllerExceptionHandler {
    private Date timestamp;
    private Integer code;
    private String message;

    public ControllerExceptionHandler(Integer code, String message) {
        this.timestamp = new Date();
        this.code = code;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
