import application.dto.AdminFullDTO;
import application.dto.UserFullDTO;
import application.services.SetOfAllNamesOfMeterReadingService;
import application.services.SetOfAllNamesOfMeterReadingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for SetOfAllNamesOfMeterReadingService Implementations")
class SetOfAllNamesOfMeterReadingServiceTest {

    private SetOfAllNamesOfMeterReadingService setOfAllNamesService;

    @BeforeEach
    void setUp() {
        setOfAllNamesService = new SetOfAllNamesOfMeterReadingServiceImpl();
    }

    @Test
    @DisplayName("Test successful addition of a meter reading by an admin")
    void testAddMeterReading_Success_Admin() {
        // Arrange
        AdminFullDTO adminDTO = new AdminFullDTO("adminUser", "adminPassword");

        // Act
        setOfAllNamesService.addMeterReading(adminDTO, "electricity");

        // Assert
        Set<String> listOfNames = setOfAllNamesService.getListOfNamesOfMeterReadings();
        assertTrue(listOfNames.contains("electricity"));
    }

    @Test
    @DisplayName("Test failure of adding a meter reading by a user")
    void testAddMeterReading_Failure_User() {
        // Arrange
        UserFullDTO userDTO = new UserFullDTO("testUser", "password");

        // Act
        setOfAllNamesService.addMeterReading(userDTO, "water");

        // Assert
        Set<String> listOfNames = setOfAllNamesService.getListOfNamesOfMeterReadings();
        assertFalse(listOfNames.contains("water"));
    }

    @Test
    @DisplayName("Test successful retrieval of the list of meter reading names (empty list)")
    void testGetListOfNamesOfMeterReadings_Success_EmptyList() {
        // Act
        Set<String> listOfNames = setOfAllNamesService.getListOfNamesOfMeterReadings();

        // Assert
        assertNotNull(listOfNames);
        assertTrue(listOfNames.isEmpty());
    }
}
