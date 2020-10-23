package ua.nure.podvalnyi.web.command.moderator;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.entity.containers.EventContainer;
import ua.nure.podvalnyi.db.service.EventService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static ua.nure.podvalnyi.web.utils.Const.EVENTS;
import static ua.nure.podvalnyi.web.utils.Const.EVENT_FORM;

public class GetAllEventsCommand extends Command {

    private static final Logger LOG = Logger.getLogger(GetAllEventsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer = Initializer.getInstance();
        EventService<Event> eventService = initializer.getEventService();
        request.getParameter("sort");
        List<Event> events = eventService.getListOfEvents();


        request.setAttribute("events", events);
        LOG.trace("Set request attribute 'events' -->" + events);


        String sort = request.getParameter("sortBy");
        LOG.trace("Get request parameter sortBy --> " + sort);


        if (sort != null) {
            switch (sort) {
                case "DateDown": {
                    events = eventService.sortEventByDateDown();
                    LOG.trace("Set SortEvents by date (Down)");
                    break;
                }
                case "DateUp": {
                    events = eventService.sortEventByDateUp();
                    LOG.trace("Set SortEvents by date (Up)");
                    break;
                }
                case "UsersUp": {
                    events = eventService.sortEventByAmountOfUsersUp();
                    LOG.trace("Set SortEvents by users (Up)");
                    break;
                }
                case "UsersDown": {
                    events = eventService.sortEventByAmountOfUsersDown();
                    LOG.trace("Set SortEvents by users (Down)");
                    break;
                }
            }
        } else
            eventService.getListOfEvents();

        LOG.info("Sort events by default");
        request.setAttribute("events", events);
        LOG.trace("Set request attribute events -->" + events);

        Long userId = (Long.parseLong(request.getParameter("id")));

        List<Event> userEvents = eventService.getEventsByUser(userId);
        request.setAttribute("userEvents",userEvents);

        LOG.debug("Command finished");


        return EVENTS;
    }
}
