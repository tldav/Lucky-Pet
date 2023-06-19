package com.tekgs.nextgen.luckyPet.view;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiView;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import org.softwareonpurpose.gauntlet.Environment;

public abstract class LuckyPetView extends UiView {
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    
    protected LuckyPetView(String relativeUrl, UiElement viewElement) {
        super(String.format("%s/%s", DOMAIN_URL, relativeUrl), viewElement);
    }
    
    protected abstract boolean areKeyElementsLoaded();
    
    @Override
    protected boolean confirmElementStates() {
        long start = System.currentTimeMillis();
        boolean isConfirmed = WebUiHost.getInstance().getAddress().contains(this.getAddress());
        isConfirmed &= this.getElement().waitUntilVisible();
        isConfirmed &= this.areKeyElementsLoaded();
        isConfirmed &= System.currentTimeMillis() - start < 3000;
        return isConfirmed;
    }
    
}
