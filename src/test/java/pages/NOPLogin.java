package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NOPLogin extends Page{
    //constructor
    public NOPLogin() {
        url = "https://nop-qa.portnov.com/login?returnUrl=%2F";
        title ="Your store. Login";
    }
    // Locators
    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "RememberMe")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='/passwordrecovery']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//a[@href='/register?returnUrl=%2F']")
    private WebElement registerLink;

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }




}
