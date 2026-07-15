package practise.testcases;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eventhub.baseutility.BaseClass;
import practise.pom.DownloadUploadFile;

public class DownloadAndUploadFile extends BaseClass{
	
	
	@Test(dataProvider ="getData")
	public void downloaduploadfileflow(HashMap<String,String> input) throws InterruptedException
	{
		DownloadUploadFile duf= new DownloadUploadFile(driver);
		duf.launchApp();
		
		// 1. Get the dynamic path to the current user's Downloads folder
	    // This automatically handles the operating system and slashes correctly.
	    String dynamicPath = Paths.get(System.getProperty("user.home"), "Downloads", "uploadfile.xlsx")
	                              .toAbsolutePath()
	                              .toString();
	    
	    // 2. Pass the safely formatted dynamic path to your upload method
	    duf.uploadFile(dynamicPath);
	    
	    //This is will cause error using direct path in firefox
		//duf.uploadFile("C:/Users/sakha/Downloads/uploadfile.xlsx");
	    
		duf.downloadFile();
		System.out.println("Push only this line");
		
	}
	
	
	
	
	
	
	
	
	
	
	@DataProvider
    public Object[][] getData() throws IOException {
        // Read test data from the JSON file
        List<HashMap<String, String>> data = getJson(System.getProperty("user.dir") + "\\src\\test\\java\\eventhub\\resources\\data.json");
        return new Object[][] { { data.get(0) } };
    }
	
	

}
