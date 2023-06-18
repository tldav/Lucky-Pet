package com.tekgs.nextgen.luckyPet.view.error;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import org.softwareonpurpose.gauntlet.Environment;

public class ErrorView extends UiView implements ErrorViewCalibratable {
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String RELATIVE_URL = "error";
    private static final String VIEW_URL = String.format("%s/%s", DOMAIN_URL, RELATIVE_URL);
    private static final String DESCRIPTION = "'Error' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "error-view";
    
    public ErrorView() {
        super(VIEW_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
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
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }
}
