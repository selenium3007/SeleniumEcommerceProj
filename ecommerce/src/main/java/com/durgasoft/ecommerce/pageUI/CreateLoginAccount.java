package com.durgasoft.ecommerce.pageUI;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.seleniumhq.jetty9.util.log.Log;

import com.durgasoft.ecommerce.basePage.BasePage;
//import com.durgasoft.ecommerce.homePage.TC001_CustomerRegistration;

public class CreateLoginAccount extends BasePage{
	
	public static final Logger log = Logger.getLogger(CreateLoginAccount.class.getName());
	
	@FindBy(linkText="Sign in") WebElement linkSignIN;
	@FindBy(id="email_create") WebElement txtEmailID;
	@FindBy(id="SubmitCreate") WebElement btnCreateAccount;
	@FindBy(xpath="//h1[text()='Create an account']") WebElement txtCreateAnAccount;
	@FindBy(id="id_gender1") WebElement radioMr;
	@FindBy(id="customer_firstname") WebElement txtFirstName;
	@FindBy(id="customer_lastname") WebElement txtLastName;
	@FindBy(id="passwd") WebElement txtPassword;
	@FindBy(id="days") WebElement dropDownDays;
	@FindBy(id="months") WebElement dropDownMonths;
	@FindBy(id="years") WebElement dropDownYears;
	@FindBy(id="address1") WebElement txtAddress;
	@FindBy(id="city") WebElement txtCity;
	@FindBy(id="id_state") WebElement dropDownState;
	@FindBy(id="postcode") WebElement txtZipCode;
	@FindBy(id="id_country") WebElement dropDownCountry;
	@FindBy(id="phone_mobile") WebElement txtPhone;
	@FindBy(id="alias") WebElement txtAliasAddress;
	@FindBy(id="submitAccount") WebElement btnRegister;
	@FindBy(xpath="//h1[text()='My account']") WebElement txtMyAccount;
	
	public CreateLoginAccount(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public void createAccount() throws Exception{
		
		linkSignIN.click();
		log.info("Clicked on SignIn button with object:" + linkSignIN.toString());
		txtEmailID.sendKeys(getData("firstname")+getData("lastname")+randomNumber()+getData("domain"));
		log.info("Entered Email ID:" +txtEmailID.getAttribute("value")+ "using object" +txtEmailID.toString());
		btnCreateAccount.click();
		log.info("Clicked on Create an Account:" +btnCreateAccount.toString());
		Thread.sleep(5000);
		assertEquals(txtCreateAnAccount.getText(), "CREATE AN ACCOUNT");
		log.info("Verified customer info page by using object:" +txtCreateAnAccount.toString());
		radioMr.click();
		log.info("Clicked on radion button by using object:" +radioMr.toString());
		txtFirstName.sendKeys("Srikanth");
		log.info("Entered first name by using object:" +txtFirstName.toString());
		txtLastName.sendKeys("S");
		log.info("Entered last name bu using object:" +txtLastName.toString());
		txtPassword.sendKeys("abc@1234");
		log.info("Password entered by using object:" +txtPassword.toString());
		selectOption(dropDownDays,3);
		log.info("Selected a day by using object:" +dropDownDays.toString());
		selectOption(dropDownMonths, 7);
		log.info("Selected a month by using object:" +dropDownMonths.toString());
		selectOption(dropDownYears, 2);
		log.info("Selected a year by using object:" +dropDownYears.toString());
		txtAddress.sendKeys(getData("address1"));
		log.info("Entered address by using object:" +txtAddress.toString());
		txtCity.sendKeys(getData("city"));
		log.info("Entered city by using object:" +txtCity.toString());
		selectOption(dropDownState, 8);
		log.info("Selected state by using object:" +dropDownState.toString());
		txtZipCode.sendKeys(getData("postcode"));
		log.info("Entered zip code by using object:" +txtZipCode.toString());
		selectOption(dropDownCountry, 1);
		log.info("Selected country by using object:"+dropDownCountry.toString());
		txtPhone.sendKeys(getData("phone_mobile"));
		log.info("Entered phone number by using object:" +txtPhone.toString());
		txtAliasAddress.sendKeys(getData("alias"));
		log.info("Entered alias address by using object:" +txtAliasAddress.toString());
		btnRegister.click();
		log.info("Clicked on Registration by using object:" +btnRegister.toString());
		Thread.sleep(5000);
		assertEquals(txtMyAccount.getText(), "MY ACCOUNT");
		log.info("Verified my account page by using object:" +txtMyAccount.toString());
	}
	
}
