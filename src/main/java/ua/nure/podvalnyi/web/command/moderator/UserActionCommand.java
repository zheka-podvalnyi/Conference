package ua.nure.podvalnyi.web.command.moderator;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.UserService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.nure.podvalnyi.web.utils.Const.ALL_USERS;

public class UserActionCommand extends Command {

    private static final Logger LOG = Logger.getLogger(UserActionCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer = Initializer.getInstance();
        UserService<User> userService = initializer.getUserService();
        Long id = Long.parseLong(request.getParameter("userId"));
        LOG.trace("Get request parameter 'userId' --> " + id);
        User user = userService.getUserById(id);
        userService.changeUser(user);
        LOG.trace("User updated");
        LOG.debug("Command finished");
        return ALL_USERS;
    }
}
