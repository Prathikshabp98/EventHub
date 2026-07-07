package practise.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eventhub.mainutility.MainClass;

public class DownloadUploadFile extends MainClass{
WebDriver driver;

	public DownloadUploadFile(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@id='downloadButton']")
	WebElement downloadBtn;
	
	@FindBy(xpath="//input[@class='upload']")
	WebElement uploadBtn;
	
	//String path = "C:\\Users\\sakha\\Downloads\\download (12).xlsx";
	
	
	
	public void launchApp()  
	{
		
		driver.get("https://rahulshettyacademy.com/upload-download-test/");
	}

	public void downloadFile() throws InterruptedException
	{
		waitForvisiblityOfWebElement(downloadBtn);
		
		downloadBtn.click();
		Thread.sleep(5000);

	}
	
	public void uploadFile(String path) throws InterruptedException
	{
		waitForvisiblityOfWebElement(uploadBtn);
		uploadBtn.sendKeys(path);
		
	}
	
	
	
	
	
	
	
	
	
	
}
