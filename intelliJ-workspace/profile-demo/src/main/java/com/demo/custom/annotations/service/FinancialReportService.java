package com.demo.custom.annotations.service;

import com.demo.custom.annotations.dao.FinancialDataDao;
import org.springframework.stereotype.Component;

@Component
public class FinancialReportService {

    private final FinancialDataDao financialDataDao;

    public FinancialReportService(FinancialDataDao financialDataDao) {
        this.financialDataDao = financialDataDao;
    }

    public void generateReport() {
        financialDataDao.financialReport();
    }
}
