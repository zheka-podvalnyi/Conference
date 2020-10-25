package ua.nure.podvalnyi.web.command.moderator;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.EventService;
import ua.nure.podvalnyi.db.service.UserService;
import ua.nure.podvalnyi.web.command.Command;
import ua.nure.podvalnyi.web.utils.SendEmailNotification;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Date;
import java.util.List;

import static ua.nure.podvalnyi.web.utils.Const.EVENT_FORM;

public class EditEventCommand extends Command {

    Logger LOG = Logger.getLogger(EditEventCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        LOG.debug("Command starts");

        Initializer initializer = Initializer.getInstance();
        EventService<Event> eventService = initializer.getEventService();
        UserService<User> userService = initializer.getUserService();

        Date date = Date.valueOf(request.getParameter("date"));
        String place = request.getParameter("place");
        String name = request.getParameter("name");



        Long id = Long.parseLong(request.getParameter("id"));
        Event event = new Event(id, date, place,name);


        eventService.changeEvent(event);

        for (String mail:userService.getMailUsersByEventId(id)
             ) {
            SendEmailNotification.mail("TEST", mail);
        }





        LOG.trace("Event was changed");
        LOG.debug("Command finished");

        return EVENT_FORM;
    }
}

