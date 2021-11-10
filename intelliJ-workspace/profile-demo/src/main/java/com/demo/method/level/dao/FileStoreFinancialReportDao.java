package com.demo.method.level.dao;

import com.demo.method.level.ds.FinancialReport;

public class FileStoreFinancialReportDao implements FinancialDataDao{
    @Override
    public FinancialReport financialReport() {
        System.out.println("FileStore FinancialReport");
        return null;
    }
}
