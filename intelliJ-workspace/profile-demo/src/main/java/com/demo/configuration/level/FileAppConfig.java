package com.demo.configuration.level;

import com.demo.configuration.level.dao.FileStoreFinancialReportDao;
import com.demo.configuration.level.dao.FinancialDataDao;
import com.demo.configuration.level.service.FileReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("file")
public class FileAppConfig {

    @Bean
    public FinancialDataDao financialDataDao() {
        return new FileStoreFinancialReportDao();
    }

    @Bean
    public FileReportWriter fileReportWriter() {
        return new FileReportWriter();
    }
}
