package com.helloworld.bootrest.dto;

public class AddResponse {
    private int result;

    public AddResponse() {
    }

    public AddResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}


