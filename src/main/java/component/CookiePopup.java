package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiePopup extends AbsBaseComponent{
    public CookiePopup(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[contains(text(),'OK')]")
    private WebElement buttonCookie;

    public CookiePopup clickOnButtonCookie() {
        buttonCookie.click();
        return this;
    }
}