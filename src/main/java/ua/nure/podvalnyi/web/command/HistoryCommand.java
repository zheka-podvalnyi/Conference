package ua.nure.podvalnyi.web.command;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.EventService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HistoryCommand extends Command {

    private static final Logger LOG = Logger.getLogger(HistoryCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        HttpSession session = request.getSession();
        Initializer initializer = Initializer.getInstance();
        EventService<Event> eventService = initializer.getEventService();
        //User user = (User) session.setAttribute();
    return "null";
    }
}
