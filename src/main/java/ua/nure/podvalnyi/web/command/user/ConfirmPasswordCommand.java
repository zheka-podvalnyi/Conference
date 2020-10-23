package ua.nure.podvalnyi.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.UserService;
import ua.nure.podvalnyi.web.command.Command;
import ua.nure.podvalnyi.web.utils.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static ua.nure.podvalnyi.web.utils.Const.CONFIRM_PASSWORD;

public class ConfirmPasswordCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ConfirmPasswordCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer = Initializer.getInstance();
        UserService<User> userService = initializer.getUserService();
        String forward = "profile.jsp?success=true";
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            LOG.trace("User not authorized");
            forward = "pages/login.jsp?success=true";
        } else {
            LOG.trace("User authorized");
        }
        String login = request.getParameter("login");
        Validation.checkLogin(login);
        String password = request.getParameter("password");
        Validation.checkPassword(password);
        String security = request.getParameter("security");
        LOG.trace("Get request parameter 'login' --> " + login + "Get request parameter 'password' --> " + password +
                "Get request parameter 'security' --> " + security);
        User user = userService.getUserByLogin(login);
        Validation.checkUser(user);
        Validation.confirmPassword(user.getPassword(), security);
        user.setPassword(password);
        userService.changeUser(user);
        LOG.trace("User updated");
        LOG.debug("Command finished");
        return CONFIRM_PASSWORD;
    }
}
