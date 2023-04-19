package com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.revenueRegion;

public interface RevenueRegionCalibratable {

    String getRevenueGross();

    String getRevenueMonth();

    String getRevenueYear();

    boolean equivalent(RevenueRegionCalibratable comparator);
}
