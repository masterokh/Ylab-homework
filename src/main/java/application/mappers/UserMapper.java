package application.mappers;

import application.dto.MeterReadingFullDTO;
import application.dto.UserFullDTO;
import application.models.MeterReadingImpl;
import application.models.User;
import java.util.List;
import java.util.stream.Collectors;
/**
 * The UserMapper class provides static methods for converting User and UserFullDTO objects.
 */
public class UserMapper {

    /**
     * Converts a User object to a UserFullDTO object.
     *
     * @param user The User object to convert.
     * @return The corresponding UserFullDTO object.
     */
    public static UserFullDTO toDto(User user) {
        if(user.getMeterReadingHistory()!= null){
            List<MeterReadingFullDTO> meterReadingDTOs = user.getMeterReadingHistory().stream()
                    .map(MeterReadingImpl::toDto)
                    .collect(Collectors.toList());

            return new UserFullDTO(user.getUsername(), user.getPassword(), meterReadingDTOs);
        }

        return new UserFullDTO(user.getUsername(), user.getPassword());
    }

    /**
     * Converts a UserFullDTO object to a User object.
     *
     * @param dto The UserFullDTO object to convert.
     * @return The corresponding User object.
     */
    public static User toUser(UserFullDTO dto) {
        User user = new User(dto.getUsername(), dto.getPassword());

        if (dto.getMeterReadingHistory() != null) {
            List<MeterReadingImpl> meterReadingList = dto.getMeterReadingHistory().stream()
                    .map(MeterReadingFullDTO::toMeterReadingImpl)
                    .collect(Collectors.toList());

            for (MeterReadingImpl meterReading : meterReadingList) {
                user.addMeterReading(meterReading);
            }
        }

        return user;
    }
}

