package com.tekgs.nextgen.luckyPet.view.pets;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.tekgs.nextgen.luckyPet.view.LuckyPetView;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.PetListRegion;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.PetListRegionCalibratable;

public class PetsView extends LuckyPetView implements PetsViewCalibratable {
    private static final String RELATIVE_URL = "pets";
    private static final String DESCRIPTION = "'Pets' View";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "pets-view";
    
    public PetsView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static PetsView directNav() {
        new PetsView().load();
        return LuckyPetView.expect(PetsView.class);
    }
    
    @Override
    public PetListRegionCalibratable getPetListRegion() {
        return PetListRegion.getInstance(this.getElement());
    }
    
    @Override
    protected boolean areKeyElementsLoaded() {
        return true;
    }
    
}
