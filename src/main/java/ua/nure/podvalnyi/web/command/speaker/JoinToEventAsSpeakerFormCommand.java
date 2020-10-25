package ua.nure.podvalnyi.web.command.speaker;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Statistic;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.StatisticService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import static ua.nure.podvalnyi.web.utils.Const.REGISTER_TO_EVENT;

public class JoinToEventAsSpeakerFormCommand extends Command {

    private static final Logger LOG = Logger.getLogger(JoinToEventAsSpeakerCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer = Initializer.getInstance();
        StatisticService<Statistic> statisticService = initializer.getStatisticService();

        Long eventId = (Long.parseLong(request.getParameter("eventId")));

        request.setAttribute("id",eventId);

        return  REGISTER_TO_EVENT;
    }
}
