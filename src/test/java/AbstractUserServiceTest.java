import application.dto.AdminFullDTO;
import application.dto.MeterReadingFullDTO;
import application.dto.UserFullDTO;
import application.services.AbstractUserService;
import application.services.AbstractUserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for AbstractUserService Implementations")
public class AbstractUserServiceTest {

    private AbstractUserService userService;

    @BeforeEach
    public void setUp() {
        userService = new AbstractUserServiceImpl();
    }

    @Test
    @DisplayName("Test successful registration of a user")
    public void testRegisterUser_Success() {
        // Arrange
        UserFullDTO userDTO = new UserFullDTO("testUser", "password");

        // Act
        userService.registerAbstractUser(userDTO);

        // Assert
        assertTrue(userService.abstractUserIsAvailable(userDTO));
    }

    @Test
    @DisplayName("Test successful registration of a new admin")
    public void testRegisterNewAdmin_Success() {
        // Arrange
        String adminUsername = "admin";
        String adminPassword = "adminPass";

        // Act
        userService.registerNewAdmin(adminUsername, adminPassword);

        // Assert
        assertTrue(userService.abstractUserIsAvailable(new AdminFullDTO(adminUsername, adminPassword)));
    }

    @Test
    @DisplayName("Test user login with invalid credentials")
    public void testLoginUser_InvalidCredentials() {
        // Arrange
        UserFullDTO userDTO = new UserFullDTO("testUser", "password");
        userService.registerAbstractUser(userDTO);

        // Act
        userService.loginUser(userDTO.getUsername(), "wrongPassword");

        // Assert
        assertFalse(userDTO.getIsLogin());
    }

    @Test
    @DisplayName("Test successful logout of a user")
    public void testLogOut_Success() {
        // Arrange
        UserFullDTO userDTO = new UserFullDTO("testUser", "password");
        userService.registerAbstractUser(userDTO);

        // Act
        userService.logOut(userDTO.getUsername());

        // Assert
        assertFalse(userDTO.getIsLogin());
    }

    @Test
    @DisplayName("Test successful submission of a meter reading by a user")
    public void testSubmitMeterReading_Success() {
        // Arrange
        UserFullDTO userDTO = new UserFullDTO("testUser", "password");
        userService.registerAbstractUser(userDTO);
        MeterReadingFullDTO meterReadingDTO = new MeterReadingFullDTO(1, 2024);

        // Act
        userService.submitMeterReading(userDTO, meterReadingDTO);

        // Assert
        assertEquals(1, userService.viewMeterReadingHistory(userDTO).size());
    }
}
