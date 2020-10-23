package ua.nure.podvalnyi.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.web.command.Command;
import ua.nure.podvalnyi.web.command.Register;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.nure.podvalnyi.web.utils.Const.REGISTER;

public class RegisterCommand extends Command {

    private static final Logger LOG = Logger.getLogger(RegisterCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Register.createUser(request,"user");
        LOG.debug("Command finished");
        return REGISTER;
    }
}
