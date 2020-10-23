package ua.nure.podvalnyi.web.command.moderator;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Statistic;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.StatisticService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import static ua.nure.podvalnyi.web.utils.Const.STATISTIC;

public class GetStatisticCommand extends Command {

    Logger LOG = Logger.getLogger(GetStatisticCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer = Initializer.getInstance();
        StatisticService<Statistic> statisticService = initializer.getStatisticService();

        Long eventId = (Long.parseLong(request.getParameter("id")));

        List<Statistic> statistics = statisticService.getStatisticByEventId(eventId);

        request.setAttribute("statistics", statistics);

        Long count = statisticService.countStatistic(eventId);

        request.setAttribute("count",count);

        LOG.debug("Command finished");

        return STATISTIC;
    }
}
