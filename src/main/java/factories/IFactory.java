package factories;

import data.BrowserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public interface IFactory {
    WebDriver createDriver(BrowserData data);
    WebDriverManager setUp(BrowserData data) ;

}