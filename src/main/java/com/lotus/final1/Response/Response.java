package com.lotus.final1.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    private String error;
    private int Status;
    private T data;

    public Response(String error, int status, T data) {
        this.error = error;
        Status = status;
        this.data = data;
    }
}
