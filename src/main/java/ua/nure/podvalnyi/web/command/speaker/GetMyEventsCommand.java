package ua.nure.podvalnyi.web.command.speaker;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.EventService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static ua.nure.podvalnyi.web.utils.Const.EVENTS;

public class GetMyEventsCommand extends Command {

    private static final Logger LOG = Logger.getLogger(GetMyEventsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer = Initializer.getInstance();
        EventService<Event> eventService = initializer.getEventService();

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        Long userId = user.getId();

        List<Event> userEvents = eventService.getEventsByUser(userId);

        request.setAttribute("userEvents", userEvents);

        LOG.debug("Command finished");


        return EVENTS;
    }
}
