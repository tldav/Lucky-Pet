package com.tekgs.nextgen.luckyPet.view.pets.petListRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.petRegion.PetRegion;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.petRegion.PetRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class PetListRegion extends UiRegion implements PetListRegionCalibratable {
    private static final String DESCRIPTION = "'Pet List' region";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "pet-list-region";
    
    private PetListRegion(UiElement parentElement) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parentElement));
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
