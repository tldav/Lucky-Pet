package com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.loginFailureRegion;

public interface LoginFailureRegionCalibratable {
    String getFailureCount();
    
    String getDate();
    
    boolean equivalent(LoginFailureRegionCalibratable comparator);
}
