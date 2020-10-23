package ua.nure.podvalnyi.db.service;

import ua.nure.podvalnyi.db.entity.Report;
import ua.nure.podvalnyi.exception.DBException;

import java.sql.SQLException;
import java.util.List;

public interface ReportService<E extends Report> {


    List<E> getReports() throws DBException;

    List<E> getReportByEventId(Long id) throws DBException;

    E getReportById(Long eventId) throws DBException;

    Long addReport(E report) throws DBException;

    boolean changeReport(E report) throws DBException;

    boolean changeReport( E report, Long userId) throws DBException;

}
