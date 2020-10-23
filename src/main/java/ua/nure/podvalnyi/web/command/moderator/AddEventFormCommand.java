package ua.nure.podvalnyi.web.command.moderator;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.nure.podvalnyi.web.utils.Const.EVENT_FORM;

public class AddEventFormCommand extends Command {

    private static final Logger LOG = Logger.getLogger(AddEventCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        LOG.debug("Command finished");
        return EVENT_FORM;
    }
}
