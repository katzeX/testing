package com.internship.bookstore.model.enums;

import lombok.Getter;

public enum Role {
    ACTIVE("Active"),
    BLOCKED("Blocked");

    @Getter
    private final String value;

    Role(String value) {
        this.value = value;
    }
}