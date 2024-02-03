package application.controllers;

import application.dto.AbstractUserFullDTO;
import application.dto.MeterReadingFullDTO;
import application.models.AbstractUser;
import application.models.MeterReadingImpl;
import application.services.AbstractUserService;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the {@link UserController} interface.
 * Acts as an intermediary between the application's business logic and user input.
 */
public class UserControllerImpl implements UserController {

    /**
     * The underlying service that provides user-related functionality.
     */
    private AbstractUserService abstractUserService;

    /**
     * Constructs a new instance of {@code UserInputPortImpl} with the specified {@link AbstractUserService}.
     *
     * @param abstractUserService The service handling user-related operations.
     */
    public UserControllerImpl(AbstractUserService abstractUserService) {
        this.abstractUserService = abstractUserService;
    }

    @Override
    public Map<String, AbstractUser> getUsers() {
        return abstractUserService.getUsers();
    }

    @Override
    public <T extends AbstractUserFullDTO> void registerAbstractUser(T userDTO) {
        abstractUserService.registerAbstractUser(userDTO);
    }

    @Override
    public void registerNewAdmin(String username, String password) {
        abstractUserService.registerNewAdmin(username, password);
    }

    @Override
    public void loginUser(String username, String password) {
        abstractUserService.loginUser(username, password);
    }

    @Override
    public void logOut(String username) {
        abstractUserService.logOut(username);
    }

    @Override
    public void submitMeterReading(AbstractUserFullDTO abstractUserFullDTO, MeterReadingFullDTO meterReadingFullDTO) {
        abstractUserService.submitMeterReading(abstractUserFullDTO, meterReadingFullDTO);
    }

    @Override
    public MeterReadingFullDTO viewLatestMeterReading(AbstractUserFullDTO abstractUserFullDTO) {
        return abstractUserService.viewLatestMeterReading(abstractUserFullDTO);
    }

    @Override
    public List<MeterReadingImpl> viewMeterReadingHistory(AbstractUserFullDTO abstractUserFullDTO) {
        return abstractUserService.viewMeterReadingHistory(abstractUserFullDTO);
    }

    @Override
    public boolean abstractUserIsAvailable(AbstractUserFullDTO abstractUserFullDTO) {
        return abstractUserService.abstractUserIsAvailable(abstractUserFullDTO);
    }

    @Override
    public AbstractUser getCertainUser(String username) {
        return abstractUserService.getCertainUser(username);
    }
}
