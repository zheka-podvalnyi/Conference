package ua.nure.podvalnyi.db.dao.implement;

import ua.nure.podvalnyi.db.dao.StatisticDbDao;
import ua.nure.podvalnyi.db.entity.RequestDto;
import ua.nure.podvalnyi.db.entity.Statistic;
import ua.nure.podvalnyi.db.entity.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatisticDbDaoImpl implements StatisticDbDao {

    private static final String TABLE = "statistic";

    private static final String GET_STATISTIC_BY_USER_ID = "SELECT * FROM " + TABLE + " WHERE user_id=?";
    private static final String GET_STATISTIC_BY_EVENT_ID = "SELECT * FROM " + TABLE + " WHERE event_id=?";
    private static final String GET_STATISTIC = "SELECT * FROM " + TABLE + " WHERE user_id=? AND event_id=?";

    private static final String ADD_STATISTIC = "INSERT INTO " + TABLE +
            " (user_id, event_id, user_status) " + " VALUES (?,?,?)";

    private static final String COUNT_STATISTIC = "SELECT COUNT(*) AS count FROM " + TABLE;

    private static final String CHANGE_STATISTIC = "UPDATE " + TABLE +" SET user_status=?,speaker_status=?,speaker_topic=?," +
            "confirm=? WHERE user_id=? AND event_id=?";

    private static final String GET_LIST_REQUEST_DTO = "SELECT statistic.user_id,user.user_name,user.user_middlename,user.user_lastname,user.user_login," +
            "event.event_id,event.event_date,event.event_place,event.event_name, statistic.speaker_topic " + " FROM " + TABLE + " RIGHT JOIN user on user.user_id=statistic.user_id RIGHT JOIN event on event.event_id= statistic.event_id WHERE speaker_status=1 " +
            " AND confirm=0 ";


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
    public Statistic getStatistic(Connection connection, Long userId, Long eventId) throws SQLException {
        Statistic statistic = null;
        String query = GET_STATISTIC;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, eventId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    statistic = getStatistic(resultSet);

                }
            }
        }
        return statistic;
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

    @Override
    public boolean changeStatistic(Connection connection, Statistic statistic) throws SQLException {
        String query = CHANGE_STATISTIC;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBoolean(1,statistic.isUserStatus());
            preparedStatement.setBoolean(2,statistic.isSpeakerStatus());
            preparedStatement.setString(3,statistic.getSpeakerTopic());
            preparedStatement.setBoolean(4, statistic.isConfirm());
            preparedStatement.setLong(5,statistic.getUserId());
            preparedStatement.setLong(6,statistic.getEventId());
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public List getRequestDto(Connection connection) throws SQLException {
        List<RequestDto> requestDtoList  = new ArrayList<>();
        String query = GET_LIST_REQUEST_DTO;
        try (PreparedStatement prepared = connection.prepareStatement(query);
             ResultSet resultSet = prepared.executeQuery()) {
            while (resultSet.next()) {
                RequestDto requestDto = getRequestDto(resultSet);

                requestDtoList.add(requestDto);
            }
        }
        return requestDtoList;
    }



    private Statistic getStatistic(ResultSet resultSet) throws SQLException{
        return new Statistic(resultSet.getLong("user_id"),resultSet.getLong("event_id"),
                resultSet.getBoolean("user_status"),resultSet.getBoolean("speaker_status"),
                resultSet.getString("speaker_topic"),resultSet.getBoolean("confirm"));
    }
    private RequestDto getRequestDto(ResultSet resultSet) throws SQLException{
        return new RequestDto(resultSet.getLong("user_id"),resultSet.getString("user_name"),resultSet.getString("user_middlename"),
                resultSet.getString("user_lastname"),resultSet.getString("user_login"),resultSet.getLong("event_id"),resultSet.getDate("event_date"),
                resultSet.getString("event_place"), resultSet.getString("event_name"), resultSet.getString("speaker_topic"));
    }
}
