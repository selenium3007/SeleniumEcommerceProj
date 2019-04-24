package com.durgasoft.ecommerce.basePage;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {
	
	public static WebDriver driver;
	public static final String path="./config.properties";
	public String log4jpath = "log4j.properties";
	public static ExtentReports extent;
	public ExtentTest test;
	public ITestResult result;
	
	@AfterMethod
	public void endofReport(ITestResult result) {
		
		getResult(result);
	}
	
	private void getResult(ITestResult result2) {
		
		if(result2.getStatus()==ITestResult.SUCCESS) {
			
			test.log(LogStatus.PASS, result2.getName()+"Test is passed");
		}
		else if(result2.getStatus()==ITestResult.SKIP) {
			
			test.log(LogStatus.SKIP, result2.getName()+"Test is skipped"+result2.getThrowable());
		}
		else if(result2.getStatus()==ITestResult.FAILURE) {
			
			test.log(LogStatus.FAIL, result2.getName()+"Test is failed"+result2.getThrowable());
		}
	}
	
	static {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent=new ExtentReports(System.getProperty("user.dir")+"/src/main/java/com/durgasoft/ecommerce/htmlreports/test/"+dateFormat.format(cal.getTime())+".html",false);
	}
	
	@BeforeMethod
	public void startReport(Method result) {
		
		test=extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+"test case is started");
	}

	public static String getData(String key)throws Exception{
		
		File f = new File(path);
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(f);
		p.load(fi);
		return p.getProperty(key);
	}
	
	public int randomNumber() {
		
		Random r = new Random();
		int random=r.nextInt(9999);
		return random;
	}
	
	public void selectOption(WebElement dropDownDays2, int option) {
		
		Select s = new Select(dropDownDays2);
		s.selectByIndex(option);
	}

	
	public void browserLaunch(String browser, String url) {
		
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		PropertyConfigurator.configure(log4jpath);
	}

}
