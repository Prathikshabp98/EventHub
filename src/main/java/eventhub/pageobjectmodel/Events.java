package eventhub.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eventhub.mainutility.MainClass;

public class Events extends MainClass{
	WebDriver driver;
	
	public Events(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@id='nav-events']")
	WebElement eventsTab;
	
	@FindBy(xpath="//div[@class='grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6 mb-10']/article")
	List<WebElement> eventList;
	
	@FindBy(xpath="//div[@class='grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6 mb-10']/article/div[@class='p-4 flex flex-col flex-1']/a")
	List<WebElement> eventLinkList;
	
	@FindBy(xpath="//input[@id='customerName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='customer-email']")
	WebElement email;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement incTicketcount;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement confirmBookingBtn;
	
	@FindBy(xpath="//div//h2[contains(text(), 'Book Tickets')]/following-sibling::span")
	WebElement ticketAmt;
	
	@FindBy(xpath="//span[@id='ticket-count']")
	WebElement noOfTickets;
	
	@FindBy(xpath="//span[@class='text-indigo-700']")
    WebElement totalAmt;
	
	
	
	
	
	
	public void clickOnEventsTab() 
	{
		waitForvisiblityOfWebElement(eventsTab);
		eventsTab.click();
	}
	
	public void clickOnEvent(String eventName)
	{
		waitForvisiblityOfAllWebElement(eventList);
		
		for(WebElement event:eventList)
		{
			if(event.getText().contains(eventName))
			{
				WebElement eventLink = event.findElement(By.xpath(".//div[@class='p-4 flex flex-col flex-1']/a"));
				waitForvisiblityOfWebElement(eventLink);
				eventLink.click();
				return;
		}
	}
	}
	
	public void bookTicketsDetailsFill(String fn , String em , String ph)
	{
		waitForvisiblityOfWebElement(firstName);
		incTicketcount.click();
		firstName.sendKeys(fn);
		email.sendKeys(em);
		phoneNumber.sendKeys(ph);
		
	}
	
	public void clickOnConfirmBooking()
	{
		confirmBookingBtn.click();
	}
	
	public int calculateExpectedTicketAmount() 
	{
		waitForvisiblityOfWebElement(ticketAmt);
		String ticketAmount = ticketAmt.getText().replaceAll("[^0-9]", "");
		String noOfTicketsValue = noOfTickets.getText();
		int totalAmount = Integer.parseInt(ticketAmount) * Integer.parseInt(noOfTicketsValue);
		System.out.println("Total Amount is: " + totalAmount);
		return totalAmount;
	}
	
	public int calculateActualTicketAmount() {
		waitForvisiblityOfWebElement(totalAmt);
		String totalAmount = totalAmt.getText().replaceAll("[^0-9]", "");
		int actualTotalAmount = Integer.parseInt(totalAmount);
		System.out.println("Actual Total Amount is: " + actualTotalAmount);
		return actualTotalAmount;
	}
	
	
	
	
	

	
	
	

	
	
	
	
	
	
	
	
	
	
	

}
