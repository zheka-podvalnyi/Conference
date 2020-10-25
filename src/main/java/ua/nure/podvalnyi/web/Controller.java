package ua.nure.podvalnyi.web;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.web.command.Command;
import ua.nure.podvalnyi.web.command.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(value = "/controller1", name = "controller")

public class Controller extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(Controller.class);

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        // go to forward
        response.sendRedirect(process(request, response, "POST"));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(process(request, response, "GET")).forward(request, response);

    }

    private String process(HttpServletRequest request, HttpServletResponse response, String method) {

        LOG.debug("Controller starts");

        // extract command name from the request
        String commandName = request.getParameter("command");
        LOG.trace("Request parameter: command --> " + commandName);

        // obtain command object by its name
        Command command;

        // execute command and get forward address
        String forward = "pages/error.jsp?error=";
        switch (commandName) {


            case "login": {
                forward = "pages/login.jsp?error=";
                break;
            }
            case "registration": {
                forward = "pages/registration.jsp?error=";
                break;
            }


        }
        try {
            command = CommandContainer.get(commandName,method);
            LOG.trace("Obtained command --> " + command);
            forward =command.execute(request,response);
        }catch (Exception ex){
            LOG.trace(ex.getMessage());
            forward = forward + ex.getMessage();
            request.setAttribute("errorMessage", ex.getMessage());
        }
        LOG.trace("Forward address --> " + forward);
        LOG.debug("Controller finished, now go to forward address --> " + forward);
    return forward;
    }
}
