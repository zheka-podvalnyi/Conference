package ua.nure.podvalnyi.web.command.moderator;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.db.entity.User;

import ua.nure.podvalnyi.db.service.EventService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static ua.nure.podvalnyi.web.utils.Const.EVENTS;


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
                case "dateDown": {
                    events = eventService.sortEventByDateDown();
                    LOG.trace("Set SortEvents by date (Down)");
                    break;
                }
                case "dateUp": {
                    events = eventService.sortEventByDateUp();
                    LOG.trace("Set SortEvents by date (Up)");
                    break;
                }
                case "usersUp": {
                    events = eventService.sortEventByAmountOfUsersUp();
                    LOG.trace("Set SortEvents by users (Up)");
                    break;
                }
                case "usersDown": {
                    events = eventService.sortEventByAmountOfUsersDown();
                    LOG.trace("Set SortEvents by users (Down)");
                    break;
                }
                case "reportsDown": {
                    events = eventService.sortEventByReportsDown();
                    LOG.trace("Set SortEvents by reports (Down)");
                    break;
                }
                case "reportsUp": {
                    events = eventService.sortEventByReportsUp();
                    LOG.trace("Set SortEvents by reports (Up)");
                    break;
                }
            }
        } else
            eventService.getListOfEvents();

        LOG.info("Sort events by default");
        request.setAttribute("events", events);
        LOG.trace("Set request attribute events -->" + events);


        User user = (User)request.getSession().getAttribute("user");

        List<Event> userEvents = eventService.getEventsByUser(user.getId());

        LOG.debug("Command finished");
        request.setAttribute("userEvents",userEvents);



        return EVENTS;
    }
}
