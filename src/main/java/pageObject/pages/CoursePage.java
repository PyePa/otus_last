package pageObject.pages;

import data.courses.CoursesDurationData;
import data.courses.CoursesFormatData;
import data.courses.CoursesSubTitleData;
import data.courses.CoursesTitleData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursePage extends AbsBasePage{
    public CoursePage(WebDriver driver) {
        super(driver, "/");
    }
    public CoursePage checkTitleCourse(String expected, CoursesTitleData coursesTitleData) {
        Assertions.assertEquals(expected, $(By.cssSelector(coursesTitleData.getName())).getText());
        return this;
    }

    public CoursePage checkSubTitleCourse(String expected, CoursesSubTitleData coursesSubTitleData) {
        Assertions.assertEquals(expected, $(By.cssSelector(coursesSubTitleData.getName())).getText());
        return this;
    }

    public CoursePage checkDurationCourse(String expected, CoursesDurationData coursesDurationData) {
        Assertions.assertEquals(expected, $(By.xpath(coursesDurationData.getName())).getText());
        return this;
    }

    public CoursePage checkFormatCourse(String expected, CoursesFormatData coursesFormatData) {
        Assertions.assertEquals(expected, $(By.xpath(coursesFormatData.getName())).getText());
        return this;
    }
}