package com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.revenueRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class RevenueRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Revenue' region";
    private final RevenueRegionCalibratable expected;
    private final RevenueRegionCalibratable actual;
    
    private RevenueRegionCalibrator(RevenueRegionCalibratable expected, RevenueRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }
    
    public static RevenueRegionCalibrator getInstance(RevenueRegionCalibratable expected, RevenueRegionCalibratable actual) {
        return new RevenueRegionCalibrator(expected, actual);
    }
    
    @Override
    protected void executeVerifications() {
        verify("'Gross Revenue' gross", this.expected.getRevenueGross(), this.actual.getRevenueGross());
        verify("'Gross Revenue' month", this.expected.getRevenueMonth(), this.actual.getRevenueMonth());
        verify("'Gross Revenue' year", this.expected.getRevenueYear(), this.actual.getRevenueYear());
    }
}
