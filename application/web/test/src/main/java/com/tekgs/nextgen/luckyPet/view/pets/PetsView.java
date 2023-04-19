package com.tekgs.nextgen.luckyPet.view.pets;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.PetListRegion;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.PetListRegionCalibratable;
import org.softwareonpurpose.gauntlet.Environment;

public class PetsView extends UiView implements PetsViewCalibratable {
    private static final String DESCRIPTION = "'Pets' View";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "pets-view";
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String RELATIVE_URL = "pets";
    private static final String VIEW_URL = String.format("%s/%s", DOMAIN_URL, RELATIVE_URL);

    public PetsView() {
        super(VIEW_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static PetsView directNav() {
        new PetsView().load();
        return UiView.expect(PetsView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    @Override
    public PetListRegionCalibratable getPetListRegion() {
        return PetListRegion.getInstance(this.getElement());
    }
}
