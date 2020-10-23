package ua.nure.podvalnyi.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.nure.podvalnyi.web.utils.Const.CHANGE_PASSWORD_FORM;

public class ChangePasswordFormCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ChangeLanguageCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        LOG.debug("Command finished");
    return CHANGE_PASSWORD_FORM;
    }
}
