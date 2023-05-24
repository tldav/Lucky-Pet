package com.luckypet.user.data.cart.itemList;

import com.luckypet.ListCalibrator;
import com.luckypet.user.data.cart.itemList.item.ItemCalibratable;
import com.luckypet.user.data.cart.itemList.item.ItemCalibrator;

public class ItemListCalibrator extends ListCalibrator<ItemCalibrator, ItemCalibratable> {
    private static final String DESCRIPTION = "'Item List'";

    private ItemListCalibrator(ItemListCalibratable expected, ItemListCalibratable actual) {
        super(DESCRIPTION, expected, actual, ItemCalibrator.class, ItemCalibratable.class);
    }

    public static ItemListCalibrator getInstance(ItemListCalibratable itemListExpected, ItemListCalibratable itemList){
        return new ItemListCalibrator(itemListExpected, itemList);
    }

    @Override
    protected void executeVerifications() {

    }
}
