package eventhub.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eventhub.mainutility.MainClass;

public class Login extends MainClass{
	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='password']")	
	WebElement password;
	
	@FindBy(xpath="//button[@id='login-btn']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@href='/register']")
	WebElement registerLink;

	
	

	
	
	

	
	public void launchApplication()
	{
		driver.get("https://eventhub.rahulshettyacademy.com/login");
		driver.manage().window().maximize();
	}
	
	public void loginToApplication(String emailId, String pass) 
	{
		   waitForvisiblityOfWebElement(email);
           email.sendKeys(emailId);
           password.sendKeys(pass);
           loginButton.click();
           
	}
	
	public void clickOnRegisterLink() {
		waitForvisiblityOfWebElement(registerLink);
		waitForElementToBeClickable(registerLink);
		        registerLink.click();
	}
	

public WebElement getRegisterLinkElement() {
    return driver.findElement(By.xpath("//a[@href='/register']")); // Replace with the actual locator
}

	
	
	
	
	
	
	
	
	
	
	

}
