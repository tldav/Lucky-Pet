package com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion.failedLoginRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public class FailedLoginRegion extends UiRegion implements FailedLoginRegionCalibratable {
    public static final String DESCRIPTION = "Failure Detail";
    public static final String LOCATOR_TYPE = UiLocatorType.CLASS;
    public static final String LOCATOR_VALUE = "failure-aggregation";

    private FailedLoginRegion(UiElement regionElement) {
        super(regionElement);
    }

    public static FailedLoginRegion getInstance(UiElement regionElement) {
        return new FailedLoginRegion(regionElement);
    }

    @Override
    public boolean equivalent(FailedLoginRegionCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        boolean isEquivalent = comparator.getDate() == null || this.getDate().equals(comparator.getDate());
        isEquivalent &= comparator.getFailureCount() == null || this.getFailureCount().equals(comparator.getFailureCount());
        return isEquivalent;
    }

    @Override
    public String getFailureCount() {
        return getFailureCountElement().getText();
    }

    private UiElement getFailureCountElement() {
        return UiElement.getInstance("Failure Count", UiLocatorType.CLASS, "failure-count", this.getElement());
    }

    @Override
    public String getDate() {
        return getDateElement().getText();
    }

    private UiElement getDateElement() {
        return UiElement.getInstance("Date", UiLocatorType.CLASS, "failure-date", this.getElement());
    }
}
