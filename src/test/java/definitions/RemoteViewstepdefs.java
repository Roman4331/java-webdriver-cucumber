package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
public class RemoteViewstepdefs {
    @Given("I navigate to the OKC Job Match")
    public void iNavigateToTheChromeRemoteViewPage() {
    getDriver().get("https://okjobmatch.com");
    }

    @When("I enter login {string} and password {string}")
    public void iEnterLoginAndPassword(String username, String password) {
        getDriver().findElement(By.xpath("//input[@id='user_username']")).sendKeys(username);
        getDriver().findElement(By.xpath("//input[@id='user_password']")).sendKeys(password);
    }

    @When("I click on NEXT button in modal")
    public void iClickOnNEXTButtonInModal() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Next')]")).click();
    }

    @When("I enter password {string}")
    public void iEnterPassword(String password) {
        getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(password);
    }

    @When("I click on NEXTtwo button in modal")
    public void iClickOnNEXTtwoButtonInModal() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Next')]")).click();
    }

    @Then("I click on CactusTotco button in modal")
    public void iClickOnCactusTotcoButtonInModal() {
        getDriver().findElement(By.xpath("//div[contains(text(),'MacBook-Pro.local')]")).click();
    }

    @Then("I enter pin {string}")
    public void iEnterPin(String PIN) {
        getDriver().findElement(By.xpath("//input[@aria-label='Enter PIN']")).sendKeys(PIN);
    }

    @Then("I click on right arrow button")
    public void iClickOnRightArrowButton() {
        getDriver().findElement(By.xpath("//div[@aria-label='Submit PIN and connect']")).click();
    }

    @Then("I click on login")
    public void iClickOnLogin() {
        getDriver().findElement(By.xpath("//a[@href='/usr/sign_in']")).click();
    }


    @When("I click on Log In button in modal")
    public void iClickOnLogInButtonInModal() {
        getDriver().findElement(By.xpath("//input[@value='Log In']")).click();
    }

    @Then("I click on job search")
    public void iClickOnJobSearchInTheLeftPanelMenu() {
        getDriver().findElement(By.id("button8")).click();
    }

    @Then("I fill out search menu with keywords {string}, {string}, {int}")
    public void iFillOutSearchMenuWithKeywords(String keyword, String location, int num) {
        getDriver().findElement(By.id("search_job_search_keywords_picker")).sendKeys(keyword);
        getDriver().findElement(By.id("job_search_location_field")).sendKeys(location);
        getDriver().findElement(By.id("job_search_radius_field")).sendKeys(String.valueOf(num));
    }
}
