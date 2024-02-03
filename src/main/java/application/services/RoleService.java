package application.services;

import application.dto.RoleDTO;
import application.models.Role;

import java.util.Set;
import java.util.stream.Collectors;

public class RoleService {
    private Set<Role> roles;

    public RoleService(Set<RoleDTO> roleDTOs) {
        this.roles = roleDTOs.stream()
                .map(RoleDTO::toRole)
                .collect(Collectors.toSet());
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
