package com.durgasoft.ecommerce.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.durgasoft.ecommerce.basePage.BasePage;

public class Listeners extends BasePage implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		Reporter.log("Test is Failed:"+arg0.getMethod().getMethodName());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = arg0.getName();
		if(!arg0.isSuccess()) {
			File sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String reportDirectory = (new File(System.getProperty("user.dir")).getAbsolutePath()
					+"/src/main/java/com/durgasoft/ecommerce");
			File targetPath = new File((String)reportDirectory+"/failedScreens/"+methodName+""
					+simpleDate.format(cal.getTime())+".png");
			
			try {
				
				FileHandler.copy(sourcepath, targetPath);
				
			} catch(IOException e) {
				e.printStackTrace();
			}
			Reporter.log("<a href=' "+targetPath.getAbsolutePath()+" '>"+"<img src=' "+targetPath.getAbsolutePath()+" 'height='100' width='100'/></a>");
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		
		Reporter.log("Test is Skipped:"+arg0.getMethod().getMethodName());
	}

	public void onTestStart(ITestResult arg0) {
		
		Reporter.log("Test Start Running:"+arg0.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult arg0) {
		
		Reporter.log("Test is Success:"+arg0.getMethod().getMethodName());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = arg0.getName();
		if(arg0.isSuccess()) {
			File sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String reportDirectory = (new File(System.getProperty("user.dir")).getAbsolutePath()
					+"/src/main/java/com/durgasoft/ecommerce");
			File targetPath = new File((String)reportDirectory+"/passedScreens/"+methodName+""
					+simpleDate.format(cal.getTime())+".png");
			
			try {
				
				FileHandler.copy(sourcepath, targetPath);
				
			} catch(IOException e) {
				e.printStackTrace();
			}
			Reporter.log("<a href=' "+targetPath.getAbsolutePath()+"'>"+"<img src=' "+targetPath.getAbsolutePath()+"'height='100' width='100'/></a>");
		}
	}
	

}
