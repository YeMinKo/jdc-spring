package com.demo.component.level.dao;

import com.demo.component.level.ds.FinancialReport;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("file")
public class FileStoreFinancialReportDao implements FinancialDataDao {
    @Override
    public FinancialReport financialReport() {
        System.out.println("FileStore FinancialReport");
        return null;
    }
}
