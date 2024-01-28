package application.in;

import application.dto.AbstractUserFullDTO;
import application.services.SetOfAllNamesOfMeterReadingService;

import java.util.Set;

/**
 * Implementation of the input port for managing all names of meter readings.
 * Acts as a boundary between the application's business logic and user interactions.
 */
public class AllNamesOfMeterReadingInputPortImpl implements AllNamesOfMeterReadingInputPort {

    private SetOfAllNamesOfMeterReadingService setOfAllNamesOfMeterReadingService;

    /**
     * Constructs an instance of AllNamesOfMeterReadingInputPortImpl.
     *
     * @param setOfAllNamesOfMeterReadingService The service responsible for managing all names of meter readings.
     */
    public AllNamesOfMeterReadingInputPortImpl(SetOfAllNamesOfMeterReadingService setOfAllNamesOfMeterReadingService) {
        this.setOfAllNamesOfMeterReadingService = setOfAllNamesOfMeterReadingService;
    }

    /**
     * Adds a new meter reading to the set of all names for admin users.
     *
     * @param abstractUserFullDTO The user for whom the meter reading is being added.
     * @param newMeterReading      The name of the new meter reading.
     */
    @Override
    public void addMeterReading(AbstractUserFullDTO abstractUserFullDTO, String newMeterReading) {
        setOfAllNamesOfMeterReadingService.addMeterReading(abstractUserFullDTO, newMeterReading);
    }

    /**
     * Retrieves the set of all names of meter readings.
     *
     * @return A set containing all names of meter readings in the system.
     */
    @Override
    public Set<String> getListOfNamesOfMeterReadings() {
        return setOfAllNamesOfMeterReadingService.getListOfNamesOfMeterReadings();
    }
}
