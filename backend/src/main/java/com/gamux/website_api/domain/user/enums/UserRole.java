package com.gamux.website_api.domain.user.enums;

public enum UserRole {
    ADMIN("admin"),
    STAFF("staff"),
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
