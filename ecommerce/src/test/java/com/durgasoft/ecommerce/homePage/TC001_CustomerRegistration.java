package com.durgasoft.ecommerce.homePage;

import org.testng.annotations.Test;
import com.durgasoft.ecommerce.basePage.BasePage;
import com.durgasoft.ecommerce.pageUI.CreateLoginAccount;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TC001_CustomerRegistration extends BasePage{
	
	public static final Logger log = Logger.getLogger(TC001_CustomerRegistration.class.getName());
	
  @Test
  public void customerRegistration() throws Exception{
	  
	  CreateLoginAccount login = new CreateLoginAccount(driver);
	  log.info("***Starting TC001_CustomerRegistration***");
	  login.createAccount();
	  log.info("***End of TC001_CustomerRegistration");
  }
  
  
  @BeforeClass
  public void beforeTest() throws Exception{
	  
	  browserLaunch(getData("browser"),getData("url"));
	  
  }
  
  @AfterClass
  public void closeBrowser() {
	  
	  driver.quit();
  }
  

}
