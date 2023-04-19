package com.tekgs.nextgen.luckyPet.view.pets.petListRegion.petRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class PetRegion extends UiRegion implements PetRegionCalibratable {
    private PetRegion(UiElement petRegionElement) {
        super(petRegionElement);
    }

    public static PetRegion getInstance(UiElement petElement) {
        return new PetRegion(petElement);
    }

    @Override
    public boolean equivalent(PetRegionCalibratable comparator) {
        return comparator.getName() == null || this.getName().equals(comparator.getName());
    }

    @Override
    public String getName() {
        return this.getElement().getText();
    }
}
