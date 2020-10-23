package ua.nure.podvalnyi.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.web.command.Command;
import ua.nure.podvalnyi.web.utils.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static ua.nure.podvalnyi.web.utils.Const.LOGIN;

public class DeauthorizationCommand extends Command {

    private static final Logger LOG = Logger.getLogger(DeauthorizationCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        LOG.trace("Session attribute: user --> " + user);
        Validation.checkUser(user);

        session.setAttribute("user", null);

        LOG.trace("Logout: user --> " + user);

        LOG.debug("Command finished");

        return LOGIN;
    }
}
