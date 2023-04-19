package com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion.failedLoginRegion.FailedLoginRegion;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion.failedLoginRegion.FailedLoginRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class FailedLoginListRegion extends UiRegion implements FailedLoginReportCalibratable {
    private static final String DESCRIPTION = "'Failed Login' report";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "failed-login-list-region";

    private FailedLoginListRegion(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static FailedLoginListRegion getInstance(UiElement parent) {
        return new FailedLoginListRegion(parent);
    }

    @Override
    public List<FailedLoginRegionCalibratable> getFailureDates() {
        List<FailedLoginRegionCalibratable> failures = new ArrayList<>();
        String description = FailedLoginRegion.DESCRIPTION;
        String locatorType = FailedLoginRegion.LOCATOR_TYPE;
        String locatorValue = FailedLoginRegion.LOCATOR_VALUE;
        List<UiElement> elements = UiElement.getList(description, locatorType, locatorValue, this.getElement());
        for(UiElement element:elements){
            failures.add(FailedLoginRegion.getInstance(element));
        }
        return failures;
    }
}
