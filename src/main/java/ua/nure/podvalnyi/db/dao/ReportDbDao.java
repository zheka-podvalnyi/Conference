package ua.nure.podvalnyi.db.dao;

import ua.nure.podvalnyi.db.entity.Report;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ReportDbDao<E extends Report> {

    List<E> getReports(Connection connection) throws SQLException;

    List<E> getReportByEventId(Connection connection, Long eventId) throws SQLException;

    E getReportById(Connection connection, Long id) throws SQLException;

    Long addReport(Connection connection, E report) throws SQLException;

    boolean changeReport(Connection connection, E report) throws SQLException;

    boolean changeReport(Connection connection, E report, Long userId) throws SQLException;
}
