package ua.nure.podvalnyi.db.dao.implement;

import ua.nure.podvalnyi.db.dao.ReportDbDao;
import ua.nure.podvalnyi.db.entity.Report;
import ua.nure.podvalnyi.db.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDbDaoImpl implements ReportDbDao {

    private static final String TABLE = "report";
    private static final String GET_ALL_REPORTS = "SELECT * FROM " + TABLE;
    private static final String GET_REPORT_BY_ID = "SELECT * FROM " + TABLE + " WHERE report_id=?";
    private static final String GET_REPORT_BY_EVENT_ID = "SELECT * FROM " + TABLE + "WHERE event_id=?";
    private static final String ADD_REPORT = "INSERT INTO " + TABLE + " VALUES (DEFAULT,?)";
    private static final String CHANGE_REPORT = "UPDATE " + TABLE + " SET report_topic=? WHERE report_id=?";
    private static final String CHANGE_REPORT_BY_USER = "UPDATE " + TABLE +
            " SET report_topic=? WHERE user_id=?";

    @Override
    public List getReports(Connection connection) throws SQLException {
        List<Report> reports = new ArrayList<>();
        String query = GET_ALL_REPORTS;
        try (PreparedStatement prepared = connection.prepareStatement(query);
             ResultSet resultSet = prepared.executeQuery()) {
            while (resultSet.next()) {
                Report report = getReport(resultSet);
                report.setId(resultSet.getLong("report_id"));
                reports.add(report);
            }
        }
        return reports;
    }


    @Override
    public List getReportByEventId(Connection connection, Long eventId) throws SQLException {
        List<Report> reports = new ArrayList<>();
        String query = GET_REPORT_BY_EVENT_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, eventId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Report report = getReport(resultSet);
                    report.setId(resultSet.getLong("report_id"));
                    reports.add(report);
                }
            }
        }
        return reports;
    }

    @Override
    public Report getReportById(Connection connection, Long reportId) throws SQLException {
        Report report = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_REPORT_BY_ID)) {
            preparedStatement.setLong(1, reportId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    report = getReport(resultSet);
                    report.setId(resultSet.getLong("report_id"));
                }
            }
        }
        return report;
    }

    @Override
    public Long addReport(Connection connection, Report report) throws SQLException {
        String query = ADD_REPORT;
        Long id = 0L;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, report.getTopic());
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
    public boolean changeReport(Connection connection, Report report) throws SQLException {
        String query = CHANGE_REPORT;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, report.getTopic());
            preparedStatement.setLong(2, report.getId());
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean changeReport(Connection connection, Report report, Long userId) throws SQLException {


        String query = CHANGE_REPORT_BY_USER;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, report.getTopic());
            preparedStatement.setLong(2, report.getId());

            return preparedStatement.executeUpdate() > 0;
        }
    }



    private Report getReport(ResultSet resultSet) throws SQLException{
        return new Report(resultSet.getString("report_topic"));
    }
}
