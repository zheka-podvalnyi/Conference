package ua.nure.podvalnyi.db.dao.implement;

import jdk.nashorn.internal.objects.annotations.Where;
import ua.nure.podvalnyi.db.dao.EventDbDao;
import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.db.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDbDaoImpl implements EventDbDao {

    private static final String TABLE = "event";
    private static final String GET_ALL_EVENTS = "SELECT * FROM " + TABLE;
    private static final String GET_EVENT_BY_ID = "SELECT * FROM " + TABLE +" WHERE event_id=?";
    private static final String GET_EVENT_BY_NAME = "SELECT * FROM " + TABLE +" WHERE event_name=?";
    private static final String GET_EVENT_BY_USER = "Select * FROM "+TABLE+ " WHERE event_id in(select event_id FROM statistic Where user_id=?)";
    private static final String ADD_EVENT = "INSERT INTO " + TABLE +" VALUES (DEFAULT, ?, ?, ?)";
    private static final String DELETE_EVENT_BY_ID = "DELETE  FROM " + TABLE +" WHERE event_id=?";
    private static final String CHANGE_EVENT = "UPDATE " + TABLE +" SET event_date=?, event_place=?,  event_name=? WHERE event_id=?";
    private static final String SORT_EVENT_BY_DATE_UP = "SELECT * FROM " + TABLE + " ORDER BY event_date DESC";
    private static final String SORT_EVENT_BY_DATE_DOWN = "SELECT * FROM " + TABLE + " ORDER BY event_date ASC";
    private static final String JOIN_USER_TO_EVENT = "INSERT INTO user_event VALUES(? , ?)";
    private static final String SORT_EVENT_BY_USERS_UP = "SELECT COUNT(event_amount_user) * FROM "+ TABLE +
            " ORDER BY event_amount_user DESC";
    private static final String SORT_EVENT_BY_USERS_DOWN = "SELECT COUNT(event_amount_user) * FROM "+ TABLE +
            " ORDER BY event_amount_user ASC";





    @Override
    public List getEvents(Connection connection) throws SQLException {
        List<Event> events = new ArrayList<>();
        String query = GET_ALL_EVENTS;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Event event = getEvent(resultSet);
                event.setId(resultSet.getLong("event_id"));
                events.add(event);
            }
        }
        return events;
    }

    @Override
    public Event getEventById(Connection connection, Long eventId) throws SQLException {
        Event event = null;
        String query = GET_EVENT_BY_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, eventId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    event = getEvent(resultSet);
                    event.setId(resultSet.getLong("event_id"));
                }
            }
        }
        return event;
    }

    @Override
    public List getEventsByUser(Connection connection, Long userId) throws SQLException {
        List<Event> events = new ArrayList<>();
        String query = GET_EVENT_BY_USER;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Event event = getEvent(resultSet);
                    event.setId(resultSet.getLong("event_id"));
                    events.add(event);
                }
            }
        }
        return events;

    }

    @Override
    public Event getEventByName(Connection connection, String name) throws SQLException {
        Event event = null;
        String query = GET_EVENT_BY_NAME;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    event = getEvent(resultSet);
                    event.setId(resultSet.getLong("event_name"));
                }
            }
        }
        return event;
    }

    @Override
    public Long addEvent(Connection connection, Event event) throws SQLException {
        String query = ADD_EVENT;
        Long id = 0L;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setDate(1, event.getDate());
            preparedStatement.setString(2, event.getPlace());
            preparedStatement.setString(3, event.getName());
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getLong(1);
                }
            }
        }
        return id;
    }


    @Override
    public boolean removeEventById(Connection connection, Long id) throws SQLException {
        String query = DELETE_EVENT_BY_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean changeEvent(Connection connection, Event event) throws SQLException {
        String query = CHANGE_EVENT;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, event.getDate());
            preparedStatement.setString(2, event.getPlace());
            preparedStatement.setString(3, event.getName());
            preparedStatement.setLong(4, event.getId());

            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public List sortEventByDateUp(Connection connection) throws SQLException {
        List<Event> events = new ArrayList<>();
        String query = SORT_EVENT_BY_DATE_UP;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Event event = getEvent(resultSet);
                event.setId(resultSet.getLong("event_id"));
                events.add(event);
            }
        }
        return events;
    }


    @Override
    public List sortEventByDateDown(Connection connection) throws SQLException {
        List<Event> events = new ArrayList<>();
        String query = SORT_EVENT_BY_DATE_DOWN;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Event event = getEvent(resultSet);
                event.setId(resultSet.getLong("event_id"));
                events.add(event);
            }
        }
        return events;
    }



    @Override
    public List sortEventByAmountOfUsersUp(Connection connection) throws SQLException {
        List<Event> events = new ArrayList<>();
        String query = SORT_EVENT_BY_USERS_UP;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Event event = getEvent(resultSet);
                event.setId(resultSet.getLong("event_id"));
                events.add(event);
            }
        }
        return events;
    }

    @Override
    public List sortEventByAmountOfUsersDown(Connection connection) throws SQLException {
        List<Event> events = new ArrayList<>();
        String query = SORT_EVENT_BY_USERS_DOWN;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Event event = getEvent(resultSet);
                event.setId(resultSet.getLong("event_id"));
                events.add(event);
            }
        }
        return events;
    }

    @Override
    public Long joinToEvent(Connection connection, Long userId, Long eventId) throws SQLException {
        Long id = 0L;
        String query = JOIN_USER_TO_EVENT;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, eventId);
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getLong(1);

                }
            }
            return id;
        }
    }

    private Event getEvent(ResultSet resultSet) throws SQLException{
        return new Event(resultSet.getDate("event_date"),resultSet.getString("event_place"),resultSet.getString("event_name"));
    }
}
