package ua.nure.podvalnyi.web.command.moderator;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.nure.podvalnyi.web.utils.Const.MODER_REGISTRATION;

public class NewModerCommand extends Command {

    private static final Logger LOG = Logger.getLogger(NewModerCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        LOG.debug("Command finished");
        return MODER_REGISTRATION;
    }
}
