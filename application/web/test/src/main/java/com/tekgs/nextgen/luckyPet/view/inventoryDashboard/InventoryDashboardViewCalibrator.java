package com.tekgs.nextgen.luckyPet.view.inventoryDashboard;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.LowStockListRegionCalibrator;

public class InventoryDashboardViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Inventory Dashboard' view";

    private InventoryDashboardViewCalibrator(InventoryDashboardViewExpected expected, InventoryDashboardView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addChildCalibrator(LowStockListRegionCalibrator.getInstance(expected.getLowStockListRegion(), actual.getLowStockListRegion()));
        UiRegion.suppressConstructionLogging(false);
    }

    public static InventoryDashboardViewCalibrator getInstance(InventoryDashboardViewExpected expected, InventoryDashboardView actual) {
        return new InventoryDashboardViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
    }
}
