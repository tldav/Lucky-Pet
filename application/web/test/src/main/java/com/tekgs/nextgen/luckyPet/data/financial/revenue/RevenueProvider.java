package com.tekgs.nextgen.luckyPet.data.financial.revenue;

import java.util.List;

public class RevenueProvider {
    private final RevenueRepository repository = RevenueRepository.getInstance();
    
    private RevenueProvider() {
    }
    
    public static RevenueProvider getInstance() {
        return new RevenueProvider();
    }
    
    public List<Revenue> get() {
        return this.repository.query();
    }
}
