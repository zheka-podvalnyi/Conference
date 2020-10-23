package ua.nure.podvalnyi.web.command.moderator;


import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.EventService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;

import static ua.nure.podvalnyi.web.utils.Const.ADD_EVENT;

public class AddEventCommand extends Command {

    private static final Logger LOG = Logger.getLogger(AddEventCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        /**
         *
         * Initializing services
         *
         * **/

        Initializer initializer = Initializer.getInstance();
        EventService<Event> eventService = initializer.getEventService();

        Date date = Date.valueOf(request.getParameter("date"));
        String place = request.getParameter("place");
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        LOG.trace("Get user from session -->" + user);
     /*   String name = request.getParameter("name");
        LOG.trace("Get request parameter 'name' -->" + name);*/

        Event event = new Event(date,place,name);
        eventService.addEvent(event);


        request.setAttribute("createdEvent", event);

        LOG.trace("Set request attribute 'addEvent' --> " + event);
        LOG.debug("Command finished");

    return ADD_EVENT;
    }
}
