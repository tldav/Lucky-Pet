package com.tekgs.nextgen.luckyPet.view.notFound;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.tekgs.nextgen.luckyPet.view.LuckyPetView;
import com.tekgs.nextgen.luckyPet.view.error.ErrorView;

public class NotFoundView extends LuckyPetView {
    private static final String RELATIVE_URL = "not-found";
    private static final String LOCATOR_VALUE = "body";
    private static final String DESCRIPTION = "'Page Not Found'";
    private static final String LOCATOR_TYPE = UiLocatorType.TAG;
    
    public NotFoundView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static ErrorView directNav() {
        new NotFoundView().load();
        return LuckyPetView.expect(ErrorView.class);
    }
    
    @Override
    protected boolean areKeyElementsLoaded() {
        return true;
    }
}
