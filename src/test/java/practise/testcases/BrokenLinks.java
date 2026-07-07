package practise.testcases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import eventhub.baseutility.BaseClass;

public class BrokenLinks extends BaseClass{
	
	
   @Test
	public void brokenlinks() {
		
	   driver.get("https://practice-automation.com/broken-links/");
	   List<WebElement> links= driver.findElements(By.tagName("a"));
	   System.out.println("Total links in website is :" +links.size());
	   
	   for(WebElement link : links )
	   {
		   String url = link.getAttribute("href");
		   
		   if(url == null || url.isEmpty())
	  {
			  System.out.println("URL is empty or url is null");
			  continue;
	  }
		   
		if (url.startsWith("javascript")) {
			System.out.println("URL is javascript");
			continue;
		}
		
		verifyLink(url);
		
		
		   
		   
		   
	   }
		   
	}
   
   public static void verifyLink(String linkUrl)
   {
	   try {
		   URL url = new URL(linkUrl);
		   
		   HttpURLConnection httpUrlConnect = (HttpURLConnection) url.openConnection();
		   
		   httpUrlConnect.setConnectTimeout(5000);
		   
		   httpUrlConnect.setRequestMethod("HEAD");
		   
		   httpUrlConnect.connect();
		   
		  int responsecode=  httpUrlConnect.getResponseCode();
		  
			if (responsecode >= 400) {
				System.out.println(linkUrl + " is a broken link");
			} else {
				System.out.println(linkUrl + " is a valid link");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		   
	   }
   }
	
	
	
}
