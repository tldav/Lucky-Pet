package com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.revenueRegion;

import com.tekgs.nextgen.luckyPet.data.financial.Cents;
import com.tekgs.nextgen.luckyPet.data.financial.revenue.Revenue;

public class RevenueRegionExpected implements RevenueRegionCalibratable {
    private final Revenue revenue;

    private RevenueRegionExpected(Revenue revenue) {
        this.revenue = revenue;
    }

    public static RevenueRegionExpected getInstance(Revenue revenue) {
        return new RevenueRegionExpected(revenue);
    }

    @Override
    public boolean equivalent(RevenueRegionCalibratable comparator) {
        return false;
    }

    @Override
    public String getRevenueGross() {
        return Cents.getInstance(this.revenue.getGross()).inUsdFormat();
    }

    @Override
    public String getRevenueMonth() {
        return this.revenue.getMonth();
    }

    @Override
    public String getRevenueYear() {
        return String.valueOf(this.revenue.getYear());
    }
}
