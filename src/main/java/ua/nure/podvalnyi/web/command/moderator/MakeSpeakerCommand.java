package ua.nure.podvalnyi.web.command.moderator;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Statistic;
import ua.nure.podvalnyi.db.service.StatisticService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.nure.podvalnyi.web.utils.Const.CONFIRM_REQUEST;

public class MakeSpeakerCommand extends Command {

    private static final Logger LOG = Logger.getLogger(MakeSpeakerCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer = Initializer.getInstance();
        StatisticService statisticService = initializer.getStatisticService();

        Long userId = Long.parseLong(request.getParameter("userId"));
        Long eventId = Long.parseLong(request.getParameter("eventId"));

        Statistic statistic = statisticService.getStatistic(userId,eventId);

        statistic.setConfirm(true);
        statisticService.changeStatistic(statistic);

    return CONFIRM_REQUEST;
    }
}
