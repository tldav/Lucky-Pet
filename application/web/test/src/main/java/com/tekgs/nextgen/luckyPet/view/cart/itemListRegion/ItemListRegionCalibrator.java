package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion.ItemRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion.ItemRegionCalibrator;

import java.util.ArrayList;
import java.util.List;

public class ItemListRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Item List' region";
    private final ItemListRegionCalibratable expected;
    private final ItemListRegionCalibratable actual;


    private ItemListRegionCalibrator(ItemListRegionCalibratable expected, ItemListRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected=expected;
        this.actual=actual;
        UiRegion.suppressConstructionLogging(true);
        List<ItemRegionCalibratable> itemsExpected = expected.getItemRegions();
        List<ItemRegionCalibratable> itemsActual = new ArrayList<>(actual.getItemRegions());
        addCalibrationsExpected(itemsExpected, itemsActual);
        addCalibrationsUnexpected(itemsActual);
        UiRegion.suppressConstructionLogging(false);
    }

    public static ItemListRegionCalibrator getInstance(ItemListRegionCalibratable expected, ItemListRegionCalibratable actual) {
        return new ItemListRegionCalibrator(expected, actual);
    }

    private void addCalibrationsExpected(List<ItemRegionCalibratable> itemsExpected, List<ItemRegionCalibratable> itemsActual) {
        for (ItemRegionCalibratable itemExpected : itemsExpected) {
            ItemRegionCalibratable itemFound = addCalibrationFound(itemsActual, itemExpected);
            if (itemFound != null) {
                itemsActual.remove(itemFound);
            } else {
                addChildCalibrator(ItemRegionCalibrator.getInstance(itemExpected, null));
            }
        }
    }

    private ItemRegionCalibratable addCalibrationFound(List<ItemRegionCalibratable> itemsActual, ItemRegionCalibratable itemExpected) {
        ItemRegionCalibratable itemFound = null;
        for (ItemRegionCalibratable itemActual : itemsActual) {
            if (itemActual.equivalent(itemExpected)) {
                itemFound = itemActual;
                addChildCalibrator(ItemRegionCalibrator.getInstance(itemExpected, itemActual));
                break;
            }
        }
        return itemFound;
    }

    private void addCalibrationsUnexpected(List<ItemRegionCalibratable> itemsActual) {
        for(ItemRegionCalibratable itemActual: itemsActual){
            addChildCalibrator(ItemRegionCalibrator.getInstance(null, itemActual));
        }
    }
    
    @Override
    protected void executeVerifications() {
        // <@;) <- Todd
        verify("'Empty Cart' message", expected.getCartEmptyMessage(), actual.getCartEmptyMessage());
    }
}
