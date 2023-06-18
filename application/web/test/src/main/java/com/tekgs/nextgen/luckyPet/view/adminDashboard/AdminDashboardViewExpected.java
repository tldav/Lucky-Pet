package com.tekgs.nextgen.luckyPet.view.adminDashboard;

import com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.LoginFailureListRegionExpected;

public class AdminDashboardViewExpected implements AdminDashboardViewCalibratable {
    private final String logFileName;
    
    private AdminDashboardViewExpected(String logFilename) {
        this.logFileName = logFilename;
    }
    
    public static AdminDashboardViewExpected getInstance() {
        return new AdminDashboardViewExpected(null);
    }
    
    public static AdminDashboardViewExpected getInstance(String logFilename) {
        return new AdminDashboardViewExpected(logFilename);
    }
    
    @Override
    public LoginFailureListRegionExpected getLoginFailureListRegion() {
        return LoginFailureListRegionExpected.getInstance(this.logFileName);
    }
}
