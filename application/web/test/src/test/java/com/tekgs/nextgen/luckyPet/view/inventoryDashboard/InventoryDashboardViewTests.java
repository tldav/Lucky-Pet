package com.tekgs.nextgen.luckyPet.view.inventoryDashboard;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.LUCKY_PET_WEB, GauntletTest.View.INVENTORY_DASHBOARD})
public class InventoryDashboardViewTests extends GauntletTest {
    
    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("61-Inventory Management-low-inventory-report");
        InventoryDashboardView actual = InventoryDashboardView.directNav();
        InventoryDashboardViewExpected expected = InventoryDashboardViewExpected.getInstance();
        then(InventoryDashboardViewCalibrator.getInstance(expected, actual));
    }
}
