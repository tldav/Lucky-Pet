package com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion.failedLoginRegion;

public class FailedLoginRegionExpected implements FailedLoginRegionCalibratable {
    private final String failureDate;
    private final Integer failureCount;

    public FailedLoginRegionExpected(String failureDate, Integer failureCount) {
        this.failureDate = failureDate;
        this.failureCount = failureCount;
    }

    public static FailedLoginRegionExpected getInstance(String date, Integer count) {
        return new FailedLoginRegionExpected(date, count);
    }

    @Override
    public boolean equivalent(FailedLoginRegionCalibratable comparator) {
        return false;
    }

    @Override
    public String getFailureCount() {
        return failureCount.toString();
    }

    @Override
    public String getDate() {
        return failureDate;
    }
}
