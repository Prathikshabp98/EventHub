package eventhub.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eventhub.mainutility.MainClass;

public class FixedWeb extends MainClass{
	WebDriver driver ;
	
	public FixedWeb(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@name='courses']/tbody/tr/td[3]")
	List<WebElement> priceList;
	
	
	
	
	
	public void webTablelaunchApplication() 
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
	}
	
	public void calculateWebTableAmt()
	{
		int sum=0;
		for(int i=0;i<priceList.size();i++)
		{
			String prices=priceList.get(i).getText();
			int price=Integer.parseInt(prices);
			sum=sum+price;
			
		}
		System.out.println("Total amount is : "+sum);
	}

}
