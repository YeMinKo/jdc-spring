package com.demo.custom.annotations;
import com.demo.custom.annotations.service.FinancialReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfilesResolver;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        // Just Testing...
        ActiveProfilesResolver obj;

        // Activate Profile
//        context.getEnvironment().setActiveProfiles("database");
//        context.register(AppConfig.class);
//        context.refresh();

        FinancialReportService financialReportService = context.getBean(FinancialReportService.class);
        financialReportService.generateReport();

    }
}
