package com.demo.method.level.dao;

import com.demo.method.level.ds.FinancialReport;

public class DatabaseStoreFinancialReportDao implements FinancialDataDao{
    @Override
    public FinancialReport financialReport() {
        System.out.println("Database FinancialReport");
        return null;
    }
}
