package com.tekgs.nextgen.luckyPet.view.pets.petListRegion.petRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class PetRegion extends UiRegion implements PetRegionCalibratable {
    private PetRegion(UiElement regionElement) {
        super(regionElement);
    }
    
    public static PetRegion getInstance(UiElement regionElement) {
        return new PetRegion(regionElement);
    }
    
    @Override
    public String getName() {
        return this.getElement().getText();
    }
    
    @Override
    public boolean equivalent(PetRegionCalibratable comparator) {
        return comparator.getName() == null || this.getName().equals(comparator.getName());
    }
}
