package com.gamux.website_api.domain.gamux_project.enums;

public enum MemberRole {
    LEADER(3),
    ADMIN(2),
    MEMBER(1),
    VIEWER(0);

    private int level;

    MemberRole(int level) {
        this.level = level;
    }

    public int getRole() {
        return level;
    }

    public boolean isAtLeast(MemberRole required) {
        return this.level >= required.level;
    }
}
