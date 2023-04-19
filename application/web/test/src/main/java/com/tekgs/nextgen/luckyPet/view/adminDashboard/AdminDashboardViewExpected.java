package com.tekgs.nextgen.luckyPet.view.adminDashboard;

import com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion.FailedLoginReportExpected;

public class AdminDashboardViewExpected implements AdminDashboardViewCalibratable {
    private final String loginFailureLogFile;

    private AdminDashboardViewExpected(String logFilename) {
        this.loginFailureLogFile = logFilename;
    }

    public static AdminDashboardViewExpected getInstance() {
        return new AdminDashboardViewExpected(null);
    }

    public static AdminDashboardViewExpected getInstance(String logFilename) {
        return new AdminDashboardViewExpected(logFilename);
    }

    @Override
    public FailedLoginReportExpected inFailedLoginReport() {
        return FailedLoginReportExpected.getInstance(loginFailureLogFile);
    }
}
