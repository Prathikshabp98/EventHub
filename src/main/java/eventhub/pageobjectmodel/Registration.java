

package eventhub.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eventhub.mainutility.MainClass;

public class Registration extends MainClass {
    WebDriver driver;

    public Registration(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='register-email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='register-password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@placeholder='Repeat your password']")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@id='register-btn']")
    WebElement registerButton;

    public void completeRegistration(String email, String password, String confirmPassword) {
        waitForvisiblityOfWebElement(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        registerButton.click();
    }
}
