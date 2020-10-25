package ua.nure.podvalnyi.web.command.speaker;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.db.entity.Statistic;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.EventService;
import ua.nure.podvalnyi.db.service.StatisticService;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static ua.nure.podvalnyi.web.utils.Const.EVENTS;


public class JoinToEventAsSpeakerCommand extends Command {

    private static final Logger LOG = Logger.getLogger(JoinToEventAsSpeakerCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");

        Initializer initializer = Initializer.getInstance();

        EventService<Event> eventService = initializer.getEventService();

        StatisticService<Statistic> statisticService = initializer.getStatisticService();

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        Long eventId = (Long.parseLong(request.getParameter("id")));

        String topic = request.getParameter("topic");


        Statistic statistic = new Statistic(user.getId(),eventId,false,true,topic,false);

        statisticService.changeStatistic(statistic);

        LOG.debug("Command finished");


return EVENTS;

    }
}
