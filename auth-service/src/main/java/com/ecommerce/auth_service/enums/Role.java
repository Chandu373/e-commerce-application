package com.ecommerce.auth_service.enums;

import javax.print.DocFlavor;

public enum Role {

    USER(1, "ROLE_USER"),
    ADMIN(2, "ROLE_ADMIN");

    int id;
    String name;

    Role(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
