package waiters;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    private WebDriver driver;
    public Waiters(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            webDriverWait.until(condition);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public void waitForVisibleElement(WebElement webElement) {
        Assertions.assertTrue(waitForCondition(ExpectedConditions.visibilityOf(webElement)));
    }

    public void waitForInvisibleElement(WebElement webElement) {
        Assertions.assertTrue(waitForCondition(ExpectedConditions.invisibilityOf(webElement)));
    }

    public void waitForClickableElement(WebElement webElement) {
        Assertions.assertTrue(waitForCondition(ExpectedConditions.elementToBeClickable(webElement)));
    }

    public void waitForAttributeNotContains(WebElement locator, String attribute, String valueAttribute) {
        Assertions.assertTrue(waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(locator, attribute, valueAttribute))));
    }
    public void waitForAttributeContains(WebElement locator, String attribute, String valueAttribute) {
        Assertions.assertTrue(waitForCondition(ExpectedConditions.attributeContains(locator, attribute, valueAttribute)));
    }


    public boolean waitUrlContains(String str) {
        return waitForCondition(ExpectedConditions.urlContains(str));
    }

}