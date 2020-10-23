package ua.nure.podvalnyi.web.command.moderator;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.db.service.EventService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.nure.podvalnyi.web.utils.Const.EVENTS;

public class DeleteEventCommand extends Command {

    Logger LOG = Logger.getLogger(DeleteEventCommand.class);
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

        Long id = Long.parseLong(request.getParameter("id"));
        eventService.removeEventById(id);

        LOG.trace("Event was removed");
        LOG.debug("Command finished");

    return EVENTS;
    }
}
