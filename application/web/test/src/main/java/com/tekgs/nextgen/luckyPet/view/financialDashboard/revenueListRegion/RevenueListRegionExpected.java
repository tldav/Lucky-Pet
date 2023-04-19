package com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion;

import com.tekgs.nextgen.luckyPet.data.financial.revenue.Revenue;
import com.tekgs.nextgen.luckyPet.data.financial.revenue.RevenueProvider;
import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.revenueRegion.RevenueRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.revenueRegion.RevenueRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class RevenueListRegionExpected implements RevenueListRegionCalibratable {
    
    List<Revenue> revenueList = new ArrayList<>();
    
    private RevenueListRegionExpected() {
        this.revenueList.addAll(RevenueProvider.getInstance().get());
    }
    
    public static RevenueListRegionCalibratable getInstance() {
        return new RevenueListRegionExpected();
    }
    
    @Override
    public List<RevenueRegionCalibratable> getRevenueRegions() {
        List<RevenueRegionCalibratable> revenueRegionsExpected = new ArrayList<>();
        
        this.revenueList.forEach(revenue ->{
            revenueRegionsExpected.add(RevenueRegionExpected.getInstance(revenue));
        });
        return revenueRegionsExpected;
    }
}
