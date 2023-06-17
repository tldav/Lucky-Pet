package com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.loginFailureRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public class LoginFailureRegion extends UiRegion implements LoginFailureRegionCalibratable {
    private LoginFailureRegion(UiElement regionElement) {
        super(regionElement);
    }
    
    public static LoginFailureRegion getInstance(UiElement regionElement) {
        return new LoginFailureRegion(regionElement);
    }
    
    private UiElement getFailureCountElement() {
        return UiElement.getInstance("Failure Count", UiLocatorType.CLASS, "failure-count", this.getElement());
    }
    
    private UiElement getDateElement() {
        return UiElement.getInstance("Date", UiLocatorType.CLASS, "failure-date", this.getElement());
    }
    
    @Override
    public String getFailureCount() {
        return getFailureCountElement().getText();
    }
    
    @Override
    public String getDate() {
        return getDateElement().getText();
    }
    
    @Override
    public boolean equivalent(LoginFailureRegionCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        boolean isEquivalent = comparator.getDate() == null || this.getDate().equals(comparator.getDate());
        isEquivalent &= comparator.getFailureCount() == null || this.getFailureCount().equals(comparator.getFailureCount());
        return isEquivalent;
    }
}
