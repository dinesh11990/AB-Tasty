package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page_Objects {
	
	
	@FindBy(id="email")
	public static WebElement userName;
	
	@FindBy(id="password")
	public static WebElement password1;
	
	@FindBy(id="password")
	public static WebElement password2;
	
	@FindBy(id="password")
	public static WebElement password3;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	public static WebElement forgot;
	
	@FindBy(name="email")
	public static WebElement email;
	
	@FindBy(xpath="//button[contains(text(),'Send me the password reset link')]")
	public static WebElement forgotemail;
	
	@FindBy(xpath="//*[@id=\"recaptcha-anchor\"]")
	public static WebElement captcha;
	
	@FindBy(xpath="//button[normalize-space()='Sign in']")
	public static WebElement signin;
	
	@FindBy(xpath="//div[@class='Notification__container___14-Nt Notification__success___-DN6H']")
	public static WebElement getmessage;
	
	@FindBy(xpath="//a[normalize-space()='Return to login']")
	public static WebElement returnlogin;
	
	@FindBy(xpath="//button[normalize-space()='Sign in']")
	public static WebElement submitButton;
	
	@FindBy(xpath="//div[contains(text(),'Please enter a valid email or password')]")
	public static WebElement errorMessage;
	
	
	
	

}
