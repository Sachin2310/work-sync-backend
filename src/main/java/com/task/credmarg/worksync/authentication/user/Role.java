package com.task.credmarg.worksync.authentication.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER("user"),
    ADMIN("admin");
    private final String value;

    Role(String value) {
        this.value = value;
    }

    public Role fromValue(String value) {
        for (Role role : Role.values()) {
            if (role.value.equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid Role type: " + value);
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
