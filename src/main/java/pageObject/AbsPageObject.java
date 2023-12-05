package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiters;

import java.util.List;

public abstract class AbsPageObject {
    protected WebDriver driver;
    protected Waiters webDriverWait;
    protected Actions actions;
    public AbsPageObject(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new Waiters(driver);
        this.actions = new Actions(driver);

        PageFactory.initElements(driver, this);
    }

    protected WebElement $(By selector) {
        return driver.findElement(selector);
    }

    protected List<WebElement> $$(By selector) {
        return driver.findElements(selector);
    }

    public void actionsMoveElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}