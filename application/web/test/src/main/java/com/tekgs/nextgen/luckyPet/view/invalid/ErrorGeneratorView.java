package com.tekgs.nextgen.luckyPet.view.invalid;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.view.LuckyPetView;
import com.tekgs.nextgen.luckyPet.view.error.ErrorView;

public class ErrorGeneratorView extends LuckyPetView {
    private static final String RELATIVE_URL = "error-generator";
    private static final String DESCRIPTION = "'Generic Error' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "error-generator";
    
    public ErrorGeneratorView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static ErrorView directNav() {
        new ErrorGeneratorView().load();
        return UiView.expect(ErrorView.class);
    }
    
    @Override
    protected boolean areKeyElementsLoaded() {
        return true;
    }
}
