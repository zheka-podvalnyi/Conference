package ua.nure.podvalnyi.db.dao.implement;

import ua.nure.podvalnyi.db.dao.StatisticDbDao;
import ua.nure.podvalnyi.db.entity.Statistic;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatisticDbDaoImpl implements StatisticDbDao {

    private static final String TABLE = "statistic";

    private static final String GET_STATISTIC_BY_USER_ID = "SELECT * FROM " + TABLE + " WHERE user_id=?";
    private static final String GET_STATISTIC_BY_EVENT_ID = "SELECT * FROM " + TABLE + " WHERE event_id=?";

    private static final String ADD_STATISTIC = "INSERT INTO " + TABLE +
            " (user_id, event_id, user_status) " + " VALUES (?,?,?)";

    private static final String COUNT_STATISTIC = "SELECT COUNT(*) AS count FROM " + TABLE;


    @Override
    public Statistic getStatisticByUserId(Connection connection, Long userId) throws SQLException {
        Statistic statistic = null;
        String query = GET_STATISTIC_BY_USER_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    statistic = getStatistic(resultSet);
                    statistic.setUserId(resultSet.getLong("user_id"));
                }
            }
        }
        return statistic;
    }


    @Override
    public List getStatisticByEventId(Connection connection, Long eventId) throws SQLException {

        List<Statistic> statistics= new ArrayList<>();
        String query = GET_STATISTIC_BY_EVENT_ID;
        try (PreparedStatement prepared = connection.prepareStatement(query)){
             prepared.setLong(1, eventId);
             ResultSet resultSet = prepared.executeQuery();
                while (resultSet.next()) {
                    Statistic statistic = getStatistic(resultSet);
                    statistic.setEventId(resultSet.getLong("event_id"));
                    statistics.add(statistic);
                }
            }

        return statistics;

    }

    @Override
    public Long addStatistic(Connection connection, Statistic statistic) throws SQLException {
        String query = ADD_STATISTIC;
        Long id = 0L;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, statistic.getUserId());
            preparedStatement.setLong(2, statistic.getEventId());
            preparedStatement.setBoolean(3, statistic.isUserStatus());

            preparedStatement.executeUpdate();
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                if(resultSet.next()){
                    id = resultSet.getLong(1);
                }
            }

        }
        return id;
    }

    @Override
    public Long countStatistic(Connection connection, Long eventId) throws SQLException{
        Long count = 0L;

        String query = COUNT_STATISTIC;
        try (PreparedStatement prepared = connection.prepareStatement(query)) {

            ResultSet resultSet = prepared.executeQuery();
            while (resultSet.next()) {
                 count = resultSet.getLong("count");
            }
        }
        return count;
    }

        private Statistic getStatistic(ResultSet resultSet) throws SQLException{
        return new Statistic(resultSet.getLong("user_id"),resultSet.getLong("event_id"),
                resultSet.getBoolean("user_status"));
    }
}
