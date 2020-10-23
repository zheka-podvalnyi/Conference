package ua.nure.podvalnyi.web.command.moderator;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.UserService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static ua.nure.podvalnyi.web.utils.Const.MODER_PAGE;

public class GetAllUsersCommand extends Command {

    private static final Logger LOG = Logger.getLogger(GetAllUsersCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer = Initializer.getInstance();
        UserService<User> userService = initializer.getUserService();
        List<User> users = userService.getListOfUsers();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        for (User item : users) {

            if (item.getId().equals(user.getId())) {
                user = item;
            }
        }
        users.remove(user);
        request.setAttribute("users", users);
        LOG.trace("Set request attribute 'users' -->" + users);
        LOG.debug("Command finished");
        return MODER_PAGE;
    }
}
