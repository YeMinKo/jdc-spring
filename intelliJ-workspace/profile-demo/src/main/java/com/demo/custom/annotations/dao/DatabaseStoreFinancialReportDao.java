package com.demo.custom.annotations.dao;

import com.demo.custom.annotations.annotations.DatabaseProfile;
import com.demo.custom.annotations.ds.FinancialReport;
import org.springframework.stereotype.Component;

@Component
@DatabaseProfile
public class DatabaseStoreFinancialReportDao implements FinancialDataDao {
    @Override
    public FinancialReport financialReport() {
        System.out.println("Database FinancialReport");
        return null;
    }
}
