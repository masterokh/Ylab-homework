package application.dto;

import application.models.Role;

public class RoleDTO {
    private final String role;

    public RoleDTO(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public Role toRole() {
        return new Role(role);
    }
}
