package com.tekgs.nextgen.luckyPet.view.adminDashboard;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion.FailedLoginListRegion;
import org.softwareonpurpose.gauntlet.Environment;

public class AdminDashboardView extends UiView implements AdminDashboardViewCalibratable {
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String RELATIVE_URL = "admin-dashboard";
    private static final String VIEW_URL = String.format("%s/%s", DOMAIN_URL, RELATIVE_URL);
    private static final String DESCRIPTION = "'Admin Dashboard' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "admin-dashboard";
    private static final String QUERY_STRING = "?fileName=%s";

    public AdminDashboardView() {
        super(VIEW_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static AdminDashboardView directNav() {
        new AdminDashboardView().load();
        return UiView.expect(AdminDashboardView.class);
    }

    public static AdminDashboardView directNav(String logFilename) {
        new AdminDashboardView().load(String.format(QUERY_STRING, logFilename));
        return UiView.expect(AdminDashboardView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().isDisplayed();
    }

    @Override
    public FailedLoginListRegion inFailedLoginReport() {
        return FailedLoginListRegion.getInstance(this.getElement());
    }
}
