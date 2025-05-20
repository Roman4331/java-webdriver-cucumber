package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.QuoteForm;
import pages.QuoteResult;
import support.DriverFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static support.DriverFactory.getDriver;

public class QuoteStepDefs {
    WebDriver driver = DriverFactory.getDriver();
    QuoteForm quoteForm = new QuoteForm();
    QuoteResult quoteResult = new QuoteResult();

    @Given("I visit Quote Page in the {string} Environment")
    public void iVisitQuotePageInTheEnvironment(String env)
    {
        if(env.equalsIgnoreCase("QA")) {
            getDriver().get("https://quote-qa.portnov.com/");
        } else if (env.equalsIgnoreCase("Stage")) {
            getDriver().get("https://quote-stage.portnov.com/");
        } else {
            System.out.println("Wrong Environment option");
        }

    }
    @When("I enter {string} for the Username field")
    public void iEnterForTheUsernameField(String userName) {
        getDriver().findElement(By.name("username")).sendKeys(userName);

    }
    @And("I enter {string} for first name and {string} for the last name in the Name field")
    public void iEnterForFirstNameAndForTheLastNameInTheNameField(String firstName, String lastName) {
        getDriver().findElement(By.id("name")).click();
        getDriver().findElement(By.id("firstName")).sendKeys(firstName);
        getDriver().findElement(By.id("lastName")).sendKeys(lastName);
        getDriver().findElement(By.xpath("//button/span[text()='Save']")).click();
    }

    @And("I enter {string} for the Email field")
    public void iEnterForTheEmailField(String email) {
        getDriver().findElement(By.name("email")).sendKeys((email));
    }

    @When("I enter {string} for the Password field")
    public void iEnterForThePasswordField(String password) {
        getDriver().findElement(By.id("password")).sendKeys(password);
    }


    @And("I enter {string} for the Confirm Password field")
    public void iEnterForTheConfirmPasswordField(String password) {
        getDriver().findElement(By.id("confirmPassword")).sendKeys(password);
    }
    @Then("I {string} the Privacy Policy Policy checkbox")
    public void iThePrivacyPolicyPolicyCheckbox(String status) {
        getDriver().findElement(By.name("agreedToPrivacyPolicy")).click();
    }


    @When("I click on the {string} button at the bottom of the page")
    public void iClickOnTheButtonAtTheBottomOfThePage(String button) {
        String id = "";
        switch (button) {
            case "Submit":
//                getDriver().findElement(By.id("formSubmit")).click();
                id = "formSubmit";
                break;
            case "Reset":
                break;
            case "Refresh":
                break;
            default:
                System.out.println("Bad War");
        }
getDriver().findElement(By.id(id)).click();
    }

    @Then("I verify we see the Submitted Application Page")
    public void iVerifyWeSeeTheSubmittedApplicationPage() {
        assertThat(getDriver().findElement(By.id("quotePageResult")).isDisplayed()).isTrue();
    }

    @Then("I verify username is {string}, first name is {string}, last name is {string}, email is {string}")
    public void iVerifyUsernameIsFirstNameIsLastNameIsEmailIs(String username, String firstName, String lastName, String email) {
        assertThat(getDriver().findElement(By.name("username")).getText()).isEqualTo(username);
        assertThat(getDriver().findElement(By.name("firstName")).getText()).isEqualTo(firstName);
        assertThat(getDriver().findElement(By.name("lastName")).getText()).isEqualTo(lastName);
        assertThat(getDriver().findElement(By.name("email")).getText()).isEqualTo(email);
    }

    @When("I fill out the required fields on the form")
    public void iFillOutTheRequiredFieldsOnTheForm() throws InterruptedException {
        // example of using variable for WebElement - the element is used multiple times
        WebElement usernameElement = driver.findElement(By.xpath("//input[@name='username']"));
        usernameElement.sendKeys("a");
        usernameElement.sendKeys(Keys.ENTER);
//        Thread.sleep(1000);
        usernameElement.clear();
        usernameElement.sendKeys("john_doe");
        driver.findElement(By.xpath("//input[@id='name']")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Doe");
        driver.findElement(By.xpath("//span[text()='Save']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("john.doe@example.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

    }

    @And("I submit the quote form")
    public void iSubmitTheQuoteForm() {
        driver.findElement(By.xpath("//button[@id='formSubmit']")).click();    }

    @Then("I see required fields submitted successfully")
    public void iSeeRequiredFieldsSubmittedSuccessfully() {
        String usernameText = driver.findElement(By.xpath("//b[@name='username']")).getText();
//        Assert.assertEquals("richard_roe", usernameText);
//        Assert.assertTrue(usernameText.length() > 5);
//        assertThat(usernameText).isEqualTo("john_doe");
//        assertThat(usernameText).hasSizeGreaterThan(5);
//        assertThat(usernameText).contains("john");
//        assertThat(usernameText).containsIgnoringCase("JOHN");
        String resultBoxText = driver.findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        System.out.println(resultBoxText);
        assertThat(resultBoxText).contains("john_doe");
        assertThat(resultBoxText).contains("john.doe@example.com");
        assertThat(resultBoxText).contains("John Doe");
        assertThat(resultBoxText).doesNotContain("Password123");
        // recommended to verify every field separately
        String agreedText = driver.findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(agreedText).isEqualTo("true");
    }

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String pageName) {
        switch (pageName) {
            case "quote":
                quoteForm.open();
                break;
            case "result":
                quoteResult.open();
                break;
            default:
                throw new Error("Unknown page: " + pageName);
        }
    }

    @When("I fill out the required fields on the form oop")
    public void iFillOutTheRequiredFieldsOnTheFormOop() {
        quoteForm.fillUsername("john_doe");
        quoteForm.fillEmail("john.doe@example.com");
        quoteForm.fillPassword("Password123");
        quoteForm.fillName("John", "Doe");
        quoteForm.acceptPrivacyPolicy();
    }

    @And("I submit the quote form oop")
    public void iSubmitTheQuoteFormOop() {
        quoteForm.clickSubmitButton();
    }

    @Then("I see required fields submitted successfully oop")
    public void iSeeRequiredFieldsSubmittedSuccessfullyOop() {
        assertThat(quoteResult.getUsername()).isEqualTo("john_doe");
        assertThat(quoteResult.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(quoteResult.getFirstName()).isEqualTo("John");
        assertThat(quoteResult.getLastName()).isEqualTo("Doe");
        assertThat(quoteResult.getName()).isEqualTo("John Doe");
        assertThat(quoteResult.getPassword()).doesNotContain("Password123");
        assertThat(quoteResult.isAgreedToPrivacyPolicy()).isTrue();
    }

    @And("I {string} third party agreement")
    public void iThirdPartyAgreement(String action) {
        if (action.equals("accept")) {
            quoteForm.acceptThirdPartyAgreement();
        } else if (action.equals("decline")) {
            quoteForm.declineThirdPartyAgreement();
        } else {
            throw new Error("Unknown action: " + action);
        }
    }

    @Then("I verify that third party agreement is {string}")
    public void iVerifyThatThirdPartyAgreementIs(String action) {
        assertThat(quoteResult.getThirdPartyAgreement()).isEqualTo(action);
    }

    @When("I type {string} contact person name and {string} contact person phone")
    public void iTypeContactPersonNameAndContactPersonPhone(String name, String phone) {
        quoteForm.fillContactPersonInformation(name, phone);
    }

}
