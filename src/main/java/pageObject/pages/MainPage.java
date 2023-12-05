package pageObject.pages;

import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;

public class MainPage extends AbsBasePage {
    public MainPage(WebDriver driver) {
        super(driver, "/");
    }
}