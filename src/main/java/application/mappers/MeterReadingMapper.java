package application.mappers;

import application.dto.MeterReadingFullDTO;
import application.models.MeterReadingImpl;
import java.util.HashMap;

/**
 * The MeterReadingMapper class provides methods for mapping between MeterReadingFullDTO and MeterReadingImpl.
 */
public class MeterReadingMapper {

    /**
     * Converts MeterReadingFullDTO to MeterReadingImpl.
     *
     * @param dto The MeterReadingFullDTO to be converted.
     * @return The MeterReadingImpl object.
     */
    public static MeterReadingImpl toMeterReadingImpl(MeterReadingFullDTO dto) {
        MeterReadingImpl meterReading = new MeterReadingImpl(dto.getMonth(), dto.getYear());
        meterReading.initializeReadings(new HashMap<>(dto.getReadings()));
        return meterReading;
    }

    /**
     * Converts MeterReadingImpl to MeterReadingFullDTO.
     *
     * @param meterReading The MeterReadingImpl to be converted.
     * @return The MeterReadingFullDTO object.
     */
    public static MeterReadingFullDTO toDto(MeterReadingImpl meterReading) {
        MeterReadingFullDTO dto = new MeterReadingFullDTO(meterReading.getMonth(), meterReading.getYear());
        dto.setReadings(new HashMap<>(meterReading.getReadings()));
        return dto;
    }
}
