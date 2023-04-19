package com.tekgs.nextgen.luckyPet.view.notFound;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.view.error.ErrorView;

public class NotFoundView extends UiView {
    private static final String VIEW_URL = "http://localhost:3000/notfound";
    private static final String LOCATOR_VALUE = "body";
    private static final String DESCRIPTION = "'Page Not Found'";
    private static final String LOCATOR_TYPE = UiLocatorType.TAG;

    public NotFoundView() {
        super(VIEW_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }


    public static ErrorView directNav() {
        new NotFoundView().load();
        return UiView.expect(ErrorView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return false;
    }
}
