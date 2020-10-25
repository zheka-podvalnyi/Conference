package ua.nure.podvalnyi.web.command.speaker;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.db.service.EventService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.nure.podvalnyi.web.utils.Const.REGISTER_TO_EVENT;

public class GetEventByIdCommand extends Command {

    private static final Logger LOG = Logger.getLogger(GetEventByIdCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command Starts");

        Initializer initializer = Initializer.getInstance();

        EventService<Event> eventService = initializer.getEventService();

        Long eventId = (Long.parseLong(request.getParameter("id")));

        request.setAttribute("eventById", eventService.getEventById(eventId));

        return  REGISTER_TO_EVENT;
    }
}
