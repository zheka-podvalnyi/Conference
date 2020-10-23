package ua.nure.podvalnyi.db.service.implement;

import ua.nure.podvalnyi.db.dao.ReportDbDao;
import ua.nure.podvalnyi.db.entity.Report;
import ua.nure.podvalnyi.db.service.ReportService;
import ua.nure.podvalnyi.exception.DBException;
import ua.nure.podvalnyi.transaction.TransactionManager;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReportServiceImpl implements ReportService {

    private ReportDbDao reportDbDao;
    private TransactionManager transactionManager;

    public ReportServiceImpl(ReportDbDao reportDbDao, TransactionManager transactionManager) {
        this.reportDbDao = reportDbDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public List getReports() throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> reportDbDao.getReports(connection)))
                .orElse(Collections.emptyList());
    }

    @Override
    public List getReportByEventId(Long eventId) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> reportDbDao.getReportByEventId(connection,eventId)))
                .orElse(Collections.emptyList());
    }

    @Override
    public Report getReportById(Long id) throws DBException {
        return  transactionManager.useWithOutTransaction(connection -> reportDbDao.getReportById(connection, id));
    }

    @Override
    public Long addReport(Report report) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(
                connection -> reportDbDao.addReport(connection, report))).orElse(-1L);
    }

    @Override
    public boolean changeReport(Report report) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> reportDbDao.changeReport(connection, report)))
                .isPresent();
    }

    @Override
    public boolean changeReport(Report report, Long userId) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> reportDbDao.changeReport(connection, report,userId)))
                .isPresent();
    }
}
