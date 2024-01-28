import application.dto.AdminFullDTO;
import application.dto.MeterReadingFullDTO;
import application.dto.UserFullDTO;
import application.services.AbstractUserService;
import application.services.AbstractUserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the {@link AbstractUserService} implementations.
 * It focuses on testing user registration, login, meter reading submission, and related operations.
 */
public class AbstractUserServiceTest {

    /**
     * The instance of {@link AbstractUserService} used for testing.
     */
    private AbstractUserService userService;

    /**
     * Sets up the test environment before each test method is executed.
     * Initializes the {@link #userService} with a new instance of {@link AbstractUserServiceImpl}.
     */
    @BeforeEach
    public void setUp() {
        userService = new AbstractUserServiceImpl();
    }

    /**
     * Tests the successful registration of a user.
     * Creates a {@link UserFullDTO}, registers it using the {@link AbstractUserService},
     * and asserts that the user is available in the system.
     */
    @Test
    public void testRegisterUser_Success() {
        // Arrange
        UserFullDTO userDTO = new UserFullDTO("testUser", "password");

        // Act
        userService.registerAbstractUser(userDTO);

        // Assert
        assertTrue(userService.abstractUserIsAvailable(userDTO));
    }

    /**
     * Tests the successful registration of a new admin.
     * Registers a new admin using the {@link AbstractUserService} and asserts
     * that the admin is available in the system.
     */
    @Test
    public void testRegisterNewAdmin_Success() {
        // Arrange
        String adminUsername = "admin";
        String adminPassword = "adminPass";

        // Act
        userService.registerNewAdmin(adminUsername, adminPassword);

        // Assert
        assertTrue(userService.abstractUserIsAvailable(new AdminFullDTO(adminUsername, adminPassword)));
    }

    /**
     * Tests the behavior when a user tries to log in with invalid credentials.
     * Registers a user, attempts to log in with incorrect credentials, and asserts
     * that the user's login status is false.
     */
    @Test
    public void testLoginUser_InvalidCredentials() {
        // Arrange
        UserFullDTO userDTO = new UserFullDTO("testUser", "password");
        userService.registerAbstractUser(userDTO);

        // Act
        userService.loginUser(userDTO.getUsername(), "wrongPassword");

        // Assert
        assertFalse(userDTO.getIsLogin());
    }

    /**
     * Tests the successful logout of a user.
     * Registers a user, logs them in, logs them out, and asserts that the user's login status is false.
     */
    @Test
    public void testLogOut_Success() {
        // Arrange
        UserFullDTO userDTO = new UserFullDTO("testUser", "password");
        userService.registerAbstractUser(userDTO);

        // Act
        userService.logOut(userDTO.getUsername());

        // Assert
        assertFalse(userDTO.getIsLogin());
    }

    /**
     * Tests the successful submission of a meter reading by a user.
     * Registers a user, submits a meter reading, and asserts that the user's
     * meter reading history has the expected size.
     */
    @Test
    public void testSubmitMeterReading_Success() {
        // Arrange
        UserFullDTO userDTO = new UserFullDTO("testUser", "password");
        userService.registerAbstractUser(userDTO);
        MeterReadingFullDTO meterReadingDTO = new MeterReadingFullDTO(1, 2024);

        // Act
        userService.submitMeterReading(userDTO, meterReadingDTO);

        // Assert
        assertEquals(1, userDTO.getMeterReadingHistory().size());
    }
}
