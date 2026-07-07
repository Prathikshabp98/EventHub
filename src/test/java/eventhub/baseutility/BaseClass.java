package eventhub.baseutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseClass {
	
	public  WebDriver driver;
	public Properties prop;
	
	/*@BeforeClass
	public void initializeDriver()
    {
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	

}*/
	
	@BeforeClass
	public void initializeDriver() throws IOException
	{
		// 1. Load your GlobalData.properties file
		prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\sakha\\Practise-workspace\\EventHub\\src\\test\\java\\testResource\\GlobalData.properties"); // Adjust path if needed
        prop.load(fis);
        
     // 2. THIS is where your logic belongs!
        // It checks the command line first. If empty, it reads the 'browser' key from your properties file.
        String browserName = System.getProperty("browser") != null 
                             ? System.getProperty("browser") 
                             : prop.getProperty("browser");

        // 3. Fallback safety check
        if (browserName == null) {
            browserName = "chrome";
        }

        // 4. Initialize the browser
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
    }
        
	
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	public List<HashMap<String, String>> getJson(String file) throws IOException 
	{
		String json=FileUtils.readFileToString(new File(file),StandardCharsets.UTF_8);
		ObjectMapper map = new ObjectMapper();
		 List<HashMap<String,String>> data=map.readValue(json, new TypeReference <List<HashMap<String,String>>>(){});
		 return data;
		
	}
}
