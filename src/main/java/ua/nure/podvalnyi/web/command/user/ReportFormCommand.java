package ua.nure.podvalnyi.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Report;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.ReportService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static ua.nure.podvalnyi.web.utils.Const.REPORT_FORM;

public class ReportFormCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ReportFormCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer = Initializer.getInstance();
        ReportService<Report> reportService = initializer.getReportService();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        LOG.trace("Get user from session --> " + user);
        List<Report> reports = new ArrayList<>();

        return REPORT_FORM;
    }
}
