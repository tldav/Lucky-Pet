package com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion.failedLoginRegion;

public interface FailedLoginRegionCalibratable {
    boolean equivalent(FailedLoginRegionCalibratable comparator);

    String getFailureCount();

    String getDate();
}
