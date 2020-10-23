package ua.nure.podvalnyi.db.dao;

import ua.nure.podvalnyi.db.entity.Statistic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface StatisticDbDao <E extends Statistic> {

    E getStatisticByUserId(Connection connection, Long userId) throws SQLException;

    List<E> getStatisticByEventId(Connection connection, Long eventId) throws SQLException;

    Long addStatistic(Connection connection, E statistic) throws SQLException;

    Long countStatistic(Connection connection, Long eventId) throws SQLException;

}
