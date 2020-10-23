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


import static ua.nure.podvalnyi.web.utils.Const.EDIT_EVENT_FORM;

public class EditEventFormCommand extends Command {

    private static final Logger LOG = Logger.getLogger(EditEventCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer = Initializer.getInstance();
        EventService<Event> eventService = initializer.getEventService();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        LOG.trace("Get user from session --> " + user);

        Long id = Long.parseLong(request.getParameter("id"));


        request.setAttribute("event",eventService.getEventById(id));
        request.setAttribute("id",id);

        return EDIT_EVENT_FORM;
    }
}
