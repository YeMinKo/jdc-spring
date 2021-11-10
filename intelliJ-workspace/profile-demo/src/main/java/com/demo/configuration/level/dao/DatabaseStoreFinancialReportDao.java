package com.demo.configuration.level.dao;

import com.demo.configuration.level.ds.FinancialReport;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

public class DatabaseStoreFinancialReportDao implements FinancialDataDao {
    @Override
    public FinancialReport financialReport() {
        System.out.println("Database FinancialReport");
        return null;
    }
}
