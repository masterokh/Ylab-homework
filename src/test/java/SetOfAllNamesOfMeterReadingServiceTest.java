import application.dto.AdminFullDTO;
import application.dto.UserFullDTO;
import application.services.SetOfAllNamesOfMeterReadingService;
import application.services.SetOfAllNamesOfMeterReadingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the {@link SetOfAllNamesOfMeterReadingService} implementations.
 * It focuses on testing the addition of meter readings by admins and users,
 * as well as retrieving the list of meter reading names.
 */
class SetOfAllNamesOfMeterReadingServiceTest {

    /**
     * The instance of {@link SetOfAllNamesOfMeterReadingService} used for testing.
     */
    private SetOfAllNamesOfMeterReadingService setOfAllNamesService;

    /**
     * Sets up the test environment before each test method is executed.
     * Initializes the {@link #setOfAllNamesService} with a new instance of {@link SetOfAllNamesOfMeterReadingServiceImpl}.
     */
    @BeforeEach
    void setUp() {
        setOfAllNamesService = new SetOfAllNamesOfMeterReadingServiceImpl();
    }

    /**
     * Tests the successful addition of a meter reading by an admin.
     * Creates an {@link AdminFullDTO}, adds a meter reading using the {@link SetOfAllNamesOfMeterReadingService},
     * and asserts that the list of names contains the added meter reading.
     */
    @Test
    void testAddMeterReading_Success_Admin() {
        // Arrange
        AdminFullDTO adminDTO = new AdminFullDTO("adminUser", "adminPassword");

        // Act
        setOfAllNamesService.addMeterReading(adminDTO, "electricity");

        // Assert
        Set<String> listOfNames = setOfAllNamesService.getListOfNamesOfMeterReadings();
        assertTrue(listOfNames.contains("electricity"));
    }

    /**
     * Tests the failure of adding a meter reading by a user.
     * Creates a {@link UserFullDTO}, attempts to add a meter reading using the {@link SetOfAllNamesOfMeterReadingService},
     * and asserts that the list of names does not contain the attempted meter reading.
     */
    @Test
    void testAddMeterReading_Failure_User() {
        // Arrange
        UserFullDTO userDTO = new UserFullDTO("testUser", "password");

        // Act
        setOfAllNamesService.addMeterReading(userDTO, "water");

        // Assert
        Set<String> listOfNames = setOfAllNamesService.getListOfNamesOfMeterReadings();
        assertFalse(listOfNames.contains("water"));
    }

    /**
     * Tests the successful retrieval of the list of meter reading names.
     * Invokes the {@link SetOfAllNamesOfMeterReadingService#getListOfNamesOfMeterReadings()} method,
     * and asserts that the returned list is not null and empty.
     */
    @Test
    void testGetListOfNamesOfMeterReadings_Success_EmptyList() {
        // Act
        Set<String> listOfNames = setOfAllNamesService.getListOfNamesOfMeterReadings();

        // Assert
        assertNotNull(listOfNames);
        assertTrue(listOfNames.isEmpty());
    }
}

