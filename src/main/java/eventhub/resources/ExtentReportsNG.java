package eventhub.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	
	public static  ExtentReports getReportObject()
	{
		String path =  System.getProperty("user.dir")+"\\reports\\eventhub.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Event HUB Automation Test Results");
		reporter.config().setDocumentTitle("Automation report of Event Hub");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Prathiksha BP");
		return extent;
		
		
		
	}

	

}
