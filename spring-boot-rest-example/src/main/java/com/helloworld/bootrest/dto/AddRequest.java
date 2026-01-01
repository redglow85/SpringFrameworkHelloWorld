package com.helloworld.bootrest.dto;

public class AddRequest {
    private int a;
    private int b;

    public AddRequest() {
    }

    public AddRequest(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}


