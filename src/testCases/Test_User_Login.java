package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.Login_Page_Objects;

public class Test_User_Login extends CommonFunctions {

	static Logger logger=Logger.getLogger("Test_User_Login.class");
	String actualMessage=null;

	@Test
	public void login() {

		/*I don't have to abtasty username and password to do the login, Moreover there is no signin for
		external users, So here I have automated
		1. Wrong email and password
		2. I have tried multi attemps of password 
		3. I don't see Captcha after more than three attemps which is the bug*/

		logger.info("Logging in to the AB Tasty Portal");
		PageFactory.initElements(driver,Login_Page_Objects.class);
		Login_Page_Objects.userName.sendKeys(properties.getProperty("username"));
		
		//Login more than 3 times
		Login_Page_Objects.password1.sendKeys(properties.getProperty("password1"));
		Login_Page_Objects.submitButton.click();
		Login_Page_Objects.password1.clear();
		Login_Page_Objects.password2.sendKeys(properties.getProperty("password2"));
		Login_Page_Objects.submitButton.click();
		Login_Page_Objects.password2.clear();
		Login_Page_Objects.password3.sendKeys(properties.getProperty("password3"));
		Login_Page_Objects.submitButton.click();

	}

	@Test
	public void getText() {

		login();
		actualMessage = Login_Page_Objects.errorMessage.getText();
		Assert.assertEquals(actualMessage,"Please enter a valid email or password");

	}

	@Test
	public void forgotPassword() {

		//I can see the Captcha only after more than 4 or 5 attempts it's a bug
		login();
		Login_Page_Objects.forgot.click();
		Login_Page_Objects.email.sendKeys("dinesh@abtasty.com");
		Login_Page_Objects.forgotemail.click();
		Login_Page_Objects.returnlogin.click();
	}



}
