package com.demo.configuration.level.service;

import com.demo.configuration.level.dao.FinancialDataDao;
import org.springframework.stereotype.Component;

public class FinancialReportService {

    private final FinancialDataDao financialDataDao;

    public FinancialReportService(FinancialDataDao financialDataDao) {
        this.financialDataDao = financialDataDao;
    }

    public void generateReport() {
        financialDataDao.financialReport();
    }
}
