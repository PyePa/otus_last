package component;

import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;

public abstract class AbsBaseComponent extends AbsPageObject {
    public AbsBaseComponent(WebDriver driver) {
        super(driver);
    }
}