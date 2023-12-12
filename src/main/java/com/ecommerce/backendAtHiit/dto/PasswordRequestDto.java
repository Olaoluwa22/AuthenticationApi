package com.ecommerce.backendAtHiit.dto;

public class PasswordRequestDto {
    private String email;
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String firstname) {
        this.email = email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    @Override
    public String toString() {
        return "PasswordResetDto{" +
                "email='" + email + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", confirmNewPassword='"+ confirmNewPassword+
                '}';
    }
}