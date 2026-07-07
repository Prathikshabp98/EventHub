package eventhub.mainutility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass {
	WebDriver driver;
	
	public MainClass(WebDriver driver) 
	{
       this.driver=driver; 

    }
	
	public void waitForvisiblityOfWebElement(WebElement FindBy)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.visibilityOf(FindBy));
	}
	
	public void waitForvisiblityOfAllWebElement(List<WebElement> FindBy)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.visibilityOfAllElements(FindBy));
	}
	
	public void waitForElementToBeClickable(WebElement FindBy)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.elementToBeClickable(FindBy));
	}
	
	
	
	
	
	
}
