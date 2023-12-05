package component;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CourseCatalog extends AbsBaseComponent {

    public CourseCatalog(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(), 'Каталог')]//ancestor::section//child::a")
    private List<WebElement> coursesListLocator;

    @FindBy(xpath = "//button[contains(text(),'Показать еще')]")
    private WebElement ShowMoreButtonLocator;

    private String courseSelector = "a[href='/lessons/%s']";

    public CourseCatalog checkVisibleCourses() {


        for (WebElement element : coursesListLocator) {
            Assertions.assertTrue(element.isDisplayed());
        }
        return this;
    }

    public CourseCatalog checkCountCourses(int countCourses) {

        Assertions.assertEquals(countCourses, coursesListLocator.size());
        return this;
    }

    public CourseCatalog clickCourse(String courseName) {

        String selector = String.format(courseSelector, courseName);
        $(By.cssSelector(selector)).click();
        return this;
    }
}