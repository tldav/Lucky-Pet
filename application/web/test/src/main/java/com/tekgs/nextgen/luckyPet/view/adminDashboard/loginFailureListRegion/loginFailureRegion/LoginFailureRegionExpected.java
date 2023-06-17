package com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.loginFailureRegion;

public class LoginFailureRegionExpected implements LoginFailureRegionCalibratable {
    private final String failureDate;
    private final Integer failureCount;

    public LoginFailureRegionExpected(String failureDate, Integer failureCount) {
        this.failureDate = failureDate;
        this.failureCount = failureCount;
    }

    public static LoginFailureRegionExpected getInstance(String date, Integer count) {
        return new LoginFailureRegionExpected(date, count);
    }

    @Override
    public boolean equivalent(LoginFailureRegionCalibratable comparator) {
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
