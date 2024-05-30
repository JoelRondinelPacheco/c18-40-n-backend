package com.example.demo.persistence.utils;

import java.util.Arrays;
import java.util.List;

public enum RoleEnum {
    USER(Arrays.asList(Permissions.READ, Permissions.COMMENT_EVENT)),
    ADMIN(Arrays.asList(Permissions.READ, Permissions.EDIT_EVENT, Permissions.COMMENT_EVENT, Permissions.CREATE_EVENT, Permissions.DELETE_EVENT));

    private List<Permissions> permissions;

    RoleEnum(List<Permissions> permissions) { this.permissions = permissions; }

    public List<Permissions> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }
}
