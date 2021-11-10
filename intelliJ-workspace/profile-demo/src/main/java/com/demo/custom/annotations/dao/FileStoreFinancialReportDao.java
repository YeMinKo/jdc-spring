package com.demo.custom.annotations.dao;

import com.demo.custom.annotations.annotations.FileProfile;
import com.demo.custom.annotations.ds.FinancialReport;
import org.springframework.stereotype.Component;

@Component
@FileProfile
public class FileStoreFinancialReportDao implements FinancialDataDao {
    @Override
    public FinancialReport financialReport() {
        System.out.println("FileStore FinancialReport");
        return null;
    }
}
