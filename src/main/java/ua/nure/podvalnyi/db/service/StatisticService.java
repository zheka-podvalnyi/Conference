package ua.nure.podvalnyi.db.service;

import ua.nure.podvalnyi.db.entity.RequestDto;
import ua.nure.podvalnyi.db.entity.Statistic;
import ua.nure.podvalnyi.exception.DBException;

import java.sql.SQLException;
import java.util.List;


public interface StatisticService<E extends Statistic> {

    E getStatisticByUserId(Long userId) throws DBException;

    List<E> getStatisticByEventId(Long eventId) throws DBException;

    E getStatistic(Long userId, Long eventId) throws DBException;

    Long addStatistic(E statistic) throws DBException;

    Long countStatistic(Long eventId) throws DBException;

    boolean changeStatistic(E statistic) throws DBException;

    List<RequestDto> getRequestDto() throws DBException;
}
