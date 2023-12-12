package com.ecommerce.backendAtHiit.constant;

public enum AppConstant {
    SUCCESS("10","Login Successful"),
    FAILED("19","Email does not Exist"),
    UNAUTHORIZED("10","Incorrect email or password"),
    INCORRECT("11", "Password incorrect");

    public String message;
    public String status;

    AppConstant(String status, String message) {
        this.status=status;
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AppConstant{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
