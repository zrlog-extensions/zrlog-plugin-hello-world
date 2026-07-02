package com.zrlog.plugin.helloworld.controller;

public class HelloWorldApiResponse<T> {

    private boolean success;
    private T data;

    public HelloWorldApiResponse() {
    }

    private HelloWorldApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public static HelloWorldApiResponse<Void> success() {
        return new HelloWorldApiResponse<Void>(true, null);
    }

    public static <T> HelloWorldApiResponse<T> success(T data) {
        return new HelloWorldApiResponse<T>(true, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
