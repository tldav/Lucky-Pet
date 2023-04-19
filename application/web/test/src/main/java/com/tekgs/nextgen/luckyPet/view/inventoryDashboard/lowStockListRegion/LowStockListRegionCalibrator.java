package com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.lowStockRegion.LowStockRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.lowStockRegion.LowStockRegionCalibrator;

import java.util.ArrayList;
import java.util.List;

public class LowStockListRegionCalibrator extends Calibrator {

    private static final String DESCRIPTION = "'Low Inventory List' region";


    private LowStockListRegionCalibrator(LowStockListRegionCalibratable expected, LowStockListRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        List<LowStockRegionCalibratable> stockListExpected = expected.getLowStockRegions();
        List<LowStockRegionCalibratable> stockListActual = new ArrayList<>(actual.getLowStockRegions());
        addCalibrationsExpected(stockListExpected, stockListActual);
        addCalibrationsUnexpected(stockListActual);
        UiRegion.suppressConstructionLogging(false);
    }

public static LowStockListRegionCalibrator getInstance(LowStockListRegionCalibratable expected, LowStockListRegionCalibratable actual) {
        return new LowStockListRegionCalibrator(expected, actual);
    }

    private void addCalibrationsExpected(List<LowStockRegionCalibratable> stockListExpected, List<LowStockRegionCalibratable> stockListActual) {
        for (LowStockRegionCalibratable stockExpected : stockListExpected) {
            LowStockRegionCalibratable stockFound = addCalibrationFound(stockListActual, stockExpected);
            if (stockFound != null) {
                stockListActual.remove(stockFound);
            } else {
                addChildCalibrator(LowStockRegionCalibrator.getInstance(stockExpected, null));
            }
        }
    }

    private LowStockRegionCalibratable addCalibrationFound(List<LowStockRegionCalibratable> stockListActual, LowStockRegionCalibratable stockExpected) {
        LowStockRegionCalibratable stockFound = null;
        for (LowStockRegionCalibratable stockActual : stockListActual) {
            if (stockActual.equivalent(stockExpected)) {
                stockFound = stockActual;
                addChildCalibrator(LowStockRegionCalibrator.getInstance(stockExpected, stockActual));
                break;
            }
        }
        return stockFound;
    }

    private void addCalibrationsUnexpected(List<LowStockRegionCalibratable> stockListActual) {
        for (LowStockRegionCalibratable stockActual : stockListActual) {
            addChildCalibrator(LowStockRegionCalibrator.getInstance(null, stockActual));
        }
    }

    @Override
    protected void executeVerifications() {
    
    }
}
