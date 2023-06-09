package com.tekgs.nextgen.luckyPet.data.financial.revenue;

public class Revenue {
    private final String month;
    private final int year;
    private final long gross;
    
    private Revenue(String month, int year, long gross) {
        this.month = month;
        this.year = year;
        this.gross = gross;
    }
    
    public String getMonth() {
        return this.month;
    }
    
    public long getGross() {
        return this.gross;
    }
    
    public int getYear() {
        return this.year;
    }
}
