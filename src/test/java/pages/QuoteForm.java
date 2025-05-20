package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteForm extends Page {

    // constructor
    public QuoteForm() {
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    // selectors

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    // Name dialog selectors
    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='middleName']")
    private WebElement middleName;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement agreedToPrivacyPolicy;

    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement formSubmit;

    @FindBy(xpath = "//button[@id='thirdPartyButton']")
    private WebElement thirdPartyButton;

    // contact person iframe
    @FindBy(xpath = "//input[@id='contactPersonName']")
    private WebElement contactPersonName;
    @FindBy(xpath = "//input[@id='contactPersonPhone']")
    private WebElement contactPersonPhone;


    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }
    // static polymorphism (method overloading)
    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void fillUsername(String usernameValue) {
        username.sendKeys(usernameValue);
    }

    public void fillEmail(String emailValue) {
        email.sendKeys(emailValue);
    }

    public void fillPassword(String passwordValue) {
        password.sendKeys(passwordValue);
        confirmPassword.sendKeys(passwordValue);
    }

    public void acceptPrivacyPolicy() {
        if (!agreedToPrivacyPolicy.isSelected()) {
            agreedToPrivacyPolicy.click();
        }
    }

    public void declinePrivacyPolicy() {
        if (agreedToPrivacyPolicy.isSelected()) {
            agreedToPrivacyPolicy.click();
        }
    }

    public void clickSubmitButton() {
        formSubmit.click();
    }

    public void acceptThirdPartyAgreement() {
        thirdPartyButton.click();
        driver.switchTo().alert().accept();
    }

    public void declineThirdPartyAgreement() {
        thirdPartyButton.click();
        driver.switchTo().alert().dismiss();
    }

    public void fillContactPersonInformation(String contactPersonNameValue, String contactPersonPhoneValue) {
        driver.switchTo().frame("additionalInfo");
        contactPersonName.sendKeys(contactPersonNameValue);
        contactPersonPhone.sendKeys(contactPersonPhoneValue);
        driver.switchTo().defaultContent();
    }
}
