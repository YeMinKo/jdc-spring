package com.demo.configuration.level.dao;

import com.demo.configuration.level.ds.FinancialReport;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


public class FileStoreFinancialReportDao implements FinancialDataDao {
    @Override
    public FinancialReport financialReport() {
        System.out.println("FileStore FinancialReport");
        return null;
    }
}
