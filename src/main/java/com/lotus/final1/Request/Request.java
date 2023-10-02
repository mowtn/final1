package com.lotus.final1.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request<T> {
    private String error;
    private int Status;
    private T data;

    public Request(String error, int status, T data) {
        this.error = error;
        Status = status;
        this.data = data;
    }
}
