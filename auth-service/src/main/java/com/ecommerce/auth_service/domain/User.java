package com.ecommerce.auth_service.domain;

import com.ecommerce.auth_service.enums.Role;
import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String email;
    private String mobile;
    private Role roles;
}
