package ua.nure.podvalnyi.web.command.moderator;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;

import ua.nure.podvalnyi.db.entity.RequestDto;
import ua.nure.podvalnyi.db.entity.Statistic;

import ua.nure.podvalnyi.db.service.StatisticService;

import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static ua.nure.podvalnyi.web.utils.Const.REQUEST_LIST;

public class RequestListFormCommand extends Command {

    private static final Logger LOG = Logger.getLogger(RequestListFormCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer= Initializer.getInstance();
        StatisticService<Statistic> statisticService = initializer.getStatisticService();
        List<RequestDto> requestDtoList = statisticService.getRequestDto();

        request.setAttribute("requestDtoList", requestDtoList);

        LOG.debug("Command finished");
   return REQUEST_LIST;
    }
}
