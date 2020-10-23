package ua.nure.podvalnyi.web.command.moderator;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Report;
import ua.nure.podvalnyi.db.service.ReportService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static ua.nure.podvalnyi.web.utils.Const.MODER_PAGE;

public class GetAllReportsCommand extends Command {

    private static final Logger LOG = Logger.getLogger(GetAllReportsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer = Initializer.getInstance();
        ReportService<Report> reportService = initializer.getReportService();
        List<Report> reports = reportService.getReports();
/*




 */
        LOG.trace("Set request attribute 'reports' --> " + reports);
        LOG.debug("Command finished");
        return MODER_PAGE;
    }
}
