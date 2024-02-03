package application.mappers;

import application.dto.AdminFullDTO;
import application.models.Admin;

/**
 * The AdminMapper class provides static methods for converting Admin and AdminFullDTO objects.
 */
public class AdminMapper {

    /**
     * Converts an Admin object to an AdminFullDTO object.
     *
     * @param admin The Admin object to convert.
     * @return The corresponding AdminFullDTO object.
     */
    public static AdminFullDTO toDto(Admin admin) {
        AdminFullDTO dto = new AdminFullDTO(admin.getUsername(), admin.getPassword());
        return dto;
    }

    /**
     * Converts an AdminFullDTO object to an Admin object.
     *
     * @param dto The AdminFullDTO object to convert.
     * @return The corresponding Admin object.
     */
    public static Admin toAdmin(AdminFullDTO dto) {
        Admin admin = new Admin(dto.getUsername(), dto.getPassword());
        return admin;
    }
}
