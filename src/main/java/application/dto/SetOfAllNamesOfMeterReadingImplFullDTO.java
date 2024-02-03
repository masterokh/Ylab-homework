package application.dto;

import application.models.SetOfAllNamesOfMeterReadingImpl;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The SetOfAllNamesOfMeterReadingImplFullDTO class represents a data transfer object (DTO) for
 * a set of names of meter readings. It implements the SetOfAllNamesOfMeterReading interface and
 * provides methods to add meter readings individually or as a set, and to retrieve the list of names
 * of meter readings.
 */
public class SetOfAllNamesOfMeterReadingImplFullDTO {

    private Set<String> listOfNamesOfMeterReadings;

    /**
     * Constructs a new SetOfAllNamesOfMeterReadingImplFullDTO with an initial list of names.
     *
     * @param listOfNamesOfMeterReadings The initial list of names of meter readings.
     */
    public SetOfAllNamesOfMeterReadingImplFullDTO(LinkedHashSet<String> listOfNamesOfMeterReadings) {
        this.listOfNamesOfMeterReadings = listOfNamesOfMeterReadings;
    }

    /**
     * Constructs a new SetOfAllNamesOfMeterReadingImplFullDTO with an empty list of names.
     */
    public SetOfAllNamesOfMeterReadingImplFullDTO() {
        listOfNamesOfMeterReadings = new LinkedHashSet<>();
    }

    /**
     * Gets the list of names of meter readings.
     *
     * @return The set of names of meter readings.
     */
    public Set<String> getListOfNamesOfMeterReadings() {
        return listOfNamesOfMeterReadings;
    }
    /**
     * Converts SetOfAllNamesOfMeterReadingImplFullDTO to SetOfAllNamesOfMeterReadingImpl.
     *
     * @return SetOfAllNamesOfMeterReadingImpl object.
     */
    public SetOfAllNamesOfMeterReadingImpl toSetOfAllNamesOfMeterReadingImpl() {
        SetOfAllNamesOfMeterReadingImpl setOfAllNames = new SetOfAllNamesOfMeterReadingImpl((LinkedHashSet<String>) this.listOfNamesOfMeterReadings);
        return setOfAllNames;
    }
}
