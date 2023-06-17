package com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.loginFailureRegion.LoginFailureRegion;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.loginFailureRegion.LoginFailureRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class LoginFailureListRegion extends UiRegion implements LoginFailureListRegionCalibratable {
    private static final String DESCRIPTION = "'Failed Login' report";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "login-failure-list-region";
    
    private LoginFailureListRegion(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }
    
    public static LoginFailureListRegion getInstance(UiElement parent) {
        return new LoginFailureListRegion(parent);
    }
    
    @Override
    public List<LoginFailureRegionCalibratable> getLoginFailureRegions() {
        List<LoginFailureRegionCalibratable> loginFailureRegions = new ArrayList<>();
        List<UiElement> elements = UiElement.getList("'Login Failure' region", UiLocatorType.CLASS, "login-failure-region", this.getElement());
        for (UiElement element : elements) {
            loginFailureRegions.add(LoginFailureRegion.getInstance(element));
        }
        return loginFailureRegions;
    }
}
