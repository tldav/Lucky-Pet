package com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.revenueRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public class RevenueRegion extends UiRegion implements RevenueRegionCalibratable {
    private RevenueRegion(UiElement regionElement) {
        super(regionElement);}

    public static RevenueRegion getInstance(UiElement regionElement) {
        return new RevenueRegion(regionElement);
    }

    private UiElement getGrossElement() {
        return UiElement.getInstance("'Revenue' gross", UiLocatorType.CLASS, "revenue-gross", this.getElement());
    }

    private UiElement getMonthElement() {
        return UiElement.getInstance("'Revenue' month", UiLocatorType.CLASS, "revenue-month", this.getElement());
    }

    private UiElement getYearElement() {
        return UiElement.getInstance("'Revenue' year", UiLocatorType.CLASS, "revenue-year", this.getElement());
    }

    @Override
    public String getRevenueGross() {
        return this.getGrossElement().getText();
    }

    @Override
    public String getRevenueMonth() {
        return this.getMonthElement().getText();
    }

    @Override
    public String getRevenueYear() { return this.getYearElement().getText(); }

    @Override
    public boolean equivalent(RevenueRegionCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        boolean isEquivalent = comparator.getRevenueMonth() == null || this.getRevenueMonth().equals(comparator.getRevenueMonth());
        isEquivalent &= comparator.getRevenueYear() == null || this.getRevenueYear().equals(comparator.getRevenueYear());
        isEquivalent &= comparator.getRevenueGross() == null || this.getRevenueGross().equals(comparator.getRevenueGross());
        return isEquivalent;
    }
}
