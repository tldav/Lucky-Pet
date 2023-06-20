package com.tekgs.nextgen.luckyPet.view.adminDashboard;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.view.LuckyPetView;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.LoginFailureListRegion;

public class AdminDashboardView extends LuckyPetView implements AdminDashboardViewCalibratable {
    private static final String RELATIVE_URL = "admin-dashboard";
    private static final String URL_PARAM = "?fileName=%s";
    private static final String DESCRIPTION = "'Admin Dashboard' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "admin-dashboard-view";
    
    public AdminDashboardView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static AdminDashboardView directNav() {
        new AdminDashboardView().load();
        return LuckyPetView.expect(AdminDashboardView.class);
    }
    
    public static AdminDashboardView directNav(String fileName) {
        new AdminDashboardView().load(String.format(URL_PARAM, fileName));
        return LuckyPetView.expect(AdminDashboardView.class);
    }
    
    @Override
    public LoginFailureListRegion getLoginFailureListRegion() {
        return LoginFailureListRegion.getInstance(this.getElement());
    }
    
    @Override
    protected boolean areKeyElementsLoaded() {
        return true;
    }
    
}
