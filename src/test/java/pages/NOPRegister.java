package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class NOPRegister extends Page {
    //public String url = "https://nop-qa.portnov.com/register?returnUrl=%2F";
    //public String title ="Your store. Register";

    //Constructor
    public NOPRegister() {
        url = "https://nop-qa.portnov.com/register?returnUrl=%2F";
        title ="Your store. Register";
    }

    // Locators
    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(id = "gender-male")
    private WebElement genderMaleRadioButton;

    @FindBy(id = "gender-female")
    private WebElement genderFemaleRadioButton;

    @FindBy(name = "DateOfBirthDay")
    private WebElement dateOfBirthDayDropdown;

    @FindBy(name = "DateOfBirthMonth")
    private WebElement dateOfBirthMonthDropdown;

    @FindBy(name = "DateOfBirthYear")
    private WebElement dateOfBirthYearDropdown;

    @FindBy(id = "Company")
    private WebElement companyField;

    @FindBy(id = "Newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement registrationResultMessage;

    @FindBy(xpath = "//a[@class='button-1 register-continue-button']")
    private WebElement registrationResultContinueButton;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement registrationResultLogout;

    public HashMap<String, String> registerUser() {
        //Generates a random 5 digit number
        int randomFiveDigitNumber = (int)(Math.random() * 90000) + 10000;
        String email = "john.doe" + randomFiveDigitNumber + "@example.com";

        //Filling out the Register Users
        genderMaleRadioButton.click();
        firstNameField.sendKeys("John" + randomFiveDigitNumber);
        lastNameField.sendKeys("Doe" + randomFiveDigitNumber);
        emailField.sendKeys(email);
        passwordField.sendKeys("Password123");
        confirmPasswordField.sendKeys("Password123");
        dateOfBirthDayDropdown.sendKeys("1");
        dateOfBirthMonthDropdown.sendKeys("January");
        dateOfBirthYearDropdown.sendKeys("1990");
        companyField.sendKeys("Example Company");
        newsletterCheckbox.click();
        registerButton.click();

        //Create a new HashMap that will containt email and password of newly created user
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", email);
        credentials.put("password", "Password123");

        //I am returning said Hashmap through the method
        return credentials;
    }

    //Overloading or Polymorphism
    public HashMap<String, String> registerUser(String firstName, String lastName, String email, String password) {        //Generates a random 5 digit number
        //Filling out the Register Users
        genderMaleRadioButton.click();
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        dateOfBirthDayDropdown.sendKeys("1");
        dateOfBirthMonthDropdown.sendKeys("January");
        dateOfBirthYearDropdown.sendKeys("1990");
        companyField.sendKeys("Example Company");
        newsletterCheckbox.click();
        registerButton.click();

        //Create a new HashMap that will containt email and password of newly created user
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", email);
        credentials.put("password", password);

        //I am returning said Hashmap through the method
        return credentials;
    }

    public void waitForRegistrationResultMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(registrationResultMessage));
        assertThat(registrationResultMessage.isDisplayed()).isTrue();
    }

    public void clickLogoutButton() {
        registrationResultLogout.click();
    }



}
