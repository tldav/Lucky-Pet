package com.tekgs.nextgen.luckyPet.view.pets.petListRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.petRegion.PetRegion;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.petRegion.PetRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class PetListRegion extends UiRegion implements PetListRegionCalibratable {
    private PetListRegion(UiElement parentElement) {
        super(UiElement.getInstance("'Pet List' region", UiLocatorType.ID, "pet-list-region", parentElement));
    }
    
    public static PetListRegionCalibratable getInstance(UiElement element) {
        return new PetListRegion(element);
    }
    
    @Override
    public List<PetRegionCalibratable> getPetRegions() {
        List<PetRegionCalibratable> petRegions = new ArrayList<>();
        for (UiElement petElement : UiElement.getList("'Pet' region", UiLocatorType.CLASS, "pet-region", this.getElement())) {
            petRegions.add(PetRegion.getInstance(petElement));
        }
        return petRegions;
    }
}
