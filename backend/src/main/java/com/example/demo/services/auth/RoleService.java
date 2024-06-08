package com.example.demo.services.auth;

import com.example.demo.persistence.entities.Role;

public interface RoleService {
    Role getByName(String name);
}
