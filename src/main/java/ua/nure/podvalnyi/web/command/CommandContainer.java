package ua.nure.podvalnyi.web.command;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.exception.AppException;
import ua.nure.podvalnyi.web.command.moderator.*;
import ua.nure.podvalnyi.web.command.speaker.GetMyEventsCommand;
import ua.nure.podvalnyi.web.command.user.*;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {

    private static final Logger LOG = Logger.getLogger(CommandContainer.class);

    /**
     * @value getCommands - Map with GET commands.
     * @value postCommands - Map with POST commands.
     **/
    private static Map<String, Command> getCommands = new TreeMap<String, Command>();
    private static Map<String, Command> postCommands = new TreeMap<String, Command>();


    static {
        /**
         * Out-of-control commands.
         **/
        //out-of-control
        postCommands.put("login", new AuthorizeCommand());
        getCommands.put("logout", new DeauthorizationCommand());
        postCommands.put("registration", new RegisterCommand());
        postCommands.put("changeLanguage", new ChangeLanguageCommand());
        postCommands.put("makeNewPassword", new ChangePasswordCommand());
        getCommands.put("changePassword", new ChangePasswordFormCommand());
        getCommands.put("confirmPassword", new ConfirmPasswordCommand());
        getCommands.put("allEvents", new GetAllEventsCommand());
        getCommands.put("sortEvents", new SortEventsCommand());


        /**
         * User commands.
         **/
        //user commands
        postCommands.put("addReport", new AddReportCommand());

        getCommands.put("history", new HistoryCommand());
        getCommands.put("profile", new ProfileFormCommand());
        getCommands.put("reports", new ReportFormCommand());
        getCommands.put("joinToEvent", new JoinUserToEventCommand());


        /**
         * Moderator commands.
         **/
        //moder commands
        postCommands.put("newModer", new CreateNewModerCommand());
        getCommands.put("createModer", new NewModerCommand());
        getCommands.put("allUsers", new GetAllUsersCommand());
        getCommands.put("getStatistic", new GetStatisticCommand());
        getCommands.put("editEventForm",new EditEventFormCommand());
       getCommands.put("myEvents",new GetMyEventsCommand());

        getCommands.put("allReports", new GetAllReportsCommand());
        postCommands.put("addEvent", new AddEventCommand());
        postCommands.put("deleteEvent", new DeleteEventCommand());
        postCommands.put("editEvent", new EditEventCommand());

        postCommands.put("addNewEvent",new EventFormCommand());
        postCommands.put("userAction", new UserActionCommand());


        LOG.debug("Command container was successfully initialized");

    }

    /**
     * Returns command object with the given name.
     *
     * @param commandName Name of the command.
     * @return Command object.
     */
    public static Command get(String commandName, String method) throws AppException {
        switch (method) {
            case "POST": {
                if (commandName == null || !postCommands.containsKey(commandName)) {
                    LOG.trace("Command not found, name --> " + commandName);
                    throw new AppException("Command not found");
                }
                return postCommands.get(commandName);
            }
            case "GET": {
                if (commandName == null || !getCommands.containsKey(commandName)) {
                    LOG.trace("Command not found, name --> " + commandName);
                    throw new AppException("Command not found");
                }
                return getCommands.get(commandName);
            }
        }
        throw new AppException("Command not found");
    }
}
