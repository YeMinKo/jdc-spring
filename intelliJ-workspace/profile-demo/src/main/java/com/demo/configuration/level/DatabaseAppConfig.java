package com.demo.configuration.level;

import com.demo.configuration.level.dao.DatabaseStoreFinancialReportDao;
import com.demo.configuration.level.dao.FinancialDataDao;
import com.demo.configuration.level.service.DatabaseReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("database")
public class DatabaseAppConfig {

    @Bean
    public FinancialDataDao financialDataDao() {
        return new DatabaseStoreFinancialReportDao();
    }

    @Bean
    public DatabaseReportWriter databaseReportWriter() {
        return new DatabaseReportWriter();
    }
}
