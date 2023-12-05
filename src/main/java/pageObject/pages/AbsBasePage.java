package pageObject.pages;

import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;

public abstract class AbsBasePage extends AbsPageObject {
    private String BASE_URL = System.getProperty("base.url", "https://otus.ru");

    private String path;
    public AbsBasePage(WebDriver driver, String path) {
        super(driver);
        this.path = path;
    }
    public void open() {
        driver.get(BASE_URL + path);
    }
}