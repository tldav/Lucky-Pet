package com.tekgs.nextgen.luckyPet.view.error;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.view.LuckyPetView;

public class ErrorView extends LuckyPetView implements ErrorViewCalibratable {
    private static final String RELATIVE_URL = "error";
    private static final String DESCRIPTION = "'Error' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "error-view";
    
    public ErrorView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static ErrorView directNav() {
        new ErrorView().load();
        return UiView.expect(ErrorView.class);
    }
    
    private UiElement getMessageElement() {
        return UiElement.getInstance("'Error' message", LOCATOR_TYPE, "error-message", this.getElement());
    }
    
    @Override
    public String getMessage() {
        return this.getMessageElement().getText();
    }
    
    @Override
    protected boolean areKeyElementsLoaded() {
        return false;
    }
}
