package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverFactory;

public class Page {

    protected String url;
    protected String title;
    protected WebDriver driver;

    public Page() {
        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(url);
    }

    public String getExpectedTitle() {
        return title;
    }
}
