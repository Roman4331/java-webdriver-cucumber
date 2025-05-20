package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverFactory;

public class QuotePOM {

    private static final String URL = "https://skryabin.com/market/quote.html";
    WebDriver driver = DriverFactory.getDriver();

    public QuotePOM() {
        
        
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    //elements


    //methods
    public void openQuoteForm() {
        driver.get(URL);
    }





}
