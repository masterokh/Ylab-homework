package application.controllers;

import application.dto.AdminFullDTO;
import application.dto.MeterReadingFullDTO;
import application.dto.UserFullDTO;
import application.mappers.AdminMapper;
import application.mappers.MeterReadingMapper;
import application.mappers.UserMapper;
import application.models.*;
import application.services.AbstractUserService;
import application.services.AbstractUserServiceImpl;
import application.services.SetOfAllNamesOfMeterReadingService;
import application.services.SetOfAllNamesOfMeterReadingServiceImpl;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The ConsoleProgram class represents the main console-based user interface for interacting
 * with the application. It provides options for user registration, login, and various operations
 * based on the user's role (Admin or User).
 */
public class ConsoleProgram {

    /**
     * Starts the console program, initializing necessary services and handling user interactions.
     */
    public static void start() {
        AbstractUserService abstractUserService = new AbstractUserServiceImpl();
        SetOfAllNamesOfMeterReadingService setOfAllNamesOfMeterReadingService = new SetOfAllNamesOfMeterReadingServiceImpl();
        UserController userInputPort = new UserControllerImpl(abstractUserService);
        AllNamesOfMeterReadingController allNamesOfMeterReadingInputPort = new AllNamesOfMeterReadingControllerImpl(setOfAllNamesOfMeterReadingService);
        userInputPort.registerNewAdmin("admin","12345");

        allNamesOfMeterReadingInputPort.addMeterReading(AdminMapper.toDto((Admin) userInputPort.getCertainUser("admin")), "Heating");
        allNamesOfMeterReadingInputPort.addMeterReading(AdminMapper.toDto((Admin) userInputPort.getCertainUser("admin")), "Hot Water");
        allNamesOfMeterReadingInputPort.addMeterReading(AdminMapper.toDto((Admin) userInputPort.getCertainUser("admin")), "Cold Water");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        UserFullDTO userFullDTO = new UserFullDTO(username, password);
                        userInputPort.registerAbstractUser(userFullDTO);
                        break;
                    case 2:
                        System.out.print("Enter username: ");
                        String usernameToLogin = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String passwordToLogin = scanner.nextLine();
                        userInputPort.loginUser(usernameToLogin, passwordToLogin);
                        if(userInputPort.getCertainUser(usernameToLogin) instanceof Admin){
                            workWithAdminAccount(AdminMapper.toDto((Admin) userInputPort.getCertainUser(usernameToLogin)), userInputPort, allNamesOfMeterReadingInputPort, scanner);
                        } else if (userInputPort.getCertainUser(usernameToLogin) instanceof User) {
                            workWithUserAccount((UserMapper.toDto((User) userInputPort.getCertainUser(usernameToLogin))), userInputPort, allNamesOfMeterReadingInputPort, scanner);
                        } else {
                            System.out.println("Incorrect type");
                        }
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }

        }
    }

    /**
     * Handles the interaction with an Admin account, providing options such as registering a new admin,
     * adding a new meter reading, retrieving information about a certain user, and logging out.
     *
     * @param adminFullDTO                The Admin account currently logged in.
     * @param userInputPort               The UserInputPort for user-related operations.
     * @param allNamesOfMeterReadingInputPort The AllNamesOfMeterReadingInputPort for meter reading operations.
     * @param scanner                     The Scanner for user input.
     */
    private static void workWithAdminAccount(AdminFullDTO adminFullDTO, UserController userInputPort, AllNamesOfMeterReadingController allNamesOfMeterReadingInputPort, Scanner scanner){
        boolean tempCheak = true;
        while (tempCheak){
            System.out.println("You are Admin!");
            System.out.println("1. Register new Admin");
            System.out.println("2. Add new Meter reading");
            System.out.println("3. Get information about certain user");
            System.out.println("4. Log Out");

            int userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1:
                    System.out.print("Enter username: ");
                    String usernameOfNewAdmin = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String passwordOfNewAdmin = scanner.nextLine();
                    userInputPort.registerNewAdmin(usernameOfNewAdmin, passwordOfNewAdmin);
                    break;
                case 2:
                    System.out.println("Enter name of new meter reading:");
                    String meterReading = scanner.nextLine();
                    allNamesOfMeterReadingInputPort.addMeterReading(adminFullDTO, meterReading);
                    System.out.println(allNamesOfMeterReadingInputPort.getListOfNamesOfMeterReadings());
                    break;
                case 3:
                    System.out.print("Enter username: ");
                    String usernameToFind = scanner.nextLine();
                    System.out.println(userInputPort.getCertainUser(usernameToFind));
                    break;
                case 4:
                    userInputPort.logOut(adminFullDTO.getUsername());
                    tempCheak = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Handles the interaction with a User account, providing options such as submitting a meter reading,
     * viewing the latest meter reading, viewing the meter reading history, and logging out.
     *
     * @param userFullDTO                 The User account currently logged in.
     * @param userInputPort               The UserInputPort for user-related operations.
     * @param allNamesOfMeterReadingInputPort The AllNamesOfMeterReadingInputPort for meter reading operations.
     * @param scanner                     The Scanner for user input.
     */
    private static void workWithUserAccount(UserFullDTO userFullDTO, UserController userInputPort, AllNamesOfMeterReadingController allNamesOfMeterReadingInputPort, Scanner scanner){
        boolean tempCheak = true;
        while (tempCheak){
            System.out.println("1. Submit Meter Reading");
            System.out.println("2. View Latest Meter Reading");
            System.out.println("3. View Meter Reading History");
            System.out.println("4. Log Out");

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.println("Enter meter reading details:");

                    System.out.print("Month (1-12): ");
                    int month = scanner.nextInt();

                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    MeterReading newReading = new MeterReadingImpl(month, year);
                    for(String element: allNamesOfMeterReadingInputPort.getListOfNamesOfMeterReadings()){
                        System.out.print(element + " reading: ");
                        newReading.addReading(element,scanner.nextDouble());
                    }
                    userInputPort.submitMeterReading(userFullDTO,MeterReadingMapper.toDto((MeterReadingImpl) newReading));
                    break;
                case 2:
                    AbstractUser certainUser = userInputPort.getCertainUser(userFullDTO.getUsername());
                    MeterReadingFullDTO latestReading = UserMapper.toDto((User)certainUser).getLatestMeterReading();
                    if (latestReading == null) {
                        System.out.println("No meter readings available.");
                    } else {
                        System.out.println("Month is " + latestReading.getMonth() + " Year is " + latestReading.getYear());
                        for (Map.Entry<String, Double> entry : latestReading.getReadings().entrySet()) {
                            System.out.println("name of readings " + entry.getKey() + " quantity is " + entry.getValue());
                        }
                    }
                    break;
                case 3:
                    List<MeterReadingImpl> readingHistory = userInputPort.viewMeterReadingHistory(userFullDTO);

                    if (readingHistory.isEmpty()) {
                        System.out.println("No meter readings available.");
                    } else {
                        System.out.println("Meter Reading History:");
                        for(MeterReadingImpl element: readingHistory){
                            System.out.println("Month is " + element.getMonth() + " Year is " + element.getYear());
                            for (Map.Entry<String, Double> entry : element.getReadings().entrySet()) {
                                System.out.println("name of readings " + entry.getKey() + " quantity is " + entry.getValue());
                            }
                        }
                    }
                    break;
                case 4:
                    userInputPort.logOut(userFullDTO.getUsername());
                    tempCheak = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}