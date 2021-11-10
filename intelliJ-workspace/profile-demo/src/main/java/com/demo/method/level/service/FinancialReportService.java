package com.demo.method.level.service;

import com.demo.method.level.dao.FinancialDataDao;

public class FinancialReportService {

    private final FinancialDataDao financialDataDao;

    public FinancialReportService(FinancialDataDao financialDataDao) {
        this.financialDataDao = financialDataDao;
    }

    public void generateReport() {
        financialDataDao.financialReport();
    }
}
