package eventhub.baseutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import eventhub.resources.ExtentReportsNG;

public class Listeners extends BaseClass implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent=ExtentReportsNG.getReportObject();
	
	//concurrency problem when code is run in parrallel execution
	ThreadLocal<ExtentTest> threadlocal= new ThreadLocal();
	
	@Override
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		threadlocal.set(test); //unique thread id
	  }

	@Override
	  public void onTestSuccess(ITestResult result) {
		threadlocal.get().log(Status.PASS, "Test Passed successfully");
	    
	  }

	@Override
	  public void onTestFailure(ITestResult result) {
	
	    threadlocal.get().fail(result.getThrowable());
	    
		
	  }

	@Override
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	@Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	@Override
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	@Override
	  public void onStart(ITestContext context) {
	    // not implemented
	  }

	@Override
	  public void onFinish(ITestContext context) {
	    extent.flush();
	  }
	
	
	
	
	
	
	
	

}
